package com.example.techshop.dao.idao;

import com.example.techshop.entity.RoleEntity;

public interface IRoleRepo {

  RoleEntity getRoleByName(String roleName);

}
