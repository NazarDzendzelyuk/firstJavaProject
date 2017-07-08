package ua.com.Bershka.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.Dao.MaterialDao;
import ua.com.Bershka.Service.MaterialService;
import ua.com.Bershka.dto.filter.SimpleFilter;

@Service
public class MaterialServiceImplementation implements MaterialService {

	@Autowired
	MaterialDao materialDao;

	public void save(Material material) {
		materialDao.save(material);
	}

	public Material findOne(int id) {
		return materialDao.findOne(id);
	}

	public List<Material> findAll() {
		return materialDao.findAll();
	}

	public void delete(int id) {
		materialDao.delete(id);
	}

	public Material findByMaterial(String material) {
		return materialDao.findByMaterial(material);
	}

	@Override
	public Page<Material> findAll(SimpleFilter filter, Pageable pageable) {
		return materialDao.findAll(findByNameLike(filter), pageable);
	}

	private Specification<Material> findByNameLike(SimpleFilter filter) {
		return (root, query, cb) -> {
			if (filter.getSearch().isEmpty())
				return null;
			return cb.like(cb.lower(root.get("material")), filter.getSearch().toLowerCase() + "%");
		};
	}

	@Override
	public List<Material> findByMaterialId(int id) {
		return materialDao.findByMaterialId(id);
	}

}
