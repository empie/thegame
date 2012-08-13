<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>

<hgroup>
	<h1>Overzicht van alle spelen</h1>
</hgroup>
<article>
	<table>
		<thead>
			<tr>
				<th>gameId</th>
				<th>time created</th>
				<th>status</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${spelen}" var="spel">
				<tr>
					<td><c:out value="${spel.spelId.id}" /></td>
					<td><joda:format value="${spel.tijdstipAangemaakt}" style="SS" /></td>
					<td><c:out value="${spel.status.schermTekst}" /></td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
</article>
