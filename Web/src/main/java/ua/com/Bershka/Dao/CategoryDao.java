package ua.com.Bershka.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.Bershka.Classes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>,JpaSpecificationExecutor<Category> {

	Category findByCategory(String category);
	Category findBySex(String name);

	@Query("SELECT c FROM Category c WHERE c.sex.id = ?1")
	List<Category> findBySexId(int id);
	
	@Query("SELECT c FROM Category c LEFT JOIN FETCH c.sex")
	List<Category> findAll();
	@Query("SELECT c FROM Category c LEFT JOIN FETCH c.sex WHERE c.id=?1")
	Category findOne(int id);
	
	
}
