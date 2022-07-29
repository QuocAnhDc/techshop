<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <title>Metronic | Metronic | Admin Dashboard Template</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <meta content="" name="description">
    <meta content="" name="author">
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
          rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/font-awesome/css/font-awesome.min.css'/>"
          rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/simple-line-icons/simple-line-icons.min.css'/>"
          rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/bootstrap/css/bootstrap.min.css'/>"
          rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/uniform/css/uniform.default.css'/>"
          rel="stylesheet"
          type="text/css">
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
    <link href="<c:url value='/static/assets/global/plugins/jqvmap/jqvmap/jqvmap.css'/>"
          rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/morris/morris.css'/>" rel="stylesheet"
          type="text/css">
    <!-- END PAGE LEVEL PLUGIN STYLES -->
    <!-- BEGIN PAGE STYLES -->
    <link href="<c:url value='/static/assets/admin/pages/css/tasks.css'/>" rel="stylesheet"
          type="text/css"/>
    <link href="<c:url value='/static/assets/global/css/components-rounded.css'/>"
          id="style_components"
          rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/assets/global/css/plugins.css'/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/admin/layout3/css/layout.css'/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/admin/layout3/css/themes/default.css'/>"
          rel="stylesheet" type="text/css"
          id="style_color">
    <link href="<c:url value='/static/assets/admin/layout3/css/custom.css'/>" rel="stylesheet"
          type="text/css">
    <!-- END THEME STYLES -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/static/assets/global/plugins/select2/select2.css'/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/static/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css'/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/static/assets/global/plugins/bootstrap-datepicker/css/datepicker.css'/>"/>
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/static/assets/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css'/>"/>
    <link href="<c:url value='/static/assets/global/plugins/fancybox/source/jquery.fancybox.css'/>"
          rel="stylesheet" type="text/css"/>
    <!-- END PAGE LEVEL STYLES -->
    <link rel="shortcut icon" href="favicon.ico"/>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-storage.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-database.js"></script>



</head>
<body>
<!-- Header -->
<%@ include file="/common/admin/header.jsp" %>
<!-- End Header -->

<dec:body/>

<!-- Begin footer -->
<%@ include file="/common/admin/footer.jsp" %>
<!-- end footer -->

<script src="<c:url value='/static/assets/global/plugins/jquery.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery-migrate.min.js'/>"
        type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="<c:url value='/static/assets/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/bootstrap/js/bootstrap.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery.blockui.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery.cokie.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/uniform/jquery.uniform.min.js'/>"
        type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="<c:url value='/static/assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js'/>"
        type="text/javascript"></script>
<script type="text/javascript"
        src="<c:url value='/static/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js'/>"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui-1.10.3.custom.min.js for drag & drop support -->
<script src="<c:url value='/static/assets/global/plugins/morris/morris.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/morris/raphael-min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery.sparkline.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/select2/select2.min.js'/>"></script>
<script src="<c:url value='/static/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js'/>"
        type="text/javascript" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value='/static/assets/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js'/>"></script>
<script src="<c:url value='/static/assets/global/plugins/bootstrap-maxlength/bootstrap-maxlength.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js'/>" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value='/static/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js'/>"></script>
<script src="<c:url value='/static/assets/global/plugins/plupload/js/plupload.full.min.js'/>" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="<c:url value='/static/assets/global/scripts/metronic.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/admin/layout3/scripts/layout.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/admin/layout3/scripts/demo.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/admin/pages/scripts/table-managed.js'/>"></script>
<script src="<c:url value='/static/assets/admin/pages/scripts/index3.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/admin/pages/scripts/tasks.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/scripts/datatable.js'/>"></script>
<script src=".<c:url value='/static/assets/admin/pages/scripts/ecommerce-products.js'/>"></script>
<script src="<c:url value='/static/assets/admin/pages/scripts/ecommerce-products-edit.js'/>"></script>
<!-- END PAGE LEVEL SCRIPTS -->

<script>
  jQuery(document).ready(function () {
    Metronic.init(); // init metronic core componets
    Layout.init(); // init layout
    Demo.init(); // init demo(theme settings page)
    Index.init(); // init index page
    Tasks.initDashboardWidget(); // init tash dashboard widget
  });
</script>

<script>
  jQuery(document).ready(function () {
    Metronic.init(); // init metronic core components
    Layout.init(); // init current layout
    Demo.init(); // init demo features
    TableManaged.init();
  });
</script>

<script>
  jQuery(document).ready(function () {
    Metronic.init(); // init metronic core components
    Layout.init(); // init current layout
    Demo.init(); // init demo features
    EcommerceProducts.init();
  });
</script>

<script>
  jQuery(document).ready(function() {
    Metronic.init(); // init metronic core components
    Layout.init(); // init current layout
    Demo.init(); // init demo features
    EcommerceProductsEdit.init();
  });
</script>
<!-- END JAVASCRIPTS -->
</body>
</html>
