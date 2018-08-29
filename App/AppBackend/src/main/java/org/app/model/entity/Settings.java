package org.app.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Settings.QUERY_FIND_ALL, query = "SELECT c FROM Settings c") })
public class Settings extends Superclass implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String QUERY_FIND_ALL = "Settings.FindAll";

	private String defaultWindowWidth;

	public String getDefaultWindowWidth() {
		return defaultWindowWidth;
	}

	public void setDefaultWindowWidth(String defaultWindowWidth) {
		this.defaultWindowWidth = defaultWindowWidth;
	}

}
