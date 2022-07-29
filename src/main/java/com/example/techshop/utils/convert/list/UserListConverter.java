package com.example.techshop.utils.convert.list;

import com.example.techshop.dto.UserDTO;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.utils.convert.UserConverter;

import java.util.ArrayList;
import java.util.List;

public class UserListConverter {

  public static List<UserDTO> entity2Dto(List<UserEntity> entities) {
    List<UserDTO> dtos = new ArrayList<UserDTO>();
    for (UserEntity entity : entities) {
      UserDTO dto = new UserDTO();
      dto = UserConverter.entity2Dto(entity);
      dtos.add(dto);
    }
    return dtos;
  }

  public static List<UserEntity> dto2Entity(List<UserDTO> dtos) {
    List<UserEntity> entities = new ArrayList<UserEntity>();
    for (UserDTO dto : dtos) {
      UserEntity entity = new UserEntity();
      entity = UserConverter.dto2Entity(dto);
      entities.add(entity);
    }
    return entities;
  }

}
