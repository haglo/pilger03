package org.app.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@SuppressWarnings("all")
@NamedQueries({ @NamedQuery(name = EmailFolder.QUERY_FIND_ALL, query = "SELECT c FROM EmailFolder c"),
		@NamedQuery(name = EmailFolder.QUERY_FIND_BY_FOLDER, query = "SELECT c FROM EmailFolder c WHERE c.emailFolder =  :emailFolder") })
public class EmailFolder extends Superclass implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String QUERY_FIND_ALL = "EmailFolder.FindAll";
	public static final String QUERY_FIND_BY_FOLDER = "EmailFolder.FindByFolder";

	@Column(unique = true)
	private String emailFolder;

	public String getEmailFolder() {
		return emailFolder;
	}

	public void setEmailFolder(String emailFolder) {
		this.emailFolder = emailFolder;
	}

}
