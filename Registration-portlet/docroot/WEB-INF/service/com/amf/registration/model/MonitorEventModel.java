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

package com.amf.registration.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the MonitorEvent service. Represents a row in the &quot;amf_MonitorEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.amf.registration.model.impl.MonitorEventModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.amf.registration.model.impl.MonitorEventImpl}.
 * </p>
 *
 * @author liferay
 * @see MonitorEvent
 * @see com.amf.registration.model.impl.MonitorEventImpl
 * @see com.amf.registration.model.impl.MonitorEventModelImpl
 * @generated
 */
public interface MonitorEventModel extends BaseModel<MonitorEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a monitor event model instance should use the {@link MonitorEvent} interface instead.
	 */

	/**
	 * Returns the primary key of this monitor event.
	 *
	 * @return the primary key of this monitor event
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this monitor event.
	 *
	 * @param primaryKey the primary key of this monitor event
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the event ID of this monitor event.
	 *
	 * @return the event ID of this monitor event
	 */
	public long getEventId();

	/**
	 * Sets the event ID of this monitor event.
	 *
	 * @param eventId the event ID of this monitor event
	 */
	public void setEventId(long eventId);

	/**
	 * Returns the user ID of this monitor event.
	 *
	 * @return the user ID of this monitor event
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this monitor event.
	 *
	 * @param userId the user ID of this monitor event
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this monitor event.
	 *
	 * @return the user uuid of this monitor event
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this monitor event.
	 *
	 * @param userUuid the user uuid of this monitor event
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the ip of this monitor event.
	 *
	 * @return the ip of this monitor event
	 */
	@AutoEscape
	public String getIp();

	/**
	 * Sets the ip of this monitor event.
	 *
	 * @param ip the ip of this monitor event
	 */
	public void setIp(String ip);

	/**
	 * Returns the event date of this monitor event.
	 *
	 * @return the event date of this monitor event
	 */
	public Date getEventDate();

	/**
	 * Sets the event date of this monitor event.
	 *
	 * @param eventDate the event date of this monitor event
	 */
	public void setEventDate(Date eventDate);

	/**
	 * Returns the event type of this monitor event.
	 *
	 * @return the event type of this monitor event
	 */
	public int getEventType();

	/**
	 * Sets the event type of this monitor event.
	 *
	 * @param eventType the event type of this monitor event
	 */
	public void setEventType(int eventType);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(MonitorEvent monitorEvent);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MonitorEvent> toCacheModel();

	@Override
	public MonitorEvent toEscapedModel();

	@Override
	public MonitorEvent toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}