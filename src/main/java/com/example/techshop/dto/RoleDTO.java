package com.example.techshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {

  private Integer roleId;

  private String name;

  private String description;

  private List<UserDTO> userDTOList;

  @Override
  public String toString() {
    return this.name;
  }
}
