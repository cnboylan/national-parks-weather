
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/Header.jsp" />
<c:url value="/css/nationalparkgeek.css" var="cssHref" />
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
			
			<div class="homeParkName">
			<h2><c:out value="${park.parkName}" /></h2>
			</div>
			
			<div class="homeText">
			<c:out value="${park.state}" /><br><br>
			<c:out value="${park.description}" /> <br><br><br><br>
			
			</div>
	</div>
</c:forEach>

</body>
</html>