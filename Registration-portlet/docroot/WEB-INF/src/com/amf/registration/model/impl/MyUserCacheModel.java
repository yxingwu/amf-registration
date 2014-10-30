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

import com.amf.registration.model.MyUser;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MyUser in entity cache.
 *
 * @author liferay
 * @see MyUser
 * @generated
 */
public class MyUserCacheModel implements CacheModel<MyUser>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{userId=");
		sb.append(userId);

		return sb.toString();
	}

	@Override
	public MyUser toEntityModel() {
		MyUserImpl myUserImpl = new MyUserImpl();

		myUserImpl.setUserId(userId);

		myUserImpl.resetOriginalValues();

		return myUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
	}

	public long userId;
}