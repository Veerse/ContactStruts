<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>

 <html:html>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit contact</title>

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
		
			<h1 class="uk-heading-primary">Edit</h1>
			
			<html:form action="/EditContact" styleClass="uk-form-stacked">
				<html:errors />
					<html:hidden property="id" styleId="id"></html:hidden> <!-- INPUT HERE -->
					
					<div class="uk-margin">
					 	<label class="uk-form-label" for="form-stacked-text">First name</label>
		        		<div class="uk-form-controls">
							<html:text styleClass="uk-input" property="firstName"/> <!-- INPUT HERE -->
						</div>
					</div>
					
					<div class="uk-margin">
						<label class="uk-form-label" for="form-stacked-text">Last name</label>
		       			<div class="uk-form-controls">
							<html:text styleClass="uk-input" property="lastName" /> <!-- INPUT HERE -->
						</div>
					</div>
					
					 <div class="uk-margin">
					 	<label class="uk-form-label" for="form-stacked-text">Email</label>
		       			<div class="uk-form-controls">
							<html:text styleClass="uk-input" property="email"/> <!-- INPUT HERE -->
						</div>
					</div>
					
					<html:submit styleClass="uk-button uk-button-default uk-button-small"><bean:message key="forms.contact.submit" /></html:submit>
			</html:form>
			
			<a class="uk-link-muted" href="ReadContact.do">Back</a>
			
		</div>
	</div>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/uikit-icons.min.js"></script>
	
</body>
</html>

</html:html>