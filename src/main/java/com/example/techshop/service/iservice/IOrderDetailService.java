package com.example.techshop.service.iservice;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.dto.OrderItemDTO;

import java.util.List;
import java.util.Map;

 public interface IOrderDetailService {
   List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize);
   List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize, String col, String value);
   List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize, boolean value);
   Integer CountOrderDetailList(String col, String value);
   Integer CountOrderDetailList( boolean value) ;
   Map<Integer, Integer> getIncomeInMonth(int year);
   Integer CountOrderDetailList();
   OrderDetailDTO update (OrderDetailDTO dto);
   OrderDetailDTO findById(Integer id) ;
   List<Integer> getYear();
   Integer CountOrderDetailNotConFirmed();
   void sendConfirmationMail(OrderDetailDTO orderDetail);
   Map<OrderDetailDTO, List<OrderItemDTO>> getItemsByCus(Integer cusId);
}
