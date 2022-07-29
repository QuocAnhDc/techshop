<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<c:url var="home" value="/home"/>
<!-- BEGIN HEADER -->
<div class="page-header">
    <!-- BEGIN HEADER TOP -->
    <div class="page-header-top">
        <div class="container">
            <!-- BEGIN LOGO -->
            <div class="page-logo">
                <a href="${home}"><img
                        src="<c:url value='/static/assets/frontend/layout/img/logos/logo-shop-red.png'/>"
                        alt="Metronic Shop UI"></a>
            </div>
            <!-- END LOGO -->
            <!-- BEGIN RESPONSIVE MENU TOGGLER -->
            <a href="javascript:;" class="menu-toggler"></a>
        </div>
    </div>
    <!-- END HEADER TOP -->
    <!-- BEGIN HEADER MENU -->
    <div class="page-header-menu">
        <div class="container">
            <div class="hor-menu ">
                <ul class="nav navbar-nav" style="text-align:center">
                    <li class="" style="margin-right: 50px">
                        <a href="<c:url value="/admin"/>">Dashboard</a>
                    </li>
                    <li class="" style="margin-right: 50px">
                        <a href="<c:url value="/admin/user"/>">Tài khoản</a>
                    </li>
                    <li class=" " style="margin-right: 50px">
                        <a href="<c:url value="/admin/product"/>">Sản phẩm</a>
                    </li>
                    <li class=" " style="margin-right: 50px">
                        <a href="<c:url value="/admin/category"/>">Loại sản phẩm</a>
                    </li>
                    <li class=" " style="margin-right: 50px">
                        <a href="<c:url value="/admin/brand"/>">Thương hiệu</a>
                    </li>
                    <li class="" style="margin-right: 50px">
                        <a href="<c:url value="/admin/order"/>">Đơn hàng</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>