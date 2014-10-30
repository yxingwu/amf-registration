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

package com.amf.registration.service.impl;

import com.amf.registration.service.base.MyUserLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import java.util.List;

/**
 * @author Yuxing Wu
 * @see com.amf.registration.service.base.MyUserLocalServiceBaseImpl
 * @see com.amf.registration.service.MyUserLocalServiceUtil
 */
public class MyUserLocalServiceImpl extends MyUserLocalServiceBaseImpl {

	public int countByZip(String zip) throws SystemException {
		return myUserFinder.countByZip(zip);
	}

	public List<User> getUsersByZip(String zip, int start, int end)
		throws SystemException {

		return myUserFinder.findByZip(zip, start, end);
	}

}