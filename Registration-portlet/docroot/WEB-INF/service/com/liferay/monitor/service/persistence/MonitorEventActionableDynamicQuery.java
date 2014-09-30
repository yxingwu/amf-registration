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

package com.liferay.monitor.service.persistence;

import com.liferay.monitor.model.MonitorEvent;
import com.liferay.monitor.service.MonitorEventLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author liferay
 * @generated
 */
public abstract class MonitorEventActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public MonitorEventActionableDynamicQuery() throws SystemException {
		setBaseLocalService(MonitorEventLocalServiceUtil.getService());
		setClass(MonitorEvent.class);

		setClassLoader(com.liferay.monitor.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("eventId");
	}
}