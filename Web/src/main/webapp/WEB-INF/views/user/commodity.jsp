<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- <ul> -->
<%--   <c:forEach items="${commodities}" var="commodity"> --%>
<%--   	<li><a href="/details/${commodity.id}">${commodity.commodity}<br> --%>
<%--  </a> Ціна: ${commodity.price}</li> --%>
<%--    </c:forEach> --%>
<!-- </ul> -->
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="style.css" rel="stylesheet">
		<title>Дитячі товари</Title>
	</head>
	<body>

		<div class="Header">
			<div class="clear-fix">
			<div class="middleheader ">
				<img src="https://s5.postimg.org/dk4ie7mqv/bershka.jpg" class="logow">
			</div>
			
			</div>
		</div>
				<div class="row text-center">
					<div class="col-md-10">
					
					<c:forEach items="${commodities }" var="commodity">
					<div class="col-md-6">
						<a href="/details/${commodity.id }"><img src="/images/commodity/${commodity.id}.jpg?version=${commodity.version}" height="250"></a>
						<h3>${commodity.commodity }</h3>
						<h4>Ціна: ${commodity.price }</h4>
						<a href="/details/${commodity.id }" class="categoryText"><h4>Детальніше...</h4></a></div>
					</c:forEach>
				</div>
				<div class="row" style="margin-left:115px">
					<div class="col-md-4">
<%-- 						<c:forEach items="commodities" var="commodity"> --%>
<%-- 						<a href="/details/${commodity.id}">${commodity.commodity }</a> --%>
<%-- 						<p> ${commodity.price }</p> --%>
<%-- 						</c:forEach> --%>
						<hr>
						</div>
					</div>
				</div>
				<div class="row">
				<div class="col-md-1">
				</div>
					<div class="col-md-4">
						<p><br><h4>Великий вибір товарів</h4></br>
							Beshka.com - найбільший онлайн-магазин модного одягу, взуття та аксесуарів в Україні. Тут Ви можете купити все модні новинки з доставкою додому.
							В каталозі інтернет-магазину Beshka.com.ua більше 1000 брендів чоловічого, жіночого та дитячого взуття та одягу різних цінових категорій, загалом понад 2 000 000 товарів.
							Наш асортимент постійно поповнюється новими товарами та брендами, в числі яких є як всесвітньо відомі виробники (Mango, Incity, SAVAGE, Tom Tailor, Adidas та інші), так і дизайнерські марки, ексклюзивно представлені на Beshka.com.
							Ми співпрацюємо тільки з офіційними представниками марок. Всі товари, що надходять до нас, мають необхідні сертифікати.</p>
					</div>
					<div class="col-md-2">
					</div>
					<div class="col-md-4">
						<p><br><h4>Доставка по всій Україні</h4></br>
Beshka.com - це європейський рівень сервісу.
Ми забезпечуємо швидку доставку товарів по всій країні. Ваше замовлення буде доставлений в будь-яку точку України протягом 4-6 робочих днів.
Разом з провідними логістичними операторами по доставці товарів в Україні - Meest Express і Нова Пошта- ми постійно поліпшуємо наш сервіс і робимо все можливе, щоб Ви отримали Ваше замовлення якомога швидше.
Доставка по всій Україні безкоштовна при сумі замовлення від 750 гривень. Якщо сума замовлення менше 750 гривень, вартість доставки складе 49 гривень при замовленні через Meest Express і 39 грн при замовленні на відділення служби доставки Нова Пошта.
Підпишіться на нашу розсилку, щоб першими дізнаватися про новини доставки, а також про акції та знижки на сайті Beshka.com.</p>
					</div>
				</div>
				<div class="row">
				<div class="col-md-1">
				</div>
					<div class="col-md-4">
						<p><br><h4>Оплата і повернення</h4></br>
							Ми розвиваємося і покращуємо наш сервіс. На даний момент оплатити замовлення можна готівкою в момент доставки або банківською картою. Найближчим часом ми представимо і інші способи оплати замовлень.
							Якщо доставлений товар вам не підійшов, не сподобався або має заводський брак, ви можете повернути його протягом 14 днів не рахуючи дня покупки, поштою або протягом 30 днів з кур'єром. Ми перерахуємо вам гроші в мінімально можливі терміни після отримання вашої посилки.
							Завдяки Beshka.com купувати модні речі стало простіше, швидше і комфортніше. Приємного шопінгу!</p>
					</div>
					<div class="col-md-2">
					</div>
					<div class="col-md-4">
						<p><br><h4>Інші продавці на Beshka.com</h4></br>
							Beshka.com стає маркетплейсом: тепер на сайті представлені товари не тільки різних брендів, але і інших компаній-продавців. Ви можете насолоджуватися ще більш широким асортиментом, а ми завжди будемо ретельно відстежувати якість обслуговування клієнтів всіма продавцями. Зверніть увагу: умови доставки та повернення товарів сторонніх продавців необхідно уточнювати в описі товару і на сторінці продавця.</p>
					</div>
				</div>
				<hr>
			
					<div class="footer">
					</div>
			</div>
				
			</body>
			</html>