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

package com.amf.registration.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MyUser}.
 * </p>
 *
 * @author liferay
 * @see MyUser
 * @generated
 */
public class MyUserWrapper implements MyUser, ModelWrapper<MyUser> {
	public MyUserWrapper(MyUser myUser) {
		_myUser = myUser;
	}

	@Override
	public Class<?> getModelClass() {
		return MyUser.class;
	}

	@Override
	public String getModelClassName() {
		return MyUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this my user.
	*
	* @return the primary key of this my user
	*/
	@Override
	public long getPrimaryKey() {
		return _myUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this my user.
	*
	* @param primaryKey the primary key of this my user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_myUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this my user.
	*
	* @return the user ID of this my user
	*/
	@Override
	public long getUserId() {
		return _myUser.getUserId();
	}

	/**
	* Sets the user ID of this my user.
	*
	* @param userId the user ID of this my user
	*/
	@Override
	public void setUserId(long userId) {
		_myUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this my user.
	*
	* @return the user uuid of this my user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _myUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this my user.
	*
	* @param userUuid the user uuid of this my user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_myUser.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _myUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_myUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _myUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_myUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _myUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _myUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_myUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _myUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_myUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_myUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_myUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MyUserWrapper((MyUser)_myUser.clone());
	}

	@Override
	public int compareTo(com.amf.registration.model.MyUser myUser) {
		return _myUser.compareTo(myUser);
	}

	@Override
	public int hashCode() {
		return _myUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.amf.registration.model.MyUser> toCacheModel() {
		return _myUser.toCacheModel();
	}

	@Override
	public com.amf.registration.model.MyUser toEscapedModel() {
		return new MyUserWrapper(_myUser.toEscapedModel());
	}

	@Override
	public com.amf.registration.model.MyUser toUnescapedModel() {
		return new MyUserWrapper(_myUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _myUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _myUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_myUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MyUserWrapper)) {
			return false;
		}

		MyUserWrapper myUserWrapper = (MyUserWrapper)obj;

		if (Validator.equals(_myUser, myUserWrapper._myUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MyUser getWrappedMyUser() {
		return _myUser;
	}

	@Override
	public MyUser getWrappedModel() {
		return _myUser;
	}

	@Override
	public void resetOriginalValues() {
		_myUser.resetOriginalValues();
	}

	private MyUser _myUser;
}