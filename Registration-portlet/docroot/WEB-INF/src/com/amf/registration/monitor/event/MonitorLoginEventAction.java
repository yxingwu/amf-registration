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

package com.amf.registration.monitor.event;

import com.amf.registration.service.MonitorEventLocalServiceUtil;
import com.amf.registration.util.MonitorEventTypes;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yuxing Wu
 */
public class MonitorLoginEventAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
		throws ActionException {

		try {
			User user = PortalUtil.getUser(request);

			long userId = user.getUserId();

			String ip = user.getLoginIP();

			int eventType = MonitorEventTypes.LOGIN;

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				request);

			MonitorEventLocalServiceUtil.addEvent(
				userId, ip, eventType, serviceContext);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}