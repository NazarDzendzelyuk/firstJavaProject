package ua.com.Bershka.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.dto.filter.SimpleFilter;

public interface SexService {

	void save(Sex sex);
	Sex findOne(int id);
	List<Sex>findAll();
	void delete(int id);
	Sex findByName(String name);
	List<Sex> findByCategoryId(int id);

	List<Sex>findBySexId(int id);
	
	Page<Sex>findAll(Pageable pageable,SimpleFilter filter);

}
