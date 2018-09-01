package org.app.model.dao;

import java.util.List;
import org.app.model.entity.Pmail;

public interface PmailDAO {

	public Pmail create(Pmail pmail);

	public Pmail update(Pmail pmail);

	public void remove(Integer id);

	public Pmail findByID(Integer id);
	
	public List<Pmail> findAll();


}