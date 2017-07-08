package ua.com.Bershka.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.Classes.Material;

public interface MaterialDao extends JpaRepository<Material, Integer>,JpaSpecificationExecutor<Material>{
	
		
	@Query("SELECT m FROM Material m join m.commodities c WHERE c.id=?1")
	List<Material>findByMaterialId(int id);

	Material findByMaterial(String material);
	
}
