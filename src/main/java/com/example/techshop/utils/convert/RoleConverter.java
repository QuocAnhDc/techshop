package com.example.techshop.utils.convert;

import com.example.techshop.dto.RoleDTO;
import com.example.techshop.entity.RoleEntity;

public class RoleConverter {

  public static RoleDTO entity2Dto(RoleEntity entity) {
    RoleDTO dto = new RoleDTO();
    dto.setRoleId(entity.getRoleId());
    dto.setDescription(entity.getDescription());
    dto.setName(entity.getName());
    return dto;
  }

  public static RoleEntity dto2Entity(RoleDTO dto) {
    RoleEntity entity = new RoleEntity();
    entity.setRoleId(dto.getRoleId());
    entity.setDescription(dto.getDescription());
    entity.setName(dto.getName());
    return entity;
  }
}
