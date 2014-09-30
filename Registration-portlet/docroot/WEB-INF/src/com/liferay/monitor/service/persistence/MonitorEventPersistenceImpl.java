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

import com.liferay.monitor.NoSuchMonitorEventException;
import com.liferay.monitor.model.MonitorEvent;
import com.liferay.monitor.model.impl.MonitorEventImpl;
import com.liferay.monitor.model.impl.MonitorEventModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the monitor event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see MonitorEventPersistence
 * @see MonitorEventUtil
 * @generated
 */
public class MonitorEventPersistenceImpl extends BasePersistenceImpl<MonitorEvent>
	implements MonitorEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MonitorEventUtil} to access the monitor event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MonitorEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, MonitorEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, MonitorEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, MonitorEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByeventType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, MonitorEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByeventType",
			new String[] { Integer.class.getName() },
			MonitorEventModelImpl.EVENTTYPE_COLUMN_BITMASK |
			MonitorEventModelImpl.EVENTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTYPE = new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByeventType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the monitor events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching monitor events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MonitorEvent> findByeventType(int eventType)
		throws SystemException {
		return findByeventType(eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

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
	@Override
	public List<MonitorEvent> findByeventType(int eventType, int start, int end)
		throws SystemException {
		return findByeventType(eventType, start, end, null);
	}

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
	@Override
	public List<MonitorEvent> findByeventType(int eventType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType, start, end, orderByComparator };
		}

		List<MonitorEvent> list = (List<MonitorEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MonitorEvent monitorEvent : list) {
				if ((eventType != monitorEvent.getEventType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MONITOREVENT_WHERE);

			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MonitorEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventType);

				if (!pagination) {
					list = (List<MonitorEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MonitorEvent>(list);
				}
				else {
					list = (List<MonitorEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first monitor event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monitor event
	 * @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent findByeventType_First(int eventType,
		OrderByComparator orderByComparator)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = fetchByeventType_First(eventType,
				orderByComparator);

		if (monitorEvent != null) {
			return monitorEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonitorEventException(msg.toString());
	}

	/**
	 * Returns the first monitor event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monitor event, or <code>null</code> if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent fetchByeventType_First(int eventType,
		OrderByComparator orderByComparator) throws SystemException {
		List<MonitorEvent> list = findByeventType(eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last monitor event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monitor event
	 * @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent findByeventType_Last(int eventType,
		OrderByComparator orderByComparator)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = fetchByeventType_Last(eventType,
				orderByComparator);

		if (monitorEvent != null) {
			return monitorEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonitorEventException(msg.toString());
	}

	/**
	 * Returns the last monitor event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monitor event, or <code>null</code> if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent fetchByeventType_Last(int eventType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByeventType(eventType);

		if (count == 0) {
			return null;
		}

		List<MonitorEvent> list = findByeventType(eventType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public MonitorEvent[] findByeventType_PrevAndNext(long eventId,
		int eventType, OrderByComparator orderByComparator)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			MonitorEvent[] array = new MonitorEventImpl[3];

			array[0] = getByeventType_PrevAndNext(session, monitorEvent,
					eventType, orderByComparator, true);

			array[1] = monitorEvent;

			array[2] = getByeventType_PrevAndNext(session, monitorEvent,
					eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MonitorEvent getByeventType_PrevAndNext(Session session,
		MonitorEvent monitorEvent, int eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MONITOREVENT_WHERE);

		query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MonitorEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(monitorEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MonitorEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the monitor events where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByeventType(int eventType) throws SystemException {
		for (MonitorEvent monitorEvent : findByeventType(eventType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(monitorEvent);
		}
	}

	/**
	 * Returns the number of monitor events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching monitor events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByeventType(int eventType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTTYPE;

		Object[] finderArgs = new Object[] { eventType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MONITOREVENT_WHERE);

			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventType);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2 = "monitorEvent.eventType = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, MonitorEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, MonitorEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			MonitorEventModelImpl.USERID_COLUMN_BITMASK |
			MonitorEventModelImpl.EVENTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the monitor events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching monitor events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MonitorEvent> findByuserId(long userId)
		throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<MonitorEvent> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
	}

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
	@Override
	public List<MonitorEvent> findByuserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<MonitorEvent> list = (List<MonitorEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MonitorEvent monitorEvent : list) {
				if ((userId != monitorEvent.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MONITOREVENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MonitorEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<MonitorEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MonitorEvent>(list);
				}
				else {
					list = (List<MonitorEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first monitor event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monitor event
	 * @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = fetchByuserId_First(userId,
				orderByComparator);

		if (monitorEvent != null) {
			return monitorEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonitorEventException(msg.toString());
	}

	/**
	 * Returns the first monitor event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monitor event, or <code>null</code> if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<MonitorEvent> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last monitor event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monitor event
	 * @throws com.liferay.monitor.NoSuchMonitorEventException if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = fetchByuserId_Last(userId, orderByComparator);

		if (monitorEvent != null) {
			return monitorEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonitorEventException(msg.toString());
	}

	/**
	 * Returns the last monitor event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monitor event, or <code>null</code> if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<MonitorEvent> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public MonitorEvent[] findByuserId_PrevAndNext(long eventId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			MonitorEvent[] array = new MonitorEventImpl[3];

			array[0] = getByuserId_PrevAndNext(session, monitorEvent, userId,
					orderByComparator, true);

			array[1] = monitorEvent;

			array[2] = getByuserId_PrevAndNext(session, monitorEvent, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MonitorEvent getByuserId_PrevAndNext(Session session,
		MonitorEvent monitorEvent, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MONITOREVENT_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MonitorEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(monitorEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MonitorEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the monitor events where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (MonitorEvent monitorEvent : findByuserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(monitorEvent);
		}
	}

	/**
	 * Returns the number of monitor events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching monitor events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MONITOREVENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "monitorEvent.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_E = new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, MonitorEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_E",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_E = new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, MonitorEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_E",
			new String[] { Long.class.getName(), Integer.class.getName() },
			MonitorEventModelImpl.USERID_COLUMN_BITMASK |
			MonitorEventModelImpl.EVENTTYPE_COLUMN_BITMASK |
			MonitorEventModelImpl.EVENTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_E = new FinderPath(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_E",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the monitor events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching monitor events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MonitorEvent> findByU_E(long userId, int eventType)
		throws SystemException {
		return findByU_E(userId, eventType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<MonitorEvent> findByU_E(long userId, int eventType, int start,
		int end) throws SystemException {
		return findByU_E(userId, eventType, start, end, null);
	}

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
	@Override
	public List<MonitorEvent> findByU_E(long userId, int eventType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_E;
			finderArgs = new Object[] { userId, eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_E;
			finderArgs = new Object[] {
					userId, eventType,
					
					start, end, orderByComparator
				};
		}

		List<MonitorEvent> list = (List<MonitorEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MonitorEvent monitorEvent : list) {
				if ((userId != monitorEvent.getUserId()) ||
						(eventType != monitorEvent.getEventType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MONITOREVENT_WHERE);

			query.append(_FINDER_COLUMN_U_E_USERID_2);

			query.append(_FINDER_COLUMN_U_E_EVENTTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MonitorEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(eventType);

				if (!pagination) {
					list = (List<MonitorEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MonitorEvent>(list);
				}
				else {
					list = (List<MonitorEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public MonitorEvent findByU_E_First(long userId, int eventType,
		OrderByComparator orderByComparator)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = fetchByU_E_First(userId, eventType,
				orderByComparator);

		if (monitorEvent != null) {
			return monitorEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonitorEventException(msg.toString());
	}

	/**
	 * Returns the first monitor event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monitor event, or <code>null</code> if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent fetchByU_E_First(long userId, int eventType,
		OrderByComparator orderByComparator) throws SystemException {
		List<MonitorEvent> list = findByU_E(userId, eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public MonitorEvent findByU_E_Last(long userId, int eventType,
		OrderByComparator orderByComparator)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = fetchByU_E_Last(userId, eventType,
				orderByComparator);

		if (monitorEvent != null) {
			return monitorEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonitorEventException(msg.toString());
	}

	/**
	 * Returns the last monitor event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monitor event, or <code>null</code> if a matching monitor event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent fetchByU_E_Last(long userId, int eventType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByU_E(userId, eventType);

		if (count == 0) {
			return null;
		}

		List<MonitorEvent> list = findByU_E(userId, eventType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public MonitorEvent[] findByU_E_PrevAndNext(long eventId, long userId,
		int eventType, OrderByComparator orderByComparator)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			MonitorEvent[] array = new MonitorEventImpl[3];

			array[0] = getByU_E_PrevAndNext(session, monitorEvent, userId,
					eventType, orderByComparator, true);

			array[1] = monitorEvent;

			array[2] = getByU_E_PrevAndNext(session, monitorEvent, userId,
					eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MonitorEvent getByU_E_PrevAndNext(Session session,
		MonitorEvent monitorEvent, long userId, int eventType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MONITOREVENT_WHERE);

		query.append(_FINDER_COLUMN_U_E_USERID_2);

		query.append(_FINDER_COLUMN_U_E_EVENTTYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MonitorEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(eventType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(monitorEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MonitorEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the monitor events where userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByU_E(long userId, int eventType)
		throws SystemException {
		for (MonitorEvent monitorEvent : findByU_E(userId, eventType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(monitorEvent);
		}
	}

	/**
	 * Returns the number of monitor events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching monitor events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByU_E(long userId, int eventType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_E;

		Object[] finderArgs = new Object[] { userId, eventType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MONITOREVENT_WHERE);

			query.append(_FINDER_COLUMN_U_E_USERID_2);

			query.append(_FINDER_COLUMN_U_E_EVENTTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(eventType);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_E_USERID_2 = "monitorEvent.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_E_EVENTTYPE_2 = "monitorEvent.eventType = ?";

	public MonitorEventPersistenceImpl() {
		setModelClass(MonitorEvent.class);
	}

	/**
	 * Caches the monitor event in the entity cache if it is enabled.
	 *
	 * @param monitorEvent the monitor event
	 */
	@Override
	public void cacheResult(MonitorEvent monitorEvent) {
		EntityCacheUtil.putResult(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventImpl.class, monitorEvent.getPrimaryKey(), monitorEvent);

		monitorEvent.resetOriginalValues();
	}

	/**
	 * Caches the monitor events in the entity cache if it is enabled.
	 *
	 * @param monitorEvents the monitor events
	 */
	@Override
	public void cacheResult(List<MonitorEvent> monitorEvents) {
		for (MonitorEvent monitorEvent : monitorEvents) {
			if (EntityCacheUtil.getResult(
						MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
						MonitorEventImpl.class, monitorEvent.getPrimaryKey()) == null) {
				cacheResult(monitorEvent);
			}
			else {
				monitorEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all monitor events.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MonitorEventImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MonitorEventImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the monitor event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MonitorEvent monitorEvent) {
		EntityCacheUtil.removeResult(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventImpl.class, monitorEvent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MonitorEvent> monitorEvents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MonitorEvent monitorEvent : monitorEvents) {
			EntityCacheUtil.removeResult(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
				MonitorEventImpl.class, monitorEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new monitor event with the primary key. Does not add the monitor event to the database.
	 *
	 * @param eventId the primary key for the new monitor event
	 * @return the new monitor event
	 */
	@Override
	public MonitorEvent create(long eventId) {
		MonitorEvent monitorEvent = new MonitorEventImpl();

		monitorEvent.setNew(true);
		monitorEvent.setPrimaryKey(eventId);

		return monitorEvent;
	}

	/**
	 * Removes the monitor event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the monitor event
	 * @return the monitor event that was removed
	 * @throws com.liferay.monitor.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent remove(long eventId)
		throws NoSuchMonitorEventException, SystemException {
		return remove((Serializable)eventId);
	}

	/**
	 * Removes the monitor event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the monitor event
	 * @return the monitor event that was removed
	 * @throws com.liferay.monitor.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent remove(Serializable primaryKey)
		throws NoSuchMonitorEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MonitorEvent monitorEvent = (MonitorEvent)session.get(MonitorEventImpl.class,
					primaryKey);

			if (monitorEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMonitorEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(monitorEvent);
		}
		catch (NoSuchMonitorEventException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MonitorEvent removeImpl(MonitorEvent monitorEvent)
		throws SystemException {
		monitorEvent = toUnwrappedModel(monitorEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(monitorEvent)) {
				monitorEvent = (MonitorEvent)session.get(MonitorEventImpl.class,
						monitorEvent.getPrimaryKeyObj());
			}

			if (monitorEvent != null) {
				session.delete(monitorEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (monitorEvent != null) {
			clearCache(monitorEvent);
		}

		return monitorEvent;
	}

	@Override
	public MonitorEvent updateImpl(
		com.liferay.monitor.model.MonitorEvent monitorEvent)
		throws SystemException {
		monitorEvent = toUnwrappedModel(monitorEvent);

		boolean isNew = monitorEvent.isNew();

		MonitorEventModelImpl monitorEventModelImpl = (MonitorEventModelImpl)monitorEvent;

		Session session = null;

		try {
			session = openSession();

			if (monitorEvent.isNew()) {
				session.save(monitorEvent);

				monitorEvent.setNew(false);
			}
			else {
				session.merge(monitorEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MonitorEventModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((monitorEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monitorEventModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);

				args = new Object[] { monitorEventModelImpl.getEventType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);
			}

			if ((monitorEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monitorEventModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { monitorEventModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((monitorEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_E.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monitorEventModelImpl.getOriginalUserId(),
						monitorEventModelImpl.getOriginalEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_E,
					args);

				args = new Object[] {
						monitorEventModelImpl.getUserId(),
						monitorEventModelImpl.getEventType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_E, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_E,
					args);
			}
		}

		EntityCacheUtil.putResult(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
			MonitorEventImpl.class, monitorEvent.getPrimaryKey(), monitorEvent);

		return monitorEvent;
	}

	protected MonitorEvent toUnwrappedModel(MonitorEvent monitorEvent) {
		if (monitorEvent instanceof MonitorEventImpl) {
			return monitorEvent;
		}

		MonitorEventImpl monitorEventImpl = new MonitorEventImpl();

		monitorEventImpl.setNew(monitorEvent.isNew());
		monitorEventImpl.setPrimaryKey(monitorEvent.getPrimaryKey());

		monitorEventImpl.setEventId(monitorEvent.getEventId());
		monitorEventImpl.setUserId(monitorEvent.getUserId());
		monitorEventImpl.setIp(monitorEvent.getIp());
		monitorEventImpl.setEventDate(monitorEvent.getEventDate());
		monitorEventImpl.setEventType(monitorEvent.getEventType());

		return monitorEventImpl;
	}

	/**
	 * Returns the monitor event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the monitor event
	 * @return the monitor event
	 * @throws com.liferay.monitor.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMonitorEventException, SystemException {
		MonitorEvent monitorEvent = fetchByPrimaryKey(primaryKey);

		if (monitorEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMonitorEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return monitorEvent;
	}

	/**
	 * Returns the monitor event with the primary key or throws a {@link com.liferay.monitor.NoSuchMonitorEventException} if it could not be found.
	 *
	 * @param eventId the primary key of the monitor event
	 * @return the monitor event
	 * @throws com.liferay.monitor.NoSuchMonitorEventException if a monitor event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent findByPrimaryKey(long eventId)
		throws NoSuchMonitorEventException, SystemException {
		return findByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns the monitor event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the monitor event
	 * @return the monitor event, or <code>null</code> if a monitor event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MonitorEvent monitorEvent = (MonitorEvent)EntityCacheUtil.getResult(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
				MonitorEventImpl.class, primaryKey);

		if (monitorEvent == _nullMonitorEvent) {
			return null;
		}

		if (monitorEvent == null) {
			Session session = null;

			try {
				session = openSession();

				monitorEvent = (MonitorEvent)session.get(MonitorEventImpl.class,
						primaryKey);

				if (monitorEvent != null) {
					cacheResult(monitorEvent);
				}
				else {
					EntityCacheUtil.putResult(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
						MonitorEventImpl.class, primaryKey, _nullMonitorEvent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MonitorEventModelImpl.ENTITY_CACHE_ENABLED,
					MonitorEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return monitorEvent;
	}

	/**
	 * Returns the monitor event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the monitor event
	 * @return the monitor event, or <code>null</code> if a monitor event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MonitorEvent fetchByPrimaryKey(long eventId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns all the monitor events.
	 *
	 * @return the monitor events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MonitorEvent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<MonitorEvent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<MonitorEvent> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<MonitorEvent> list = (List<MonitorEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MONITOREVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MONITOREVENT;

				if (pagination) {
					sql = sql.concat(MonitorEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MonitorEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MonitorEvent>(list);
				}
				else {
					list = (List<MonitorEvent>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the monitor events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MonitorEvent monitorEvent : findAll()) {
			remove(monitorEvent);
		}
	}

	/**
	 * Returns the number of monitor events.
	 *
	 * @return the number of monitor events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MONITOREVENT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the monitor event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.monitor.model.MonitorEvent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MonitorEvent>> listenersList = new ArrayList<ModelListener<MonitorEvent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MonitorEvent>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MonitorEventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MONITOREVENT = "SELECT monitorEvent FROM MonitorEvent monitorEvent";
	private static final String _SQL_SELECT_MONITOREVENT_WHERE = "SELECT monitorEvent FROM MonitorEvent monitorEvent WHERE ";
	private static final String _SQL_COUNT_MONITOREVENT = "SELECT COUNT(monitorEvent) FROM MonitorEvent monitorEvent";
	private static final String _SQL_COUNT_MONITOREVENT_WHERE = "SELECT COUNT(monitorEvent) FROM MonitorEvent monitorEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "monitorEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MonitorEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MonitorEvent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MonitorEventPersistenceImpl.class);
	private static MonitorEvent _nullMonitorEvent = new MonitorEventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MonitorEvent> toCacheModel() {
				return _nullMonitorEventCacheModel;
			}
		};

	private static CacheModel<MonitorEvent> _nullMonitorEventCacheModel = new CacheModel<MonitorEvent>() {
			@Override
			public MonitorEvent toEntityModel() {
				return _nullMonitorEvent;
			}
		};
}