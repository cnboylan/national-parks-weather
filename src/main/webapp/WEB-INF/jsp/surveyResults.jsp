<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@include file="common/Header.jsp" %>

<c:url value="/css/nationalparkgeek.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">



<div>
	<div>
		<h2 id="surveyTitle">Survey Results</h2>
		
		<%-- <c:if test = "${ not empty message}">
		<h2>Thank you for voting for ${message.parkName }!</h2>
	</c:if> --%>
		<p class="tableData">Top Ranked Parks:</p>
	</div>

<table class="tableborder center">
<tr class="tableborder">
	<th class="tableborder">Park Photo</th>
	<th class="tableborder">Park Name</th>
	<th class="tableborder">Number of Votes</th>
</tr>

<c:forEach var="item" items="${surveyResults}">
	<tr class="tableborder">
	<td class="tableborder">
	<div id="imgDiv"><img id="parkImg" src="img/parks/${item.parkCode.toLowerCase()}.jpg"></div>
	</td>
	<td class="tableborder">
	<div class="tableData">${item.parkName}</div>
	</td>
	<td class="tableborder">
	<div class="tableData">${item.surveySum}</div>
	</td>
	</tr>
</c:forEach>

</table>
</div>