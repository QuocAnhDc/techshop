<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>


<c:url var="addProduct" value="/admin/product/edit"/>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <!-- BEGIN PAGE TITLE -->
            <div class="page-title">
                <h1>Quản lí tài khoản <small>Thêm hoặc sửa sản phẩm</small></h1>
            </div>
        </div>
    </div>
    <div class="page-content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="portlet light">
                        <div class="portlet-body">
                            <div class="tabbable">
                                <div class="tab-content no-space">
                                    <div class="tab-pane active" id="tab_general">
                                        <div class="form-body">
                                            <c:if test="${user != null}">
                                                <form action="${addUser}" method="post"
                                                      style="max-width: 800px; margin: 0 auto">
                                                    <input type="hidden" value="${user.userId}" name="pojo.userId"/>
                                                    <div class="form-group " style="padding-top: 20px">
                                                        <label class="col-md-2 control-label">E-mail:</label>
                                                        <div class="col-md-10">
                                                            <input type="email" class=" form-control"
                                                                   value="${user.email}" name="pojo.email" required
                                                                   minlength="8" maxlength="128"/>
                                                        </div>
                                                    </div>
                                                    <div  style="padding-top: 20px" class="form-group ">
                                                        <label class="col-md-2 control-label">Tên:</label>
                                                        <div class="col-md-10">
                                                            <input type="text" class=" form-control"
                                                                   value="${user.firstName}" name="pojo.firstName"
                                                                   required minlength="2"
                                                                   maxlength="45"/>
                                                        </div>
                                                    </div>
                                                    <div  style="padding-top: 20px" class="form-group">
                                                        <label class="col-md-2 control-label">Họ và tên đệm </label>
                                                        <div class="col-md-10">
                                                            <input type="text" class=" form-control"
                                                                   value="${user.lastName}" name="pojo.lastName"
                                                                   required minlength="2"
                                                                   maxlength="45"/>
                                                        </div>
                                                    </div>
                                                    <div  style="padding-top: 20px" class="form-group ">
                                                        <label class="col-md-2 control-label">Mật khẩu: </label>
                                                        <div class="col-md-10">
                                                            <input type="password" class="form-control"
                                                                   value="${user.password}"
                                                                   minlength="4" maxlenth="20" name="pojo.password"/>
                                                        </div>
                                                    </div>
                                                    <div  style="padding-top: 20px" class="form-group ">
                                                        <label class="col-md-2 control-label ">Quyền</label>
                                                        <div class="col-md-10">
                                                            <block>
                                                                <c:forEach var="role" items="${roles}">
                                                                    <c:if test="${user.roleDTO.name.equals(role.name)}">
                                                                        <input type="radio"
                                                                               value="${role.name}"
                                                                               name="role"
                                                                               class="m-2"
                                                                               checked
                                                                        />
                                                                    </c:if>
                                                                    <c:if test="${!user.roleDTO.name.equals(role.name)}">
                                                                        <input type="radio"
                                                                               value="${role.name}"
                                                                               name="role"
                                                                               class="m-2"
                                                                        />
                                                                    </c:if>
                                                                    <br/>
                                                                </c:forEach>
                                                            </block>
                                                        </div>
                                                    </div>
                                                    <div  style="padding-top: 20px" class="form-group ">
                                                        <label class="col-md-2 control-label">Hình ảnh: </label>
                                                        <div class="col-md-10">
                                                            <input type="file" id="file" accept=".jpg, .png">
                                                            <progress id="progress_bar" value="0" max="100"></progress>
                                                            <img src="${user.photos}" alt="" id="image"
                                                                 style="width:300px;height:400px;">
                                                            <input type="hidden" name="pojo.photos" id="pathImage"
                                                                   value=""/>
                                                            <script src="<c:url value='/static/uploadImageUserFirebase.js'/>"
                                                                    type="text/javascript"></script>

                                                        </div>
                                                    </div>
                                                    <div  style="padding-top: 20px"  class="text-center m-3">
                                                        <input type="submit" value="Save" class="btn btn-primary m-3"/>
                                                        <a type="button" href="<c:url value='/admin/user'/>" class="btn btn-secondary">Cancel</a>
                                                    </div>
                                                </form>
                                            </c:if>
                                            <c:if test="${user == null}">
                                                <form action="${addUser}" method="post"
                                                      style="max-width: 800px; margin: 0 auto">
                                                    <input type="hidden" name="pojo.userId"/>
                                                    <div  style="padding-top: 20px" class="form-group ">
                                                        <label class="col-md-2 control-label">E-mail:</label>
                                                        <div class="col-md-10">
                                                            <input type="email" class=" form-control"
                                                                   name="pojo.email" required
                                                                   minlength="8" maxlength="128"/>
                                                        </div>
                                                    </div>
                                                    <div  style="padding-top: 20px" class="form-group ">
                                                        <label class="col-md-2 control-label">Tên: <span
                                                                class="required">
													* </span>
                                                        </label>
                                                        <div class="col-md-10">
                                                            <input type="text" class=" form-control"
                                                                   name="pojo.firstName"
                                                                   required minlength="2"
                                                                   maxlength="45"/>
                                                        </div>
                                                    </div>
                                                    <div  style="padding-top: 20px"  class="form-group ">
                                                        <label class="col-md-2 control-label">Họ và tên đệm
                                                            <span class="required"> * </span></label>
                                                        <div class="col-md-10">
                                                            <input type="text" class=" form-control"
                                                                   value="${user.lastName}" name="pojo.lastName"
                                                                   required minlength="2"
                                                                   maxlength="45"/>
                                                        </div>
                                                    </div>
                                                    <div   style="padding-top: 20px" class="form-group ">
                                                        <label class="col-md-2 control-label">Mật khẩu: <span
                                                                class="required">* </span></label>
                                                        <div class="col-md-10">
                                                            <input type="password" class="form-control"

                                                                   minlength="4" maxlenth="20" name="pojo.password"/>
                                                        </div>
                                                    </div>

                                                    <div  style="padding-top: 20px"  class="form-group ">
                                                        <label class="col-md-2 control-label ">Quyền</label>
                                                        <div class="col-md-10">
                                                            <block>
                                                                <c:forEach var="role" items="${roles}">
                                                                    <input type="radio"
                                                                           value="${role.name}"
                                                                           name="role"
                                                                           class="m-2"
                                                                    />
                                                                    <c:out value="${role.name}"></c:out>
                                                                    <br/>
                                                                </c:forEach>
                                                            </block>
                                                        </div>
                                                    </div>
                                                    <div  style="padding-top: 20px" class="form-group ">
                                                        <label class="col-md-2 control-label">Hình ảnh: </label>
                                                        <div class="col-md-10">
                                                            <input type="file" id="file" accept=".jpg, .png">
                                                            <progress id="progress_bar" value="0" max="100"></progress>
                                                            <img src="" alt="" id="image"
                                                                 style="width:300px;height:400px;">
                                                            <input type="hidden" name="pojo.photos" id="pathImage"
                                                                   value=""/>
                                                            <script src="<c:url value='/static/uploadImageUserFirebase.js'/>"
                                                                    type="text/javascript"></script>

                                                        </div>
                                                    </div>
                                                    <div   style="padding-top: 20px" class="text-center m-3">
                                                        <input type="submit" value="Save" class="btn btn-primary m-3"/>
                                                        <a type="button" href="<c:url value='/admin/user'/>" class="btn btn-secondary">Cancel</a>
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
            <!-- END PAGE CONTENT INNER -->
        </div>
    </div>
    <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->