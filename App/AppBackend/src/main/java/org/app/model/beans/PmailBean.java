package org.app.model.beans;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.app.model.dao.PmailDAO;
import org.app.model.entity.Pmail;

@Stateless
@Remote(PmailDAO.class)
public class PmailBean implements PmailDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Pmail create(Pmail pmail) {
		em.persist(pmail);
		em.flush();
		return pmail;
	}

	@Override
	public Pmail update(Pmail pmail) {
		pmail = em.merge(pmail);
		em.flush();
		return pmail;
	}

	@Override
	public void remove(Integer id) {
		Pmail toBeDeleted = findByID(id);
		em.remove(toBeDeleted);
		em.flush();
	}

	@Override
	public Pmail findByID(Integer id) {
		return em.find(Pmail.class, id);
	}

	@Override
	public List<Pmail> findAll() {
		return em.createNamedQuery(Pmail.QUERY_GET_ALL, Pmail.class).getResultList();
	}

}
