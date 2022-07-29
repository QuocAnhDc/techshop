package com.example.techshop.dao.idao;

import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.entity.OrderItemEntity;

import java.util.List;

 public interface IOrderDetailRepo {

   List<Object[]> getIncomeInMonth(int year);

   List<OrderItemEntity> getOrderItems(Integer orderId);
   public List<OrderDetailEntity> getOrderDetailByCusId(Integer cusId);

}
