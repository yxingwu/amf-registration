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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for MonitorEvent. This utility wraps
 * {@link com.liferay.monitor.service.impl.MonitorEventLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author liferay
 * @see MonitorEventLocalService
 * @see com.liferay.monitor.service.base.MonitorEventLocalServiceBaseImpl
 * @see com.liferay.monitor.service.impl.MonitorEventLocalServiceImpl
 * @generated
 */
public class MonitorEventLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.monitor.service.impl.MonitorEventLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the monitor event to the database. Also notifies the appropriate model listeners.
	*
	* @param monitorEvent the monitor event
	* @return the monitor event that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.monitor.model.MonitorEvent addMonitorEvent(
		com.liferay.monitor.model.MonitorEvent monitorEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addMonitorEvent(monitorEvent);
	}

	/**
	* Creates a new monitor event with the primary key. Does not add the monitor event to the database.
	*
	* @param eventId the primary key for the new monitor event
	* @return the new monitor event
	*/
	public static com.liferay.monitor.model.MonitorEvent createMonitorEvent(
		long eventId) {
		return getService().createMonitorEvent(eventId);
	}

	/**
	* Deletes the monitor event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event that was removed
	* @throws PortalException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.monitor.model.MonitorEvent deleteMonitorEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMonitorEvent(eventId);
	}

	/**
	* Deletes the monitor event from the database. Also notifies the appropriate model listeners.
	*
	* @param monitorEvent the monitor event
	* @return the monitor event that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.monitor.model.MonitorEvent deleteMonitorEvent(
		com.liferay.monitor.model.MonitorEvent monitorEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMonitorEvent(monitorEvent);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.monitor.model.MonitorEvent fetchMonitorEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMonitorEvent(eventId);
	}

	/**
	* Returns the monitor event with the primary key.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event
	* @throws PortalException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.monitor.model.MonitorEvent getMonitorEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMonitorEvent(eventId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.monitor.model.MonitorEvent> getMonitorEvents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMonitorEvents(start, end);
	}

	/**
	* Returns the number of monitor events.
	*
	* @return the number of monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static int getMonitorEventsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMonitorEventsCount();
	}

	/**
	* Updates the monitor event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param monitorEvent the monitor event
	* @return the monitor event that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.monitor.model.MonitorEvent updateMonitorEvent(
		com.liferay.monitor.model.MonitorEvent monitorEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateMonitorEvent(monitorEvent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.monitor.model.MonitorEvent addMonitorEvent(
		long userId, java.lang.String ip, int eventType,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMonitorEvent(userId, ip, eventType, serviceContext);
	}

	public static java.util.List<com.liferay.monitor.model.MonitorEvent> getMonitorEventsByType(
		int eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMonitorEventsByType(eventType, start, end);
	}

	public static java.util.List<com.liferay.monitor.model.MonitorEvent> getMonitorEventsByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMonitorEventsByUserId(userId, start, end);
	}

	public static java.util.List<com.liferay.monitor.model.MonitorEvent> getMonitorEventsByUserIdAndType(
		long userId, int eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getMonitorEventsByUserIdAndType(userId, eventType, start,
			end);
	}

	public static int getMonitorEventsCount(int eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMonitorEventsCount(eventType);
	}

	public static int getMonitorEventsCount(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMonitorEventsCount(userId);
	}

	public static int getMonitorEventsCount(long userId, int eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMonitorEventsCount(userId, eventType);
	}

	public static void clearService() {
		_service = null;
	}

	public static MonitorEventLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MonitorEventLocalService.class.getName());

			if (invokableLocalService instanceof MonitorEventLocalService) {
				_service = (MonitorEventLocalService)invokableLocalService;
			}
			else {
				_service = new MonitorEventLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MonitorEventLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MonitorEventLocalService service) {
	}

	private static MonitorEventLocalService _service;
}