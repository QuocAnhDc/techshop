package com.example.techshop.dao.repository;

import com.example.techshop.dao.AbstractDao;
import com.example.techshop.dao.idao.IRoleRepo;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class RoleRepo extends AbstractDao<Integer, RoleEntity> implements IRoleRepo {

  @Override
  public RoleEntity getRoleByName(String roleName) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
      String queryString = "FROM RoleEntity c WHERE c.name=: roleName";
      Query query = session.createQuery(queryString);
      query.setParameter("roleName", roleName);
      return (RoleEntity) query.uniqueResult();
    } catch (HibernateException e) {
      throw e;
    } finally {
      session.close();
    }
  }
}
