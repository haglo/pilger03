package org.app.controler;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.app.model.audit.ElytronUserSessionScoped;
import org.app.model.entity.Account;
import org.app.model.entity.ElytronRole;
import org.app.model.entity.ElytronUser;

/*
 * Managed Bean
 * In MVC the Controler-Part
 */
@SessionScoped
public class SessionService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	SettingsService settingsService;

	@Inject
	ElytronUserSessionScoped elytronUserSessionScoped;

	private ElytronUser elytronUser = new ElytronUser();
	private ElytronRole elytronRole = new ElytronRole();
	private Locale currentLocale;
	private String currentTheme;

	public ElytronUser getElytronUser() {
		return elytronUser;
	}
	
	public ElytronRole getElytronRole() {
		return elytronRole;
	}

	public void setCurrentUser(ElytronUser user) {
		this.elytronUser = user;
		this.elytronRole = this.elytronUser.getElytronRole();
		elytronUserSessionScoped.setElytronUser(elytronUser);
	}

	public Locale getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}

	public String getCurrentTheme() {
		return currentTheme;
	}

	public void setCurrentTheme(String currentTheme) {
		this.currentTheme = currentTheme;
	}

}
