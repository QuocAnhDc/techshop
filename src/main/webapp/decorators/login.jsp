<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <title>TechShop</title>

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

    <!-- Fonts START -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
    <!-- Fonts END -->

    <!-- Global styles START -->
    <link href="<c:url value='/static/assets/global/plugins/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
    <!-- Global styles END -->

    <!-- Page level plugin styles START -->
    <link href="<c:url value='/static/assets/global/plugins/fancybox/source/jquery.fancybox.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/uniform/css/uniform.default.css'/>" rel="stylesheet" type="text/css">
    <!-- Page level plugin styles END -->

    <!-- Theme styles START -->
    <link href="<c:url value='/static/assets/global/css/components.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/layout/css/style.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/layout/css/style-responsive.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/layout/css/themes/red.css'/>" rel="stylesheet" id="style-color">
    <link href="<c:url value='/static/assets/frontend/layout/css/custom.css'/>" rel="stylesheet">
    <!-- Theme styles END -->
</head>
<body class="ecommerce">
<!-- Header -->
<%@ include file="/common/web/header.jsp" %>
<!-- End Header -->

<!-- Begin body -->
<dec:body/>
<!-- End body -->

<!-- Begin footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- end footer -->


<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
<!--[if lt IE 9]>
<script src="<c:url value='/static/assets/global/plugins/respond.min.js'/>"></script>
<![endif]-->
<script src="<c:url value='/static/assets/global/plugins/jquery.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery-migrate.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/bootstrap/js/bootstrap.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/assets/frontend/layout/scripts/back-to-top.js'/>" type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
<script src="<c:url value='/static/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js'/>" type="text/javascript"></script><!-- pop up -->
<script src="<c:url value='/static/assets/global/plugins/uniform/jquery.uniform.min.js'/>" type="text/javascript"></script>

<script src="<c:url value='/static/assets/frontend/layout/scripts/layout.js'/>" type="text/javascript"></script>
<script type="text/javascript">
  jQuery(document).ready(function() {
    Layout.init();
    Layout.initUniform();
    Layout.initTwitter();
  });
</script>
<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>

</html>
