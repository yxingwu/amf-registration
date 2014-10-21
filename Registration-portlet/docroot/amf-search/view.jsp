<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/init.jsp" %>

<portlet:actionURL name="search" var="searchURL">
	<portlet:param name="mvcPath" value="/amf-search/view.jsp" />
</portlet:actionURL>

<aui:form action="<%= searchURL %>" method="post" name="fm">
	<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-postal-code" />

	<aui:input label="enter-us-zip" name="zip" />

	<aui:button-row>
		<aui:button name="search" type="submit" value="search" />
	</aui:button-row>
</aui:form>