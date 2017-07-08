package ua.com.Bershka.Service;

import java.util.List;







import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.dto.filter.SimpleFilter;

public interface CategoryService  {

	void save(Category category);
	Category findOne(int id );
	 List<Category> findAll();
	 void delete(int id);
	Category findByCategory(String category);
	
	List<Category> findBySexId(int id);

	Page<Category>findAll(Pageable pageable);	

}
