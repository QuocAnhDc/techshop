<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>


<c:url var="addCategory" value="/admin/category/edit"/>
<div class="page-container">
    <div class="page-head">
        <div class="container">
            <div class="page-title">
                <h1>Chỉnh sửa loại sản phẩm <small>Thêm và chỉnh sửa sản phẩm</small></h1>
            </div>
        </div>
    </div>
    <div class="page-content">
        <div class="container">
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="<c:url value="/admin"/>">Trang chủ</a><i class="fa fa-circle"></i>
                </li>
                <li class="active">
                    Chỉnh sửa sản phẩm
                </li>
            </ul>
            <div class="row">
                <div class="col-md-12">
                    <div class="portlet light">
                        <div class="portlet-body">
                            <div class="tabbable">
                                <div class="tab-content no-space">
                                    <div class="tab-pane active" id="tab_general">
                                        <div class="form-body">
                                            <c:if test="${category != null}">
                                                <form action="<c:url value="/admin/category/edit" />" method="post" style="max-width: 800px; margin: 0 auto">
                                                    <input type="hidden" value="${category.categoryId}" name="pojo.categoryId">
                                                    <div class="form-group margin-bottom-10">
                                                        <label class="col-md-2 control-label">Tên :
                                                            <span class="required">* </span>
                                                        </label>
                                                        <div class="col-md-10">
                                                            <input type="text" value="${category.name}" class="form-control" name="pojo.name" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="form-group margin-bottom-10">
                                                        <label class="col-md-2 control-label">Mô tả: <span class="required">
													* </span>
                                                        </label>
                                                        <div class="col-md-10">
                                                            <input class="form-control" value="${category.description}" name="pojo.description">
                                                        </div>
                                                    </div>
                                                    <div class="text-center m-3">
                                                        <input type="submit" value="Save" class="btn btn-primary m-3"/>
                                                        <a type="button" href="<c:url value='/admin/category'/>" class="btn btn-secondary">Cancel</a>
                                                    </div>
                                                </form>
                                            </c:if>
                                            <c:if test="${category == null}">
                                            <form action="${addCategory}" method="post" style="max-width: 800px; margin: 0 auto">
                                                <div class="form-group margin-bottom-10">
                                                    <label class="col-md-2 control-label">Tên:
                                                        <span class="required">* </span>
                                                    </label>
                                                    <div class="col-md-10 margin-bottom-10">
                                                        <input type="text" class="form-control" name="pojo.name" placeholder="">
                                                    </div>
                                                </div>
                                                <div class="form-group margin-bottom-10">
                                                    <label class="col-md-2 control-label">Mô tả: <span class="required">
													* </span>
                                                    </label>
                                                    <div class="col-md-10 ">
                                                        <input class="form-control" name="pojo.description">
                                                    </div>
                                                </div>
                                                <div class="form-group margin-bottom-10 margin-top-10 text-center ">
                                                    <input type="submit" value="Save" class="btn btn-primary margin-top-10"/>
                                                    <a type="button" href="<c:url value='/admin/category'/>" class="btn btn-secondary">Cancel</a>
                                                </div>
                                           </form>

                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>