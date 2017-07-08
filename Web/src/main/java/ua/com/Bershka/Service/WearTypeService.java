package ua.com.Bershka.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.dto.filter.WearTypeFilter;
import ua.com.Bershka.dto.form.WearTypeForm;


public interface WearTypeService  {

	void save(WearTypeForm entity);
	WearType findOne(int id );
	 List<WearType> findAll();
	 void delete(int id);
	WearType findByWearType(String wearType);
	
	Page<WearType> findAll(Pageable pageable,WearTypeFilter filter);
	
	WearType findUnique(String wearType,Category category);

	List<WearType> findByCategoryId(int id);
	
	WearTypeForm findForm(int id);
}
