<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>

<html:html>

<head>

	<title>About group</title>

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
			
			<table class="uk-table uk-table-striped">
				<caption>Members of <bean:write name="group" property="groupName" /></caption>
			    <tbody>
			    
				        <bean:define id="list_group" name="ContactList"/>
				    	<logic:iterate id="contact" name = "ContactList">
				    	<tr>
				            <td><bean:write name="contact" property="firstName" /></td>
				            <td><bean:write name="contact" property="lastName" /></td>
				            <td><bean:write name="contact" property="email" /></td>
				            <td><a class="uk-link-muted" href="ContactAbout.do?id=<bean:write name="contact" property="id" />"><span uk-icon="icon: plus-circle"></span></a></td>
				        	<td><a class="uk-link-muted" href="Contact_GroupDeleteAction.do?id_contact=<bean:write name="contact" property="id" />&id_group=<bean:write name="group" property="groupID" />"><span uk-icon="icon: close"></span></a></td>
				        </tr>
			           	</logic:iterate>
			    </tbody>
			</table>
			
			
			<a class="uk-link-muted" href="ReadGroup.do">Back</a>
			
		</div>  	
	</div>
		
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit-icons.min.js"></script>
	
</body>
</html:html>
