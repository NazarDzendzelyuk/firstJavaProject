package ua.com.Bershka.ServiceImplementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.Bershka.Classes.People;
import ua.com.Bershka.Dao.PeopleDao;
import ua.com.Bershka.Service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private PeopleDao  peopleDao;
	
	@Override
	public List<People> findAll() {
		return peopleDao.findAll();
	}

	@Override
	public People findOne(int id) {
		return peopleDao.findOne(id);
	}

	@Override
	public People save(People people) {
		return peopleDao.saveAndFlush(people);
	}

	@Override
	public void delete(int id) {
		peopleDao.delete(id);
	}

}
