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

package com.liferay.monitor.model;

import com.liferay.monitor.service.ClpSerializer;
import com.liferay.monitor.service.MonitorEventLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liferay
 */
public class MonitorEventClp extends BaseModelImpl<MonitorEvent>
	implements MonitorEvent {
	public MonitorEventClp() {
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
	public long getPrimaryKey() {
		return _eventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_monitorEventRemoteModel != null) {
			try {
				Class<?> clazz = _monitorEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_monitorEventRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_monitorEventRemoteModel != null) {
			try {
				Class<?> clazz = _monitorEventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_monitorEventRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getIp() {
		return _ip;
	}

	@Override
	public void setIp(String ip) {
		_ip = ip;

		if (_monitorEventRemoteModel != null) {
			try {
				Class<?> clazz = _monitorEventRemoteModel.getClass();

				Method method = clazz.getMethod("setIp", String.class);

				method.invoke(_monitorEventRemoteModel, ip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEventDate() {
		return _eventDate;
	}

	@Override
	public void setEventDate(Date eventDate) {
		_eventDate = eventDate;

		if (_monitorEventRemoteModel != null) {
			try {
				Class<?> clazz = _monitorEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDate", Date.class);

				method.invoke(_monitorEventRemoteModel, eventDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEventType() {
		return _eventType;
	}

	@Override
	public void setEventType(int eventType) {
		_eventType = eventType;

		if (_monitorEventRemoteModel != null) {
			try {
				Class<?> clazz = _monitorEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", int.class);

				method.invoke(_monitorEventRemoteModel, eventType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMonitorEventRemoteModel() {
		return _monitorEventRemoteModel;
	}

	public void setMonitorEventRemoteModel(BaseModel<?> monitorEventRemoteModel) {
		_monitorEventRemoteModel = monitorEventRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _monitorEventRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_monitorEventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MonitorEventLocalServiceUtil.addMonitorEvent(this);
		}
		else {
			MonitorEventLocalServiceUtil.updateMonitorEvent(this);
		}
	}

	@Override
	public MonitorEvent toEscapedModel() {
		return (MonitorEvent)ProxyUtil.newProxyInstance(MonitorEvent.class.getClassLoader(),
			new Class[] { MonitorEvent.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MonitorEventClp clone = new MonitorEventClp();

		clone.setEventId(getEventId());
		clone.setUserId(getUserId());
		clone.setIp(getIp());
		clone.setEventDate(getEventDate());
		clone.setEventType(getEventType());

		return clone;
	}

	@Override
	public int compareTo(MonitorEvent monitorEvent) {
		int value = 0;

		value = DateUtil.compareTo(getEventDate(), monitorEvent.getEventDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MonitorEventClp)) {
			return false;
		}

		MonitorEventClp monitorEvent = (MonitorEventClp)obj;

		long primaryKey = monitorEvent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{eventId=");
		sb.append(getEventId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", ip=");
		sb.append(getIp());
		sb.append(", eventDate=");
		sb.append(getEventDate());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.monitor.model.MonitorEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip</column-name><column-value><![CDATA[");
		sb.append(getIp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDate</column-name><column-value><![CDATA[");
		sb.append(getEventDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventId;
	private long _userId;
	private String _userUuid;
	private String _ip;
	private Date _eventDate;
	private int _eventType;
	private BaseModel<?> _monitorEventRemoteModel;
}