<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<hgroup>
	<h1>
		<a href="#">Thegame</a>
	</h1>
	<h4>
		<strong>Bordspelen testen in het jaar <del>2022</del> <ins>2012</ins></strong>
	</h4>
</hgroup>
<nav class="menu_main">
	<ul>
		<li><a href="${pageContext.request.contextPath}">home</a></li>
		<li><a href="${pageContext.request.contextPath}/spel/lijst">Spelen</a></li>
	</ul>
</nav>
