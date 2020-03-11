<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Geek</title>
</head>
<body>
	<header>
		<c:url value="/HomePage" var="HomePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${HomePageHref}"> <img src="${logoSrc}"
			alt="National Park Geek Logo" />
		</a>
	</header>
</body>
</html>