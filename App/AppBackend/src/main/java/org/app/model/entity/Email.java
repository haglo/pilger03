package org.app.model.entity;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@SuppressWarnings("all")
@NamedQuery(name = Email.QUERY_GET_ALL, query = "SELECT c FROM Email c")
public class Email extends Superclass implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String QUERY_GET_ALL = "Email.GetAll";

	@NotNull
	private String euuid;

	@NotNull
	private String epuuid;

	private Timestamp createTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMAIL_FOLDER_ID")
	private EmailFolder emailFolder;

	@NotNull
	private String header;

	@NotNull
	private String body;

	@NotNull
	private String email;

	public String getEuuid() {
		return euuid;
	}

	public void setEuuid(String euuid) {
		this.euuid = euuid;
	}

	public String getEpuuid() {
		return epuuid;
	}

	public void setEpuuid(String epuuid) {
		this.epuuid = epuuid;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateAT(Timestamp createTime) {
		this.createTime = createTime;
	}

	public EmailFolder getEmailFolder() {
		return emailFolder;
	}

	public void setEmailFolder(EmailFolder emailFolder) {
		this.emailFolder = emailFolder;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
