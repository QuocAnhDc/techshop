package com.example.techshop.service.serviceimpl;

import com.example.techshop.dto.RoleDTO;
import com.example.techshop.entity.RoleEntity;
import com.example.techshop.service.iservice.IRoleService;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.RoleConverter;

import java.util.ArrayList;
import java.util.List;

public class RoleService implements IRoleService {


  @Override
  public RoleDTO getRoleByName(String roleName) {
    RoleEntity roleEntity = STRepoUtil.getRoleRepo().getRoleByName(roleName);
    return RoleConverter.entity2Dto(roleEntity);
  }

  @Override
  public List<RoleDTO> getRole() {
    List<RoleDTO> dtos = new ArrayList<>();
    List<RoleEntity> entitys = STRepoUtil.getRoleRepo().findAll();
    for (RoleEntity entity : entitys) {
      dtos.add(RoleConverter.entity2Dto(entity));
    }
    return dtos;
  }

  @Override
  public void saveRole(RoleDTO dto) {
    RoleEntity entity = RoleConverter.dto2Entity(dto);
    STRepoUtil.getRoleRepo().save(entity);
  }

  @Override
  public RoleDTO updateRole(RoleDTO dto) {
    RoleEntity entity = RoleConverter.dto2Entity(dto);
    entity = STRepoUtil.getRoleRepo().update(entity);
    dto = RoleConverter.entity2Dto(entity);
    return dto;
  }

  @Override
  public void deleteRole(List<Integer> ids) {
    STRepoUtil.getRoleRepo().delete(ids);
  }

}
