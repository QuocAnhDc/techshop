package com.example.techshop.dao;

import com.example.techshop.utils.HibernateUtil;
import javassist.tools.rmi.ObjectNotFoundException;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;


public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {

  private final Class<T> persistenceClass;

  public AbstractDao() {
    this.persistenceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
  }

  public String getPersistenceClassName() {
    return this.persistenceClass.getSimpleName();
  }

  @Override
  public List<T> findAll() {
    List<T> list = new ArrayList<T>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      //HQL
      StringBuilder sql = new StringBuilder("from ");
      sql.append(this.getPersistenceClassName());
      Query query = session.createQuery(sql.toString());
      list = query.list();
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
    return list;
  }

  @Override
  public T update(T entity) {
    T result = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      Object object = session.merge(entity);
      result = (T) object;
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
//      log.error(e.getMessage(),e);
      throw e;
    } finally {
      session.close();
    }
    return result;
  }

  @Override
  public T save(T entity) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      session.persist(entity);
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
//      log.error(e.getMessage(),e);
      throw e;
    } finally {
      session.close();
    }
    return entity;
  }

  @Override
  public T findById(ID id) {
    T result = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      result = (T) session.get(persistenceClass, id);
      if (result == null) {
        new ObjectNotFoundException("NOT FOUND " + id, null);
      }
    } catch (Exception e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
    return result;
  }

  @Override
  public Integer delete(List<ID> ids) {
    Integer count = 0;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try {
      for (ID item : ids) {
        T t = (T) session.get(persistenceClass, item);
        session.delete(t);
        count++;
      }
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    } finally {
      session.close();
    }
    return count;
  }

  @Override
  public T findEqualUnique(String property, Object value) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    T result = null;
    try {
      String sql =
          "FROM " + getPersistenceClassName() + " model WHERE model." + property + "= :value";
      Query query = session.createQuery(sql.toString());
      query.setParameter("value", value);
      result = (T) query.uniqueResult();

    } catch (HibernateException e) {
      transaction.rollback();
//      log.error(e.getMessage(),e);
      throw e;
    } finally {
      session.close();
    }
    return result;
  }


  public List<T> pagination(Integer pageNumber, Integer pageSize) {
    List<T> listResult = new ArrayList<>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String term = getPersistenceClassName();
      term = term.split("Entity")[0];
      String firstLetter = term.substring(0, 1);
      String remainingLetters = term.substring(1, term.length());
      firstLetter = firstLetter.toLowerCase();

      Criteria criteria = session.createCriteria(persistenceClass);
      criteria.setFirstResult((pageNumber - 1) * pageSize);
      criteria.setMaxResults(pageSize);
      criteria.addOrder(Order.asc(firstLetter + remainingLetters + "Id"));

      listResult = (List<T>) criteria.list();
      session.getTransaction().commit();
    } catch (HibernateException e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return listResult;
  }

  public int Count(String params) {
    int count = 0;
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<Long> query = builder.createQuery(Long.class);
      Root<T> root = query.from(persistenceClass);
      query.select(builder.count(root.get(params)));
      count = Math.toIntExact((Long) session.createQuery(query).getSingleResult());
      session.getTransaction().commit();
    } catch (HibernateException e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return count;
  }

  public int Count(String params, String col, String value) {
    List<T> listResult = new ArrayList<>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String term = getPersistenceClassName();
      term = term.split("Entity")[0];
      String firstLetter = term.substring(0, 1);
      String remainingLetters = term.substring(1, term.length());
      firstLetter = firstLetter.toLowerCase();

      Criteria criteria = session.createCriteria(persistenceClass);
      criteria.addOrder(Order.asc(firstLetter + remainingLetters + "Id"));
      criteria.add(Restrictions.ilike(col, "%" + value + "%", MatchMode.ANYWHERE));
      listResult = (List<T>) criteria.list();
      session.getTransaction().commit();
    } catch (HibernateException e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return listResult.size();
  }

  public List<T> pagination(Integer pageNumber, Integer pageSize, String col, String value) {
    List<T> listResult = new ArrayList<>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String term = getPersistenceClassName();
      term = term.split("Entity")[0];
      String firstLetter = term.substring(0, 1);
      String remainingLetters = term.substring(1, term.length());
      firstLetter = firstLetter.toLowerCase();
      Criteria criteria = session.createCriteria(persistenceClass);
      criteria.setFirstResult((pageNumber - 1) * pageSize);
      criteria.setMaxResults(pageSize);
      criteria.add(Restrictions.ilike(col, "%" + value + "%", MatchMode.ANYWHERE));
      criteria.addOrder(Order.desc(firstLetter + remainingLetters + "Id"));

      listResult = (List<T>) criteria.list();
      session.getTransaction().commit();
    } catch (HibernateException e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return listResult;
  }

  public List<T> pagination(Integer pageNumber, Integer pageSize, String col, boolean sale) {
    List<T> listResult = new ArrayList<>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String term = getPersistenceClassName();
      term = term.split("Entity")[0];
      String firstLetter = term.substring(0, 1);
      String remainingLetters = term.substring(1, term.length());
      firstLetter = firstLetter.toLowerCase();
      Criteria criteria = session.createCriteria(persistenceClass);
      criteria.setFirstResult((pageNumber - 1) * pageSize);
      criteria.setMaxResults(pageSize);
      criteria.add(Restrictions.eq(col, sale));
      criteria.addOrder(Order.asc(firstLetter + remainingLetters + "Id"));

      listResult = (List<T>) criteria.list();
      session.getTransaction().commit();
    } catch (HibernateException e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return listResult;
  }

  public int Count(String params, String col, boolean sale) {
    List<T> listResult = new ArrayList<>();
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      session.beginTransaction();
      String term = getPersistenceClassName();
      term = term.split("Entity")[0];
      String firstLetter = term.substring(0, 1);
      String remainingLetters = term.substring(1, term.length());
      firstLetter = firstLetter.toLowerCase();

      Criteria criteria = session.createCriteria(persistenceClass);
      criteria.addOrder(Order.asc(firstLetter + remainingLetters + "Id"));
      criteria.add(Restrictions.eq(col, sale));
      listResult = (List<T>) criteria.list();
      session.getTransaction().commit();
    } catch (HibernateException e) {
      e.printStackTrace();
      session.getTransaction().rollback();
    } finally {
      session.close();
    }
    return listResult.size();
  }

}
