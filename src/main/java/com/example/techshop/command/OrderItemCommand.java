package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.OrderItemDTO;

public class OrderItemCommand  extends AbstractCommand<OrderItemDTO> {

  public OrderItemCommand(){
    this.pojo = new OrderItemDTO();
  }

}
