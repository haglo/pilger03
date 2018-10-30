package org.app.helper;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Locale;
import org.app.model.entity.enums.DefaultLanguage;
import org.app.model.entity.enums.DefaultTheme;

public final class I18n {

	private static I18n instance;

	final I18nManager i18m = I18nManager.getInstance();

	public static final String LOGIN_VIEW = "Login";
	public static final String PERSON_VIEW = "Person";
	public static final String MASTER_DETAIL_VIEW = "MasterDetail";
	public static final String ACCOUNT_VIEW = "Account";
	public static final String ELYTRON_USER_VIEW = "ElytronUserView";
	public static final String HELP_VIEW = "Help";
	public static final String TITLE_VIEW = "Title";
	public static final String SETTINGS_VIEW = "Settings";
	public static final String EMAIL_VIEW = "Email";
	public static final String INBOX_VIEW = "Inbox";

	public static final String THEME = "Theme";
	public static final String LOCALE = "Locale";
	public static final String ROLE_SYSTEM = "System";
	public static final String ROLE_POWERUSER = "Poweruser";
	public static final String ROLE_ADMINISTRATOR = "Administrator";
	public static final String ROLE_USER = "User";
	public static final String ROLE_GUEST = "Guest";
	public static final String ELYTRON_PASSWORD = "secret01"; // Default-Password given in Entity ElytronUser.java
	public static String WINDOW_WIDTH = "";

	public String BASIC_ID = "ID";
	public String BASIC_UUID = "UUID";

	public String BASIC_EDIT = i18m.getMessage("basic.edit");
	public String BASIC_SAVE = i18m.getMessage("basic.save");
	public String BASIC_LIST_PRIO = i18m.getMessage("basic.listprio");
	public String BASIC_COMMENT = i18m.getMessage("basic.comment");
	public String BASIC_ABOUT = i18m.getMessage("basic.about");
	public String BASIC_DATE = i18m.getMessage("basic.date");
	public String BASIC_CREATE_BY = i18m.getMessage("basic.createby");
	public String BASIC_CREATE_AT = i18m.getMessage("basic.createat");
	public String BASIC_MODIFY_BY = i18m.getMessage("basic.modifyby");
	public String BASIC_MODIFY_AT = i18m.getMessage("basic.modifyat");
	public String BASIC_EMAIL = i18m.getMessage("basic.email");
	public String BASIC_PHONE = i18m.getMessage("basic.phone");
	public String BASIC_MOBILE = i18m.getMessage("basic.mobile");
	public String BASIC_FAX = i18m.getMessage("basic.fax");
	public String BASIC_WEBSITE = i18m.getMessage("basic.website");
	public String BASIC_LANGUAGE = i18m.getMessage("basic.language");
	public String BASIC_THEME = i18m.getMessage("basic.theme");
	public String BASIC_TYPE = i18m.getMessage("basic.type");
	public String BASIC_DELETE = i18m.getMessage("basic.delete");
	public String BASIC_PRINT = i18m.getMessage("basic.print");

	public String AUTH_LOGIN = i18m.getMessage("auth.login");
	public String AUTH_REMEMBER_ME = i18m.getMessage("auth.rememberme");

	public String NAVI_PERSONS = i18m.getMessage("navi.persons");
	public String NAVI_MASTER_DETAIL = i18m.getMessage("navi.masterdetail");
	public String NAVI_ACCOUNTS = i18m.getMessage("navi.accounts");
	public String NAVI_ELYTRON_USER = i18m.getMessage("navi.elytronuser");
	public String NAVI_HELP = i18m.getMessage("navi.help");
	public String NAVI_EMAIL = i18m.getMessage("navi.email");
	public String NAVI_SETTINGS = i18m.getMessage("navi.settings");
	public String NAVI_LOGOUT = i18m.getMessage("navi.logout");

	public String PERSON_SURNAME = i18m.getMessage("person.surname");
	public String PERSON_LASTNAME = i18m.getMessage("person.lastname");
	public String PERSON_STREET = i18m.getMessage("person.street");
	public String PERSON_POSTBOX = i18m.getMessage("person.postbox");
	public String PERSON_ZIPCODE = i18m.getMessage("person.zipcode");
	public String PERSON_CITY = i18m.getMessage("person.city");
	public String PERSON_COUNTRY = i18m.getMessage("person.country");
	public String PERSON_COMMUNICATION = i18m.getMessage("person.communication");

