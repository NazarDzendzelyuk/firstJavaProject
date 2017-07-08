package ua.com.Bershka.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.dto.filter.SimpleFilter;

public interface MaterialService {

	void save(Material material);
	Material findOne(int id);
	List<Material>findAll();
	void delete (int id);
	
	List<Material>findByMaterialId(int id);


	Page<Material>findAll(SimpleFilter filter,Pageable pageable);
	
	Material findByMaterial(String material);
}
