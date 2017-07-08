package ua.com.Bershka.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.Dao.SexDao;
import ua.com.Bershka.Service.SexService;
import ua.com.Bershka.dto.filter.SimpleFilter;
@Service
public class SexServiceImpl implements SexService {
	@Autowired
	private SexDao sexDao;
	
	public void save(Sex sex) {
		sexDao.save(sex);
	}

	public Sex findOne(int id) {
		return sexDao.findOne(id);
	}

	public List<Sex> findAll() {
		return sexDao.findAll();
	}

	public void delete(int id) {
		sexDao.delete(id);
	}

	public Sex findByName(String name) {
		return sexDao.findByName(name);
	}

	public List<Sex> findByCategoryId(int id) {
		return sexDao.findByCategoryId(id);
	}

	public List<Sex> findBySexId(int id) {
		return sexDao.findBySexId(id);
	}

	@Override
	public Page<Sex> findAll(Pageable pageable, SimpleFilter filter) {
		return sexDao.findAll(findByNameLike(filter),pageable);
	}

	private Specification<Sex> findByNameLike(SimpleFilter filter){
		return (root, query, cb)-> {
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
		};
	}

	

}
