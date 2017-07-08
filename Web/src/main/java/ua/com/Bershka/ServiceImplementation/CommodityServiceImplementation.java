package ua.com.Bershka.ServiceImplementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.Dao.CommodityDao;
import ua.com.Bershka.Service.CommodityService;
import ua.com.Bershka.Service.FileWriter;
import ua.com.Bershka.Service.FileWriter.Folder;
import ua.com.Bershka.dto.filter.CommodityFilter;
import ua.com.Bershka.dto.form.CommodityForm;
import ua.com.Bershka.specification.CommoditySpecification;
@Service
public class CommodityServiceImplementation implements CommodityService {

	@Autowired
	CommodityDao commodityDao;
	
	@Autowired
	private FileWriter fileWriter;
	
	public void save(CommodityForm form) {
			Commodity entity=new Commodity();
			entity.setPrice(new Integer(form.getPrice()));
			entity.setSize(new Integer(form.getSize()));
			entity.setId(form.getId());
			entity.setCategory(form.getCategory());
			entity.setColor(form.getColor());
			entity.setCommodity(form.getCommodity());
			entity.setMaterial(form.getMaterial());
			entity.setSex(form.getSex());
			entity.setWearType(form.getWearType());
			commodityDao.save(entity);
			entity=commodityDao.saveAndFlush(entity);		
			if(fileWriter.write(Folder.COMMODITY, form.getFile(), entity.getId())){
				entity.setVersion(form.getVersion()+1);
				commodityDao.save(entity);
				
			}
		}
	
	public Commodity findOne(int id) {
		return commodityDao.findOne(id);
	}

	
	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	
	public void delete(int id) {
	
		commodityDao.delete(id);
	}

	
	public Commodity findByCommodity(String commodity) {
		return commodityDao.findByCommodity(commodity);
	}

	
	public Commodity findByPrice(int price) {
		return commodityDao.findByPrice(price);
	}

	public List<Commodity> findByColorId(int id) {
		return commodityDao.findByColorId(id);
	}
	
	
	public List<Commodity> findByWearTypeId(int id) {
		return commodityDao.findByWearTypeId(id);
	}



	public CommodityForm findForm(int id) {
		Commodity entity=findOne(id);
		CommodityForm form=new CommodityForm();
		form.setPrice(String.valueOf(entity.getPrice()));
		form.setSize(String.valueOf(entity.getSize()));
		form.setId(entity.getId());
		form.setCategory(entity.getCategory());
		form.setColor(entity.getColor());
		form.setCommodity(entity.getCommodity());
		form.setMaterial(entity.getMaterial());
		form.setSex(entity.getSex());
		form.setWearType(entity.getWearType());
		form.setVersion(entity.getVersion());
		return form;
	}


	public Commodity findUnique(String price, String size, String commodity,
			Category category, Color color, Material material,
			WearType wearType, Sex sex) {
		return commodityDao.findUnique(new Integer(price), new Integer(size), commodity, category.getId(), color.getId(), material.getId(), wearType.getId(), sex.getId());
	}

	@Override
	public Page<Commodity> findAll(Pageable pageable, CommodityFilter filter) {
		return commodityDao.findAll(new CommoditySpecification(filter),pageable);
	}

	@Override
	public List<Commodity> findByCategoryId(int id) {
		return commodityDao.findByCategoryId(id);
	}


}
