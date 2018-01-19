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
        	<!-- LECTURE DES CONTACTS DU GROUPE -->
        	<table class="uk-table uk-table-hover uk-table-divider">
			    <thead>
			        <tr>
			        	<th>#</th>
			            <th>Group name</th>
			            <th>Actions</th>
			        </tr>
			    </thead>
			    <tbody>
			    
			    	<bean:define id="List_Groups" name="GroupList"/>
			    	<logic:iterate id="group" name = "GroupList">

					<!-- CANVAS TO ADD A CONTACT TO THE GROUP, OPEN AT YOUR OWN RISKS -->
					<div class="uk-offcanvas-content">
					    <div id="offcanvas-flip<bean:write name="group" property="groupID" />" uk-offcanvas="flip: true; overlay: true">
					        <div class="uk-offcanvas-bar">
					            <button class="uk-offcanvas-close" type="button" uk-close></button>
					            <h3>Add contact to <bean:write name="group" property="groupName" /></h3>
					            <p>
					            	
					            	<html:form action="/Contact_GroupCreate" styleClass="uk-form-stacked">
										<html:errors />
											
											<div class="uk-margin">
								        		<div class="uk-form-controls">
								        			<input class="uk-input" type="hidden" name = "ref_group" value ="<bean:write name="group" property="groupID" />"> <!-- INPUT HERE -->
												</div>
											</div>
											
											<!-- CONTACT LIST -->
											<div class="uk-margin">
										        <label class="uk-form-label" for="form-horizontal-select">Contact name</label>
										        <div class="uk-form-controls">
										        
										            <select class="form-control" id="refcontact" name="ref_contact">
										                <bean:define id="List_Contacts" name="ContactList"/>
													    	<logic:iterate id="contact" name = "ContactList">
													    		<option value = "<bean:write name="contact" property="id" />"><bean:write name="contact" property="firstName" /> <bean:write name="contact" property="lastName" /></option>
												           	</logic:iterate>
										            </select>
										            
										        </div>
										    </div>
											<!-- /CONTACT LIST -->
											
											<html:submit styleClass="uk-button uk-button-default uk-button-small"><bean:message key="forms.contact.submit" /></html:submit>
									</html:form>
					            	
					            </p>
					        </div>
					    </div>
					</div>
					<!-- /CANVAS TO ADD A CONTACT TO THE GROUP -->
					
			        <tr>
			            <td><bean:write name="group" property="groupID" /></td>
			            <td><bean:write name="group" property="groupName" /></td>
			            <td>
			           		<!-- ACTIONS ADD EDIT DELETE-->
			            	<div class="uk-button-group">
							    <div class="uk-inline">
							        <button class="uk-button uk-button-default" type="button"><span uk-icon="icon:  triangle-down"></span></button>
							        <div uk-dropdown="mode: click; boundary: ! .uk-button-group; boundary-align: true;">
							            <ul class="uk-nav uk-dropdown-nav">						            
							            <!-- INFORMATIONS -->
							                <li><a href="GroupAbout.do?id=<bean:write name="group" property="groupID" />">Informations</a></li>
						                <!-- ADD A CONTACT -->    
						                
							               	<li><a href="#" uk-toggle="target: #offcanvas-flip<bean:write name="group" property="groupID" />">Add a contact</a></li>
							               	
							            <!-- EDIT -->    
							               	<li><a href="GroupEditForm.do?id=<bean:write name="group" property="groupID" />">Edit</a></li>
							            <!-- DELETE -->
							               	<li><a href="GroupDelete.do?id=<bean:write name="group" property="groupID" />">Delete</a></li>
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
