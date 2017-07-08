<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/registration" method="POST" modelAttribute="user">
				<div class="form-group">
						<label for="email" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="email"/></label>
					</div>
					<div class="form-group">
    					<label for="email" class="col-sm-2 control-label" >Email</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="email" id="email" placeholder="you@example.org"/>
    					</div>
  					</div>
  					<div class="form-group">
						<label for="password" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="password"/></label>
					</div>
					<div class="form-group">
    					<label for="password" class="col-sm-2 control-label">Password</label>
    					<div class="col-sm-10">
      						<form:password class="form-control" path="password" id="password"/>
    					</div>
  					</div>
  					<div class="form-group">
						<label for="address" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="address"/></label>
					</div>
  					<div class="form-group">
    					<label for="address" class="col-sm-2 control-label">Address</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="address" id="address"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="phoneNumber" class="col-sm-2 control-label">Phone number</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="phoneNumber" id="phoneNumber"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		
		<script>
 $('label').each(function(){
  if(!$(this).html()) $(this).parent().hide();
 });
 
</script>