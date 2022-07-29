<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>

<fmt:setLocale value="vi_VN"/>

<c:set var="totalAll" value="0"/>

<c:url value="/checkout" var="checkout"/>
<c:url var="cart" value="/cart"/>
<div class="main">
    <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN CONTENT -->
            <div class="col-md-12 col-sm-12">
                <h1>
                    <%--                    <fmt:message key="checkout" bundle="${lang}">--%>
                </h1>
                <form action="${checkout}" method="post">

                    <!-- BEGIN CHECKOUT PAGE -->
                    <div class="panel-group checkout-page accordion scrollable" id="checkout-page">
                        <!-- BEGIN SHIPPING ADDRESS -->
                        <div id="shipping-address" class="panel panel-default">
                            <div class="panel-heading">
                                <h2 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#checkout-page"
                                       href="#shipping-address-content" class="accordion-toggle">
                                        BƯỚC 1: NHẬP THÔNG TIN
                                    </a>
                                </h2>
                            </div>
                            <div id="shipping-address-content" class="panel-collapse collapse">
                                <div class="panel-body row">
                                    <div class="col-md-6 col-sm-6">
                                        <div class="form-group">
                                            <label for="telephone-dd">
                                                <fmt:message key="phone" bundle="${lang}"/>
                                            </label>
                                            <input type="text" id="telephone-dd"
                                                   name="pojo.phoneNumber"
                                                   class="form-control"
                                                   required>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6">
                                        <div class="form-group">
                                            <label for="address-dd">
                                                <fmt:message key="address" bundle="${lang}"/>
                                            </label>
                                            <input type="text" name="pojo.address" id="address-dd"
                                                   class="form-control"
                                                   required>
                                        </div>
                                    </div>
                                    <%--                                    <div class="col-md-12">--%>
                                    <%--                                        <button class="btn btn-primary  pull-right" type="submit"--%>
                                    <%--                                                id="button-shipping-address" data-toggle="collapse"--%>
                                    <%--                                                data-parent="#checkout-page"--%>
                                    <%--                                                data-target="#shipping-method-content">--%>
                                    <%--                                            <fmt:message key="continue" bundle="${lang}"/>--%>
                                    <%--                                        </button>--%>
                                    <%--                                    </div>--%>
                                </div>
                            </div>
                        </div>
                        <!-- END SHIPPING ADDRESS -->

                        <!-- BEGIN CONFIRM -->
                        <div id="confirm" class="panel panel-default">
                            <div class="panel-heading">
                                <h2 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#checkout-page"
                                       href="#confirm-content" class="accordion-toggle">
                                        BƯỚC 2: XÁC NHẬN ĐƠN HÀNG
                                    </a>
                                </h2>
                            </div>
                            <div id="confirm-content" class="panel-collapse collapse">
                                <div class="panel-body row">
                                    <div class="col-md-12 clearfix">
                                        <div class="table-wrapper-responsive">
                                            <table>
                                                <tr>
                                                    <th class="checkout-image">
                                                        <fmt:message key="image" bundle="${lang}"/>
                                                    </th>
                                                    <th class="checkout-description">
                                                        <fmt:message key="description"
                                                                     bundle="${lang}"/>
                                                    </th>
                                                    <th class="checkout-quantity">
                                                        <fmt:message key="quantity"
                                                                     bundle="${lang}"/>
                                                    </th>
                                                    <th class="checkout-price">
                                                        <fmt:message key="price" bundle="${lang}"/>
                                                    </th>
                                                    <th class="checkout-total">
                                                        <fmt:message key="total" bundle="${lang}"/>
                                                    </th>
                                                </tr>
                                                <c:forEach items="${cartItems}" var="item">
                                                    <c:set var="total"
                                                           value="${item.productDTO.price*item.quantity}"/>
                                                    <c:set var="totalAll"
                                                           value="${totalAll +total}"/>
                                                    <tr>
                                                        <c:url var="pDetail" value="/pDetail">
                                                            <c:param name="pojo.productId"
                                                                     value="${item.productDTO.productId}"/>
                                                        </c:url>
                                                        <td class="checkout-image">
                                                            <a href="${pDetail}"><img
                                                                    src="${item.productDTO.photo}"
                                                                    alt="Berry Lace Dress"></a>
                                                        </td>
                                                        <td class="checkout-description">
                                                            <h3>
                                                                <a href="${pDetail}">${item.productDTO.name}</a>
                                                            </h3>
                                                            <p>${item.productDTO.description}</p>
                                                        </td>
                                                        <td class="checkout-quantity">${item.quantity}</td>
                                                        <td class="checkout-price">
                                                            <strong>
                                                                <fmt:formatNumber
                                                                        value="${item.productDTO.price}"
                                                                        type="currency"
                                                                        maxFractionDigits="0"/>
                                                            </strong>
                                                        </td>
                                                        <td class="checkout-total">
                                                            <strong>
                                                                <fmt:formatNumber value="${total}"
                                                                                  type="currency"
                                                                                  maxFractionDigits="0"/>
                                                            </strong>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                        <div class="checkout-total-block">
                                            <ul>
                                                <li class="checkout-total-price">
                                                    <em><fmt:message key="total"
                                                                     bundle="${lang}"/> </em>
                                                    <strong class="price">
                                                        <fmt:formatNumber value="${totalAll}"
                                                                          type="currency"
                                                                          maxFractionDigits="0"/>
                                                    </strong>
                                                </li>
                                            </ul>
                                        </div>
                                        <%--                                        <input type="hidden" name="cartItems" value="${cartItems}"/>--%>
                                        <input type="hidden" name="total" value="${totalAll}"/>
                                        <input type="hidden" name="cusId"
                                               value="${sessionScope.loginedUser.userId}"/>
                                        <div class="clearfix"></div>

                                        <c:if test="${empty cartItems}">
                                            <button class="btn btn-primary pull-right" type="submit"
                                                    id="button-confirm" disabled="disabled">
                                                <fmt:message key="confirmOrder" bundle="${lang}"/>
                                            </button>
                                        </c:if>
                                        <c:if test="${not empty cartItems}">
                                            <button class="btn btn-primary pull-right" type="submit"
                                                    id="button-confirm">
                                                <fmt:message key="confirmOrder" bundle="${lang}"/>
                                            </button>

                                        </c:if>


                                        <button type="button"
                                                class="btn btn-default pull-right margin-right-20">
                                            <a href="${cart}"><fmt:message key="cancel"
                                                                           bundle="${lang}"/></a>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END CONFIRM -->
                    </div>
                    <!-- END CHECKOUT PAGE -->
                </form>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

