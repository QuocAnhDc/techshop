<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="register" value="/register"/>

<div class="main">
    <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN SIDEBAR -->
            <div class="sidebar col-md-3 col-sm-3">
                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <li class="list-group-item clearfix"><a href="${register}"><i
                            class="fa fa-angle-right"></i><fmt:message
                            key="register" bundle="${lang}"/></a></li>
                </ul>
            </div>
            <!-- END SIDEBAR -->

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-9">
                <h1><fmt:message
                        key="login" bundle="${lang}"/></h1>
                <div class="content-form-page">
                    <div class="row">
                        <div class="col-md-7 col-sm-7">
                            <c:if test="${not empty errorMessage}">
                                <h4 class="block" style="color: red">${errorMessage}</h4>
                            </c:if>
                            <form action="${login}" method="post"
                                  class="form-horizontal form-without-legend" role="form">
                                <div class="form-group">
                                    <label for="email" class="col-lg-4 control-label">EMAIL<span
                                            class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input name="email" type="email" class="form-control"
                                               id="email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-lg-4 control-label"><fmt:message
                                            key="password" bundle="${lang}"/>
                                        <span class="require">*</span></label>
                                    <div class="col-lg-8">
                                        <input name="password" type="password" class="form-control"
                                               id="password">
                                    </div>
                                </div>
<%--                                <div class="row">--%>
<%--                                    <div class="col-lg-8 col-md-offset-4 padding-left-0">--%>
<%--                                        <a href="page-forgotton-password.html">Forget Password?</a>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
                                <div class="row">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                                        <button type="submit" class="btn btn-primary"><fmt:message
                                                key="login" bundle="${lang}"/></button>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
                                        <hr>
                                        <div class="login-socio">
                                            <p class="text-muted">or login using:</p>
                                            <ul class="social-icons">
                                                <li><a href="#" data-original-title="facebook"
                                                       class="facebook" title="facebook"></a></li>
                                                <li><a href="#" data-original-title="Twitter"
                                                       class="twitter" title="Twitter"></a></li>
                                                <li><a href="#" data-original-title="Google Plus"
                                                       class="googleplus" title="Google Plus"></a>
                                                </li>
                                                <li><a href="#" data-original-title="Linkedin"
                                                       class="linkedin" title="LinkedIn"></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-4 col-sm-4 pull-right">
                            <div class="form-info">
                                <h2><em>Important</em> Information</h2>
                                <p>Công Nghệ Phần Mềm</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>