
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/Header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Weather Service</title>
<c:set var="pageTitle" value="Home Page"/>
</head>

<body>

<c:forEach var="park" items="${parks}">

<div class="home">
			<div class="homeImage">
			<a href="/45-m3-java-capstone/DetailPage/${park.parkCode}"><img src="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" /></a>
			</div>
			
			<div class="homeText">
			<h2><c:out value="${park.name}" /></h2><br>
			<c:out value="${park.state}" />
			<c:out value="${park.parkDescription}" /> 
			
			</div>
	</div>
</c:forEach>

</body>
</html>