package com.example.techshop.service.iservice;

import com.example.techshop.dto.RoleDTO;

import java.util.List;

 public interface IRoleService {
   RoleDTO getRoleByName(String roleName);

   List<RoleDTO> getRole();

   void saveRole(RoleDTO dto);
   RoleDTO updateRole(RoleDTO dto);
   void deleteRole(List<Integer> ids);


}
