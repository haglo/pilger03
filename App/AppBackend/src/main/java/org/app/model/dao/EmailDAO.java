package org.app.model.dao;

import java.util.List;
import org.app.model.entity.Email;

public interface EmailDAO {

	public Email create(Email email);

	public Email update(Email email);

	public void remove(Integer id);

	public Email findByID(Integer id);
	
	public List<Email> findAll();


}