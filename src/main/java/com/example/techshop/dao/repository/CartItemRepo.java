package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.dao.idao.ICartItemRepo;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.ProductEntity;
import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.HibernateUtil;
import com.example.techshop.utils.STRepoUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CartItemRepo extends AbstractDao<Integer, CartItemEntity> implements
    ICartItemRepo {

  @Override
  public boolean addProductToCart(Integer cusId, Integer productId) {
    try {
      ShoppingSessionEntity sessionEntity = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
      if (sessionEntity == null) {
        //Neu khong tim thay session thi tao moi
        sessionEntity = new ShoppingSessionEntity();
        sessionEntity.setUserEntity(STRepoUtil.getUserRepo().findById(cusId));
        sessionEntity.setTotal(0);
        STRepoUtil.getShoppingSessionRepo().save(sessionEntity);
      }
      //Kiem tra xem da ton tai cart cua san pham do hay chua
      CartItemEntity cartItem = findCartItem(sessionEntity.getSessionId(), productId);
      //Neu co thi tang len 1
      if (cartItem != null) {
        if (isEnoughAmount(productId, 1)) {
          cartItem.setQuantity(cartItem.getQuantity() + 1);
          STRepoUtil.getCartItemRepo().update(cartItem);
          updateProductQuantity(productId, 1);
          return true;
        } else {
          return false;
        }
      }
      //Neu chua co thi tao moi
      if (isEnoughAmount(productId, 1)) {
        cartItem = new CartItemEntity();
        cartItem.setShoppingSessionEntity(sessionEntity);
        cartItem.setProductEntity(STRepoUtil.getProductRepo().findById(productId));
        cartItem.setQuantity(1);
        cartItem.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        STRepoUtil.getCartItemRepo().save(cartItem);
        updateProductQuantity(productId, 1);
        return true;
      } else {
        return false;
      }
    } catch (HibernateException e) {
      throw e;
    }
  }

  @Override
  public boolean updateCartItem(Integer cusId, Integer productId, int quantity) {
    try {
      ShoppingSessionEntity session = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
      Integer sessionId = session.getSessionId();
      if (sessionId != null) {
        //Tim item trong session
        CartItemEntity cartItem = findCartItem(sessionId, productId);
        //Lay so thay doi cua san pham
        int changedQuantity = quantity - cartItem.getQuantity();
        if (cartItem != null && isEnoughAmount(productId, changedQuantity)) {
          cartItem.setQuantity(quantity);
          STRepoUtil.getCartItemRepo().update(cartItem);
          updateProductQuantity(productId, changedQuantity);
          return true;
        }
      }
    } catch (HibernateException e) {
      throw e;
    }
    return false;
  }

  public void updateProductQuantity(Integer productId, int changedQuantity) {
    try {
      ProductEntity product = STRepoUtil.getProductRepo().findById(productId);
      product.setQuantity(product.getQuantity() - changedQuantity);
      STRepoUtil.getProductRepo().update(product);
    } catch (HibernateException e) {
      throw e;
    }

  }

  @Override
  public boolean deleteCartItem(Integer cusId, Integer productId, HttpServletRequest request,
      HttpServletResponse response) {
    try {
      if (cusId > 0) {
        ShoppingSessionEntity session = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
        Integer sessionId = session.getSessionId();
        CartItemEntity cartItem = findCartItem(sessionId, productId);
        Integer cartItemId = cartItem.getCartItemId();
        updateProductQuantity(productId, -cartItem.getQuantity());
        STRepoUtil.getCartItemRepo().delete(Collections.singletonList(cartItemId));
        return true;
      } else {
        Cookie cookie = new Cookie("productId" + productId, "");
        cookie.setMaxAge(0);
        cookie.setPath("/cart");
        response.addCookie(cookie);
        return true;
      }
    } catch (HibernateException e) {
      throw e;
    }
  }

  @Override
  public CartItemEntity findCartItem(Integer sessionId, Integer productId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      String queryString = "FROM CartItemEntity c WHERE c.productEntity.productId = :productId "
          + "and c.shoppingSessionEntity.sessionId = : sessionId";
      Query query = session.createQuery(queryString);
      query.setParameter("productId", productId);
      query.setParameter("sessionId", sessionId);
      CartItemEntity cartItem = (CartItemEntity) query.uniqueResult();
      transaction.commit();
      return cartItem;
    } catch (HibernateException e) {
      throw e;
    } finally {
      session.close();
    }
  }

  @Override
  public List<CartItemEntity> getCartGreater30Day() {
    List<CartItemEntity> listResult = new ArrayList<>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      Criteria criteria = session.createCriteria(CartItemEntity.class);

      Instant now = Instant.now(); //current date
      Instant before = now.minus(Duration.ofDays(30));
      Date dateBefore = Date.from(before);
      Timestamp ts = new Timestamp(dateBefore.getTime());
      criteria.add(Restrictions.lt("createdDate", ts));
      listResult = (List<CartItemEntity>) criteria.list();
      session.getTransaction().commit();
    } catch (HibernateException e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return listResult;
  }

  public boolean isEnoughAmount(Integer productId, int quantity) {
    ProductEntity product = STRepoUtil.getProductRepo().findById(productId);
    if (product.getQuantity() >= quantity) {
      return true;
    } else if (product.getQuantity() == 0) {
      return false;
    }
    return false;
  }

  @Override
  public List<CartItemEntity> getCartItemsByCusId(Integer cusId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    List<CartItemEntity> cartItems = new ArrayList<CartItemEntity>();
    ShoppingSessionEntity shoppingSession = new ShoppingSessionEntity();
    try {
      shoppingSession = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
      if (shoppingSession != null) {
        String queryString = "FROM CartItemEntity c WHERE c.shoppingSessionEntity.sessionId = :sessionId ";
        Query query = session.createQuery(queryString);
        query.setParameter("sessionId", shoppingSession.getSessionId());
        cartItems = (List<CartItemEntity>) query.getResultList();
      } else {
        ShoppingSessionEntity sessionEntity = new ShoppingSessionEntity();
        UserEntity user = STRepoUtil.getUserRepo().findById(cusId);
        sessionEntity.setUserEntity(user);
        sessionEntity.setTotal(0);
        STRepoUtil.getShoppingSessionRepo().save(sessionEntity);
      }
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
    return cartItems;
  }

  @Override
  public void addCartInCookieToCus(Integer cusId, HttpServletRequest request,
      HttpServletResponse response) {
    Cookie[] cookies = request.getCookies();
    ShoppingSessionEntity sessionEntity = STRepoUtil.getUserRepo().findSessionByCusId(cusId);
    for (Cookie cookie : cookies) {
      if (cookie.getName().contains("productId")) {
        Integer productId = Integer.parseInt(cookie.getValue());
        addProductToCart(cusId, productId);
      }
    }
    for (Cookie cookie : cookies) {
      if (cookie.getName().contains("productId")) {
        cookie.setMaxAge(0);
        cookie.setPath("/cart");
        response.addCookie(cookie);
      }
    }
  }
}
