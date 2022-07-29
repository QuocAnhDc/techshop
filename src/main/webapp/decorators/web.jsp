<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <title>TechShop</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta content="Metronic Shop UI description" name="description">
    <meta content="Metronic Shop UI keywords" name="keywords">
    <meta content="keenthemes" name="author">

    <meta property="og:site_name" content="-CUSTOMER VALUE-">
    <meta property="og:title" content="-CUSTOMER VALUE-">
    <meta property="og:description" content="-CUSTOMER VALUE-">
    <meta property="og:type" content="website">
    <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
    <meta property="og:url" content="-CUSTOMER VALUE-">

    <link rel="shortcut icon" href="favicon.ico">
    <link rel="icon"
          href="<c:url value='/static/assets/frontend/layout/img/logos/logo-shop-red.png'/>">

    <!-- Fonts START -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
          rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
          rel="stylesheet" type="text/css"><!--- fonts for slider on the index page -->
    <!-- Fonts END -->

    <!-- Global styles START -->
    <link href="<c:url value='/static/assets/global/plugins/font-awesome/css/font-awesome.min.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/bootstrap/css/bootstrap.min.css'/>"
          rel="stylesheet">
    <!-- Global styles END -->

    <!-- Page level plugin styles START -->
    <link href="<c:url value='/static/assets/global/plugins/fancybox/source/jquery.fancybox.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/slider-layer-slider/css/layerslider.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/uniform/css/uniform.default.css'/>"
          rel="stylesheet" type="text/css">
    <link href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" rel="stylesheet"
          type="text/css">
    <!-- for slider-range -->
    <link href="<c:url value='/static/assets/global/plugins/rateit/src/rateit.css'/>"
          rel="stylesheet" type="text/css">
    <!-- Page level plugin styles END -->

    <!-- Theme styles START -->
    <link href="<c:url value='/static/assets/global/css/components.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/layout/css/style.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/pages/css/style-shop.css'/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/frontend/pages/css/style-layer-slider.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/layout/css/style-responsive.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/layout/css/themes/red.css'/>" rel="stylesheet"
          id="style-color">
    <link href="<c:url value='/static/assets/frontend/layout/css/custom.css'/>" rel="stylesheet">
    <style>
      body {
        display: flex;
        min-height: 100vh;
        flex-direction: column;
      }

      #content {
        flex: 1;
      }
    </style>
</head>
<body class="ecommerce">

<!-- Header -->
<%@ include file="/common/web/header.jsp" %>
<!-- End Header -->
<div id="content">
    <!-- Begin body -->
    <dec:body/>
    <!-- End body -->
</div>
<!-- Begin footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- end footer -->

