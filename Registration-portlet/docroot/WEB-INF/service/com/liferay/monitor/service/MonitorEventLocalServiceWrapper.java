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

package com.liferay.monitor.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MonitorEventLocalService}.
 *
 * @author liferay
 * @see MonitorEventLocalService
 * @generated
 */
public class MonitorEventLocalServiceWrapper implements MonitorEventLocalService,
	ServiceWrapper<MonitorEventLocalService> {
	public MonitorEventLocalServiceWrapper(
		MonitorEventLocalService monitorEventLocalService) {
		_monitorEventLocalService = monitorEventLocalService;
	}

	/**
	* Adds the monitor event to the database. Also notifies the appropriate model listeners.
	*
	* @param monitorEvent the monitor event
	* @return the monitor event that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.monitor.model.MonitorEvent addMonitorEvent(
		com.liferay.monitor.model.MonitorEvent monitorEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.addMonitorEvent(monitorEvent);
	}

	/**
	* Creates a new monitor event with the primary key. Does not add the monitor event to the database.
	*
	* @param eventId the primary key for the new monitor event
	* @return the new monitor event
	*/
	@Override
	public com.liferay.monitor.model.MonitorEvent createMonitorEvent(
		long eventId) {
		return _monitorEventLocalService.createMonitorEvent(eventId);
	}

	/**
	* Deletes the monitor event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event that was removed
	* @throws PortalException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.monitor.model.MonitorEvent deleteMonitorEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.deleteMonitorEvent(eventId);
	}

	/**
	* Deletes the monitor event from the database. Also notifies the appropriate model listeners.
	*
	* @param monitorEvent the monitor event
	* @return the monitor event that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.monitor.model.MonitorEvent deleteMonitorEvent(
		com.liferay.monitor.model.MonitorEvent monitorEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.deleteMonitorEvent(monitorEvent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _monitorEventLocalService.dynamicQuery();
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
		return _monitorEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _monitorEventLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _monitorEventLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _monitorEventLocalService.dynamicQueryCount(dynamicQuery);
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
		return _monitorEventLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.monitor.model.MonitorEvent fetchMonitorEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.fetchMonitorEvent(eventId);
	}

	/**
	* Returns the monitor event with the primary key.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event
	* @throws PortalException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.monitor.model.MonitorEvent getMonitorEvent(long eventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getMonitorEvent(eventId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the monitor events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @return the range of monitor events
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.monitor.model.MonitorEvent> getMonitorEvents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getMonitorEvents(start, end);
	}

	/**
	* Returns the number of monitor events.
	*
	* @return the number of monitor events
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMonitorEventsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getMonitorEventsCount();
	}

	/**
	* Updates the monitor event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param monitorEvent the monitor event
	* @return the monitor event that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.monitor.model.MonitorEvent updateMonitorEvent(
		com.liferay.monitor.model.MonitorEvent monitorEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.updateMonitorEvent(monitorEvent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _monitorEventLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_monitorEventLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _monitorEventLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.monitor.model.MonitorEvent addMonitorEvent(long userId,
		java.lang.String ip, int eventType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.addMonitorEvent(userId, ip, eventType,
			serviceContext);
	}

	@Override
	public java.util.List<com.liferay.monitor.model.MonitorEvent> getMonitorEventsByType(
		int eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getMonitorEventsByType(eventType,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.monitor.model.MonitorEvent> getMonitorEventsByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getMonitorEventsByUserId(userId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.monitor.model.MonitorEvent> getMonitorEventsByUserIdAndType(
		long userId, int eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getMonitorEventsByUserIdAndType(userId,
			eventType, start, end);
	}

	@Override
	public int getMonitorEventsCount(int eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getMonitorEventsCount(eventType);
	}

	@Override
	public int getMonitorEventsCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getMonitorEventsCount(userId);
	}

	@Override
	public int getMonitorEventsCount(long userId, int eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _monitorEventLocalService.getMonitorEventsCount(userId, eventType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MonitorEventLocalService getWrappedMonitorEventLocalService() {
		return _monitorEventLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMonitorEventLocalService(
		MonitorEventLocalService monitorEventLocalService) {
		_monitorEventLocalService = monitorEventLocalService;
	}

	@Override
	public MonitorEventLocalService getWrappedService() {
		return _monitorEventLocalService;
	}

	@Override
	public void setWrappedService(
		MonitorEventLocalService monitorEventLocalService) {
		_monitorEventLocalService = monitorEventLocalService;
	}

	private MonitorEventLocalService _monitorEventLocalService;
}