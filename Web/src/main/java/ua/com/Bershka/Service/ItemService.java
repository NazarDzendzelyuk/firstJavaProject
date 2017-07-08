package ua.com.Bershka.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.Bershka.Classes.Item;
import ua.com.Bershka.dto.filter.ItemFilter;
import ua.com.Bershka.dto.filter.SimpleFilter;

public interface ItemService {
	List<Item>findByUserAndStatus(String userName,int status);
	
	Item findByUserName(String userName);

	
	void save(Item item);
	Item findOne(int id);
	Page<Item> findAll(Pageable pageable, SimpleFilter filter);
	void delete(int id);
}