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

<%
boolean showPermissionsButton = MonitorEventPermission.contains(permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);
%>

<c:if test="<%= showPermissionsButton %>">
	<liferay-security:permissionsURL
		modelResource="com.liferay.monitor.model"
		modelResourceDescription="<%= HtmlUtil.escape(themeDisplay.getScopeGroupName()) %>"
		resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
		var="permissionsURL"
		windowState="<%= LiferayWindowState.POP_UP.toString() %>"
	/>

	<aui:nav-bar>
		<aui:nav>
			<aui:nav-item href="<%= permissionsURL %>" label="permissions" title="edit-permissions" useDialog="<%= true %>" />
		</aui:nav>
	</aui:nav-bar>
</c:if>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "all");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/amf-event-monitor/view.jsp");
%>

<liferay-ui:tabs
	names="all,registration,login"
	param="tabs1"
	url="<%= portletURL.toString() %>"
/>

<%
boolean hasViewPermission = MonitorEventPermission.contains(permissionChecker, scopeGroupId, ActionKeys.VIEW);

long userId = themeDisplay.getUserId();

Format dateFormatDateTime = FastDateFormatFactoryUtil.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
%>

<c:choose>
	<c:when test='<%= tabs1.equals("all") %>'>
		<%@ include file="/amf-event-monitor/view_all_events.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("registration") %>'>
		<%@ include file="/amf-event-monitor/view_registration_events.jspf" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/amf-event-monitor/view_login_events.jspf" %>
	</c:otherwise>
</c:choose>