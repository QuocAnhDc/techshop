<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<fmt:setLocale value="vi_VN"/>

<!-- BEGIN SLIDER -->
<div class="page-slider margin-bottom-35">
    <!-- LayerSlider start -->
    <div id="layerslider" style="width: 100%; height: 494px; margin: 0 auto;">
        <!-- slide one start -->
        <div class="ls-slide ls-slide1"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 24,25,27,28;">

            <img src="<c:url value='/static/assets/frontend/pages/img/layerslider/slide1/bg.jpg'/>"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title" style="top: 96px; left: 35%; white-space: nowrap;" data-ls="
            fade: true;
            fadeout: true;
            durationin: 750;
            durationout: 750;
            easingin: easeOutQuint;
            rotatein: 90;
            rotateout: -90;
            scalein: .5;
            scaleout: .5;
            showuntil: 4000;
          "></div>

            <div class="ls-l ls-mini-text" style="top: 338px; left: 35%; white-space: nowrap;"
                 data-ls="
          fade: true;
          fadeout: true;
          durationout: 750;
          easingin: easeOutQuint;
          delayin: 300;
          showuntil: 4000;
          ">
            </div>
        </div>
        <!-- slide one end -->

        <!-- slide two start -->
        <div class="ls-slide ls-slide2"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">

            <img src="<c:url value='/static/assets/frontend/pages/img/layerslider/slide2/bg.jpg'/>"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title" style="top: 40%; left: 21%; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationin: 750; durationout: 109750;
          easingin: easeOutQuint;
          easingout: easeInOutQuint;
          delayin: 0;
          delayout: 0;
          rotatein: 90;
          rotateout: -90;
          scalein: .5;
          scaleout: .5;
          showuntil: 4000;
          ">
            </div>

            <div class="ls-l ls-price" style="top: 50%; left: 45%; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationout: 109750;
          easingin: easeOutQuint;
          delayin: 300;
          scalein: .8;
          scaleout: .8;
          showuntil: 4000;">
            </div>

            <a href="#" class="ls-l ls-more"
               style="top: 72%; left: 21%; display: inline-block; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationin: 750;
          durationout: 750;
          easingin: easeOutQuint;
          easingout: easeInOutQuint;
          delayin: 0;
          delayout: 0;
          rotatein: 90;
          rotateout: -90;
          scalein: .5;
          scaleout: .5;
          showuntil: 4000;">
            </a>
        </div>
        <!-- slide two end -->

        <!-- slide three start -->
        <div class="ls-slide ls-slide3"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 92,93,105;">

            <img src="<c:url value='/static/assets/frontend/pages/img/layerslider/slide3/bg.jpg'/>"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title" style="top: 83px; left: 33%; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationin: 750;
          durationout: 750;
          easingin: easeOutQuint;
          rotatein: 90;
          rotateout: -90;
          scalein: .5;
          scaleout: .5;
          showuntil: 4000;
          ">
            </div>
            <div class="ls-l"
                 style="top: 333px; left: 33%; white-space: nowrap; font-size: 20px; font: 20px 'Open Sans Light', sans-serif;"
                 data-ls="
          fade: true;
          fadeout: true;
          durationout: 750;
          easingin: easeOutQuint;
          delayin: 300;
          scalein: .8;
          scaleout: .8;
          showuntil: 4000;
          ">
            </div>
        </div>
        <!-- slide three end -->

        <!-- slide four start -->
        <div class="ls-slide ls-slide4"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">

            <img src="<c:url value='/static/assets/frontend/pages/img/layerslider/slide1/bg.jpg'/>"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title" style="top: 35%; left: 60%; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationin: 750;
          durationout: 750;
          easingin: easeOutQuint;
          rotatein: 90;
          rotateout: -90;
          scalein: .5;
          scaleout: .5;
          showuntil: 4000;">

            </div>

            <div class="ls-l ls-mini-text" style="top: 70%; left: 60%; white-space: nowrap;"
                 data-ls="
          fade: true;
          fadeout: true;
          durationout: 750;
          easingin: easeOutQuint;
          delayin: 300;
          scalein: .8;
          scaleout: .8;
          showuntil: 4000;">
            </div>

        </div>
        <!-- slide four end -->
    </div>
    <!-- LayerSlider end -->
