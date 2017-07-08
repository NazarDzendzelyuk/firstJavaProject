<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- <h2>Категорія: ${category.category}</h2> --%>
<%-- <c:forEach items="${commodity}" var="commodity"> --%>
<%-- 	<a href="">${commodity.commodity}</a> --%>
<%-- </c:forEach> --%>
<!-- <h2>Виберіть ваш тип</h2> -->
<!-- <ul> -->
<%-- <c:forEach items="${wearTypes}" var="wearType"> --%>
<%-- 	<li><a href="/commodity/${wearType.id}">${wearType.wearType}</a></li> --%>
<%-- </c:forEach> --%>
<!-- </ul> -->

<div class="clear-fix">

			<div class="middleheader ">
				<img src="https://s5.postimg.org/dk4ie7mqv/bershka.jpg" class="logow">
			</div>
			<div class="row">
				
			
			</div>
		
</div>



<div class="row text-center">
					
	</div>
		<div class="row text-center">
		<div class="col-md-6">
					<c:forEach items="${wearTypes }" var="wearType">
								<img src="/images/weartype/${wearType.id}.jpg?version=${wearType.version}" height="400" width="422">
						<a href="/commodity/${wearType.id }" class="categoryText"><h2>${wearType.wearType }</h2></a>
					</c:forEach>
	</div>
				</div>
				

			
				
			