<!-- BEGIN CORE PLUGINS(REQUIRED FOR ALL PAGES) -->
<!--[if lt IE 9]>
<script src="<c:url value='/static/assets/global/plugins/respond.min.js'/>"></script>
<![endif]-->
<script src="<c:url value='/static/assets/global/plugins/jquery.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery-migrate.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/bootstrap/js/bootstrap.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/frontend/layout/scripts/back-to-top.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js'/>"
        type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
<script src="<c:url value='/static/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js'/>"
        type="text/javascript"></script>
<!-- pop up -->
<script src="<c:url value='/static/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js'/>"
        type="text/javascript"></script>
<!-- slider for products -->
<script src="<c:url value='/static/assets/global/plugins/zoom/jquery.zoom.min.js'/>"
        type="text/javascript"></script>
<!-- product zoom -->
<script src="<c:url value='/static/assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js'/>"
        type="text/javascript"></script>
<!-- Quantity -->
<script src="<c:url value='/static/assets/global/plugins/uniform/jquery.uniform.min.js'/>"
        type="text/javascript"></script>

<script src="<c:url value='/static/assets/frontend/layout/scripts/layout.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/frontend/pages/scripts/checkout.js'/>"
        type="text/javascript"></script>
<script type="text/javascript">
  jQuery(document).ready(function () {
    Layout.init();
    Layout.initOWL();
    Layout.initTwitter();
    Layout.initImageZoom();
    Layout.initTouchspin();
    Layout.initUniform();
    Checkout.init();
  });
</script>
<!-- END PAGE LEVEL JAVASCRIPTS -->