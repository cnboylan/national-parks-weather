<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/Header.jsp" %>


	


<br><br><br>
<div>
		<h2>Give us your feedback</h2>

		
		<c:url value="/survey" var="surveyFomrUrl"/>
		<form:form method="POST" action="${surveyFormUrl}" modelAttribute="survey">
	
			<form:label path="parkCode" for="parkCode">Favorite National Park</form:label>
			<form:select path="parkCode">
					
				<c:forEach var="parks" items="${parks}">
					<option value="${parks.parkCode}">${parks.parkName}</option>
				</c:forEach>
			</form:select>
			<form:errors style="color: red" path="parkCode" cssClass="error"/><br>
		
			<form:label path="emailAddress"  for="emailAddress">Your Email</form:label>
			<form:input path="emailAddress" />
			<form:errors style="color: red" path="emailAddress" /><br>
		
			<form:label path="state" for="state">State of Residence</form:label>
			<form:select path="state" id="state">
				<c:forEach var="state" items="${states}">
					<option value="${state}">${state}</option>
				</c:forEach>
			</form:select>
			<form:errors style="color: red" path="state" /><br>
		
			<form:label path="activityLevel" for="activityLevel">Activity Level:</form:label><br>
			<input type="radio" name="activityLevel" value="Mountain Climber" checked/><small>Mountain Climber</small>
			<input type="radio" name="activityLevel" value="I Like to Move it" /><small>I Like to Move it</small>
			<input type="radio" name="activityLevel" value="Walk in the park" /><small>Walk in the park</small>
			<input type="radio" name="activityLevel" value="Couch Potato" /><small>Couch Potato</small>
			
			<form:errors style="color: red" path="activityLevel" /><br><br>
			
			<input class="submit" type="submit" value="Submit">
		</form:form>
	
 
</div>


<%@include file="common/Footer.jsp" %>