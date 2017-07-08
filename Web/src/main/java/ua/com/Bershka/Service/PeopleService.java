package ua.com.Bershka.Service;

import java.util.List;

import ua.com.Bershka.Classes.People;

public interface PeopleService {

	List<People> findAll();
	
	People findOne(int id);
	
	People save(People people);
	
	void delete(int id);
}
