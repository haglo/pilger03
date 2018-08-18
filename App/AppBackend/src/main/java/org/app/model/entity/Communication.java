package org.app.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = Communication.QUERY_GET_ALL, query = "SELECT c FROM Communication c")
public class Communication extends Superclass implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String QUERY_GET_ALL = "Communication.GetAll";

	@NotNull
	private String communication;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMMUNICATIONTYPE_ID")
	private CommunicationType communicationType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KIND_ID")
	private Kind kind;

	@ManyToOne
	private Person person;

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

}
