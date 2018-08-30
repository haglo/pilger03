package org.app.model.beans;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.app.model.dao.EmailDAO;
import org.app.model.entity.Email;

@Stateless
@Remote(EmailDAO.class)
public class EmailBean implements EmailDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Email create(Email email) {
		em.persist(email);
		em.flush();
		return email;
	}

	@Override
	public Email update(Email email) {
		email = em.merge(email);
		em.flush();
		return email;
	}

	@Override
	public void remove(Integer id) {
		Email toBeDeleted = findByID(id);
		em.remove(toBeDeleted);
		em.flush();
	}

	@Override
	public Email findByID(Integer id) {
		return em.find(Email.class, id);
	}

	@Override
	public List<Email> findAll() {
		return em.createNamedQuery(Email.QUERY_GET_ALL, Email.class).getResultList();
	}

}
