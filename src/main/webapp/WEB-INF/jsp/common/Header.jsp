<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Geek</title>


<c:url value="/css/nationalparkgeek.css" var="cssHref"/>
<link rel="stylesheet" href="${cssHref}">
</head>


<body>
	
	
	<header>
	
		<c:url value="/" var="HomePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />
		
		<a href="${HomePageHref}"> <img src="${logoSrc}"
			alt="National Park Geek Logo" />
		</a>
		<form name="headerButtons" method="GET">
		<button type="submit" formaction="/45-m3-java-capstone/">Home</button> 
		<button type="submit" formaction="/45-m3-java-capstone/survey">Survey</button> 
	</form>
	
		
	</header>
	


</body>
</html>

 