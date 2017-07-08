package ua.com.Bershka.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.Bershka.Classes.Item;

public interface ItemDao extends JpaRepository<Item, Integer>,JpaSpecificationExecutor<Item>{
	@Query("Select i from Item i where i.userName=?1 and i.status=?2")
	List<Item>findByUserAndStatus(String userName,int status);
	
	Page<Item>findAll(Pageable pageable);
	
	Item findByUserName(String userName);
}
