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

	private String from;
	
	private String subject;
	
	private String content;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
