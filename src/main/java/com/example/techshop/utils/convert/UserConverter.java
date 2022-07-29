package com.example.techshop.utils.convert;

import com.example.techshop.dto.UserDTO;
import com.example.techshop.entity.UserEntity;

public class UserConverter {

  public static UserDTO entity2Dto(UserEntity entity) {
    UserDTO dto = new UserDTO();
    dto.setEmail(entity.getEmail());
    dto.setRoleDTO(RoleConverter.entity2Dto(entity.getRoleEntity()));
    dto.setUserId(entity.getUserId());
    dto.setFirstName(entity.getFirstName());
    dto.setPassword(entity.getPassword());
    dto.setPhotos(entity.getPhotos());
    dto.setLastName(entity.getLastName());
    return dto;
  }

  public static UserEntity dto2Entity(UserDTO dto) {
    UserEntity entity = new UserEntity();
    entity.setEmail(dto.getEmail());
    entity.setRoleEntity(RoleConverter.dto2Entity(dto.getRoleDTO()));
    entity.setUserId(dto.getUserId());
    entity.setFirstName(dto.getFirstName());
    entity.setPassword(dto.getPassword());
    entity.setPhotos(dto.getPhotos());
    entity.setLastName(dto.getLastName());
    return entity;
  }

}
