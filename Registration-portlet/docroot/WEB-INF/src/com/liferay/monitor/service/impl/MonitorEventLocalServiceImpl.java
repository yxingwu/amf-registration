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

	public MonitorEvent addMonitorEvent(
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

	public List<MonitorEvent> getMonitorEventsByType(
			int eventType, int start, int end)
		throws SystemException {

		return monitorEventPersistence.findByeventType(eventType, start, end);
	}

	public List<MonitorEvent> getMonitorEventsByUserId(
			long userId, int start, int end)
		throws SystemException {

		return monitorEventPersistence.findByuserId(userId, start, end);
	}

	public List<MonitorEvent> getMonitorEventsByUserIdAndType(
			long userId, int eventType, int start, int end)
		throws SystemException {

		return monitorEventPersistence.findByU_E(userId, eventType, start, end);
	}

	public int getMonitorEventsCount(int eventType) throws SystemException {
		return monitorEventPersistence.countByeventType(eventType);
	}

	public int getMonitorEventsCount(long userId) throws SystemException {
		return monitorEventPersistence.countByuserId(userId);
	}

	public int getMonitorEventsCount(long userId, int eventType)
		throws SystemException {

		return monitorEventPersistence.countByU_E(userId, eventType);
	}

}