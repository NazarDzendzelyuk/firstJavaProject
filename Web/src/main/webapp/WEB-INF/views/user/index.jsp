<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- <ul> -->
<%--   <c:forEach items="${sexs}" var="sex"> --%>
<%--   	<li><a href="/category/${sex.id}">${sex.name}</a></li> --%>
<%--   </c:forEach> --%>
<!-- </ul> -->
 <body>
			<div class="clear-fix">

			<div class="middleheader ">
				<img src="https://s5.postimg.org/dk4ie7mqv/bershka.jpg" class="logow">
			</div>
			<div class="row">
				
<!-- 			<a href="/peoples">People</a> -->
			</div>
		
			<center><h2>Виберіть розділ, який вас цікавить</h2></center>
				<div >
					<c:forEach items="${sexs }" var="sex">
					<c:choose>
					<c:when test="${sex.id=='2' }">
					<a href="/category/${sex.id}"><img src="https://s5.postimg.org/a4gzieew7/Жінкам.jpg" class="photo1"></a>
					</c:when>
					</c:choose>
					</c:forEach>
					<c:forEach items="${sexs }" var="sex">
					<c:choose>
					<c:when test="${sex.id=='1' }">
					<a href="/category/${sex.id }"><img src="https://s5.postimg.org/bytu051wn/Чоловікам.jpg" class="photo2"></a>
					</c:when>
					</c:choose>
					</c:forEach>
					<c:forEach items="${sexs }" var="sex">
					<c:choose>
					<c:when test="${sex.id=='3' }">
					<a href="/category/${sex.id }"><img src="https://s5.postimg.org/793wbjaw7/Дітям.jpg" class="photo3"></a>
					</c:when>
					</c:choose>
					</c:forEach>
					<c:forEach items="${sexs }" var="sex">
					<c:choose>
					<c:when test="${sex.id=='4' }">
					<a href="/category/${sex.id }"><img src="https://s5.postimg.org/f0g0wcpnr/boys.jpg" class="photo3"></a>
					</c:when>
					</c:choose>
					</c:forEach>
				</div>
			<div class="clear-fix">
			<c:forEach items="${sexs}" var="sex">
			<c:choose>
				<c:when test="${sex.id=='2' }">
				<a href="/category/${sex.id}">
				<div class="wooman">
					<p class="textdecor">${sex.name }</p>
				</div>
				</a>
				</c:when>
				</c:choose>
				</c:forEach>
				<c:forEach items="${sexs}" var="sex">
				<c:choose>
				<c:when test="${sex.id=='1' }">
				<a href="/category/${sex.id}"><div class="man">
					<p class="textdecor">${sex.name }</p>
				</div></a>
				</c:when>
				</c:choose>
				</c:forEach>
				<c:forEach items="${sexs}" var="sex">
				<c:choose>
				<c:when test="${sex.id=='3' }">
				<a href="/category/${sex.id}"><div class="children">
					<p class="textdecor">${sex.name }</p>
				</div></a>
				</c:when>
				</c:choose>
				</c:forEach>
				<c:forEach items="${sexs}" var="sex">
				<c:choose>
				<c:when test="${sex.id=='4' }">
				<a href="/category/${sex.id}">
				<div class="boys">
					<p class="textdecor">Хлопчикам</p>
				</div></a>
				</c:when>
				</c:choose>
				</c:forEach>
			<div class="features">
				<img src="https://s5.postimg.org/w28uyg4iv/feat1.png">
				<img src="https://s5.postimg.org/l3xlg9fxj/feat2.png">
				<img src="https://s5.postimg.org/8qkr9cq93/feat3.png">
			</div>
			<div class="clear-fix">
			
				<div class="feattext1">
					<h4>Швидка доставка по всій Україні</h4>
					<p>Ми гарантуємо, що ваше замовлення буде доставлений в будь-яку точку України протягом 4-6 робочих днів. Доставка безкоштовна при замовленні від 750 гривень</p>
				</div>
				<div class="feattext2">
					<h4>Перевірка якості перед покупкою</h4>
					<p>Ви можете перевірити якість речей перед кур'єром і викупити замовлення тільки, якщо ви ним задоволені. Сплачуйте тільки те, що вам сподобалося</p>
				</div>
				<div class="feattext3">
					<h4>Справжні товари відомих брендів</h4>
					<p>Ми гарантуємо якість і справжність кожної речі, яку ви у нас купите. І у вас завжди є 30 днів, щоб повернути товар зі 100% відшкодуванням</p>
				</div>
			</div>
			<center><h3>Наші парнери</h3></center>
			<div class="ads">
				<img src="https://s5.postimg.org/t0i2ohrdz/mango.jpg">
				<img src="https://s5.postimg.org/z2ppezftz/puma.jpg">	
				<img src="https://s5.postimg.org/d636em2nb/baon.jpg">
				<img src="https://s5.postimg.org/6nac1oqg7/keddo.jpg">
				<img src="https://s5.postimg.org/4nybo0lif/salamander.jpg">
				<img src="https://s5.postimg.org/98ki2y57r/river.jpg">
				<img src="https://s5.postimg.org/9nvrvyr53/strobs.jpg">
			</div>
	<hr>
			<div class="container-fluid">
				<div class="row">
				<div class="col-md-1">
				</div>
					<div class="col-md-4">
						<p><br><h4>Великий вибір товарів</h4></br>
							Beshka.com - найбільший онлайн-магазин модного одягу, взуття та аксесуарів в Україні. Тут Ви можете купити все модні новинки з доставкою додому.
							В каталозі інтернет-магазину Beshka.com.ua більше 1000 брендів чоловічого, жіночого та дитячого взуття та одягу різних цінових категорій, загалом понад 2 000 000 товарів.
							Наш асортимент постійно поповнюється новими товарами та брендами, в числі яких є як всесвітньо відомі виробники (Mango, Incity, SAVAGE, Tom Tailor, Adidas та інші), так і дизайнерські марки, ексклюзивно представлені на Lamoda.ua.
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
				
				
			</div>
			<div class="footer">
			</div>
			</div>
		</div>
</body>


