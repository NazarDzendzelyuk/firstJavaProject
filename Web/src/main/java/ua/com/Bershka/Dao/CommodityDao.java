package ua.com.Bershka.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.Classes.WearType;


public interface CommodityDao extends JpaRepository<Commodity, Integer>,JpaSpecificationExecutor<Commodity> {

	Commodity findByCommodity(String commodity);
	Commodity findByPrice(int price);
	Commodity findBySize(int size);
	@Query("SELECT c FROM Commodity c WHERE c.color.id=?1")
	List<Commodity>findByColorId(int id);
	
	@Query("SELECT c FROM Commodity c WHERE c.wearType.id = ?1")
	List<Commodity> findByWearTypeId(int id);
	
	@Query("SELECT c FROM Commodity c WHERE c.category.id = ?1")
	List<Commodity> findByCategoryId(int id);
	
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.sex LEFT JOIN FETCH c.category LEFT JOIN FETCH c.material LEFT JOIN FETCH c.wearType LEFT JOIN FETCH c.color")
	List<Commodity> findAll();
	
	@Query("SELECT c FROM Commodity c LEFT JOIN FETCH c.sex LEFT JOIN FETCH c.category LEFT JOIN FETCH c.material LEFT JOIN FETCH c.wearType LEFT JOIN FETCH c.color WHERE c.id=?1")
	Commodity findOne(int id);
	
	@Query("SELECT c FROM Commodity c WHERE c.price=?1 and c.size=?2 and c.commodity=?3 and c.category.id=?4 and c.color.id=?5 and c.material.id=?6 and c.wearType.id=?7 and c.sex.id=?8")
	Commodity findUnique(int price,int size,String commodity,int categoryId,int colorId,int materialId,int wearTypeId,int sexId);

	@Query(value="SELECT c FROM Commodity c LEFT JOIN FETCH c.category LEFT JOIN FETCH c.color  LEFT JOIN FETCH c.material LEFT JOIN FETCH c.sex LEFT JOIN FETCH c.wearType",
			countQuery="SELECT count(c.id) FROM Commodity c")
	Page<Commodity> findAll(Pageable pageable);
}
