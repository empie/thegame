<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="nl"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="nl"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="nl"> <![endif]-->
<!-- Consider adding a manifest.appcache: h5bp.com/d/Offline -->
<!--[if gt IE 8]><!--> <html class="no-js" lang="nl"> <!--<![endif]-->
<head>
<meta charset="utf-8" />
<title>Thegame</title>
<meta name="description" content="Website om makkelijk bordspelen online mee te testen">


<!-- Stylesheets -->
<link rel="shortcut icon" type="image/x-icon" href="<c:url value="/static/favicon.ico" />" />
<link rel="stylesheet" href="<c:url value="/static/css/layout/globalTemplate.css" />" type="text/css" media="all" />
<tiles:useAttribute name="additionalCss" classname="java.util.List" ignore="true" />
<c:forEach var="style" items="${additionalCss}">
	<link rel="stylesheet" href="<c:url value="/static/css/${style}" />" type="text/css" media="all" />
</c:forEach>

<!-- Javascript -->
<script type="text/javascript" src="/thegame/static/js/libs/modernizr-2.5.3.min.js"></script>
</head>
<body>
	<div class="container">
		<header class="header clearfix">
			<tiles:insertAttribute name="header" />
		</header>
		<div class="info">
			<tiles:insertAttribute name="content" />
	  	</div>
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>


<!-- JavaScript at the bottom for fast page loading -->
<tiles:useAttribute name="additionalJs" classname="java.util.List" ignore="true" />
<c:forEach var="script" items="${additionalJs}">
	<script type="text/javascript" src="<c:url value="/static/js/${script}" />"></script>
</c:forEach>

<!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if offline -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<!-- scripts concatenated and minified via build script -->
<script src="/thegame/static/js/plugins.js"></script>
<script src="/thegame/static/js/script.js"></script>
<!-- end scripts -->
</body>
</html>
