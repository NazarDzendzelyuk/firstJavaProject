package ua.com.Bershka.ServiceImplementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.property.access.spi.Getter;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Dao.CategoryDao;
import ua.com.Bershka.Service.CategoryService;
import ua.com.Bershka.dto.filter.SimpleFilter;
@Service
public class CategoryServiceImplementation implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
		
	public void save(Category category) {
		categoryDao.save(category);
	}

	
	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	
	public List<Category> findAll() {
		return categoryDao.findAll();
		
	}
	
	public void delete(int id) {
		categoryDao.delete(id);
	}

	
	public Category findByCategory(String category) {
		return categoryDao.findByCategory(category);
	}


	public List<Category> findBySexId(int id) {
		return categoryDao.findBySexId(id);
	}


	@Override
	public Page<Category> findAll(Pageable pageable) {
		
		return categoryDao.findAll(pageable);
	}
//	
//	private Specification<Category> findByNameLike(SimpleFilter filter){
//		return (root, query, cb)-> {
//			if(filter.getSearch().isEmpty())return null;
//			return cb.like(cb.lower(root.get("category")), filter.getSearch().toLowerCase()+"%");
//		};
//	}


	
}



