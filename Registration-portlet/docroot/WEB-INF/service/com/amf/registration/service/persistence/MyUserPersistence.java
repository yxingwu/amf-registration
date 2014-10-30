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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the my user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see MyUserPersistenceImpl
 * @see MyUserUtil
 * @generated
 */
public interface MyUserPersistence extends BasePersistence<MyUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MyUserUtil} to access the my user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the my user in the entity cache if it is enabled.
	*
	* @param myUser the my user
	*/
	public void cacheResult(com.amf.registration.model.MyUser myUser);

	/**
	* Caches the my users in the entity cache if it is enabled.
	*
	* @param myUsers the my users
	*/
	public void cacheResult(
		java.util.List<com.amf.registration.model.MyUser> myUsers);

	/**
	* Creates a new my user with the primary key. Does not add the my user to the database.
	*
	* @param userId the primary key for the new my user
	* @return the new my user
	*/
	public com.amf.registration.model.MyUser create(long userId);

	/**
	* Removes the my user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the my user
	* @return the my user that was removed
	* @throws com.amf.registration.NoSuchMyUserException if a my user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.MyUser remove(long userId)
		throws com.amf.registration.NoSuchMyUserException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.amf.registration.model.MyUser updateImpl(
		com.amf.registration.model.MyUser myUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the my user with the primary key or throws a {@link com.amf.registration.NoSuchMyUserException} if it could not be found.
	*
	* @param userId the primary key of the my user
	* @return the my user
	* @throws com.amf.registration.NoSuchMyUserException if a my user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.MyUser findByPrimaryKey(long userId)
		throws com.amf.registration.NoSuchMyUserException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the my user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the my user
	* @return the my user, or <code>null</code> if a my user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.amf.registration.model.MyUser fetchByPrimaryKey(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the my users.
	*
	* @return the my users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.amf.registration.model.MyUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.amf.registration.model.MyUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.amf.registration.model.MyUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the my users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of my users.
	*
	* @return the number of my users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}