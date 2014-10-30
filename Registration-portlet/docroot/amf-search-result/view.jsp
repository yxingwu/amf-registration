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
String zip = ParamUtil.getString(request, "zip");
%>

<c:choose>
	<c:when test="<%= Validator.isNull(zip) %>">
		<liferay-ui:message key="there-are-no-search-results-to-display" />
	</c:when>
	<c:otherwise>
		<h4><%= LanguageUtil.format(pageContext, "search-results-for-x", HtmlUtil.escape(zip)) %></h4>
		<hr />

		<%
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/amf-search-result/view.jsp");
		portletURL.setParameter("zip", zip);
		%>

		<liferay-ui:search-container
			delta="<%= 5 %>"
			emptyResultsMessage="no-results-found-please-try-a-different-search-criteria"
			iteratorURL="<%= portletURL %>"
			total="<%= MyUserLocalServiceUtil.countByZip(zip) %>"
		>

			<liferay-ui:search-container-results
				results="<%= MyUserLocalServiceUtil.getUsersByZip(zip, searchContainer.getStart(), searchContainer.getEnd()) %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.portal.model.User"
				escapedModel="<%= true %>"
				keyProperty="userId"
				modelVar="curUser"
			>

				<liferay-ui:search-container-column-text
					buffer="buffer"
				>

				<%
				buffer.append(curUser.getFirstName());
				buffer.append(StringPool.SPACE);
				buffer.append(StringUtil.toUpperCase(Validator.isNotNull(curUser.getLastName()) ? curUser.getLastName().substring(0, 1) : StringPool.BLANK));
				buffer.append(Validator.isNotNull(curUser.getLastName()) ? StringPool.PERIOD : StringPool.BLANK);
				buffer.append(StringPool.SPACE);
				buffer.append(StringPool.OPEN_PARENTHESIS);
				buffer.append(curUser.getScreenName());
				buffer.append(StringPool.CLOSE_PARENTHESIS);
				buffer.append(StringPool.SPACE);
				buffer.append(StringPool.DASH);
				buffer.append(StringPool.SPACE);
				buffer.append(curUser.getEmailAddress());
				%>

				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</c:otherwise>
</c:choose>