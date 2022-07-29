package com.example.techshop.dao.idao;

import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.entity.OrderItemEntity;

import java.util.List;


 public interface IOrderItemRepo {
   void convertCartItemToOrderItem(OrderDetailCommand command);

   List<OrderItemEntity> getOrderItemsByOrderId(Integer orderId);

}