	public String TITLE_WINDOW_DETAIL_CAPTION = i18m.getMessage("title.windowdetailcaption");
	public String TITLE_WINDOW_NEW_CAPTION = i18m.getMessage("title.windownewcaption");
	public String TITLE_VALUE = i18m.getMessage("title.value");
	public String TITLE_AUDIT = i18m.getMessage("title.audit");

	public String ACCOUNT_WINDOW_DETAIL_CAPTION = i18m.getMessage("account.windowdetailcaption");
	public String ACCOUNT_WINDOW_NEW_CAPTION = i18m.getMessage("account.windownewcaption");
	public String ACCOUNT_USERNAME = i18m.getMessage("account.username");
	public String ACCOUNT_PASSWORD = i18m.getMessage("account.password");
	public String ACCOUNT_GROUP = i18m.getMessage("account.group");

	public String EMAIL_INBOX = i18m.getMessage("email.inbox");
	public String EMAIL_OUTBOX = i18m.getMessage("email.outbox");
	public String EMAIL_TRASH = i18m.getMessage("email.trash");
	public String EMAIL_ARCHIVE = i18m.getMessage("email.archive");
	public String EMAIL_LOST = i18m.getMessage("email.lost");
	public String EMAIL_HEADER = i18m.getMessage("email.header");
	public String EMAIL_BODY = i18m.getMessage("email.body");
	public String EMAIL_TO = i18m.getMessage("email.to");
	public String EMAIL_BC = i18m.getMessage("email.cc");
	public String EMAIL_CC = i18m.getMessage("email.bc");
	public String EMAIL_SUBJECT = i18m.getMessage("email.subject");
	public String EMAIL_CALL = i18m.getMessage("email.call");
	public String EMAIL_WRITE = i18m.getMessage("email.write");
	public String EMAIL_SEND = i18m.getMessage("email.send");
	public String EMAIL_ANSWER = i18m.getMessage("email.answer");
	public String EMAIL_FORWARD = i18m.getMessage("email.forward");
	public String EMAIL_SIGNATURE = i18m.getMessage("email.signature");
	public String EMAIL_ATTACHMENT = i18m.getMessage("email.attachment");
	public String EMAIL_NEW = i18m.getMessage("email.new");
	public String EMAIL_SEND_SUCCESS = i18m.getMessage("email.sendSuccess");
	public String EMAIL_SEND_ERROR = i18m.getMessage("email.sendError");

	public String SETTINGS_WINDOW_WIDTH = i18m.getMessage("settings.windowwidth");

	public String HELP_LANGUAGE = i18m.getMessage("help.language");

	public String NOTIFICATION_NO_ITEM = i18m.getMessage("notification.noItem");
	public String NOTIFICATION_EXACT_ONE_ITEM = i18m.getMessage("notification.oneItem");
	public String NOTIFICATION_ONLY_ONE_ITEM = i18m.getMessage("notification.onlyOneItem");
	public String NOTIFICATION_ONTOP = i18m.getMessage("notification.ontop");
	public String NOTIFICATION_ONTBOTTOM = i18m.getMessage("notification.onBottom");

	public I18n() {
	}

	public static I18n getInstance() {
		if (instance == null) {
			instance = new I18n();
		}
		return instance;
	}

	public static Locale getElytronLocale(DefaultLanguage entry) {
		switch (entry) {
		case english:
			return Locale.ENGLISH;
		case german:
			return Locale.GERMAN;
		default:
			return Locale.ENGLISH;
		}
	}

	public static String getElytronTheme(DefaultTheme entry) {
		switch (entry) {
		case Standard:
			return "appui";
		case Default:
			return "default";
		case Medjugorje:
			return "blueprint";
		case Jugend2000:
			return "facebook";
		case Dark:
			return "dark";
		case Flat:
			return "flat";
		case FlatDark:
			return "flatdark";
		case Light:
			return "light";
		case Metro:
			return "metro";
		default:
			return "appui";
		}
	}

	public static String encodeToBase64(String token) {
		String converted;
		try {
			converted = Base64.getEncoder().encodeToString(token.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		return converted;
	}

	public static String decodeFromBase64(String token) {
		String decoded;
		try {
			byte[] asBytes = Base64.getDecoder().decode(token);
			decoded = new String(asBytes, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return decoded;
	}

}
