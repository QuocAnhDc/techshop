package com.example.techshop.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderDetailDTO {
  
  private Integer orderDetailId;

  private int total;

  private Boolean ispaid;

  private Timestamp createdDate;

  private List<OrderItemDTO> orderItemDTOList;

  private UserDTO userDTO;

  private String phoneNumber;

  private String address;
}
