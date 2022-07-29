package com.example.techshop.service.iservice;

import com.example.techshop.dto.UserDTO;

import java.util.List;

 public interface IUserService {
   boolean register(UserDTO userDTO) ;

   UserDTO findUser(String email, String password);

   List<UserDTO> getUser();

   UserDTO findById(Integer id);

   void saveUser(UserDTO userDTO) throws Exception;

   UserDTO updateUser(UserDTO userDTO) throws Exception ;

   void deleteUser(List<Integer> ids);

   UserDTO findEqualUnique(String property, Object value) ;

   List<UserDTO> pagingnation(Integer pageNumber, Integer pageSize);
    List<UserDTO> pagingnation(Integer pageNumber, Integer pageSize, String col , String value) ;

   Integer CountUser() ;
   Integer CountUser(String col, String value) ;
}
