package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.dao.idao.IUserRepo;
import com.example.techshop.entity.ShoppingSessionEntity;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.HibernateUtil;
import com.example.techshop.utils.STRepoUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UserRepo extends AbstractDao<Integer, UserEntity> implements IUserRepo {

  public UserEntity findUser(String email, String password) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    UserEntity entity = null;
    try {
      String sql = "FROM UserEntity ue WHERE ue.email= :email AND ue.password= :password";
      Query query = session.createQuery(sql);
      query.setParameter("email", email);
      query.setParameter("password", password);
      entity = (UserEntity) query.getSingleResult();

    } catch (NoResultException e) {
    }
    transaction.commit();
    session.close();
    if (entity != null) {

      return entity;
    } else {
      return null;
    }
  }


  public ShoppingSessionEntity findSessionByCusId(Integer cusId) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      String queryString = "FROM ShoppingSessionEntity s WHERE s.userEntity.userId = :cusId";
      org.hibernate.query.Query query = session.createQuery(queryString);
      query.setParameter("cusId", cusId);
      ShoppingSessionEntity shoppingSession = (ShoppingSessionEntity) query.uniqueResult();
      transaction.commit();
      return shoppingSession;
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
  }

  public boolean register(UserEntity user) {
    try {
      if (isUniqueEmail(user.getEmail())) {
        STRepoUtil.getUserRepo().save(user);
        return true;
      }
    } catch (HibernateException e) {
      throw e;
    }
    return false;
  }

  public boolean isUniqueEmail(String email) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      String queryString = "FROM UserEntity u WHERE u.email = :email";
      org.hibernate.query.Query query = session.createQuery(queryString);
      query.setParameter("email", email);
      if (query.getResultList().size() > 0) {
        transaction.commit();
        return false;
      }
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
    return true;
  }

}
