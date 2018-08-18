package org.app.model.dao;

import java.util.List;

import org.app.model.entity.Address;
import org.app.model.entity.Communication;
import org.app.model.entity.Person;
import org.app.model.entity.Person_AUD;

public interface PersonDAO {

	public Person create(Person person);

	public Person update(Person person);

	public void remove(Integer id);

	public Person findByID(Integer id);

	public List<Person> findAll();

	public List<Person_AUD> findAudById(Integer personId);
	
	public void addAddress(Address address, Person person);

	public List<Address> findAddresses(Person person);

	public void removeAddress(Address toBeRemoved);
	
	public void addCommunication(Communication address, Person person);

	public List<Communication> findCommunications(Person person);

	public void removeCommunication(Communication toBeRemoved);

}