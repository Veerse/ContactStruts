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
        	<!-- LECTURE DES CONTACTS -->
        	<table class="uk-table uk-table-hover uk-table-divider">
			    <thead>
			        <tr>
			        	<th>#</th>
			            <th>First name</th>
			            <th>Last name</th>
			            <th>Email</th>
			            <th>Actions</th>
			        </tr>
			    </thead>
			    <tbody>
			    	<bean:define id="List_Contacts" name="ContactList"/>
			    	<logic:iterate id="contact" name = "ContactList">
			        <tr>
			            <td><bean:write name="contact" property="id" /></td>
			            <td><bean:write name="contact" property="firstName" /></td>
			            <td><bean:write name="contact" property="lastName" /></td>
			            <td><bean:write name="contact" property="email" /></td>
			            <td>
			           		<!-- ACTIONS -->
			            	<div class="uk-button-group">
							    <div class="uk-inline">
							        <button class="uk-button uk-button-default" type="button"><span uk-icon="icon:  triangle-down"></span></button>
							        <div uk-dropdown="mode: click; boundary: ! .uk-button-group; boundary-align: true;">
							            <ul class="uk-nav uk-dropdown-nav">						            
							            <!-- INFORMATIONS -->
							                <li><a href="ContactAbout.do?id=<bean:write name="contact" property="id" />">Informations</a></li>
							            <!-- EDIT -->    
							               	<li><a href="ContactEditForm.do?id=<bean:write name="contact" property="id" />">Edit</a></li>
							            <!-- DELETE -->
							               	<li><a href="ContactDelete.do?id=<bean:write name="contact" property="id" />">Delete</a></li>
							            </ul>
							        </div>
							    </div>
							</div>
							<!-- /ACTIONS -->
			            </td>
			        </tr>
			        </logic:iterate>
			</table>					
			
			<!-- /LECTURE DES CONTACTS -->
		</div>	
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit-icons.min.js"></script>
	
</body>
</html:html>
