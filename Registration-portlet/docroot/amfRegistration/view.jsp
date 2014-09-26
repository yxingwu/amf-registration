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

<%@ include file="/amfRegistration/init.jsp" %>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		<liferay-ui:message key='<%= LanguageUtil.format(pageContext, "you-are-signed-in-as-x", themeDisplay.getUser().getFullName(), false) %>' />
	</c:when>
	<c:otherwise>
		<%@ include file="/amfRegistration/create_account.jspf" %>
	</c:otherwise>
</c:choose>