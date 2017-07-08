<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style type="text/css">
@media (min-width: 692px) and (max-width:900px){
				.navbar-nav>li>a{
					padding: 15px 5px;
				}
				
			}
.categoryText{
margin-top: -40px;
text-decoration:none;
color: black;

}
.probil{
	height: 200px;
}
.detailsText{
margin-top: 90px;
margin-left: 100px;
}
.detailsImage{
margin-left: 100px;
margin-top: 70px;
}
.around{
background-color: black;
}
.categoryText:hover{
text-decoration:none;
color: red;
}
*{
	padding:0;
	margin:0;
}
.clear-fix::after,.clear-fix::before{
	content:"";
	display:block;
	clear:both;
}
#active{
	color:red;
	text-decoration:underline;
}
.logow{
	width:190px;
	height:120px;
	text-align:center;
}
.general>a:hover{
	color: black;
	text-decoration:none;
}
.general>a{
	color: #777;
	text-decoration:none;
}
.general{
	font-family:Arial, sans-serif;
	font-size:17px;
	color:#777;
	margin-left:400px;
	color: black;
	text-decoration:none;
}
.logo{
	margin-left:650px;
	text-align:center;
	width:40%;
	height:120px;
	text-align:center;
}
.leftheader{
	width:30%;
	margin-top:10px;
	margin-left:90px;
	word-spacing:20px;
	float:left;
}
.general{
	margin-top:-50px;
}
.leftheader>a{
	font-family:Arial, sans-serif;
	font-size:17px;
	color:#777;
}
.leftheader>a:hover{
	color: black;
	text-decoration:none;
}
.middleheader{
	text-align:center;
}

