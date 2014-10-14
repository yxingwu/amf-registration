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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MonitorEvent}.
 * </p>
 *
 * @author liferay
 * @see MonitorEvent
 * @generated
 */
public class MonitorEventWrapper implements MonitorEvent,
	ModelWrapper<MonitorEvent> {
	public MonitorEventWrapper(MonitorEvent monitorEvent) {
		_monitorEvent = monitorEvent;
	}

	@Override
	public Class<?> getModelClass() {
		return MonitorEvent.class;
	}

	@Override
	public String getModelClassName() {
		return MonitorEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("userId", getUserId());
		attributes.put("ip", getIp());
		attributes.put("eventDate", getEventDate());
		attributes.put("eventType", getEventType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String ip = (String)attributes.get("ip");

		if (ip != null) {
			setIp(ip);
		}

		Date eventDate = (Date)attributes.get("eventDate");

		if (eventDate != null) {
			setEventDate(eventDate);
		}

		Integer eventType = (Integer)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}
	}

	/**
	* Returns the primary key of this monitor event.
	*
	* @return the primary key of this monitor event
	*/
	@Override
	public long getPrimaryKey() {
		return _monitorEvent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this monitor event.
	*
	* @param primaryKey the primary key of this monitor event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_monitorEvent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event ID of this monitor event.
	*
	* @return the event ID of this monitor event
	*/
	@Override
	public long getEventId() {
		return _monitorEvent.getEventId();
	}

	/**
	* Sets the event ID of this monitor event.
	*
	* @param eventId the event ID of this monitor event
	*/
	@Override
	public void setEventId(long eventId) {
		_monitorEvent.setEventId(eventId);
	}

	/**
	* Returns the user ID of this monitor event.
	*
	* @return the user ID of this monitor event
	*/
	@Override
	public long getUserId() {
		return _monitorEvent.getUserId();
	}

	/**
	* Sets the user ID of this monitor event.
	*
	* @param userId the user ID of this monitor event
	*/
	@Override
	public void setUserId(long userId) {
		_monitorEvent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this monitor event.
	*
	* @return the user uuid of this monitor event
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEvent.getUserUuid();
	}

	/**
	* Sets the user uuid of this monitor event.
	*
	* @param userUuid the user uuid of this monitor event
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_monitorEvent.setUserUuid(userUuid);
	}

	/**
	* Returns the ip of this monitor event.
	*
	* @return the ip of this monitor event
	*/
	@Override
	public java.lang.String getIp() {
		return _monitorEvent.getIp();
	}

	/**
	* Sets the ip of this monitor event.
	*
	* @param ip the ip of this monitor event
	*/
	@Override
	public void setIp(java.lang.String ip) {
		_monitorEvent.setIp(ip);
	}

	/**
	* Returns the event date of this monitor event.
	*
	* @return the event date of this monitor event
	*/
	@Override
	public java.util.Date getEventDate() {
		return _monitorEvent.getEventDate();
	}

	/**
	* Sets the event date of this monitor event.
	*
	* @param eventDate the event date of this monitor event
	*/
	@Override
	public void setEventDate(java.util.Date eventDate) {
		_monitorEvent.setEventDate(eventDate);
	}

	/**
	* Returns the event type of this monitor event.
	*
	* @return the event type of this monitor event
	*/
	@Override
	public int getEventType() {
		return _monitorEvent.getEventType();
	}

	/**
	* Sets the event type of this monitor event.
	*
	* @param eventType the event type of this monitor event
	*/
	@Override
	public void setEventType(int eventType) {
		_monitorEvent.setEventType(eventType);
	}

	@Override
	public boolean isNew() {
		return _monitorEvent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_monitorEvent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _monitorEvent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_monitorEvent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _monitorEvent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _monitorEvent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_monitorEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _monitorEvent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_monitorEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_monitorEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_monitorEvent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MonitorEventWrapper((MonitorEvent)_monitorEvent.clone());
	}

	@Override
	public int compareTo(com.amf.registration.model.MonitorEvent monitorEvent) {
		return _monitorEvent.compareTo(monitorEvent);
	}

	@Override
	public int hashCode() {
		return _monitorEvent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.amf.registration.model.MonitorEvent> toCacheModel() {
		return _monitorEvent.toCacheModel();
	}

	@Override
	public com.amf.registration.model.MonitorEvent toEscapedModel() {
		return new MonitorEventWrapper(_monitorEvent.toEscapedModel());
	}

	@Override
	public com.amf.registration.model.MonitorEvent toUnescapedModel() {
		return new MonitorEventWrapper(_monitorEvent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _monitorEvent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _monitorEvent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_monitorEvent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MonitorEventWrapper)) {
			return false;
		}

		MonitorEventWrapper monitorEventWrapper = (MonitorEventWrapper)obj;

		if (Validator.equals(_monitorEvent, monitorEventWrapper._monitorEvent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MonitorEvent getWrappedMonitorEvent() {
		return _monitorEvent;
	}

	@Override
	public MonitorEvent getWrappedModel() {
		return _monitorEvent;
	}

	@Override
	public void resetOriginalValues() {
		_monitorEvent.resetOriginalValues();
	}

	private MonitorEvent _monitorEvent;
}