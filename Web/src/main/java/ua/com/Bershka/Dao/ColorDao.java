package ua.com.Bershka.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Commodity;

public interface ColorDao extends JpaRepository<Color, Integer>,JpaSpecificationExecutor<Color>{

	Color findByColor(String color);
	
	@Query("SELECT c FROM Color c join c.commodities m WHERE m.id=?1")
	List<Color>findByCommodityId(int id);
	
	
	
//	@Query("select c from Color c left join fetch c.commodity where c.color=:param")	
//	Color fetchColorWithCommodity(@Param("param") String color);

}
