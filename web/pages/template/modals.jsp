<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<!-- CONTACT FORM MODAL -->
	<div id="ContactModal" uk-modal>
	    <div class="uk-modal-dialog uk-modal-body">
	        <p>
				<html:form action="/CreateContact">
					<fieldset class="uk-fieldset">
						<legend class="uk-legend">Add a contact</legend>
						<html:errors />
							<!-- CONTACT INFOS -->
								<div class="uk-margin">
									<bean:message key="forms.contact.firstname" /> <html:text styleClass="uk-input" property="firstName"/>
								</div>
								<div class="uk-margin">
									<bean:message key="forms.contact.lastname" /> <html:text styleClass="uk-input" property="lastName"/>
								</div>
								<div class="uk-margin">
									<bean:message key="forms.contact.email" /> <html:text styleClass="uk-input" property="email"/>
								</div>
								

								
					</fieldset>
					<p class="uk-text-right">
			            <button class="uk-button uk-button-default uk-modal-close" type="button">Cancel</button>
			            <button class="uk-button uk-button-primary" type="submit">Save</button>
			        </p>
				 </html:form>
					
			</p>
	    </div>
	</div>
	<!-- /CONTACT FORM MODAL -->
	
	
	<!-- GROUP FORM MODAL -->
	<div id="GroupModal" uk-modal>
	    <div class="uk-modal-dialog uk-modal-body">
			<html:form action="/CreateGroup">
				<fieldset class="uk-fieldset">
					<legend class="uk-legend">Add a group</legend>
					<html:errors />
						<div class="uk-margin">
							Name of the group<html:text styleClass="uk-input" property="groupName"/>
						</div>
		        </fieldset>
		        <p class="uk-text-right">
		            <button class="uk-button uk-button-default uk-modal-close" type="button">Cancel</button>
		            <button class="uk-button uk-button-primary" type="submit"><bean:message key="forms.contact.submit" /></button>
		        </p>
			</html:form>		        
	    </div>
	</div>
	<!-- /GROUPE FORM MODAL -->