</div>
<!-- END SLIDER -->
<div class="main">
    <div class="container">
        <!-- BEGIN SALE PRODUCT & NEW ARRIVALS -->
        <div class="row margin-bottom-40">
            <!-- BEGIN SALE PRODUCT -->
            <div class="col-md-12 sale-product">
                <h2><fmt:message key="isSale" bundle="${lang}"/></h2>
                <div class="owl-carousel owl-carousel5">
                    <c:forEach items="${productItems.isSaleProducts}" var="product">
                        <div>
                            <div class="product-item">
                                <div class="pi-img-wrapper">
                                    <img src="${product.photo}"
                                         style="height: 165px;margin-left: auto;margin-right: auto;"
                                         class="img-responsive" alt="Berry Lace Dress">
                                    <div>
                                        <a href="${product.photo}" height="165px"
                                           class="btn btn-default fancybox-button">Zoom</a>
                                        <c:url var="pDetail" value="/pDetail">
                                            <c:param name="pojo.productId"
                                                     value="${product.productId}"/>
                                        </c:url>
                                        <a href="${pDetail}"
                                           class="btn btn-default fancybox-fast-view"><fmt:message
                                                key="view" bundle="${lang}"/></a>
                                    </div>
                                </div>
                                <h3><a href="${pDetail}">${product.name}</a></h3>

                                <div class="pi-price"><fmt:formatNumber value="${product.price}"
                                                                        type="currency"
                                                                        maxFractionDigits="0"
                                /></div>
                                <div class="sticker sticker-sale"></div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <!-- END SALE PRODUCT -->
        </div>
        <!-- END SALE PRODUCT & NEW ARRIVALS -->

        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40 ">
            <!-- BEGIN SIDEBAR -->
            <div class="sidebar col-md-3 col-sm-4">
                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <li class="list-group-item clearfix"><a><fmt:message key="viewCategory"
                                                                         bundle="${lang}"/></a></li>
                    <c:forEach items="${cateItems.brandInCate}" var="category">
                        </li>
                        <li class="list-group-item clearfix dropdown">
                            <a href="shop-product-list.html">
                                <i class="fa fa-angle-right"></i>
                                    ${category.key.name}
                            </a>
                            <ul class="dropdown-menu">
                                <c:forEach items="${category.value}" var="brand">
                                    <c:url var="search" value="/search">
                                        <c:param name="brand.brandId" value="${brand.brandId}"/>
                                        <c:param name="category.categoryId"
                                                 value="${category.key.categoryId}"/>
                                    </c:url>
                                    <div>
                                        <button class="btn btn-link"
                                                style="color: #555; text-decoration: none"
                                                onclick='open123("${search}")'>${brand.name}</button>
                                    </div>
                                </c:forEach>
                            </ul>
                            <script>
                              function open123(url) {
                                // alert(url)
                                window.location.replace(url);
                              }
                            </script>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-8">
                <h2><fmt:message key="newProducts" bundle="${lang}"/></h2>
                <div class="owl-carousel owl-carousel3">
                    <c:forEach items="${productItems.newProducts}" var="product">
                        <div>
                            <div class="product-item">
                                <div class="pi-img-wrapper">
                                    <img src="${product.photo}"
                                         style="height: 165px;margin-left: auto;margin-right: auto;"
                                         class="img-responsive" alt="Berry Lace Dress">
                                    <div>
                                        <a href="${product.photo}"
                                           class="btn btn-default fancybox-button">Zoom</a>
                                        <c:url var="pDetail" value="/pDetail">
                                            <c:param name="pojo.productId"
                                                     value="${product.productId}"/>
                                        </c:url>
                                        <a href="${pDetail}"
                                           class="btn btn-default fancybox-fast-view">View</a>
                                    </div>
                                </div>
                                <h3><a href="${pDetail}">${product.name}</a></h3>

                                <div class="pi-price"><fmt:formatNumber value="${product.price}"
                                                                        type="currency"
                                                                        maxFractionDigits="0"
                                /></div>
                                <div class="sticker sticker-new"></div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <c:forEach items="${cateItems.productInCate}" var="category">
                <div class="col-md-12 col-sm-6 margin-top-15">
                    <h2>${category.key.name} mới</h2>
                    <div class="owl-carousel owl-carousel4">
                        <c:forEach items="${category.value}" var="product">
                            <div>
                                <div class="product-item">
                                    <div class="pi-img-wrapper">
                                        <img src="${product.photo}"
                                             style="height: 165px;margin-left: auto;margin-right: auto;"
                                             class="img-responsive" alt="Berry Lace Dress">
                                        <div>
                                            <a href="${product.photo}"
                                               class="btn btn-default fancybox-button">Zoom</a>
                                            <c:url var="pDetail" value="/pDetail">
                                                <c:param name="pojo.productId"
                                                         value="${product.productId}"/>
                                            </c:url>
                                            <a href="${pDetail}"
                                               class="btn btn-default fancybox-fast-view">View</a>
                                        </div>
                                    </div>
                                    <h3><a href="${pDetail}">${product.name}</a></h3>

                                    <div class="pi-price"><fmt:formatNumber value="${product.price}"
                                                                            type="currency"
                                                                            maxFractionDigits="0"
                                    /></div>
                                    <div class="sticker sticker-new"></div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>

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

<!-- BEGIN LayerSlider -->
<script src="<c:url value='/static/assets/global/plugins/slider-layer-slider/js/greensock.js'/>"
        type="text/javascript"></script>
<!-- External libraries: GreenSock -->
<script src="<c:url value='/static/assets/global/plugins/slider-layer-slider/js/layerslider.transitions.js'/>"
        type="text/javascript"></script>
<!-- LayerSlider script files -->
<script src="<c:url value='/static/assets/global/plugins/slider-layer-slider/js/layerslider.kreaturamedia.jquery.js'/>"
        type="text/javascript"></script>
<!-- LayerSlider script files -->
<script src="<c:url value='/static/assets/frontend/pages/scripts/layerslider-init.js'/>"
        type="text/javascript"></script>
<!-- END LayerSlider -->

<script src="<c:url value='/static/assets/frontend/layout/scripts/layout.js'/>"
        type="text/javascript"></script>
<script type="text/javascript">
  jQuery(document).ready(function () {
    Layout.init();
    Layout.initOWL();
    LayersliderInit.initLayerSlider();
    Layout.initImageZoom();
    Layout.initTouchspin();
    Layout.initTwitter();
  });
</script>
<!-- END PAGE LEVEL JAVASCRIPTS -->
