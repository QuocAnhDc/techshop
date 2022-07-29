package com.example.techshop.service.serviceimpl;

import com.example.techshop.dto.UserDTO;
import com.example.techshop.entity.UserEntity;
import com.example.techshop.service.iservice.IUserService;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.UserConverter;
import com.example.techshop.utils.convert.list.UserListConverter;

import java.util.List;

public class UserService implements IUserService {

  @Override
  public boolean register(UserDTO userDTO) {
    UserEntity userEntity = UserConverter.dto2Entity(userDTO);
    return STRepoUtil.getUserRepo().register(userEntity);
  }

  @Override
  public UserDTO findUser(String email, String password) {
    UserEntity entity = STRepoUtil.getUserRepo().findUser(email, password);
    if (entity != null) {
      UserDTO dto = UserConverter.entity2Dto(entity);
      return dto;
    }
    return null;
  }

  @Override
  public List<UserDTO> getUser() {
    List<UserEntity> entities = STRepoUtil.getUserRepo().findAll();
    List<UserDTO> dtos = UserListConverter.entity2Dto(entities);
    return dtos;
  }

  @Override
  public UserDTO findById(Integer id) {
    UserEntity userEntity = STRepoUtil.getUserRepo().findById(id);
    UserDTO userDTO = UserConverter.entity2Dto(userEntity);
    return userDTO;
  }

  @Override
  public void saveUser(UserDTO userDTO) throws Exception {
    UserEntity userEntity = UserConverter.dto2Entity(userDTO);
    UserEntity usersave = STRepoUtil.getUserRepo().save(userEntity);
    if (usersave == null) {
      throw new Exception("Not update");
    }
  }

  @Override
  public UserDTO updateUser(UserDTO userDTO) throws Exception {
    UserEntity userEntity = UserConverter.dto2Entity(userDTO);
    userEntity = STRepoUtil.getUserRepo().update(userEntity);
    if (userEntity == null) {
      throw new Exception("Not update");
    }
    userDTO = UserConverter.entity2Dto(userEntity);
    return userDTO;
  }

  @Override
  public void deleteUser(List<Integer> ids) {
    STRepoUtil.getUserRepo().delete(ids);
  }

  @Override
  public UserDTO findEqualUnique(String property, Object value) {
    UserEntity userEntity = STRepoUtil.getUserRepo().findEqualUnique(property, value);
    UserDTO userDTO = UserConverter.entity2Dto(userEntity);
    return userDTO;

  }

  @Override
  public List<UserDTO> pagingnation(Integer pageNumber, Integer pageSize) {
    List<UserEntity> listEntity = STRepoUtil.getUserRepo().pagination(pageNumber, pageSize);
    return UserListConverter.entity2Dto(listEntity);
  }

  @Override
  public List<UserDTO> pagingnation(Integer pageNumber, Integer pageSize, String col,
      String value) {
    List<UserEntity> listEntity = STRepoUtil.getUserRepo()
        .pagination(pageNumber, pageSize, col, value);
    return UserListConverter.entity2Dto(listEntity);
  }

  @Override
  public Integer CountUser() {
    return STRepoUtil.getUserRepo().Count("userId");
  }

  @Override
  public Integer CountUser(String col, String value) {
    return STRepoUtil.getUserRepo().Count("userId", col, value);
  }

}
