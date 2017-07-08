package ua.com.Bershka.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.Dao.WearTypeDao;
import ua.com.Bershka.Service.FileWriter;
import ua.com.Bershka.Service.WearTypeService;
import ua.com.Bershka.Service.FileWriter.Folder;
import ua.com.Bershka.dto.filter.WearTypeFilter;
import ua.com.Bershka.dto.form.CommodityForm;
import ua.com.Bershka.dto.form.WearTypeForm;
import ua.com.Bershka.specification.WearTypeSpecification;
@Service
public class WearTypeServiceImplementation implements WearTypeService {
	@Autowired
	WearTypeDao wearTypeDao;
	
	@Autowired
	private FileWriter fileWriter;
	
	public void save(WearTypeForm form) {
		WearType entity=new WearType();
		entity.setId(form.getId());
		entity.setCategory(form.getCategory() );
		entity.setWearType(form.getWearType());
		wearTypeDao.save(entity);
		entity=wearTypeDao.saveAndFlush(entity);
		if(fileWriter.write(Folder.WEARTYPE, form.getFile(), entity.getId())){
			entity.setVersion(form.getVersion()+1);
			wearTypeDao.save(entity);
			
		}
		
	}

	public WearType findOne(int id) {
		return wearTypeDao.findOne(id);
	}

	public List<WearType> findAll() {
		return wearTypeDao.findAll();
	}

	public void delete(int id) {
		wearTypeDao.delete(id);
	}

	public WearType findByWearType(String wearType) {
		return wearTypeDao.findByWearType(wearType);
	}

	public List<WearType> findByCategoryId(int id) {
		return wearTypeDao.findByCategoryId(id);
	}

	public Page<WearType> findAll(Pageable pageable,WearTypeFilter filter) {
		return wearTypeDao.findAll(new WearTypeSpecification(filter),pageable) ;
	}

	@Override
	public WearType findUnique(String wearType, Category category) {
		return wearTypeDao.findUnique(wearType, category.getId());
	}

	public WearTypeForm findForm(int id) {
		WearType entity=findOne(id);
		WearTypeForm form=new WearTypeForm();
		form.setCategory(entity.getCategory());
		form.setWearType(entity.getWearType());
		form.setId(entity.getId());
		form.setVersion(entity.getVersion());
		return form;
	}
}
