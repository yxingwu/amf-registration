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

package com.amf.registration.service.persistence;

import com.amf.registration.model.MyUser;
import com.amf.registration.service.MyUserLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author liferay
 * @generated
 */
public abstract class MyUserActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public MyUserActionableDynamicQuery() throws SystemException {
		setBaseLocalService(MyUserLocalServiceUtil.getService());
		setClass(MyUser.class);

		setClassLoader(com.amf.registration.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("userId");
	}
}