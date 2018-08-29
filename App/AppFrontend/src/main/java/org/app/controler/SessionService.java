package org.app.controler;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/*
 * Managed Bean
 * In MVC the Controler-Part
 */
@SessionScoped
public class SessionService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	SettingsService settingsService;
	
}
