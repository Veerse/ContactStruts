<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<html:html>

<head>

<title><bean:message key="contact.create" /></title>

<html:base />

</head>

<body>

	<h1><bean:message key="contact.create" /></h1>
	
	<html:form action="/CreateContact">
		<html:errors />
			<fieldset class="uk-fieldset">

				<p><bean:message key="forms.contact.firstname" /> <html:text property="firstName"/></p>
				<p><bean:message key="forms.contact.lastname" /> <html:text property="lastName"/></p>
				<p><bean:message key="forms.contact.email" /> <html:text property="email"/></p>
	
				<html:submit><bean:message key="forms.contact.submit" /></html:submit>
			
			
		
	</html:form>
	<p><html:link forward="main"><bean:message key="pages.name.main"/></html:link></p>
	
</body>
</html:html>
