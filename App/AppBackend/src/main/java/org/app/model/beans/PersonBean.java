package org.app.model.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.app.model.audit.RevInfo;
import org.app.model.dao.AddressDAO;
import org.app.model.dao.PersonDAO;
import org.app.model.entity.Address;
import org.app.model.entity.Person;
import org.app.model.entity.Person_AUD;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;

@Stateless
@Remote(PersonDAO.class)
//@DeclareRoles(value = { "System", "PowerUser", "Administrator", "Users"})
//@SecurityDomain(value="SecurityPilger")
public class PersonBean implements PersonDAO {

	@PersistenceContext
	private EntityManager em;

	@EJB
	AddressDAO addressDAO;

	@Override
//	@RolesAllowed(value = { "PowerUser" })
//	@PermitAll
	public Person create(Person person) {
		em.persist(person);
		em.flush();
		return person;
	}

	@Override
//	@RolesAllowed(value = { "PowerUser" })
//	@PermitAll
	public Person update(Person person) {

		try {
			return em.merge(person);
		} finally {
			em.flush();
		}

	}

	@Override
	public void remove(Integer id) {
		Person toBeDeleted = findByID(id);
		em.remove(toBeDeleted);
		em.flush();
	}

	@Override
	public Person findByID(Integer id) {
		return em.find(Person.class, id);
	}

	@Override
//	@PermitAll
	public List<Person> findAll() {
		return em.createNamedQuery(Person.QUERY_GET_ALL, Person.class).getResultList();
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public List<Person_AUD> findAudById(Integer personId) {
		List<Person_AUD> listAuditedPersons = new ArrayList<Person_AUD>();

		AuditReader auditReader = AuditReaderFactory.get(em);
		List<Object[]> revDatas = auditReader.createQuery().forRevisionsOfEntity(Person.class, false, false)
				.add(AuditEntity.id().eq(personId)).getResultList();

		for (Object[] revData : revDatas) {
			listAuditedPersons.add(
					new Person_AUD((Person) revData[0], (RevInfo) revData[1], (RevisionType) revData[2]));
		}
		return listAuditedPersons;

	}
	
	@Override
	public void addAddress(Address address, Person person) {
		address.setPerson(person);
		person.getAddresses().add(address);
		addressDAO.update(address);
	}

	@Override
	public List<Address> findAddresses(Person person) {
		return em.createNamedQuery(Address.QUERY_GET_BY_PERSONID, Address.class).setParameter("personID", person.getId()).getResultList();
	}

	public void removeAddress(Address toBeRemoved) {
//		System.out.println("====================");
//		System.out.println("Firstname of Person: " + toBeRemoved.getPerson().getFirstName());
//		System.out.println("ID of Address: " + toBeRemoved.getId());
//		System.out.println("Street of Address: " + toBeRemoved.getStreet());
//		System.out.println("====================");

		// toBeRemoved.setPerson(toBeRemoved.getPerson());
		// toBeRemoved.getPerson().getAddresses().remove(toBeRemoved);
		// addressDAO.remove(toBeRemoved.getId());

	}

	// public void removeAddress(Address toBeRemoved) {
	// Address merged = em.find(Address.class, toBeRemoved.getId());
	// toBeRemoved.setPerson(null);
	// em.remove(toBeRemoved);
	// em.flush();
	// toBeRemoved.getPerson();
	// em.remove(toBeRemoved);
	// person.getAddresses().remove(toBeRemoved);
	// addressDAO.update(toBeRemoved);
	// }
}
