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

package com.amf.registration.search.portlet;

import com.liferay.portal.AddressZipException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import javax.xml.namespace.QName;

/**
 * @author Yuxing Wu
 */
public class SearchPortlet extends MVCPortlet {

	public void search(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String zip = ParamUtil.getString(actionRequest, "zip");

		Validate(zip);

		QName qName = new QName("http://amf.com/events", "amf.search");

		actionResponse.setEvent(qName, zip);
	}

	protected void Validate(String zip) throws PortalException {
		if (!Validator.isDigit(zip) || (zip.length() != 5)) {
			throw new AddressZipException();
		}
	}

}