<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-default">
<button type="button" 
						class="navbar-toggle collapsed"
						data-toggle="collapse"
						data-target="#one"
						aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
<div class="collapse navbar-collapse" id="one">
						
  <div class="container-fluid">
 <a href="#" class="cart-button" style="display: none;">
  <span class="cart-button-quantity"></span>
  <span class="cart-button-label"></span>
  <!-- Or put an image here instead of span elements with text. -->
</a>
      <div class="navbar-header">
      
<div class="rightheader">	
		<a href="/">Головна</a>
    <sec:authorize access="isAuthenticated()">
<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="/admin/commodity">Admin</a>
	</sec:authorize>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
<a href="/login">Логін</a>
<a href="/registration">Реєстрація</a>

</sec:authorize>
<a href="/cart" target="_blank"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>Корзина</span></a>
    </div>
</div>
    <ul class="nav navbar-nav">
<!--       	<li><a>Home</a></li> -->
<!--       	<li><a>Page 1</a></li> -->
<!--       	<li><a>Page 2</a></li> -->
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <sec:authorize access="isAuthenticated()">
<form:form action="/logout" method="POST">
		<div class="btn"><button type="submit" class="btn btn-danger">Logout</button></div>
	</form:form>
		</sec:authorize>
    </ul>
  </div>
  </div>
</nav>

