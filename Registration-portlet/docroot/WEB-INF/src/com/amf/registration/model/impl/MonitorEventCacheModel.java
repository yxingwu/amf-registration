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

package com.amf.registration.model.impl;

import com.amf.registration.model.MonitorEvent;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MonitorEvent in entity cache.
 *
 * @author liferay
 * @see MonitorEvent
 * @generated
 */
public class MonitorEventCacheModel implements CacheModel<MonitorEvent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{eventId=");
		sb.append(eventId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", ip=");
		sb.append(ip);
		sb.append(", eventDate=");
		sb.append(eventDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MonitorEvent toEntityModel() {
		MonitorEventImpl monitorEventImpl = new MonitorEventImpl();

		monitorEventImpl.setEventId(eventId);
		monitorEventImpl.setUserId(userId);

		if (ip == null) {
			monitorEventImpl.setIp(StringPool.BLANK);
		}
		else {
			monitorEventImpl.setIp(ip);
		}

		if (eventDate == Long.MIN_VALUE) {
			monitorEventImpl.setEventDate(null);
		}
		else {
			monitorEventImpl.setEventDate(new Date(eventDate));
		}

		monitorEventImpl.setEventType(eventType);

		monitorEventImpl.resetOriginalValues();

		return monitorEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventId = objectInput.readLong();
		userId = objectInput.readLong();
		ip = objectInput.readUTF();
		eventDate = objectInput.readLong();
		eventType = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventId);
		objectOutput.writeLong(userId);

		if (ip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ip);
		}

		objectOutput.writeLong(eventDate);
		objectOutput.writeInt(eventType);
	}

	public long eventId;
	public long userId;
	public String ip;
	public long eventDate;
	public int eventType;
}