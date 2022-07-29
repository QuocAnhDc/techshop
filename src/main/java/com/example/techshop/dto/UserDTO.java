package com.example.techshop.dto;

import lombok.Data;

@Data
public class UserDTO {

  private Integer userId;

  private String email;

  private String password;

  private String firstName;

  private String lastName;

  private String photos;

  private RoleDTO roleDTO;

  private OrderDetailDTO orderDetailDTO;

}
