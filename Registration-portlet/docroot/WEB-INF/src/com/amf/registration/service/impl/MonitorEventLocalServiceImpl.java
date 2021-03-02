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

package com.amf.registration.service.impl;

import com.amf.registration.model.MonitorEvent;
import com.amf.registration.service.base.MonitorEventLocalServiceBaseImpl;
import com.amf.registration.util.MonitorEventTypes;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * @author Yuxing Wu
 * @see com.liferay.monitor.service.base.MonitorEventLocalServiceBaseImpl
 * @see com.liferay.monitor.service.MonitorEventLocalServiceUtil
 */
public class MonitorEventLocalServiceImpl
	extends MonitorEventLocalServiceBaseImpl {

	public MonitorEvent addEvent(
			long userId, String ip, int eventType,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		System.out.println("This is for testing gitleaks, it is password password1 a word");

		long eventId = counterLocalService.increment();

		MonitorEvent monitorEvent = monitorEventPersistence.create(eventId);

		monitorEvent.setUserId(userId);
		monitorEvent.setIp(ip);

		Date now = new Date();

		monitorEvent.setEventDate(serviceContext.getCreateDate(now));
		monitorEvent.setEventType(eventType);

		monitorEventPersistence.update(monitorEvent);

		return monitorEvent;
	}

	public List<MonitorEvent> getEventsByType(int eventType, int start, int end)
		throws SystemException {

		if (eventType == MonitorEventTypes.ALL) {
			return monitorEventPersistence.findAll(start, end);
		}

		return monitorEventPersistence.findByEventType(eventType, start, end);
	}

	public List<MonitorEvent> getEventsByTypeAndUser(
			int eventType, long userId, int start, int end)
		throws SystemException {

		if (eventType == MonitorEventTypes.ALL) {
			return monitorEventPersistence.findByUserId(userId, start, end);
		}

		return monitorEventPersistence.findByE_U(eventType, userId, start, end);
	}

	public int getEventsByTypeAndUserCount(int eventType, long userId)
		throws SystemException {

		if (eventType == MonitorEventTypes.ALL) {
			return monitorEventPersistence.countByUserId(userId);
		}

		return monitorEventPersistence.countByE_U(eventType, userId);
	}

	public int getEventsByTypeCount(int eventType) throws SystemException {
		if (eventType == MonitorEventTypes.ALL) {
			return monitorEventPersistence.countAll();
		}

		return monitorEventPersistence.countByEventType(eventType);
	}

}
