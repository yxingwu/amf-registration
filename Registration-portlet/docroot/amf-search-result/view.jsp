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

		<%
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcPath", "/amf-search-result/view.jsp");
		portletURL.setParameter("zip", zip);
		%>

		<liferay-ui:search-container
			delta="<%= 5 %>"
			emptyResultsMessage="no-results-found-please-try-a-different-search-criteria"
			iteratorURL="<%= portletURL %>"
		>

			<%
			DynamicQuery userDynamicQuery = DynamicQueryFactoryUtil.forClass(User.class);

			DynamicQuery addressDynamicQuery = DynamicQueryFactoryUtil.forClass(Address.class);

			addressDynamicQuery.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("userId")));

			Property zipProperty = PropertyFactoryUtil.forName("zip");

			addressDynamicQuery.add(zipProperty.eq(zip));

			Property primaryProperty = PropertyFactoryUtil.forName("primary");

			addressDynamicQuery.add(primaryProperty.eq(true));

			List userIds = AddressLocalServiceUtil.dynamicQuery(addressDynamicQuery);

			searchContainer.setTotal(userIds.size());

			Property userIdProperty = PropertyFactoryUtil.forName("userId");
			%>

			<liferay-ui:search-container-results>

				<%
				if (userIds.size() > 0) {
					userDynamicQuery.add(userIdProperty.in(userIds));

					results = UserLocalServiceUtil.dynamicQuery(userDynamicQuery, searchContainer.getStart(), searchContainer.getEnd());
				}

				searchContainer.setResults(results);
				%>

			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row
				className="com.liferay.portal.model.User"
				escapedModel="<%= true %>"
				keyProperty="userId"
				modelVar="curUser"
			>

				<liferay-ui:search-container-column-text
					buffer="buffer"
					name='<%= LanguageUtil.format(pageContext, "search-results-for-x", HtmlUtil.escape(zip)) %>'
				>

				<%
				buffer.append(curUser.getFirstName());
				buffer.append(StringPool.SPACE);
				buffer.append(StringUtil.toUpperCase(curUser.getLastName().substring(0, 1)));
				buffer.append(StringPool.PERIOD);
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