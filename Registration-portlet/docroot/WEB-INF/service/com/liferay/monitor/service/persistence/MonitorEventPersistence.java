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

package com.liferay.monitor.service.persistence;

import com.liferay.monitor.model.MonitorEvent;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the monitor event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see MonitorEventPersistenceImpl
 * @see MonitorEventUtil
 * @generated
 */
public interface MonitorEventPersistence extends BasePersistence<MonitorEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MonitorEventUtil} to access the monitor event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the monitor events where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findByeventType(
		int eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the monitor events where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @return the range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findByeventType(
		int eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the monitor events where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findByeventType(
		int eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent findByeventType_First(
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent fetchByeventType_First(
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent findByeventType_Last(
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent fetchByeventType_Last(
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the monitor events before and after the current monitor event in the ordered set where eventType = &#63;.
	*
	* @param eventId the primary key of the current monitor event
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent[] findByeventType_PrevAndNext(
		long eventId, int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the monitor events where eventType = &#63; from the database.
	*
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByeventType(int eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of monitor events where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public int countByeventType(int eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the monitor events where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the monitor events where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @return the range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the monitor events where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first monitor event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first monitor event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last monitor event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last monitor event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the monitor events before and after the current monitor event in the ordered set where userId = &#63;.
	*
	* @param eventId the primary key of the current monitor event
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent[] findByuserId_PrevAndNext(
		long eventId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the monitor events where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of monitor events where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the monitor events where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @return the matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findByU_E(
		long userId, int eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the monitor events where userId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @return the range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findByU_E(
		long userId, int eventType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the monitor events where userId = &#63; and eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findByU_E(
		long userId, int eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first monitor event in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent findByU_E_First(long userId,
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first monitor event in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent fetchByU_E_First(
		long userId, int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last monitor event in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent findByU_E_Last(long userId,
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last monitor event in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monitor event, or <code>null</code> if a matching monitor event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent fetchByU_E_Last(long userId,
		int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the monitor events before and after the current monitor event in the ordered set where userId = &#63; and eventType = &#63;.
	*
	* @param eventId the primary key of the current monitor event
	* @param userId the user ID
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent[] findByU_E_PrevAndNext(
		long eventId, long userId, int eventType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the monitor events where userId = &#63; and eventType = &#63; from the database.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByU_E(long userId, int eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of monitor events where userId = &#63; and eventType = &#63;.
	*
	* @param userId the user ID
	* @param eventType the event type
	* @return the number of matching monitor events
	* @throws SystemException if a system exception occurred
	*/
	public int countByU_E(long userId, int eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the monitor event in the entity cache if it is enabled.
	*
	* @param monitorEvent the monitor event
	*/
	public void cacheResult(com.liferay.monitor.model.MonitorEvent monitorEvent);

	/**
	* Caches the monitor events in the entity cache if it is enabled.
	*
	* @param monitorEvents the monitor events
	*/
	public void cacheResult(
		java.util.List<com.liferay.monitor.model.MonitorEvent> monitorEvents);

	/**
	* Creates a new monitor event with the primary key. Does not add the monitor event to the database.
	*
	* @param eventId the primary key for the new monitor event
	* @return the new monitor event
	*/
	public com.liferay.monitor.model.MonitorEvent create(long eventId);

	/**
	* Removes the monitor event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event that was removed
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent remove(long eventId)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.monitor.model.MonitorEvent updateImpl(
		com.liferay.monitor.model.MonitorEvent monitorEvent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the monitor event with the primary key or throws a {@link com.liferay.monitor.NoSuchMonitorEventException} if it could not be found.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event
	* @throws com.liferay.monitor.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent findByPrimaryKey(long eventId)
		throws com.liferay.monitor.NoSuchMonitorEventException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the monitor event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventId the primary key of the monitor event
	* @return the monitor event, or <code>null</code> if a monitor event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.monitor.model.MonitorEvent fetchByPrimaryKey(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the monitor events.
	*
	* @return the monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the monitor events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.monitor.model.impl.MonitorEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monitor events
	* @param end the upper bound of the range of monitor events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of monitor events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.monitor.model.MonitorEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the monitor events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of monitor events.
	*
	* @return the number of monitor events
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}