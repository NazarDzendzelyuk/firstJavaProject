package ua.com.Bershka.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.Classes.Sex;

public interface SexDao extends JpaRepository<Sex, Integer>,JpaSpecificationExecutor<Sex> {

	Sex findByName(String name);
	
	@Query("SELECT c FROM Category c WHERE c.sex.id = ?1")
	List<Sex> findByCategoryId(int id);
	
	@Query("SELECT s FROM Sex s join s.commodities c WHERE c.id=?1")
	List<Sex>findBySexId(int id);
}
