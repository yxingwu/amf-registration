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

package com.liferay.monitor.service.impl;

import com.liferay.monitor.model.MonitorEvent;
import com.liferay.monitor.service.base.MonitorEventLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.registration.util.MonitorEventTypes;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the monitor event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.monitor.service.MonitorEventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see com.liferay.monitor.service.base.MonitorEventLocalServiceBaseImpl
 * @see com.liferay.monitor.service.MonitorEventLocalServiceUtil
 */
public class MonitorEventLocalServiceImpl
	extends MonitorEventLocalServiceBaseImpl {

	public MonitorEvent addEvent(
			long userId, String ip, int eventType,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

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

		return monitorEventPersistence.findByeventType(eventType, start, end);
	}

	public List<MonitorEvent> getEventsByTypeAndUser(
			int eventType, long userId, int start, int end)
		throws SystemException {

		if (eventType == MonitorEventTypes.ALL) {
			return monitorEventPersistence.findByuserId(userId, start, end);
		}

		return monitorEventPersistence.findByE_U(eventType, userId, start, end);
	}

	public int getEventsByTypeAndUserCount(int eventType, long userId)
		throws SystemException {

		if (eventType == MonitorEventTypes.ALL) {
			return monitorEventPersistence.countByuserId(userId);
		}

		return monitorEventPersistence.countByE_U(eventType, userId);
	}

	public int getEventsByTypeCount(int eventType) throws SystemException {
		if (eventType == MonitorEventTypes.ALL) {
			return monitorEventPersistence.countAll();
		}

		return monitorEventPersistence.countByeventType(eventType);
	}

}