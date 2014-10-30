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

package com.amf.registration.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyUserLocalService}.
 *
 * @author liferay
 * @see MyUserLocalService
 * @generated
 */
public class MyUserLocalServiceWrapper implements MyUserLocalService,
	ServiceWrapper<MyUserLocalService> {
	public MyUserLocalServiceWrapper(MyUserLocalService myUserLocalService) {
		_myUserLocalService = myUserLocalService;
	}

	/**
	* Adds the my user to the database. Also notifies the appropriate model listeners.
	*
	* @param myUser the my user
	* @return the my user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.registration.model.MyUser addMyUser(
		com.amf.registration.model.MyUser myUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.addMyUser(myUser);
	}

	/**
	* Creates a new my user with the primary key. Does not add the my user to the database.
	*
	* @param userId the primary key for the new my user
	* @return the new my user
	*/
	@Override
	public com.amf.registration.model.MyUser createMyUser(long userId) {
		return _myUserLocalService.createMyUser(userId);
	}

	/**
	* Deletes the my user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the my user
	* @return the my user that was removed
	* @throws PortalException if a my user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.registration.model.MyUser deleteMyUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.deleteMyUser(userId);
	}

	/**
	* Deletes the my user from the database. Also notifies the appropriate model listeners.
	*
	* @param myUser the my user
	* @return the my user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.registration.model.MyUser deleteMyUser(
		com.amf.registration.model.MyUser myUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.deleteMyUser(myUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _myUserLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MyUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.amf.registration.model.MyUser fetchMyUser(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.fetchMyUser(userId);
	}

	/**
	* Returns the my user with the primary key.
	*
	* @param userId the primary key of the my user
	* @return the my user
	* @throws PortalException if a my user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.registration.model.MyUser getMyUser(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.getMyUser(userId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.amf.registration.model.MyUser> getMyUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.getMyUsers(start, end);
	}

	/**
	* Returns the number of my users.
	*
	* @return the number of my users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMyUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.getMyUsersCount();
	}

	/**
	* Updates the my user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param myUser the my user
	* @return the my user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.amf.registration.model.MyUser updateMyUser(
		com.amf.registration.model.MyUser myUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.updateMyUser(myUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _myUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_myUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _myUserLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public int countByZip(java.lang.String zip)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.countByZip(zip);
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> getUsersByZip(
		java.lang.String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUserLocalService.getUsersByZip(zip, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MyUserLocalService getWrappedMyUserLocalService() {
		return _myUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMyUserLocalService(
		MyUserLocalService myUserLocalService) {
		_myUserLocalService = myUserLocalService;
	}

	@Override
	public MyUserLocalService getWrappedService() {
		return _myUserLocalService;
	}

	@Override
	public void setWrappedService(MyUserLocalService myUserLocalService) {
		_myUserLocalService = myUserLocalService;
	}

	private MyUserLocalService _myUserLocalService;
}