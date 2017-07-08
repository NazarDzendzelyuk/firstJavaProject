<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row text-center">
	<h2 class="col-md-4">Назва товару</h2>
	<h2 class="col-md-4">Ціна</h2>
	<h2 class="col-md-4">Опції</h2>
</div>
<c:forEach items="${items}" var="item">
<div class="row text-center">
	<div class="col-md-4">${item.itemName }</div>
	<div class="col-md-4">${item.totalPrice }</div>
	<div class="col-md-4"><a href="/delete/${item.id }" class="btn btn-danger">Видалити</a></div>
</div>
</c:forEach>
<div class="probil"></div>
<div class="row text-center">
	<div class="col-md-4"></div>
	<div class="col-md-2">Загальна вартість: ${totalPrices }</div>
	<div class="col-md-2">
	
	<a href="/checkOut" class="btn btn-success" id="checkout">Checkout</a>
	</div>
</div>
<script type="text/javascript">
document.getElementById('checkout').addEventListener('click', function(){
	alert("Дякуємо за замовлення\nНезабаром ми з вами зв'яжемося")
});
</script>