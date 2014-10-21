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

import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.ProcessEvent;

/**
 * @author Yuxing Wu
 */
public class SearchResultPortlet extends MVCPortlet {

	@ProcessEvent(qname="{http://amf.com/events}amf.search")
	public void getZip(EventRequest eventRequest, EventResponse eventResponse) {
		Event event = eventRequest.getEvent();

		String zip = (String)event.getValue();

		eventResponse.setRenderParameter("zip", zip);
	}

}