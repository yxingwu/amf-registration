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

package com.liferay.monitor.model.impl;

import com.liferay.monitor.model.MonitorEvent;
import com.liferay.monitor.service.MonitorEventLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the MonitorEvent service. Represents a row in the &quot;amf_MonitorEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MonitorEventImpl}.
 * </p>
 *
 * @author liferay
 * @see MonitorEventImpl
 * @see com.liferay.monitor.model.MonitorEvent
 * @generated
 */
public abstract class MonitorEventBaseImpl extends MonitorEventModelImpl
	implements MonitorEvent {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a monitor event model instance should use the {@link MonitorEvent} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MonitorEventLocalServiceUtil.addMonitorEvent(this);
		}
		else {
			MonitorEventLocalServiceUtil.updateMonitorEvent(this);
		}
	}
}