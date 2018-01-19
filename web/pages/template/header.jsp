<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<!-- NAVBAR -->
<nav class="uk-navbar-container uk-margin" uk-navbar="mode: click">
	<div class="uk-navbar-left">
		<ul class="uk-navbar-nav">
			<li class="uk-active"><html:link forward="main"><bean:message key="pages.name.main"/></html:link></li>
			<li><a href="#">Add</a>
				<div class="uk-navbar-dropdown">
					<ul class="uk-nav uk-navbar-dropdown-nav">
						<li><a href="#" uk-toggle="target: #ContactModal">Un contact</a></li>
						<li><a href="#" uk-toggle="target: #GroupModal">Un groupe</a></li>
					</ul>
				</div></li>
			<li><a href="ReadContact.do">Contacts</a></li>
			<li><a href="ReadGroup.do">Groupes</a></li>
		</ul>

	</div>
</nav>
<!-- /NAVBAR -->