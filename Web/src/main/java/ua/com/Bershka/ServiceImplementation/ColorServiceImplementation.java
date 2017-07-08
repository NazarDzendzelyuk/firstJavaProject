package ua.com.Bershka.ServiceImplementation;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Dao.ColorDao;
import ua.com.Bershka.Dao.CommodityDao;
import ua.com.Bershka.Service.ColorService;
import ua.com.Bershka.dto.filter.SimpleFilter;
@Service
public class ColorServiceImplementation implements ColorService {

	@Autowired
	private ColorDao ColorDao;
	@Autowired
	private CommodityDao commodityDao;

	public void save(Color color) {
		ColorDao.save(color);
	}

	
	public Color findOne(int id) {
		return ColorDao.findOne(id);
	}

	
	public List<Color> findAll() {
		return ColorDao.findAll();
	}

	
	public void delete(int id) {
		commodityDao.save(commodityDao.findByColorId(id).stream().peek(e->e.setColor(null)).collect(Collectors.toList()));
		ColorDao.delete(id);
	}

	
	public Color findByColor(String color) {
		return ColorDao.findByColor(color);
	}

	
	public Color fetchColorWithCommodity(String color) {
		return null;
	}


	public List<Color> findByCommodityId(int id) {
		return ColorDao.findByCommodityId(id);
	}


	public Page<Color> findAll(SimpleFilter filter, Pageable pageable) {
		return ColorDao.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Color> findByNameLike(SimpleFilter filter){
		return (root, query, cb)-> {
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("color")), filter.getSearch().toLowerCase()+"%");
		};
	}
}
