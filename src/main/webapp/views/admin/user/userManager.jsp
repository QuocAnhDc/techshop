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
        <h1>Quản lí tài khoản </h1>
      </div>
    </div>
  </div>
  <div class="page-content">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="portlet light">
            <c:if test="${message != null}">
              <div class="alert alert-success text-center">
                <c:out value="${message}"></c:out>
              </div>
            </c:if>

            <form class="search-form" action="<c:url value="/admin/user" />" method="GET">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Search" name="value">
                <span class="input-group-btn">
					<button  type="submit" href="javascript:;" class="btn submit"><i class="icon-magnifier"></i></button>
					</span>
              </div>
            </form>

            <div class="row">
              <div class="col-md-12">
                <div class="portlet light">
                  <div class="portlet-title">
                    <div class="caption">
                      <i class="fa fa-gift font-green-sharp"></i>
                      <span class="caption-subject font-green-sharp bold uppercase">Tài khoản</span>
                      <span class="caption-helper">Quản lí tài khoản...</span>
                    </div>
                    <div class="col-md-6">
                      <div class="btn-group">
                        <a class="btn green"href="<c:url value='/admin/user/edit'/>">Thêm User</a>
                      </div>
                    </div>
                  </div>
                  <div class="portlet-body">
                    <div class="table-container">
                      <table class="table table-striped table-bordered table-hover" id="datatable_products">
                        <thead>
                        <tr role="row" class="heading">
                          <th width="10%">
                            Id
                          </th>
                          <th width="15%">
                            Email
                          </th>
                          <th width="15%">
                            Mật khẩu
                          </th>
                          <th width="10%">
                            Họ và tên đệm
                          </th>
                          <th width="10%">
                            Tên
                          </th>
                          <th width="10%">
                            Hình ảnh
                          </th>
                          <th width="15%">
                            Quyền
                          </th>
                          <th width="10%">
                            Hành động
                          </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${users}">
                          <tr>
                            <td>${user.userId}</td>
                            <td>${user.email}</td>
                            <td>${user.password}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td><img src="${user.photos}"  alt="" id="image" style="width:300px;height:300px;"></td>
                            <td>${user.roleDTO}</td>
                            <td>
                              <c:url value="/admin/user/edit" var="updateURL">
                                <c:param name="userId" value="${user.userId}"/>
                                <c:param name="page" value="1"/>
                              </c:url>
                              <a class="btn green" href="${updateURL}">Sửa</a>
                              <form action="<c:url value="/admin/user/delete"/>" method="post">
                                <input type="hidden" name="idDelete" value="${user.userId}"/>
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
        </div>
      </div>
    </div>
  </div>
</div>
<div style="text-align: center;">
  <nav aria-label="...">
    <ul class="pagination justify-content-center=">

      <li class="page-item ">
        <c:url var="urlPageBegin" value="/admin/user">
          <c:param name="page" value="${(pojo.page-1) < 1 ? 1 : (pojo.page-1) }"/>
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
            <c:url var="urlPage" value="/admin/user">
              <c:param name="page" value="${i}"/>
            </c:url>
            <a class="page-link" href="${urlPage}">${i}</a>
          </li>
        </c:if>
      </c:forEach>
      <li class="page-item">
        <c:url var="urlPageEnd" value="/admin/user">
          <c:param name="page" value="${(pojo.page+1)> pojo.totalItems ? pojo.totalItems : (pojo.page+1) }"/>
        </c:url>
        <a class="page-link" href="${urlPageEnd}">Next</a>
      </li>

    </ul>
  </nav>
</div>
</div>