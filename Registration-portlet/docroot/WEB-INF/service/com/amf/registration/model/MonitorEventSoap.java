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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author liferay
 * @generated
 */
public class MonitorEventSoap implements Serializable {
	public static MonitorEventSoap toSoapModel(MonitorEvent model) {
		MonitorEventSoap soapModel = new MonitorEventSoap();

		soapModel.setEventId(model.getEventId());
		soapModel.setUserId(model.getUserId());
		soapModel.setIp(model.getIp());
		soapModel.setEventDate(model.getEventDate());
		soapModel.setEventType(model.getEventType());

		return soapModel;
	}

	public static MonitorEventSoap[] toSoapModels(MonitorEvent[] models) {
		MonitorEventSoap[] soapModels = new MonitorEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MonitorEventSoap[][] toSoapModels(MonitorEvent[][] models) {
		MonitorEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MonitorEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MonitorEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MonitorEventSoap[] toSoapModels(List<MonitorEvent> models) {
		List<MonitorEventSoap> soapModels = new ArrayList<MonitorEventSoap>(models.size());

		for (MonitorEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MonitorEventSoap[soapModels.size()]);
	}

	public MonitorEventSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getIp() {
		return _ip;
	}

	public void setIp(String ip) {
		_ip = ip;
	}

	public Date getEventDate() {
		return _eventDate;
	}

	public void setEventDate(Date eventDate) {
		_eventDate = eventDate;
	}

	public int getEventType() {
		return _eventType;
	}

	public void setEventType(int eventType) {
		_eventType = eventType;
	}

	private long _eventId;
	private long _userId;
	private String _ip;
	private Date _eventDate;
	private int _eventType;
}