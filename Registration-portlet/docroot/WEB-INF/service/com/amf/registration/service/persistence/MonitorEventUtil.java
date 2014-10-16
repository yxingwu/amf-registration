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

import com.amf.registration.model.MonitorEvent;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the monitor event service. This utility wraps {@link MonitorEventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see MonitorEventPersistence
 * @see MonitorEventPersistenceImpl
 * @generated
 */
public class MonitorEventUtil {
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
	public static void clearCache(MonitorEvent monitorEvent) {
		getPersistence().clearCache(monitorEvent);
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
	public static List<MonitorEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MonitorEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MonitorEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MonitorEvent update(MonitorEvent monitorEvent)
		throws SystemException {
		return getPersistence().update(monitorEvent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MonitorEvent update(MonitorEvent monitorEvent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(monitorEvent, serviceContext);
	}

	/**
	* Returns all the monitor events where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findByEventType(
		int eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEventType(eventType);
	}

	/**
	* Returns a range of all the monitor events where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @return the range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findByEventType(
		int eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEventType(eventType, start, end);
	}

	/**
	* Returns an ordered range of all the monitor events where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findByEventType(
		int eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventType(eventType, start, end, orderByComparator);
	}

	/**
	* Returns the first monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent findByEventType_First(
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventType_First(eventType, orderByComparator);
	}

	/**
	* Returns the first monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent fetchByEventType_First(
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventType_First(eventType, orderByComparator);
	}

	/**
	* Returns the last monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent findByEventType_Last(
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventType_Last(eventType, orderByComparator);
	}

	/**
	* Returns the last monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent fetchByEventType_Last(
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEventType_Last(eventType, orderByComparator);
	}

	/**
	* Returns the monitor events before and after the current monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventId the primary key of the current monitor event
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent[] findByEventType_PrevAndNext(
		long eventId, int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEventType_PrevAndNext(eventId, eventType,
			orderByComparator);
	}

	/**
	* Removes all the monitor events where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEventType(int eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEventType(eventType);
	}

	/**
	* Returns the number of monitor events where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEventType(int eventType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEventType(eventType);
	}

	/**
	* Returns all the monitor events where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the monitor events where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @return the range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the monitor events where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first monitor event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first monitor event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last monitor event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last monitor event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the monitor events before and after the current monitor event in the ordered set where userId = &#63;.
	*
	* @param eventId the primary key of the current monitor event
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent[] findByUserId_PrevAndNext(
		long eventId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(eventId, userId, orderByComparator);
	}

	/**
	* Removes all the monitor events where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of monitor events where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the monitor events where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @return the matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findByE_U(
		int eventType, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByE_U(eventType, userId);
	}

	/**
	* Returns a range of all the monitor events where eventType = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param userId the user ID
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @return the range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findByE_U(
		int eventType, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByE_U(eventType, userId, start, end);
	}

	/**
	* Returns an ordered range of all the monitor events where eventType = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param userId the user ID
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findByE_U(
		int eventType, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByE_U(eventType, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first monitor event in the ordered set where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent findByE_U_First(
		int eventType, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByE_U_First(eventType, userId, orderByComparator);
	}

	/**
	* Returns the first monitor event in the ordered set where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent fetchByE_U_First(
		int eventType, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByE_U_First(eventType, userId, orderByComparator);
	}

	/**
	* Returns the last monitor event in the ordered set where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent findByE_U_Last(
		int eventType, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByE_U_Last(eventType, userId, orderByComparator);
	}

	/**
	* Returns the last monitor event in the ordered set where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent fetchByE_U_Last(
		int eventType, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByE_U_Last(eventType, userId, orderByComparator);
	}

	/**
	* Returns the monitor events before and after the current monitor event in the ordered set where eventType = &#63; and userId = &#63;.
	*
	* @param eventId the primary key of the current monitor event
	* @param eventType the event type
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent[] findByE_U_PrevAndNext(
		long eventId, int eventType, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByE_U_PrevAndNext(eventId, eventType, userId,
			orderByComparator);
	}

	/**
	* Removes all the monitor events where eventType = &#63; and userId = &#63; from the database.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByE_U(int eventType, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByE_U(eventType, userId);
	}

	/**
	* Returns the number of monitor events where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @return the number of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByE_U(int eventType, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByE_U(eventType, userId);
	}

	/**
	* Caches the monitor event in the entity cache if it is enabled.
	*
	* @param monitorEvent the monitor event
	*/
	public static void cacheResult(
		com.amf.registration.model.MonitorEvent monitorEvent) {
		getPersistence().cacheResult(monitorEvent);
	}

	/**
	* Caches the monitor events in the entity cache if it is enabled.
	*
	* @param monitorEvents the monitor events
	*/
	public static void cacheResult(
		java.util.List<com.amf.registration.model.MonitorEvent> monitorEvents) {
		getPersistence().cacheResult(monitorEvents);
	}

	/**
	* Creates a new monitor event with the primary key. Does not add the monitor event to the database.
	*
	* @param eventId the primary key for the new monitor event
	* @return the new monitor event
	*/
	public static com.amf.registration.model.MonitorEvent create(long eventId) {
		return getPersistence().create(eventId);
	}

	/**
	* Removes the monitor event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event that was removed
	* @throws com.amf.registration.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent remove(long eventId)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eventId);
	}

	public static com.amf.registration.model.MonitorEvent updateImpl(
		com.amf.registration.model.MonitorEvent monitorEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(monitorEvent);
	}

	/**
	* Returns the monitor event with the primary key or throws a {@link com.amf.registration.NoSuchMonitorEventException} if it could not be found.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event
	* @throws com.amf.registration.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent findByPrimaryKey(
		long eventId)
		throws com.amf.registration.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eventId);
	}

	/**
	* Returns the monitor event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event, or <code>null</code> if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.amf.registration.model.MonitorEvent fetchByPrimaryKey(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventId);
	}

	/**
	* Returns all the monitor events.
	*
	* @return the monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the monitor events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @return the range of monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the monitor events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.amf.registration.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.amf.registration.model.MonitorEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the monitor events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of monitor events.
	*
	* @return the number of monitor events
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MonitorEventPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MonitorEventPersistence)PortletBeanLocatorUtil.locate(com.amf.registration.service.ClpSerializer.getServletContextName(),
					MonitorEventPersistence.class.getName());

			ReferenceRegistry.registerReference(MonitorEventUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MonitorEventPersistence persistence) {
	}

	private static MonitorEventPersistence _persistence;
}