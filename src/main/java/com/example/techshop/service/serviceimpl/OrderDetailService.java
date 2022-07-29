package com.example.techshop.service.serviceimpl;

import com.example.techshop.dto.OrderDetailDTO;
import com.example.techshop.dto.OrderItemDTO;
import com.example.techshop.entity.OrderDetailEntity;
import com.example.techshop.entity.OrderItemEntity;
import com.example.techshop.service.iservice.IOrderDetailService;
import com.example.techshop.utils.MailUtils;
import com.example.techshop.utils.STRepoUtil;
import com.example.techshop.utils.convert.OrderDetailConverter;
import com.example.techshop.utils.convert.list.OrderDetailListConverter;
import com.example.techshop.utils.convert.list.OrderItemListConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OrderDetailService implements IOrderDetailService {

  @Override
  public List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize) {
    List<OrderDetailEntity> entities = STRepoUtil.getOrderDetailRepo()
        .pagination(pageNumber, pageSize);
    return OrderDetailListConverter.entity2Dto(entities);

  }

  @Override
  public List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize, String col,
      String value) {
    List<OrderDetailEntity> entities = STRepoUtil.getOrderDetailRepo()
        .pagination(pageNumber, pageSize, col, value);
    return OrderDetailListConverter.entity2Dto(entities);

  }

  @Override
  public List<OrderDetailDTO> pagingnation(Integer pageNumber, Integer pageSize, boolean value) {
    List<OrderDetailEntity> entities = STRepoUtil.getOrderDetailRepo()
        .pagination(pageNumber, pageSize, "ispaid", value);
    return OrderDetailListConverter.entity2Dto(entities);

  }

  @Override
  public Integer CountOrderDetailList(String col, String value) {
    return STRepoUtil.getOrderDetailRepo().Count("orderDetailId", col, value);
  }

  @Override
  public Integer CountOrderDetailList(boolean value) {
    return STRepoUtil.getOrderDetailRepo().Count("orderDetailId", "isPaid", value);
  }

  @Override
  public Map<Integer, Integer> getIncomeInMonth(int year) {
    List<Object[]> list = STRepoUtil.getOrderDetailRepo().getIncomeInMonth(year);
    Map<Integer, Integer> data = new HashMap<>();
    for (int i = 1; i <= 12; i++) {
      data.put(i, 0);
    }
    for (Object[] item : list) {
      Integer index = Integer.valueOf(item[0].toString());
      Integer value = Integer.valueOf(item[1].toString());
      data.replace(index, value);
      System.out.println(index);


    }
    return data;
  }

  @Override
  public Integer CountOrderDetailList() {
    return STRepoUtil.getOrderDetailRepo().Count("orderDetailId");
  }

  @Override
  public OrderDetailDTO update(OrderDetailDTO dto) {
    OrderDetailEntity entity = OrderDetailConverter.dto2Entity(dto);
    entity = STRepoUtil.getOrderDetailRepo().update(entity);
    OrderDetailDTO orderDTO = OrderDetailConverter.entity2Dto(entity);
    return orderDTO;
  }

  @Override
  public OrderDetailDTO findById(Integer id) {
    return OrderDetailConverter.entity2Dto(STRepoUtil.getOrderDetailRepo().findById(id));
  }

  @Override
  public List<Integer> getYear() {
    return STRepoUtil.getOrderDetailRepo().getYears();
  }

  @Override
  public Integer CountOrderDetailNotConFirmed() {
    return STRepoUtil.getOrderDetailRepo().Count("orderDetailId", "ispaid", false);
  }

  @Override
  public void sendConfirmationMail(OrderDetailDTO orderDetail) {
    MailUtils mailSender = new MailUtils(orderDetail.getUserDTO().getEmail());
    mailSender.sendMail(
        MailUtils.mailHeaders() + MailUtils.mailContent(orderDetail) + MailUtils.mailFooter());
  }

  @Override
  public Map<OrderDetailDTO, List<OrderItemDTO>> getItemsByCus(Integer cusId) {
    Map<OrderDetailDTO, List<OrderItemDTO>> results = new TreeMap<OrderDetailDTO, List<OrderItemDTO>>();
    List<OrderDetailEntity> orderDetails = STRepoUtil.getOrderDetailRepo().getOrderDetailByCusId(cusId);
    OrderDetailDTO orderDetailDTO = null;
    List<OrderItemDTO> orderItemDTOS = null;
    for (OrderDetailEntity orderDetail :orderDetails){
      List<OrderItemEntity> orderItems = STRepoUtil.getOrderDetailRepo().getOrderItems(orderDetail.getOrderDetailId());
      orderDetailDTO = OrderDetailConverter.entity2Dto(orderDetail);
      orderItemDTOS = OrderItemListConverter.entity2Dto(orderItems);
      results.put(orderDetailDTO,orderItemDTOS);
    }
    return results;
  }
}
