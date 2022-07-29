package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.dao.idao.IBrandRepo;
import com.example.techshop.entity.BrandEntity;
import com.example.techshop.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class BrandRepo extends AbstractDao<Integer, BrandEntity> implements
    IBrandRepo {

  @Override
  public BrandEntity findBrandByName(String name) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    BrandEntity brand = null;
    String queryString = "FROM BrandEntity b WHERE b.name = :name ";
    try {
      Query query = session.createQuery(queryString);
      query.setParameter("name", name);
      brand = (BrandEntity) query.uniqueResult();
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      throw e;
    }
    return brand;
  }
}
