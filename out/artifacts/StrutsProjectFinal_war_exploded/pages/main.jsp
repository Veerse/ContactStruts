<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<html:html>
<head>
	<title><bean:message key="contact.read" /></title>

	<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/assets/css/uikit.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/assets/css/uikit-rtl.min.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" />
</head>

<body>
	
	
	<jsp:include page="/pages/template/header.jsp" />
	<jsp:include page="/pages/template/modals.jsp" />
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit-icons.min.js"></script>
	
</body>
</html:html>
