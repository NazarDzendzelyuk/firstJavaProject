package ua.com.Bershka.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.dto.filter.CommodityFilter;
import ua.com.Bershka.dto.form.CommodityForm;

public interface CommodityService {

	void save (CommodityForm form);
	Commodity findOne(int id);
	List<Commodity>findAll();
	void delete(int id);
	
	List<Commodity>findByColorId(int id);
	List<Commodity> findByWearTypeId(int id);
	List<Commodity> findByCategoryId(int id);

	Commodity findByCommodity(String commodity);
	Commodity findByPrice(int price);
	Commodity findUnique(String price,String size,String commodity,Category category,Color color,Material material,WearType wearType,Sex sex);
	CommodityForm findForm(int id);
	
	Page<Commodity> findAll(Pageable pageable,CommodityFilter filter);

	


}
