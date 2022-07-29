<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<c:url value="/home" var="home"/>
<c:url value="/checkout" var="checkout"/>
<c:url value="/cart" var="cart"/>

<c:set var="totalAll" value="0"/>
<fmt:setLocale value="vi_VN"/>
<%--<c:set var="pQuantity" value="0" scope="application"/>--%>
<div class="main">
    <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN CONTENT -->
            <c:if test="${empty orderDetails.itemsByCus}">
                <div class="col-sm-12 empty-cart-cls text-center"><img
                        src="<c:url value="/static/assets/frontend/onepage/img/emptycart.png"/> "
                        width="130" height="130"
                        class="img-fluid mb-4 mr-3">
                    <h3><fmt:message key="emptyOrder" bundle="${lang}"/></h3>
                </div>
            </c:if>
            <c:if test="${not empty orderDetails.itemsByCus}">
                <c:forEach var="orderDetail" items="${orderDetails.itemsByCus}">
                    <div class="col-md-12 col-sm-12">
                        <h1>
                            <fmt:formatDate type="date" value="${orderDetail.key.createdDate}"/>
                        </h1>
                        <div class="goods-page">
                            <div class="goods-data clearfix">
                                <div class="table-wrapper-responsive">
                                    <table summary="Shopping cart">
                                        <tr>
                                            <th class="goods-page-image"><fmt:message
                                                    key="image" bundle="${lang}"/></th>
                                            <th class="goods-page-description" width="768px"
                                                height="116px"><fmt:message
                                                    key="description" bundle="${lang}"/></th>
                                            <th class="goods-page-quantity"><fmt:message
                                                    key="quantity" bundle="${lang}"/></th>
                                        </tr>
                                        <c:forEach var="item" items="${orderDetail.value}">
                                            <tr>
                                                <c:url var="pDetail" value="/pDetail">
                                                    <c:param name="pojo.productId"
                                                             value="${item.productDTO.productId}"/>
                                                </c:url>
                                                <td class="goods-page-image">
                                                    <a href="${pDetail}"><img
                                                            src="${item.productDTO.photo}"
                                                            alt="Berry Lace Dress'/>"></a>
                                                </td>
                                                <td class="goods-page-description" width="600px"
                                                    height="116px">
                                                    <h3>
                                                        <a href="${pDetail}">${item.productDTO.name}</a>
                                                    </h3>
                                                    <p>${item.productDTO.description}</p>
                                                </td>

                                                <td class="goods-page-quantity">
                                                    <div class="product-quantity">
                                                        <input id="product-quantity" type="text"
                                                               value="${item.quantity}"
                                                               class="form-control"
                                                               disabled="disabled">
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>

                                <div class="shopping-total">
                                    <ul>
                                        <li class="shopping-total-price">
                                            <em><fmt:message key="total" bundle="${lang}"/></em>
                                            <strong class="price"><fmt:formatNumber
                                                    value="${orderDetail.key.total}"
                                                    type="currency"
                                                    maxFractionDigits="0"/></strong>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

            <div class="col-md-12 col-sm-12">
                <a class="btn btn-default" href="${home}"><fmt:message key="home"
                                                                       bundle="${lang}"/> <i
                        class="fa fa-shopping-cart"></i></a>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
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
<script src="<c:url value='/static/assets/global/plugins/rateit/src/jquery.rateit.js'/>"
        type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js'/>" type="text/javascript"></script>
<!-- for slider-range -->

<script src="<c:url value='/static/assets/frontend/layout/scripts/layout.js'/>"
        type="text/javascript"></script>

<script type="text/javascript">
  jQuery(document).ready(function () {
    Layout.init();
    Layout.initOWL();
    Layout.initTwitter();
    Layout.initImageZoom();
    Layout.initTouchspin();
    Layout.initUniform();
  });
</script>
<!-- END PAGE LEVEL JAVASCRIPTS -->