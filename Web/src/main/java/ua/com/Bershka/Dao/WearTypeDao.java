package ua.com.Bershka.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.Bershka.Classes.WearType;

public interface WearTypeDao extends JpaRepository<WearType, Integer>,JpaSpecificationExecutor<WearType>{

	WearType findByWearType(String wearType);
	
	@Query("SELECT w FROM WearType w WHERE w.category.id = ?1")
	List<WearType> findByCategoryId(int id);
	
	@Query("SELECT w FROM WearType w LEFT JOIN FETCH w.category")
	List<WearType> findAll();
	@Query("SELECT w FROM WearType w LEFT JOIN FETCH w.category WHERE w.id=?1")
	WearType findOne(int id);
	@Query("SELECT w FROM WearType w WHERE w.wearType=?1 and w.category.id=?2 ")
	WearType findUnique(String wearType,int categoryId);
	@Query(value="SELECT w FROM WearType w LEFT JOIN FETCH w.category",
			countQuery="SELECT count(w.id) FROM WearType w")
	Page<WearType> findAll(Pageable pageable);
}
