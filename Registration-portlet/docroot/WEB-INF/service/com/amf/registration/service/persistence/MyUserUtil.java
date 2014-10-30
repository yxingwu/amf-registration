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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the my user service. This utility wraps {@link MyUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see MyUserPersistence
 * @see MyUserPersistenceImpl
 * @generated
 */
public class MyUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(MyUser myUser) {
		getPersistence().clearCache(myUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MyUser> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MyUser> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MyUser> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MyUser update(MyUser myUser) throws SystemException {
		return getPersistence().update(myUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MyUser update(MyUser myUser, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(myUser, serviceContext);
	}

	/**
	* Caches the my user in the entity cache if it is enabled.
	*
	* @param myUser the my user
	*/
	public static void cacheResult(com.amf.registration.model.MyUser myUser) {
		getPersistence().cacheResult(myUser);
	}

	/**
	* Caches the my users in the entity cache if it is enabled.
	*
	* @param myUsers the my users
	*/
	public static void cacheResult(
		java.util.List<com.amf.registration.model.MyUser> myUsers) {
		getPersistence().cacheResult(myUsers);
	}

	/**
	* Creates a new my user with the primary key. Does not add the my user to the database.
	*
	* @param userId the primary key for the new my user
	* @return the new my user
	*/
	public static com.amf.registration.model.MyUser create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the my user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the my user
	* @return the my user that was removed
	* @throws com.amf.registration.NoSuchMyUserException if a my user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MyUser remove(long userId)
		throws com.amf.registration.NoSuchMyUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userId);
	}

	public static com.amf.registration.model.MyUser updateImpl(
		com.amf.registration.model.MyUser myUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(myUser);
	}

	/**
	* Returns the my user with the primary key or throws a {@link com.amf.registration.NoSuchMyUserException} if it could not be found.
	*
	* @param userId the primary key of the my user
	* @return the my user
	* @throws com.amf.registration.NoSuchMyUserException if a my user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MyUser findByPrimaryKey(
		long userId)
		throws com.amf.registration.NoSuchMyUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the my user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the my user
	* @return the my user, or <code>null</code> if a my user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MyUser fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	* Returns all the my users.
	*
	* @return the my users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MyUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the my users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of my users
	* @param end the upper bound of the range of my users (not inclusive)
	* @return the range of my users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MyUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the my users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of my users
	* @param end the upper bound of the range of my users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of my users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MyUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the my users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of my users.
	*
	* @return the number of my users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MyUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MyUserPersistence)PortletBeanLocatorUtil.locate(com.amf.registration.service.ClpSerializer.getServletContextName(),
					MyUserPersistence.class.getName());

			ReferenceRegistry.registerReference(MyUserUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MyUserPersistence persistence) {
	}

	private static MyUserPersistence _persistence;
}