.btn{
margin-right: 50px;
}
.rightheader{
	margin-top:10px;
	margin-left:40px;
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
.lowerheader{
	background-color:#fafafa;
	height:50px;
	width:100%;
	margin-top:20px;
}

.photo1{
	
	width:130px;
	border-top:1px solid black;
}
.photo2{
	width:130px;
	border-top:1px solid black;
}
.photo3{
	width:152px;
	height:148px;
	border-top:1px solid black;
}
.wooman{
	width:130px;
	background-color:#181818;
	float:left;
	text-align:center;
	height:45px;
	opacity:0.85;
	margin-top:-46px;
}

.man{
	
	width:130px;
	background-color:#181818;
	float:right;
	text-align:center;
	height:45px;
	margin-top:-45.5px;
	opacity:0.85;
	margin-right:322px;
}
.children{
	
	width:152px;
	background-color:#181818;
	float:right;
	text-align:center;
	height:45px;
	opacity:0.85;
	margin-top:-45px;
	margin-right:165px;
}
.boys{
	width:152px;;
	background-color:#181818;
	float:right;
	text-align:center;
	height:45px;
	opacity:0.85;
	margin-top:-44.8px;
	margin-right:9px;
}

.wooman:hover{
	background-color:black;
	opacity:0.9999
}
.man:hover{
	background-color:black;
	opacity:0.9999
}

.children:hover{
	background-color:black;
	opacity:0.9999
}
.boys:hover{
	background-color:black;
	opacity:0.99
}
.textdecor{
	color:#FFFFFF;
	margin-top:15px;
	font-size:20px;
	font-family: Century Gothic;
}
.features{
	height:200px;
	margin-left: 70px;

}

.features>img{
	width:115px;
	margin-top:37px;
	
}
.feattext1{
	float:left;
	width:26%;
	margin-left:50px;
	height:170px;
	border-bottom:1px solid silver;
}
.feattext1>p{
	font-family:Courier New;
	font-size:10px;
	color:#150303;
}
.feattext2{
	float:left;
	width:26%;
	height:170px;
	margin-left:25px;
	border-bottom:1px solid silver;
}
.feattext2>p{
	color:#150303;
	font-family:Courier New;
	font-size:10px;
}
.feattext3{
	float:left;
	width:25%;
	margin-left:30px;
	height:170px;
	border-bottom:1px solid silver;
}
.feattext3>p{
	font-family:Courier New;
	font-size:10px;
	color:#150303;
}
.ads{
	margin-left:10px;
	margin-top:40px;
	word-spacing: 45px;
}

.present{
	height:284px;
	margin-left:140px;
	background-color:#f1f1ed;
	width:25%;
	margin-top:40px;
	float:left;
}
.present>p{
	text-align:center;
	font-family:Courier New;
	font-size:22px;
}
.pres{
	margin-top:60px;
}
.fred{
	float:left;
	margin-left:380px;
	margin-top:35px;
}
.fred>img{
	width:76%;
}
.button{
	margin-top:10px;
	margin-left:65px;
	word-spacing:12px;
}
.search{
	width:240px;
	height:30px;
	margin-left:55px;
}
.footer{
	height:60px;
}
@media (min-width:767px){
	.categoryText{
margin-top: -40px;
text-decoration:none;
color: black;

}

.detailsText{
margin-top: 90px;
margin-left: 100px;
}
.detailsImage{
margin-left: 100px;
margin-top: 70px;
}
.around{
background-color: black;
}
.categoryText:hover{
text-decoration:none;
color: red;
}
*{
	padding:0;
	margin:0;
}
.clear-fix::after,.clear-fix::before{
	content:"";
	display:block;
	clear:both;
}
#active{
	color:red;
	text-decoration:underline;
}
.logow{
	width:190px;
	height:120px;
	text-align:center;
}
.general>a:hover{
	color: black;
	text-decoration:none;
}
.general>a{
	color: #777;
	text-decoration:none;
}
.general{
	font-family:Arial, sans-serif;
	font-size:17px;
	color:#777;
	margin-left:400px;
	color: black;
	text-decoration:none;
}
.logo{
	margin-left:650px;
	text-align:center;
	width:40%;
	height:120px;
	text-align:center;
}
.leftheader{
	width:30%;
	margin-top:10px;
	margin-left:90px;
	word-spacing:20px;
	float:left;
}
.general{
	margin-top:-50px;
}
.leftheader>a{
	font-family:Arial, sans-serif;
	font-size:17px;
	color:#777;
}
.leftheader>a:hover{
	color: black;
	text-decoration:none;
}
.middleheader{
	text-align:center;
}

.btn{
margin-right: 50px;
}
.rightheader{
	margin-top:10px;
	margin-left:40px;
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
.lowerheader{
	background-color:#fafafa;
	height:50px;
	width:100%;
	margin-top:20px;
}
.dropdown1>a{
	font-family:Arial, sans-serif;
	font-size:14px;
	color:#777;
	margin-left:100px;
	
}
.dropdown1>a:hover{
	color: black;
	text-decoration:none;
}
.dropdown>a{
	font-family:Arial, sans-serif;
	font-size:14px;
	color:#777;
	
}
.dropdown>a:hover{
	color: black;
	text-decoration:none;
}
.photo1{
	margin-left:45px;
	width:350px;
	height:456px;
	border-top:1px solid black;
}
.photo2{
	width:350px;
	height:456px;
	border-top:1px solid black;
}
.photo3{
	width:350px;
	height:456px;
	border-top:1px solid black;
}
.wooman{
	margin-left:45px;
	width:350px;
	background-color:#181818;
	float:left;
	text-align:center;
	height:65px;
	opacity:0.85;
	margin-top:-65px;
}

.man{
	
	width:350px;
	background-color:#181818;
	float:right;
	text-align:center;
	height:65px;
	margin-top:-65px;
	opacity:0.85;
	margin-right:740px;
}
.children{
	
	width:350px;
	background-color:#181818;
	float:right;
	text-align:center;
	height:65px;
	opacity:0.85;
	margin-top:-65px;
	margin-right:386.5px;
}
.boys{
	width:350px;
	background-color:#181818;
	float:right;
	text-align:center;
	height:65px;
	opacity:0.85;
	margin-top:-65px;
	margin-right:32px;
}

.wooman:hover{
	background-color:black;
	opacity:0.9999
}
.man:hover{
	background-color:black;
	opacity:0.9999
}

.children:hover{
	background-color:black;
	opacity:0.9999
}
.boys:hover{
	background-color:black;
	opacity:0.99
}
.textdecor{
	color:#FFFFFF;
	margin-top:17px;
	font-size:26px;
	font-family: Century Gothic;
}
.features{
	width:100%;
	height:200px;
	word-spacing:100px;
}

.features>img{
	margin-left:175px;
	margin-top:40px;
	
}
.feattext1{
	float:left;
	width:26%;
	margin-left:150px;
	height:170px;
	border-bottom:1px solid silver;
}
.feattext1>p{
	font-family:Courier New;
	font-size:16px;
	color:#150303;
}
.feattext2{
	float:left;
	width:26%;
	height:170px;
	margin-left:25px;
	border-bottom:1px solid silver;
}
.feattext2>p{
	color:#150303;
	font-family:Courier New;
	font-size:16px;
}
.feattext3{
	float:left;
	width:25%;
	margin-left:30px;
	height:170px;
	border-bottom:1px solid silver;
}
.feattext3>p{
	font-family:Courier New;
	font-size:16px;
	color:#150303;
}
.ads{
	margin-left:130px;
	margin-top:40px;
	word-spacing: 45px;
}
.ads>a{
	margin-left:20px;
}
.present{
	height:284px;
	margin-left:140px;
	background-color:#f1f1ed;
	width:25%;
	margin-top:40px;
	float:left;
}
.present>p{
	text-align:center;
	font-family:Courier New;
	font-size:22px;
}
.pres{
	margin-top:60px;
}

.button{
	margin-top:10px;
	margin-left:65px;
	word-spacing:12px;
}

.footer{
	height:60px;
}
}
</style>

<!-- сюди буде підставлено атрибут з ім'ям title -->
<title><tiles:getAsString name="title" /></title>
</head>
<body>
<!-- 	а сюди jsp файл з ім'ям header -->
    <tiles:insertAttribute name="header" />
	<div class="container-fluid">
<!-- 	сюди jsp файл з ім'ям body -->
		<tiles:insertAttribute name="body" />
	</div>
<!-- 	сюди jsp файл з ім'ям footer -->
		<tiles:insertAttribute name="footer" />
<!-- 	зверніть увагу на те що в темплейт файлі (тут) -->
<!-- 	вже описано основний HTML код, в інших файлах -->
<!-- 	його писати не потрібно(я про <head><body><html>) -->
</body>
</html>