package ua.com.Bershka.ServiceImplementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.com.Bershka.Classes.Item;
import ua.com.Bershka.Dao.ItemDao;
import ua.com.Bershka.Service.ItemService;
import ua.com.Bershka.dto.filter.SimpleFilter;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;
	
	@Override
	public void save(Item item) {
		itemDao.save(item);		
	}

	@Override
	public Item findOne(int id) {
		return itemDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		itemDao.delete(id);
	}

	@Override
	public List<Item> findByUserAndStatus(String userName,int status) {
		return itemDao.findByUserAndStatus(userName,status);
	}

	public Page<Item> findAll(Pageable pageable,SimpleFilter filter) {
		return itemDao.findAll(findByNameLike(filter),pageable);
	}

	@Override
	public Item findByUserName(String userName) {
		return itemDao.findByUserName(userName);
	}

	private Specification<Item> findByNameLike(SimpleFilter filter){
		return (root, query, cb)-> {
			if(filter.getSearch().isEmpty())return null;
			return cb.like(cb.lower(root.get("itemName")), filter.getSearch().toLowerCase()+"%");
		};
	}
}
