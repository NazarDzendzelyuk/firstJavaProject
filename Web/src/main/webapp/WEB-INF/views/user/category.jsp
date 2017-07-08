<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- <ul> -->
<%--   <c:forEach items="${categories}" var="category"> --%>
<%--   	<li><a href="/wearType/${category.id}">${category.category}</a></li> --%>
<%--   </c:forEach> --%>
<!-- </ul> -->
<body>

		<div class="Header">
			<div class="clear-fix">
			
			
			<div class="middleheader ">
				<a href="/start"><img src="https://s5.postimg.org/evun5nbvr/bershka.jpg" class="logow"></a>
			</div>
				
			</div>
		</div>
		
			<div class="footer">
			</div>
			
				<div class="row text-center">
				<c:choose>
				<c:when test="${sex.id=='1'}">
					<div class="col-md-4">
						<img src="https://s5.postimg.org/slytpaup3/cufflinks.jpg" width="400" height="422" >
					</div>
					<div class="col-md-4">
						<img src="https://s5.postimg.org/pf8vjezmv/middle_4f06d98e4bc0f.jpg" width="400" height="422">
					</div>
					<div class="col-md-4">
						<img src="https://s5.postimg.org/lu8emg5pj/481ceecf2312baa510daa7e8ae0d617e.jpg" width="400" height="422">
					</div>
					</c:when>
					</c:choose>
					<c:choose>
					<c:when test="${sex.id=='2'}">
					<div class="col-md-4">
						<img src="https://s5.postimg.org/3v4jxqpyf/7b9e657297f3e126da215419f36f6240.jpg" width="400" height="422" >
					</div>
					<div class="col-md-4">
						<img src="https://s5.postimg.org/pwzfliztz/147404236476.jpg" width="400" height="422">
					</div>
					<div class="col-md-4">
						<img src="https://s5.postimg.org/5gof3apk7/237570157d0813837cacb07ebb039a00.jpg" width="400" height="422">					</div>
					</c:when>
					</c:choose>
					<c:choose>
					<c:when test="${sex.id=='3'}">
					<center><div class="col-md-4 ">
						<img src="https://s5.postimg.org/3jwacgo9z/images_2.jpg" width="400" height="422" >
					</div></center>
					<div class="col-md-4">
						<img src="https://s5.postimg.org/js7x877qf/evd4_image.jpg" width="400" height="422">
					</div>
					</c:when>
					</c:choose>
					<c:choose>
				<c:when test="${sex.id=='4'}">
					<div class="col-md-4">
						<a href=""><img src="https://s5.postimg.org/77c1iiwh3/YAk_pravilno_vibrati_odyag_dlya_hlopchika.jpg" width="400" height="422" ></a>
					</div>
					<div class="col-md-4">
						<img src="https://s5.postimg.org/q0xufiup3/5137_970.jpg" width="400" height="422">
					</div>
					</c:when>
					</c:choose>
				</div>
				<div class="row text-center">
					<c:forEach items="${categories }" var="category">
					<div class="col-md-4">
						<a href="/wearType/${category.id }" class="categoryText"><h3>${category.category }</h3></a>
					</div>
					</c:forEach>
				</div>
				<div class="footer">
				</div>
				
				<hr>
				
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
			</body>