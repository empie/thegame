<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>


<article id="about" class="hero clearfix">
	<h3>Makkelijk online nieuwe features in bordspelen testen</h3>
	<p>Deze website laat toe om bordspelen of nieuwe features te playtesten zonder dat het spel effectief moet gemaakt
		worden</p>
</article>



<article id="spelLijstArtikel" class="article clearfix">
	<hgroup>
		<h3 id="spelLijstTitel">Overzicht van alle spelen die op dit ogenblik lopen</h3>
	</hgroup>
	<c:choose>
		<c:when test="${empty spelen}">
		Geen spelen
		</c:when>
		<c:otherwise>

			<table class="table">
				<thead>
					<tr>
						<th class="col_33">gameId</th>
						<th class="col_33">time created</th>
						<th class="col_33">status</th>
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

		</c:otherwise>
	</c:choose>
</article>
