package ua.com.Bershka.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.dto.filter.SimpleFilter;

public interface ColorService {

	void save(Color color);
	 Color findOne(int id );
	 List<Color> findAll();
	 void delete(int id);
	Color findByColor(String color);
	List<Color>findByCommodityId(int id);
	
	Page<Color> findAll(SimpleFilter filter, Pageable pageable);


	
}
