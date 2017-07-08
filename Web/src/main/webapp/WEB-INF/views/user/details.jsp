<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- <div class="row text-center"> -->
<!-- <div class="col-md-12 col-xs-12"> -->
<%-- <h2>Деталі товару: ${commodity.commodity}</h2> --%>
<%-- <img src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"  width="300"> --%>
<!-- <ul> -->
<%-- <li>Ціна: ${commodity.price}</li> --%>
<%-- <li>Розмір: ${commodity.size}</li> --%>
<%--   <c:forEach items="${colors}" var="color"> --%>
<%--   	<li>Колір: ${color.color}<br> </li> --%>
<%--   </c:forEach> --%>
<%--   <c:forEach items="${materials}" var="material"> --%>
<%--   	<li>Матеріал ${material.material}<br> </li> --%>
<%--   </c:forEach> --%>
<%--    <c:forEach items="${sexs}" var="sex"> --%>
<%--   	<li>Стать: ${sex.name}<br> </li> --%>
<%--   </c:forEach> --%>
<!-- </ul> -->
<!-- </div> -->
<!-- </div> -->
<div class="row">
	<div class="middleheader ">
		<img src="https://s5.postimg.org/dk4ie7mqv/bershka.jpg" class="logow">
	</div>
</div>
<div class="row ">
	<div class="col-md-4">
		<img src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}"  width="300" class="detailsImage">
	</div>
	<div class="col-md-6" >
		<form:form class="form-horizontal" action="/user/details" method="GET" modelAttribute="item">
	
	<ul class="detailsText">
		<li><h3>Назва: ${commodity.commodity }</h3></li>
		<li><h3>Ціна: ${commodity.price } грн</h3></li>
		<c:forEach items="${sexs }" var="sex">	
		<li><h3>Стать: ${sex.name }</h3></li>
		</c:forEach>
		<c:forEach items="${colors }" var="color">	
			<li><h3>Колір: ${color.color}</h3></li>
		</c:forEach>
		<c:forEach items="${materials }" var="material">	
			<li><h3>Матеріал: ${material.material}</h3></li>
		</c:forEach>
		<li><h3>Розмір: ${commodity.size }</h3></li>
			
	</ul>
		<sec:authorize access="isAuthenticated()">
			<a class="btn btn-danger" href="/user/details/save/${commodity.id }">Додати в корзину</a>
		</sec:authorize>
				<sec:authorize access="!isAuthenticated()">
		
					<a class="btn btn-danger" href="/login">Додати в корзину</a>
			</sec:authorize>
	</form:form>
	</div>
</div>


					
			
				
<div class="footer">
</div>