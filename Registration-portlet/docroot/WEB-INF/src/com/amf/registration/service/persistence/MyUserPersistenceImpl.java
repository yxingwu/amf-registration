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

import com.amf.registration.NoSuchMyUserException;
import com.amf.registration.model.MyUser;
import com.amf.registration.model.impl.MyUserImpl;
import com.amf.registration.model.impl.MyUserModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the my user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see MyUserPersistence
 * @see MyUserUtil
 * @generated
 */
public class MyUserPersistenceImpl extends BasePersistenceImpl<MyUser>
	implements MyUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MyUserUtil} to access the my user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MyUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MyUserModelImpl.ENTITY_CACHE_ENABLED,
			MyUserModelImpl.FINDER_CACHE_ENABLED, MyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MyUserModelImpl.ENTITY_CACHE_ENABLED,
			MyUserModelImpl.FINDER_CACHE_ENABLED, MyUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MyUserModelImpl.ENTITY_CACHE_ENABLED,
			MyUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MyUserPersistenceImpl() {
		setModelClass(MyUser.class);
	}

	/**
	 * Caches the my user in the entity cache if it is enabled.
	 *
	 * @param myUser the my user
	 */
	@Override
	public void cacheResult(MyUser myUser) {
		EntityCacheUtil.putResult(MyUserModelImpl.ENTITY_CACHE_ENABLED,
			MyUserImpl.class, myUser.getPrimaryKey(), myUser);

		myUser.resetOriginalValues();
	}

	/**
	 * Caches the my users in the entity cache if it is enabled.
	 *
	 * @param myUsers the my users
	 */
	@Override
	public void cacheResult(List<MyUser> myUsers) {
		for (MyUser myUser : myUsers) {
			if (EntityCacheUtil.getResult(
						MyUserModelImpl.ENTITY_CACHE_ENABLED, MyUserImpl.class,
						myUser.getPrimaryKey()) == null) {
				cacheResult(myUser);
			}
			else {
				myUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all my users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MyUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MyUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the my user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MyUser myUser) {
		EntityCacheUtil.removeResult(MyUserModelImpl.ENTITY_CACHE_ENABLED,
			MyUserImpl.class, myUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<MyUser> myUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MyUser myUser : myUsers) {
			EntityCacheUtil.removeResult(MyUserModelImpl.ENTITY_CACHE_ENABLED,
				MyUserImpl.class, myUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new my user with the primary key. Does not add the my user to the database.
	 *
	 * @param userId the primary key for the new my user
	 * @return the new my user
	 */
	@Override
	public MyUser create(long userId) {
		MyUser myUser = new MyUserImpl();

		myUser.setNew(true);
		myUser.setPrimaryKey(userId);

		return myUser;
	}

	/**
	 * Removes the my user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the my user
	 * @return the my user that was removed
	 * @throws com.amf.registration.NoSuchMyUserException if a my user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyUser remove(long userId)
		throws NoSuchMyUserException, SystemException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the my user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the my user
	 * @return the my user that was removed
	 * @throws com.amf.registration.NoSuchMyUserException if a my user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyUser remove(Serializable primaryKey)
		throws NoSuchMyUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MyUser myUser = (MyUser)session.get(MyUserImpl.class, primaryKey);

			if (myUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMyUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(myUser);
		}
		catch (NoSuchMyUserException nsee) {
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
	protected MyUser removeImpl(MyUser myUser) throws SystemException {
		myUser = toUnwrappedModel(myUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(myUser)) {
				myUser = (MyUser)session.get(MyUserImpl.class,
						myUser.getPrimaryKeyObj());
			}

			if (myUser != null) {
				session.delete(myUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (myUser != null) {
			clearCache(myUser);
		}

		return myUser;
	}

	@Override
	public MyUser updateImpl(com.amf.registration.model.MyUser myUser)
		throws SystemException {
		myUser = toUnwrappedModel(myUser);

		boolean isNew = myUser.isNew();

		Session session = null;

		try {
			session = openSession();

			if (myUser.isNew()) {
				session.save(myUser);

				myUser.setNew(false);
			}
			else {
				session.merge(myUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(MyUserModelImpl.ENTITY_CACHE_ENABLED,
			MyUserImpl.class, myUser.getPrimaryKey(), myUser);

		return myUser;
	}

	protected MyUser toUnwrappedModel(MyUser myUser) {
		if (myUser instanceof MyUserImpl) {
			return myUser;
		}

		MyUserImpl myUserImpl = new MyUserImpl();

		myUserImpl.setNew(myUser.isNew());
		myUserImpl.setPrimaryKey(myUser.getPrimaryKey());

		myUserImpl.setUserId(myUser.getUserId());

		return myUserImpl;
	}

	/**
	 * Returns the my user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the my user
	 * @return the my user
	 * @throws com.amf.registration.NoSuchMyUserException if a my user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMyUserException, SystemException {
		MyUser myUser = fetchByPrimaryKey(primaryKey);

		if (myUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMyUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return myUser;
	}

	/**
	 * Returns the my user with the primary key or throws a {@link com.amf.registration.NoSuchMyUserException} if it could not be found.
	 *
	 * @param userId the primary key of the my user
	 * @return the my user
	 * @throws com.amf.registration.NoSuchMyUserException if a my user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyUser findByPrimaryKey(long userId)
		throws NoSuchMyUserException, SystemException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the my user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the my user
	 * @return the my user, or <code>null</code> if a my user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		MyUser myUser = (MyUser)EntityCacheUtil.getResult(MyUserModelImpl.ENTITY_CACHE_ENABLED,
				MyUserImpl.class, primaryKey);

		if (myUser == _nullMyUser) {
			return null;
		}

		if (myUser == null) {
			Session session = null;

			try {
				session = openSession();

				myUser = (MyUser)session.get(MyUserImpl.class, primaryKey);

				if (myUser != null) {
					cacheResult(myUser);
				}
				else {
					EntityCacheUtil.putResult(MyUserModelImpl.ENTITY_CACHE_ENABLED,
						MyUserImpl.class, primaryKey, _nullMyUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MyUserModelImpl.ENTITY_CACHE_ENABLED,
					MyUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return myUser;
	}

	/**
	 * Returns the my user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the my user
	 * @return the my user, or <code>null</code> if a my user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MyUser fetchByPrimaryKey(long userId) throws SystemException {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the my users.
	 *
	 * @return the my users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<MyUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<MyUser> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<MyUser> findAll(int start, int end,
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

		List<MyUser> list = (List<MyUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MYUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MYUSER;

				if (pagination) {
					sql = sql.concat(MyUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MyUser>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<MyUser>(list);
				}
				else {
					list = (List<MyUser>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the my users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (MyUser myUser : findAll()) {
			remove(myUser);
		}
	}

	/**
	 * Returns the number of my users.
	 *
	 * @return the number of my users
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

				Query q = session.createQuery(_SQL_COUNT_MYUSER);

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
	 * Initializes the my user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.amf.registration.model.MyUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MyUser>> listenersList = new ArrayList<ModelListener<MyUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MyUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MyUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MYUSER = "SELECT myUser FROM MyUser myUser";
	private static final String _SQL_COUNT_MYUSER = "SELECT COUNT(myUser) FROM MyUser myUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "myUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MyUser exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MyUserPersistenceImpl.class);
	private static MyUser _nullMyUser = new MyUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MyUser> toCacheModel() {
				return _nullMyUserCacheModel;
			}
		};

	private static CacheModel<MyUser> _nullMyUserCacheModel = new CacheModel<MyUser>() {
			@Override
			public MyUser toEntityModel() {
				return _nullMyUser;
			}
		};
}