<!---PAGINATION--->
<script type="text/javascript">
  $("body").on("click", ".paginationItem", function () {
    var currentPage = $(this).text();
    var totalPages = ${productItems.totalPages};
    var maxPageItems = ${productItems.maxPageItems};
    var firstIndex = (currentPage - 1) * maxPageItems;
    var totalItems = ${productItems.totalItems};
    var sort = '${empty productItems.sort?'':productItems.sort}';
    var searchName = '${empty productItems.searchName?'':productItems.searchName}';
    var brandId = ${empty productItems.brand.brandId?0:productItems.brand.brandId};
    var categoryId = ${empty productItems.category.categoryId?0:productItems.category.categoryId};

    $.ajax({
      url: "/api/get-product-list",
      type: "GET",
      data: {
        firstIndex: firstIndex,
        brandId: brandId,
        categoryId: categoryId,
        searchName: searchName,
        sort: sort
      },
      success: function (value) {
        var productList = $("#product-list").find("#product-item");
        productList.empty();
        productList.append(value);
        displayPagination(currentPage, totalPages);
        changeNotification(firstIndex, maxPageItems, totalItems);
      }
    })
  })

  function displayPagination(currentPage, totalPages) {
    document.getElementById("pagination-bar").innerHTML = '';
    var current = '<li class="paginationItem"><span><a href="#">' + currentPage + '</a></span></li>';

    var nHTML = '';
    pagination(currentPage, totalPages).forEach(function (i) {
      if (i==currentPage){
        nHTML+=current;
      } else {
        nHTML += '<li class="paginationItem"><a href="#">' + i + '</a></li>';
      }
    });
    document.getElementById("pagination-bar").innerHTML = '<ul class="pagination pull-right">'
        + nHTML + '</ul>'
  }

  function changeNotification(firstIndex, maxPageItems, totalItems) {
    if(totalItems > maxPageItems){
      document.getElementById("quantity-notification").innerHTML = 'Sản phẩm ' + Number(firstIndex+1) + ' đến '
          + Number(firstIndex + maxPageItems )
          + ' với tổng ' + totalItems ;
    } else {
      document.getElementById("quantity-notification").innerHTML = totalItems + ' sản phẩm được tìm thấy';
    }

  }

  function pagination(c, m) {
    var current = c,
        last = m,
        delta = 2,
        left = current - delta,
        right = current + delta + 1,
        range = [],
        rangeWithDots = [],
        l;

    for (let i = 1; i <= last; i++) {
      if (i == 1 || i == last || i >= left && i < right) {
        range.push(i);
      }
    }

    for (let i of range) {
      if (l) {
        if (i - l === 2) {
          rangeWithDots.push(l + 1);
        } else if (i - l !== 1) {
          rangeWithDots.push('...');
        }
      }
      rangeWithDots.push(i);
      l = i;
    }

    return rangeWithDots;
  }
</script>

<!---UPDATE CART QUANTITY--->
<script type="text/javascript">
  function updateCart(productId) {
    var cusId = ${empty sessionScope.loginedUser.userId?-1:sessionScope.loginedUser.userId};
    var quantity = document.getElementById('product-quantity').value;

    $.ajax({
      url: "/api/update-cart",
      type: "POST",
      data: {
        cusId: cusId,
        quantity: quantity,
        productId: productId
      },
      success: function () {
        window.location.href = '/cart';
        alert('Cập nhật thành công');
      }
    });
  }

</script>

<!--ADD PRODUCT TO CART--->
<script>
  function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    let expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/cart";
  }

  function addToCart() {
    var productId = ${empty product.productId?-1:product.productId};
    var cusId = ${empty sessionScope.loginedUser.userId ? -1: sessionScope.loginedUser.userId };
    $.ajax({
      url: "/api/add-to-cart",
      type: "POST",
      data: {
        cusId: cusId,
        productId: productId
      },
      success: function (value) {
        if (cusId == -1) {
          setCookie('productId' + productId, productId, 1);
        }
        document.getElementById('successful-add').innerHTML = 'THÊM THÀNH CÔNG';
      },
      error: function (value) {
        document.getElementById('successful-add').innerHTML = 'THÊM THẤT BẠI';
      }
    })
  }
</script>


<!--CHECK PASSWORD--->
<script type="text/javascript">
  $(document).ready(function () {
    $('#pass, #re_pass').on('keyup', function () {
      if ($('#pass').val() != '' && $('#re_pass').val() != '') {
        if ($('#pass').val() == $('#re_pass').val()) {
          $('#check_matching').html('OK').css('color', 'green');
          $('#signup').prop('disabled', false);
        } else {
          $('#check_matching').html('Không OK').css('color', 'red');
          $('#signup').prop('disabled', true);
        }
      } else {
        $('#check_matching').text('')
      }
    });
  });
</script>

<%--<script type="text/javascript">--%>

<%--  function sortFunction() {--%>
<%--    var selectBox = document.getElementById("sortBox");--%>
<%--    var selectedValue = selectBox.options[selectBox.selectedIndex].value;--%>
<%--    document.getElementById("sortInput").value=selectedValue;--%>
<%--  }--%>
<%--</script>--%>

<!-- END CORE PLUGINS -->
<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
</html>
