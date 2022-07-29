<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <!-- BEGIN PAGE TITLE -->
            <div class="page-title">
                <h1>Quản lí đơn hàng <small>Danh sách đơn hàng</small></h1>
            </div>
            <!-- END PAGE TITLE -->
        </div>
    </div>
    <!-- END PAGE HEAD -->
    <!-- BEGIN PAGE CONTENT -->
    <div class="page-content">
        <div class="container">
            <c:if test="${message != null}">
                <div class="alert alert-success text-center">
                    <c:out value="${message}"></c:out>
                </div>
            </c:if>
            <!-- BEGIN PAGE CONTENT INNER -->
            <div class="row">
                <div class="col-md-12">
                    <!-- Begin: life time stats -->
                    <div class="portlet light">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-gift font-green-sharp"></i>
                                <span class="caption-subject font-green-sharp bold uppercase">Đơn hàng</span>
                                <span class="caption-helper">quản lí đơn hàng...</span>
                            </div>
                            <div class="col-md-6">
                                <div class="btn-group">

                                </div>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-container">
                                <table class="table table-striped table-bordered table-hover" id="datatable_orders">
                                    <thead>
                                    <tr role="row" class="heading">
                                        <th width="10%">
                                            ID
                                        </th>
                                        <th width="15%">
                                            SĐT
                                        </th>
                                        <th width="15%">
                                            Địa chỉ
                                        </th>
                                        <th width="10%">
                                            Tổng
                                        </th>
                                        <th width="10%">
                                            Người mua
                                        </th>
                                        <th width="30%">
                                            Sản phẩm
                                        </th>
                                        <th width="10%">
                                            Xác nhận đơn hàng
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="order" items="${orders}">
                                        <tr>
                                            <td>${order.orderDetailId}</td>
                                            <td>${order.phoneNumber}</td>
                                            <td>${order.address}</td>
                                            <td>${order.total}</td>
                                            <td>${order.userDTO.firstName}  ${order.userDTO.lastName}</td>
                                            <td><c:forEach items="${order.orderItemDTOList}" var="item" >
                                                <p>${item.productDTO.name}  :  ${item.quantity} sản phẩm </p>
                                            </c:forEach></td>
                                            <td>
                                                <form action="<c:url value="/admin/order/edit"/>" method="post">
                                                    <input type="hidden" name="page" value="${pojo.page}">
                                                    <input type="hidden" name="pojo.orderDetailId" value="${order.orderDetailId}"/>
                                                    <input type="hidden" name="isPaid" value="${order.ispaid ==true ? false : true}"/>
                                                    <button type="submit" class="btn btn-primary">${order.ispaid ==true ? "Hủy xác " : "Xác "}nhận đơn hàng</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- End: life time stats -->
                </div>
            </div>
            <div style="text-align: center;">
                <nav aria-label="...">
                    <ul class="pagination justify-content-center=">

                        <li class="page-item ">
                            <c:url var="urlPageBegin" value="/admin/order/confirm">
                                <c:param name="page" value="${(pojo.page-1) < 1 ? 1 : (pojo.page-1) }"/>
                                <c:param name="value" value="${pojo.value}"/>
                            </c:url>
                            <a class="page-link" href="${urlPageBegin}">Previous</a>
                        </li>
                        <c:forEach var = "i" begin = "1" end = "${pojo.totalItems}">
                            <c:if test="${i==pojo.page}">
                                <li class="page-item active">
                                    <a class="page-link" href="${i==pojo.page}" >${i} <span class="sr-only"></span></a>
                                </li>
                            </c:if>
                            <c:if test="${i!=pojo.page}">
                                <li class="page-item">
                                    <c:url var="urlPage" value="/admin/order/confirm">
                                        <c:param name="page" value="${i}"/>
                                        <c:param name="value" value="${pojo.value}"/>
                                    </c:url>
                                    <a class="page-link" href="${urlPage}">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <li class="page-item">
                            <c:url var="urlPageEnd" value="/admin/order/confirm">
                                <c:param name="page" value="${(pojo.page+1)> pojo.totalItems ? pojo.totalItems : (pojo.page+1) }"/>
                                <c:param name="value" value="${pojo.value}"/>
                            </c:url>
                            <a class="page-link" href="${urlPageEnd}">Next</a>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>