package com.example.techshop.command;

import com.example.techshop.command.abstractcommand.AbstractCommand;
import com.example.techshop.dto.CartItemDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemCommand extends AbstractCommand<CartItemDTO> {

  public CartItemCommand() {
    this.pojo = new CartItemDTO();
  }

  private Integer cusId;

  private Integer productId;
  private String value= "";

}
