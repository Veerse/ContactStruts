<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>

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
	
	<div class="uk-flex uk-flex-center">
		<div class="uk-card uk-card-default uk-card-body"> 
			
			<table class="uk-table">
				<caption>About <bean:write name="contact" property="firstName" /></caption>
			    <tbody>
			        <tr>
			            <td><bean:write name="contact" property="firstName" /></td>
			            <td><bean:write name="contact" property="lastName" /></td>
			            <td><bean:write name="contact" property="email" /></td>
			        </tr>
			    </tbody>
			</table>
			
			<hr class="uk-divider-small">
				
				<table class="uk-table">
				<caption>About his entreprise</caption>
				    <tbody>
				        <tr>
				            <td>Enterprise Corp</td>
				            <td>27A87RF</td>
				        </tr>
				    </tbody>
				</table>
				
			<hr class="uk-divider-small">
			
				<table class="uk-table">
				<caption>Addresses</caption>
				    <tbody>
				        <tr>
				            <td>120 rue du Désert</td>
				            <td>Argenteuil</td>
				            <td>95100</td>
				            <td>France</td>
				        </tr>
				    </tbody>
				</table>
				
			<hr class="uk-divider-small">
			
				<table class="uk-table">
				<caption>Groups</caption>
				    <tbody>
				        
				        <bean:define id="list_group" name="GroupList"/>
				    	<logic:iterate id="group" name = "GroupList">
				    	<tr>
				            <td><bean:write name="group" property="groupName" /></td>
				            <td><a class="uk-link-muted" href="GroupAbout.do?id=<bean:write name="group" property="groupID" />"><span uk-icon="icon: plus-circle"></span></a></td>
				        </tr>
			           	</logic:iterate>
			           	
				    </tbody>
				</table>
				
			<hr class="uk-divider-small">	
			
			<a class="uk-link-muted" href="ReadContact.do">Back</a>
			
		</div>  	
	</div>
		
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit-icons.min.js"></script>
	
</body>
</html:html>
