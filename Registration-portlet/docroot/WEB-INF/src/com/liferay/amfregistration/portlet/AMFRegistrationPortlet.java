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

package com.liferay.amfregistration.portlet;

import com.liferay.portal.AddressCityException;
import com.liferay.portal.AddressStreetException;
import com.liferay.portal.AddressZipException;
import com.liferay.portal.CompanyMaxUsersException;
import com.liferay.portal.ContactBirthdayException;
import com.liferay.portal.ContactFirstNameException;
import com.liferay.portal.ContactLastNameException;
import com.liferay.portal.DuplicateUserEmailAddressException;
import com.liferay.portal.DuplicateUserScreenNameException;
import com.liferay.portal.GroupFriendlyURLException;
import com.liferay.portal.PhoneNumberException;
import com.liferay.portal.ReservedUserScreenNameException;
import com.liferay.portal.TermsOfUseException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.UserReminderQueryException;
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
public class AMFRegistrationPortlet extends MVCPortlet {

	public void addUser(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String firstName = ParamUtil.getString(actionRequest, "first_name");
		String lastName = ParamUtil.getString(actionRequest, "last_name");
		String emailAddress = ParamUtil.getString(
			actionRequest, "email_address");
		String userName = ParamUtil.getString(actionRequest, "username");
		boolean male = ParamUtil.getBoolean(actionRequest, "male");
		int birthdayMonth = ParamUtil.getInteger(
			actionRequest, "b_Month");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "b_Day");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "b_Year");
		String password1 = ParamUtil.getString(actionRequest, "password1");
		String password2 = ParamUtil.getString(actionRequest, "password2");
		String homePhone = ParamUtil.getString(actionRequest, "home_phone");
		String mobilePhone = ParamUtil.getString(actionRequest, "mobile_phone");
		String address1 = ParamUtil.getString(actionRequest, "address");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		long stateId = ParamUtil.getLong(actionRequest, "state");
		String zip = ParamUtil.getString(actionRequest, "zip");

		String securityQuestion = ParamUtil.getString(
			actionRequest, "security_question");
		String securityAnswer = ParamUtil.getString(
			actionRequest, "security_answer");
		boolean termsOfUse = ParamUtil.getBoolean(
			actionRequest, "accepted_tou");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			User.class.getName(), actionRequest);

		validate(
			firstName, lastName, emailAddress, userName, birthdayMonth,
			birthdayDay, birthdayYear, password1, homePhone, mobilePhone,
			address1, address2, city, zip, securityAnswer, termsOfUse);

		User user = UserLocalServiceUtil.addUserWithWorkflow(
			0, serviceContext.getCompanyId(), false, password1, password2,
			false, userName, emailAddress, 0, StringPool.BLANK,
			LocaleUtil.getDefault(), firstName, StringPool.BLANK, lastName, 0,
			0, male, birthdayMonth, birthdayDay, birthdayYear, StringPool.BLANK,
			null, null, null, null, false, serviceContext);

		addPhones(homePhone, mobilePhone, user);

		addAddress(address1, address2, city, stateId, zip, user);

		UserLocalServiceUtil.updateReminderQuery(
			user.getUserId(), securityQuestion, securityAnswer);

		UserLocalServiceUtil.updateAgreedToTermsOfUse(
			user.getUserId(), termsOfUse);
	}

	protected void addAddress(
			String address1, String address2, String city, long stateId,
			String zip, User user)
		throws PortalException, SystemException {

		List<ListType> addressTypes = ListTypeServiceUtil.getListTypes(
				ListTypeConstants.CONTACT_ADDRESS);

		int typeId = 0;

		for (ListType addressType : addressTypes) {
			if (addressType.getName().equals("personal")) {
				typeId = addressType.getListTypeId();

				break;
			}
		}

		AddressLocalServiceUtil.addAddress(
			user.getUserId(), Contact.class.getName(), user.getContactId(),
			address1, address2, StringPool.BLANK, city, zip, 0, stateId, typeId,
			false, false, new ServiceContext());
	}

	protected void addPhones(String homePhone, String mobilePhone, User user)
		throws PortalException, SystemException {

		List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes(
			ListTypeConstants.CONTACT_PHONE);

		for (ListType phoneType : phoneTypes) {
			if ((phoneType.getName().equals("personal") &&
				 Validator.isNotNull(homePhone)) ||
				(phoneType.getName().equals("mobile-phone") &&
				 Validator.isNotNull(mobilePhone))) {

				PhoneLocalServiceUtil.addPhone(
					user.getUserId(), Contact.class.getName(),
					user.getContactId(), homePhone, StringPool.BLANK,
					phoneType.getListTypeId(), false, new ServiceContext());
			}
		}
	}

	protected boolean isSessionErrorException(Throwable cause) {
		if (cause instanceof AddressCityException ||
			cause instanceof AddressStreetException ||
			cause instanceof AddressZipException ||
			cause instanceof CompanyMaxUsersException ||
			cause instanceof ContactBirthdayException ||
			cause instanceof ContactFirstNameException ||
			cause instanceof ContactLastNameException ||
			cause instanceof DuplicateUserEmailAddressException ||
			cause instanceof DuplicateUserScreenNameException ||
			cause instanceof GroupFriendlyURLException ||
			cause instanceof PhoneNumberException ||
			cause instanceof ReservedUserScreenNameException ||
			cause instanceof TermsOfUseException ||
			cause instanceof UserPasswordException ||
			cause instanceof UserReminderQueryException ||
			cause instanceof UserScreenNameException) {

			return true;
		}

		return false;
	}

	protected void validate(
			String firstName, String lastName, String emailAddress,
			String userName, int birthdayMonth, int birthdayDay,
			int birthdayYear, String password1, String homePhone,
			String mobilePhone, String address1, String address2, String city,
			String zip, String securityAnswer, boolean termsOfUse)
		throws PortalException {

		if (!Validator.isAlphanumericName(firstName) ||
			(firstName.length() > 50)) {

			throw new ContactFirstNameException();
		}

		if (!Validator.isAlphanumericName(lastName) ||
			(lastName.length() > 50)) {

			throw new ContactLastNameException();
		}

		if (Validator.isNull(emailAddress) || (emailAddress.length() > 75)) {
			throw new UserEmailAddressException();
		}

		if (!Validator.isAlphanumericName(userName) ||
			((userName.length() < 4) || (userName.length() > 16))) {

			throw new UserScreenNameException();
		}

		Date birthday = PortalUtil.getDate(
			birthdayMonth, birthdayDay, birthdayYear,
			ContactBirthdayException.class);

		int age = CalendarUtil.getAge(
			birthday, CalendarFactoryUtil.getCalendar());

		if (age < 13) {
			throw new ContactBirthdayException();
		}

		validatePassword(password1);
		validateHomePhone(homePhone);
		validateMobilePhone(mobilePhone);
		validateAddress(address1, address2, city, zip);

		if (!Validator.isAlphanumericName(securityAnswer) ||
			(securityAnswer.length() > 75)) {

			throw new UserReminderQueryException("answer-is-invalid");
		}

		if (!termsOfUse) {
			throw new TermsOfUseException();
		}
	}

	protected void validateAddress(
			String address1, String address2, String city, String zip)
		throws PortalException {

		if (!Validator.isAlphanumericName(address1) ||
			(address1.length() > 75)) {

			throw new AddressStreetException("address1-is-invalid");
		}

		if (Validator.isNotNull(address2)) {
			if (!Validator.isAlphanumericName(address2) ||
				(address2.length() > 75)) {

				throw new AddressStreetException("address2-is-invalid");
			}
		}

		if (!Validator.isAlphanumericName(city) || (city.length() > 75)) {
			throw new AddressCityException();
		}

		if (!Validator.isDigit(zip) || (zip.length() != 5)) {
			throw new AddressZipException();
		}
	}

	protected boolean validateHomePhone(String homePhone)
		throws PortalException {

			if (Validator.isNotNull(homePhone)) {
				if (Validator.isDigit(homePhone) &&
					(homePhone.length() == 10)) {

					return true;
				}
				else {
					throw new PhoneNumberException("the-home-phone-is-invalid");
				}
			}

			return false;
		}

		protected boolean validateMobilePhone(String mobilePhone)
			throws PortalException {

			if (Validator.isNotNull(mobilePhone)) {
				if (Validator.isDigit(mobilePhone) &&
					(mobilePhone.length() == 10)) {
						return true;
				}
				else {
					throw new PhoneNumberException(
						"the-mobile-phone-is-invalid");
				}
			}

			return false;
		}

	protected void validatePassword(String password) throws PortalException {
		if (password.length() < 6) {
			throw new UserPasswordException(
				UserPasswordException.PASSWORD_LENGTH);
		}

		boolean hasUppercase = false;
		boolean hasNumber = false;
		boolean hasSpecialCharacter = false;

		for (char c : password.toCharArray()) {
			if (Character.isUpperCase(c)) {
				hasUppercase = true;
			}
			else if (Validator.isDigit(c)) {
				hasNumber = true;
			}
			else {
				for (char specialCharacter : _SPECIAL_CHARACTERS) {
					if (c == specialCharacter) {
						hasSpecialCharacter = true;
					}
				}
			}

			if (hasUppercase && hasNumber && hasSpecialCharacter) {
				return;
			}
		}

		throw new UserPasswordException(UserPasswordException.PASSWORD_INVALID);
	}

	private static final char[] _SPECIAL_CHARACTERS = new char[] {
		'.', '!', '#', '$', '%', '&', '\'', '*', '+', '-', '/', '=', '?',
		'^', '_', '`', '{', '|', '}', '~', '@', ',', '"', '(', ')', '\\',
		':'
	};
}