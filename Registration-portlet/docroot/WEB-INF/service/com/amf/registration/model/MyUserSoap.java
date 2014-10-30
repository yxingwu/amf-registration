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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author liferay
 * @generated
 */
public class MyUserSoap implements Serializable {
	public static MyUserSoap toSoapModel(MyUser model) {
		MyUserSoap soapModel = new MyUserSoap();

		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static MyUserSoap[] toSoapModels(MyUser[] models) {
		MyUserSoap[] soapModels = new MyUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MyUserSoap[][] toSoapModels(MyUser[][] models) {
		MyUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MyUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MyUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MyUserSoap[] toSoapModels(List<MyUser> models) {
		List<MyUserSoap> soapModels = new ArrayList<MyUserSoap>(models.size());

		for (MyUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MyUserSoap[soapModels.size()]);
	}

	public MyUserSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _userId;
}