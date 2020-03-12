<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/Header.jsp" />

<section>

	<h2>${park.parkName}</h2>
	
	<p>${park.quote} - ${park.quoteSource}</p>
	
	<table>
		<tr>
			<td>
				<img src="<c:url value="/img/${park.parkCode}.jpg"/>" />
			</td>
		</tr>
		
		<tr>
			<td>${park.description}</td>
		</tr>
		
		
	</table>
		
</section>

<c:import url="/WEB-INF/jsp/common/Footer.jsp" />