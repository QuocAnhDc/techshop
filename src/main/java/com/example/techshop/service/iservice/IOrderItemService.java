package com.example.techshop.service.iservice;

import com.example.techshop.command.OrderDetailCommand;
import com.example.techshop.dto.OrderItemDTO;

import java.util.List;

public interface IOrderItemService {

  void convertCartItemToOrderItem(OrderDetailCommand command);

  List<OrderItemDTO> findByOrderDetail(Integer id);

}
