package ua.com.Query.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Classes.Commodity;

public class ColorDaoOld {

	final EntityManager manager;

	public ColorDaoOld(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	public void save(Color color){
		manager.getTransaction().begin();
		manager.persist(color);
		manager.getTransaction().commit();
	}
	
	public List<Color>findAll(){
		
		List<Color>colors = manager.createQuery("from Color").getResultList();
		return colors;
	}
	
	public Color findOne(String color){
		
			Color colors= (Color) manager.createQuery("select a from Color a where a.color=:param").setParameter("param", color).getSingleResult();
			return colors;
		
	}
	
	public void delete(String color){
		manager.getTransaction().begin();
		manager.remove(findOne(color));
		manager.getTransaction().commit();
	}
	
	public void addColorToCommodity(String color, String commodity){
		manager.getTransaction().begin();
		
		Color colors = (Color) manager.
				createQuery("select a from Color a where a.color =:param").
				setParameter("param", color).
				getSingleResult();
		
		
		Commodity commodities = (Commodity) manager.
				createQuery("select b from Commodity b where b.commodity =:param").
				setParameter("param", commodity).
				getSingleResult();
		
		
		
		
		colors.getCommodities().add(commodities);
		
		manager.getTransaction().commit();
	}
	
	public void deleteColorFromCommodity(String color, String commodity){
		
		manager.getTransaction().begin();
		Color colors= (Color) manager.createQuery("select a from Color a where a.color=:color").setParameter("color", color).getSingleResult();
		
		Commodity commodities = (Commodity) manager.
				createQuery("select b from Commodity b where b.commodity =:commodity").
				setParameter("commodity", commodity).
				getSingleResult();
		
		colors.getCommodities().remove(commodities);
		
		manager.getTransaction().commit();
	}
	

	
	
}

