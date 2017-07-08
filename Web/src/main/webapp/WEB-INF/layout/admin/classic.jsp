<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/css/chosen.min.css">
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/chosen.jquery.min.js"></script>

<script>
$(function() {
$('select').chosen();
})
 </script> 
<style type="text/css">
.rightheader{
	margin-top:10px;
	margin-left:1050px;
	word-spacing:20px;
	margin-bottom:-10px;
}
.rightheader>a{
	font-family:Arial, sans-serif;
	font-size:17px;
	color:#777;
}
.rightheader>a:hover{
	color: black;
	text-decoration:none;
}

body {
	padding-bottom: 70px; 
	padding-top: 70px;
}
@media (min-width: 1000px) {
    .navbar .navbar-nav {
        display: inline-block;
        float: none;
        vertical-align: top;
    }
    .navbar .navbar-collapse {
        text-align: center;
    }
}
@media(max-width:1000px)  {
	.nav > li{
	 	float: none;
		position: relative;
		display: block;
	}
    .navbar-collapse.collapse {
        display: none !important;
    }
    .navbar-collapse {
        overflow-x: visible !important;
    }
    .navbar-collapse.in {
      overflow-y: auto !important;
    }
    .collapse.in {
      display: block !important;
    }
    .navbar-toggle {
      display: block;
  }
}
  .bootstrap-widget .popover {margin-left: -10px !important;}
  .bootstrap-widget .popover .arrow {margin-left: 10px !important;}
</style>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
    <tiles:insertAttribute name="header" />
<%--     <tiles:insertAttribute name="subHeader" /> --%>
	<div class="container-fluid">
		<tiles:insertAttribute name="body" />
	</div>
		<tiles:insertAttribute name="footer" />
</body>
</html>