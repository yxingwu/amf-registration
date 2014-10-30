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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author liferay
 */
public class MyUserFinderUtil {
	public static int countByZip(java.lang.String zip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByZip(zip);
	}

	public static java.util.List<com.liferay.portal.model.User> findByZip(
		java.lang.String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByZip(zip, start, end);
	}

	public static MyUserFinder getFinder() {
		if (_finder == null) {
			_finder = (MyUserFinder)PortletBeanLocatorUtil.locate(com.amf.registration.service.ClpSerializer.getServletContextName(),
					MyUserFinder.class.getName());

			ReferenceRegistry.registerReference(MyUserFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(MyUserFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(MyUserFinderUtil.class, "_finder");
	}

	private static MyUserFinder _finder;
}