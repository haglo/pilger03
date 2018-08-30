package org.app.controler;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

import org.app.model.dao.EmailDAO;
import org.app.model.dao.PersonDAO;
import org.app.model.entity.Address;
import org.app.model.entity.Person;

/*
 * Managed Bean
 * MVC: Controler-Part
 * Repräsentiert den kpmpletten Lebenszyklus eines Personendatensatz &
 * Bietet zusätzliche Funktionalität für diesen Personendatensatz an
 */
@RequestScoped
public class EmailService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private EmailDAO emailDAO;
	
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

	
	public EmailDAO getEmailDAO() {
		return emailDAO;
	}

}
