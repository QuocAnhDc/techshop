<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <div class="page-title">
                <h1>Quản lí thương hiệu <small>Thương hiệu</small></h1>
            </div>
        </div>
    </div>
    <div class="page-content">
        <div class="container">
            <c:if test="${message != null}">
                <div class="alert alert-success text-center">
                    <c:out value="${message}"></c:out>
                </div>
            </c:if>
            <form class="search-form" action="<c:url value="/admin/brand" />" method="GET">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search" name="value" value="${pojo.value}">
                    <span class="input-group-btn">
					<button  type="submit" href="javascript:;" class="btn submit"><i class="icon-magnifier"></i></button>
					</span>
                </div>
            </form>
            <div class="row">
                <div class="col-md-12">
                    <!-- Begin: life time stats -->
                    <div class="portlet light">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-gift font-green-sharp"></i>
                                <span class="caption-subject font-green-sharp bold uppercase">Quản lí thương hiệu</span>
                                <span class="caption-helper">Quản lí thương hiệu...</span>
                            </div>
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <a class="btn green"href="<c:url value='/admin/brand/edit'/>">Thêm thương hiệu</a>
                                </div>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-container">
                                <table class="table table-striped table-bordered table-hover" id="datatable_products">
                                    <thead>
                                    <tr role="row" class="heading">
                                        <th width="20%">
                                            ID
                                        </th>
                                        <th width="50%">
                                            Tên thương hiệu
                                        </th>
                                        <th width="30%">
                                            Mô tả
                                        </th>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="brand" items="${brands}">
                                        <tr>
                                            <td>${brand.brandId}</td>
                                            <td>${brand.name}</td>
                                            <td>${brand.description}</td>
                                            <td>
                                                <c:url value="/admin/brand/edit" var="updateURL">
                                                    <c:param name="brandId" value="${brand.brandId}"/>
                                                    <c:param name="page" value="1"/>
                                                </c:url>
                                                <a class="btn green" href="${updateURL}">Sửa</a>
                                                <form action="<c:url value="/admin/brand/delete"/>" method="post">
                                                    <input type="hidden" name="idDelete" value="${brand.brandId}"/>
                                                    <button type="submit" class="btn btn-primary">Xóa</button>
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
                            <c:url var="urlPageBegin" value="/admin/brand">
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
                                    <c:url var="urlPage" value="/admin/brand">
                                        <c:param name="page" value="${i}"/>
                                        <c:param name="value" value="${pojo.value}"/>
                                    </c:url>
                                    <a class="page-link" href="${urlPage}">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <li class="page-item">
                            <c:url var="urlPageEnd" value="/admin/brand">
                                <c:param name="page" value="${(pojo.page+1)> pojo.totalItems ? pojo.totalItems : (pojo.page+1) }"/>
                                <c:param name="value" value="${pojo.value}"/>
                            </c:url>
                            <a class="page-link" href="${urlPageEnd}">Next</a>
                        </li>

                    </ul>
                </nav>
            </div>
            <!-- END PAGE CONTENT INNER -->
        </div>
    </div>
    <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->