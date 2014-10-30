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

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Yuxing Wu
 */
public class MyUserFinderImpl extends BasePersistenceImpl<MyUser>
	implements MyUserFinder {

	public static final String COUNT_BY_ZIP =
		MyUserFinder.class.getName() + ".countByZip";

	public static final String FIND_BY_ZIP =
		MyUserFinder.class.getName() + ".findByZip";

	public int countByZip(String zip) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_ZIP);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(zip);

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<User> findByZip(String zip, int start, int end)
		throws SystemException {

		Session session = null;

		List<User> users = new ArrayList<User>();

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ZIP);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("userId", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(zip);

			List<Long> userIds = (List<Long>)QueryUtil.list(
				q, getDialect(), start, end);

			for (long userId : userIds) {
				User user = UserLocalServiceUtil.fetchUser(userId);

				users.add(user);
			}

			return users;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}