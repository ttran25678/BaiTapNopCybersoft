<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	
	<jsp:include page="/decorators/conponents/header-link.jsp"></jsp:include>
	
	
	
	<title>
		<dec:title />
	</title>
</head>
<body class="layout-fixed">
	<div class="preloader"></div>
	<!-- Header Layout -->
	<div class="mdk-header-layout js-mdk-header-layout">
		<!-- Header -->
		<jsp:include page="/decorators/conponents/header.jsp"></jsp:include>
		
		<!--Layout Content -->
  		<div class="mdk-header-layout__content page">
			<!-- Navigation-bar -->
			<jsp:include page="/decorators/conponents/navigation-bar.jsp"></jsp:include>
			<dec:body />
			<!--  Content -->
			<jsp:include page="/decorators/conponents/content.jsp"></jsp:include>
			
	    </div>
   		<!-- // END Header Layout Content -->
	</div>
	
	<jsp:include page="/decorators/conponents/body-script.jsp"></jsp:include>
</body>
</html>