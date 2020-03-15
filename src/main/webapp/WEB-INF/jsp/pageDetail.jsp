<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="/WEB-INF/jsp/common/Header.jsp" />

<section>

	<h2>${park.parkName} (${park.state})</h2>
	
	<p>${park.quote} - ${park.quoteSource}</p>
	
	<table>
		<tr>
			<td>
				<img src="<c:url value="/img/parks/${fn:toLowerCase(park.parkCode)}.jpg"/>" />
			</td>
		</tr>
		
		<tr>
			<td colspan="3">${park.description}</td>
		</tr>
		
		<tr>
			<td>Acreage: ${park.acreage}</td>
			<td>Elevation: ${park.elevationInFt} ft</td>
			<td>Species: ${park.numAnimalSpecies}</td>
		</tr>
		
		<tr>
			<td>Campsites: ${park.numOfCampsites}</td>
			<td>Entry Fee: $${park.entryFee}</td>
			<td>Trail Length: ${park.milesOfTrail} mi</td>
		</tr>
		
		<tr>
			<td>Climate: ${park.climate}</td>
			<td>Founded: ${park.yearFounded}</td>
			<td>Visitors: ${park.annualVisitors}/yr</td>
		</tr>
		
	</table>
	
	<div>
	<h2>Today</h2>
	<p>Temperature:<br><a href="?code=${park.parkCode}&temp=2">Celsius</a> | <a href="?code=${park.parkCode}&temp=1">Fahrenheit</a></p>
	</div>
	
	<div class="forcastImage">
	<c:forEach items="${forecast}" var="day">
	<img src="<c:url value="/img/weather/${day.forecast}.png"/>" />
	</c:forEach>
		</div>	
			<table>
			<tr>
			
			<!-- <div class="highLow"> -->
			<c:forEach items="${forecast}" var="day">
			<td class="highLow">
			<p>High: ${day.highTemp} Low: ${day.lowTemp}</p>
			</td>
			</c:forEach>
			<!-- </div> -->
			</tr>
			<tr>
			<!-- <div class="weatherMessage"> -->
			<c:forEach items="${forecast}" var="day">
			<td class="highLow">
			<p>${day.weatherMessage}</p>
			</td>
			</c:forEach>
			<!-- </div> -->
			</tr>
		</table>
	
	
</section>

<c:import url="/WEB-INF/jsp/common/Footer.jsp" />