<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
				<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/commodity">Commodity</a></li>
					<li><a href="/admin/color<custom:allParams/>">Color</a></li>
					<li><a href="/admin/material">Material</a></li>
					<li><a href="/admin/sex">Sex</a></li>
					<li><a href="/admin/wearType">WearType</a></li>
					<li  class="active"><a href="/admin/item<custom:allParams/>">Orders</a><span
						class="sr-only">(current)</span></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12">
	<form:form class="form-inline" action="/admin/item" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search"/>
			<div class="form-group">
				<form:input path="search" class="form-control" placeholder="Search"/>
			</div>
			<button class="btn btn-primary" type="submit">Ok</button>
		</form:form>
	</div>
	<div class="col-md-9 col-xs-12">

		<div class="row">
			<div class="col-md-2 col-xs-2"><h3>Item Name</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Phone number</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Address</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Total price</h3></div>
			<div class="col-md-2 col-xs-2"><h3>User name</h3></div>
			
			<div class="col-md-2 col-xs-2 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		
		</div>
			<c:forEach items="${page.content}" var="item">
				<div class="row">
					<div class="col-md-2 col-xs-2">${item.itemName}</div>
					<div class="col-md-2 col-xs-2">${item.phone}</div>
					<div class="col-md-2 col-xs-2">${item.address}</div>
					<div class="col-md-2 col-xs-2">${item.totalPrice}</div>
					<div class="col-md-2 col-xs-2">${item.userName}</div>
				</div>
			</c:forEach>
	</div>
	
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>

