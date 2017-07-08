<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<style>
.filter .control-label {
	text-align: left;
}
</style>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/category">Category</a></li>
					<li class="active"><a href="/admin/commodity"
						<custom:allParams/>>Commodity</a><span class="sr-only">(current)</span></li>
					<li><a href="/admin/color">Color</a></li>
					<li><a href="/admin/material">Material</a></li>
					<li><a href="/admin/sex">Sex</a></li>
					<li><a href="/admin/wearType">WearType</a></li>
					<li><a href="/admin/item">Orders</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-2 col-xs-12">
		<form:form class="form-horizontal filter" action="/admin/commodity"	method="GET" modelAttribute="filter">
			<custom:hiddenInputs
				excludeParams="minSize, maxSize, minPrice, maxPrice, categoryId, colorId, materialId, wearTypeId, sexId, _sexId, _colorId, _categoryId, _materialId, _wearTypeId" />
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="minSize" class="form-control" placeholder="MinSize" />
				</div>
				<div class="col-sm-6">
					<form:input path="maxSize" class="form-control" placeholder="MaxSize" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<form:input path="minPrice" class="form-control" placeholder="MinPrice" />
				</div>
				<div class="col-sm-6">
					<form:input path="maxPrice" class="form-control" placeholder="MaxPrice" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Category</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${categories}" itemValue="id" itemLabel="category" path="categoryId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Color</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${colors}"
						itemValue="id" itemLabel="color" path="colorId" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-12">Material</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${materials}" itemValue="id" itemLabel="material" path="materialId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">Sex</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${sexs}" itemValue="id" itemLabel="name" path="sexId" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12">WearType</label>
				<div class="col-sm-12">
					<form:checkboxes element="div" items="${wearTypes}"
						itemValue="id" itemLabel="wearType" path="wearTypeId" />
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>
	</div>
	<div class="col-md-1 col-xs-1">
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Commodity asc" paramValue="commodity" />
								<custom:sort innerHtml="Commodity desc" paramValue="commodity,desc" />
								<custom:sort innerHtml="Color asc" paramValue="color.color" />
								<custom:sort innerHtml="Color desc" paramValue="color.color,desc" />
								<custom:sort innerHtml="Size  asc" paramValue="size" />
								<custom:sort innerHtml="Size  desc" paramValue="size,desc" />
							</ul>
						</div>
					</div>
					
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
				</div>
	</div>
	<div class="col-md-8 col-xs-12">
	
		<div class="row">
		
			<div class="col-md-10 col-xs-12">
			
				<form:form class="form-horizontal" action="/admin/commodity" method="POST" modelAttribute="commodity" enctype="multipart/form-data">
					<custom:hiddenInputs excludeParams="commodity, sex, price,size,category,color,material,wearType,file"/>
					
					<div class="form-group">
						<label for="commodity" style="color: red; text-align: left;"class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="commodity" /></label>
					</div>
					
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Commodity Name</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="commodity" id="name" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="name" style="color: red; text-align: left;"	class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="price" /></label>
					</div>
					<div class="form-group">

						<label for="price" class="col-sm-2 control-label">Price</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="price" id="price" />
						</div>
					</div>
					<div class="form-group">
						<label for="name" style="color: red; text-align: left;"	class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="size" /></label>
					</div>
					<div class="form-group">

						<label for="size" class="col-sm-2 control-label">Size</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="size" id="size" />
						</div>
					</div>
					<div class="form-group">
						<label for="category" class="col-sm-2 control-label">Category</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="category" id="category" items="${categories}" itemValue="id" itemLabel="category" />
						</div>
					</div>
					<div class="form-group">
						<label for="color" class="col-sm-2 control-label">Color</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="color" id="color" items="${colors}" itemValue="id" itemLabel="color" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="material" class="col-sm-2 control-label">Material</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="material" id="material" items="${materials}" itemValue="id" itemLabel="material" />
						</div>
					</div>
					<div class="form-group">
						<label for="wearType" class="col-sm-2 control-label">WearType</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="wearType" id="wearType" items="${wearTypes}" itemValue="id" itemLabel="wearType" />
						</div>
					</div>
					<div class="form-group">
						<label for="sex" class="col-sm-2 control-label">Sex</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="sex" id="sex" items="${sexs}" itemValue="id" itemLabel="name" />
						</div>
					</div>
					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-10">
      						<input name="file" type="file" id="name">
    					</div>
  					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Create</button>
						</div>
					</div>
				</form:form>
				</div>
			</div>
		</div>
		</div>
		
		<div class="row">
		<div class="row">
		<div class="col-md-1 col-xs-1">
				<h5>Image</h5>
			</div>
			<div class="col-md-1 col-xs-1">
				<h5>Commodity name</h5>
			</div>
			<div class="col-md-1 col-xs-1">
				<h5>Price</h5>
			</div>
			<div class="col-md-1 col-xs-1">
				<h5>Size</h5>
			</div>
			<div class="col-md-1 col-xs-1">
				<h5>Category</h5>
			</div>
			<div class="col-md-1 col-xs-1">
				<h5>Color</h5>
			</div>
			<div class="col-md-1 col-xs-1">
				<h5>Material</h5>
			</div>
			
			<div class="col-md-1 col-xs-1">
				<h5>WearType</h5>
			</div>
			<div class="col-md-1 col-xs-1">
				<h5>Sex</h5>
			</div>
			<div class="col-md-1 col-xs-1">
				<h5>Update</h5>
			</div>
			<div class="col-md-1 col-xs-1">
				<h5>Delete</h5>
			</div>
		</div>
		<c:forEach items="${page.content}" var="commodity">
			<div class="row">
				<div class="col-md-1 col-xs-1"><img src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}" height="100"></div>
				<div class="col-md-1 col-xs-1">${commodity.commodity}</div>
				<div class="col-md-1 col-xs-1">${commodity.price}</div>
				<div class="col-md-1 col-xs-1">${commodity.size}</div>
				<div class="col-md-1 col-xs-1">${commodity.category.category}</div>
				<div class="col-md-1 col-xs-1">${commodity.color.color}</div>
				<div class="col-md-1 col-xs-1">${commodity.material.material}</div>
				<div class="col-md-1 col-xs-1">${commodity.wearType.wearType}</div>
				<div class="col-md-1 col-xs-1">${commodity.sex.name}</div>
				<div class="col-md-1 col-xs-1">
					<a class="btn btn-warning" href="/admin/commodity/update/${commodity.id}<custom:allParams/>">update</a>
				</div>
				<div class="col-md-1 col-xs-1">
					<a class="btn btn-danger" href="/admin/commodity/delete/${commodity.id}<custom:allParams/>">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	
	


<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
<script>
	$('label').each(function(){
		if(!$(this).html()) $(this).parent().hide();
	});
	
</script>
