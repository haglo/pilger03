package org.app.controler;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import org.app.model.dao.SettingsDAO;
import org.app.model.entity.Settings;

/*
 * Managed Bean
 * In MVC the Controler-Part
 */
@RequestScoped
public class SettingsService implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private SettingsDAO settingsDAO;
	
	private boolean isEditing = false;

	public boolean getEditing() {
		return isEditing;
	}

	public void setEditing(boolean isEditing) {
		this.isEditing = isEditing;
	}

	public void toggleEditing() {
		this.isEditing = !this.isEditing;
	}

	public SettingsDAO getSettingsDAO() {
		return settingsDAO;
	}

	public String getAppWindowWidth() {
		Settings mySettings = new Settings();
		List<Settings> settings = settingsDAO.findAll();
		for (Settings entry : settings) {
			mySettings = entry;
		}
		return mySettings.getDefaultWindowWidth();
	}

	public String getUploadPath() {
		return "C:/dev/upload";
	}

}
