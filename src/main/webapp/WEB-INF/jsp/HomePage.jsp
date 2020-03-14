
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/Header.jsp" />
<c:url value="/css/nationalparkgeek.css" var="cssHref" />
<link rel="stylesheet" href="<c:url value="/bulma.min.css"/>">
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
			
		
			<a href="/45-m3-java-capstone/detail?code=${park.parkCode}"><img src="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" class="homeImage"/></a>
		
			
	<div class="homeParkInfo">
			
			<h2 class="homeParkName">${park.parkName}</h2>
			
			<h3 class="homeState">${park.state}</h3>
			
			<p class="homeDescription">${park.description}</p>
	</div>
</div>
	
</c:forEach>

</body>
</html>