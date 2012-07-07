<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <link rel="stylesheet" href="res/bootstrap/css/united.bootstrap.min.css"/>
    <link rel="stylesheet" href="res/css/app.css"/>
    <link rel="stylesheet" href="res/css/sticky.css"/>
    <script type="text/javascript" src="res/js/jquery/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="res/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="res/js/jquery/jquery.validate.min.js"></script>
    <script type="text/javascript" src="res/js/jquery/additional-methods.min.js"></script>
    <script type="text/javascript" src="res/js/jquery/jquery.validate.bootstrapfix.js"></script>
</head>
<body>
<!-- page -->
<div class="wrapper">
    <div class="container">
        <!-- header -->
        <header id="header">
            <tiles:insertAttribute name="header"/>
        </header>
        <!-- /header -->

        <!-- message -->
        <div id="message">
            <tiles:insertAttribute name="message"/>
        </div>
        <!-- /header -->

        <!-- content -->
        <div id="content">
            <tiles:insertAttribute name="content"/>
        </div>
        <!-- /content -->
    </div>
    <div class="push"><!--//--></div>
</div>
<!-- /page -->
<!-- footer -->
<footer>
    <div class="container">
        <tiles:insertAttribute name="footer"/>
    </div>
</footer>
<!-- /footer -->
</body>
</html>
