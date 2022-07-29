package com.example.techshop.dao.repository;

import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.dao.AbstractDao;
import com.example.techshop.dao.idao.IOrderItemRepo;
import com.example.techshop.entity.CartItemEntity;
import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.entity.OrderItemEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.HibernateUtil;
import com.example.techshop.utils.STRepoUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class OrderItemRepo extends AbstractDao<Integer, OrderItemEntity> implements
    IOrderItemRepo {

  @Override
  public void convertCartItemToOrderItem(OrderDetailCommand command) {
    try {
      Integer cusId = command.getCusId();
      List<CartItemEntity> cartItems = STRepoUtil.getCartItemRepo().getCartItemsByCusId(cusId);
      OrderDetailEntity orderDetail = newOrderDetail(command, cusId);
      List<Integer> delCartIds = new ArrayList<Integer>();
      for (CartItemEntity cartItem : cartItems) {
        OrderItemEntity orderItem = new OrderItemEntity();
        orderItem.setOrderDetailEntity(orderDetail);
        orderItem.setProductEntity(cartItem.getProductEntity());
        orderItem.setQuantity(cartItem.getQuantity());
        delCartIds.add(cartItem.getCartItemId());
        STRepoUtil.getOrderItemRepo().save(orderItem);
      }
      STRepoUtil.getCartItemRepo().delete(delCartIds);
    } catch (HibernateException e) {
      throw e;
    }
  }

  public OrderDetailEntity newOrderDetail(OrderDetailCommand command, Integer cusId) {
    OrderDetailEntity orderDetail = new OrderDetailEntity();
    try {
      UserEntity user = STRepoUtil.getUserRepo().findById(cusId);

      orderDetail.setAddress(command.getPojo().getAddress());
      orderDetail.setPhoneNumber(command.getPojo().getPhoneNumber());
      orderDetail.setTotal(command.getTotal());
      orderDetail.setUserEntity(user);
      orderDetail.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
      orderDetail.setIspaid(false);

      STRepoUtil.getOrderDetailRepo().save(orderDetail);
      return orderDetail;
    } catch (HibernateException e) {
      throw e;
    }
  }

  @Override
  public List<OrderItemEntity> getOrderItemsByOrderId(Integer orderId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    List<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();
    try {
      String queryString = "FROM OrderItemEntity o WHERE o.orderDetailEntity.orderDetailId= :orderId";
      Query query = session.createQuery(queryString);
      query.setParameter("orderId", orderId);
      orderItems = query.list();
      transaction.commit();
      return orderItems;
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
  }
}
