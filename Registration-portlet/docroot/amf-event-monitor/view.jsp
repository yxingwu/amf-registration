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
String tabs1 = ParamUtil.getString(request, "tabs1", "all");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/amf-event-monitor/view.jsp");
portletURL.setParameter("tabs1", tabs1);
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

<liferay-ui:search-container
	iteratorURL="<%= portletURL %>"
>

	<%
	String emptyResultsMessage = null;

	if (tabs1.equals("registration")) {
		emptyResultsMessage = "there-are-no-registration-monitor-events";

		total = hasViewPermission ? MonitorEventLocalServiceUtil.getEventsByTypeCount(MonitorEventTypes.REGISTRATION) : MonitorEventLocalServiceUtil.getEventsByTypeAndUserCount(MonitorEventTypes.REGISTRATION, userId);
	}
	else if (tabs1.equals("login")) {
		emptyResultsMessage = "there-are-no-login-monitor-events";

		total = hasViewPermission ? MonitorEventLocalServiceUtil.getEventsByTypeCount(MonitorEventTypes.LOGIN) : MonitorEventLocalServiceUtil.getEventsByTypeAndUserCount(MonitorEventTypes.LOGIN, userId);

	}
	else {
		emptyResultsMessage = "there-are-no-registration-monitor-events";

		total = hasViewPermission ? MonitorEventLocalServiceUtil.getEventsByTypeCount(MonitorEventTypes.ALL) : MonitorEventLocalServiceUtil.getEventsByTypeAndUserCount(MonitorEventTypes.ALL, userId);
	}

	searchContainer.setEmptyResultsMessage(emptyResultsMessage);
	searchContainer.setTotal(total);
	%>

	<liferay-ui:search-container-results>

		<%
		if (tabs1.equals("registration")) {
			results = hasViewPermission ? MonitorEventLocalServiceUtil.getEventsByType(MonitorEventTypes.REGISTRATION, searchContainer.getStart(), searchContainer.getEnd()) : MonitorEventLocalServiceUtil.getEventsByTypeAndUser(MonitorEventTypes.REGISTRATION, userId, searchContainer.getStart(), searchContainer.getEnd());
		}
		else if (tabs1.equals("login")) {
			results = hasViewPermission ? MonitorEventLocalServiceUtil.getEventsByType(MonitorEventTypes.LOGIN, searchContainer.getStart(), searchContainer.getEnd()) : MonitorEventLocalServiceUtil.getEventsByTypeAndUser(MonitorEventTypes.LOGIN, userId, searchContainer.getStart(), searchContainer.getEnd());
		}
		else {
			results = hasViewPermission ? MonitorEventLocalServiceUtil.getEventsByType(MonitorEventTypes.ALL, searchContainer.getStart(), searchContainer.getEnd()) : MonitorEventLocalServiceUtil.getEventsByTypeAndUser(MonitorEventTypes.ALL, userId, searchContainer.getStart(), searchContainer.getEnd());
		}

		searchContainer.setResults(results);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.amf.registration.model.MonitorEvent"
		escapedModel="<%= true %>"
		keyProperty="eventId"
		modelVar="curEvent"
	>

		<liferay-ui:search-container-column-text
			buffer="buffer"
		>

			<%
			buffer.append(dateFormatDateTime.format(curEvent.getEventDate()) + StringPool.SPACE);
			buffer.append(UserLocalServiceUtil.getUser(curEvent.getUserId()).getScreenName() + StringPool.SPACE);
			buffer.append("(");
			buffer.append(curEvent.getUserId());
			buffer.append(") ");
			buffer.append(curEvent.getIp() + StringPool.SPACE);
			buffer.append((curEvent.getEventType() == MonitorEventTypes.LOGIN) ? LanguageUtil.get(pageContext, "login") : LanguageUtil.get(pageContext, "registration"));
			%>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>