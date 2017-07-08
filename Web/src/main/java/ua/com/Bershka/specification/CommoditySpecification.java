package ua.com.Bershka.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.dto.filter.CommodityFilter;
import ua.com.Bershka.util.ParamBuilder;

public class CommoditySpecification implements Specification<Commodity> {

	private final CommodityFilter filter;
	
	private final List<Predicate>predicates=new ArrayList<>();
	
	private final static Pattern REG = Pattern.compile("^[0-9]+$");

	public CommoditySpecification(CommodityFilter filter) {
		
		super();
		this.filter = filter;
		if(REG.matcher(filter.getMaxSize()).matches()){
			filter.setMaxSizeValue(new Integer(filter.getMaxSize()));
		}
		if(REG.matcher(filter.getMinSize()).matches()){
			filter.setMinSizeValue(new Integer(filter.getMinSize()));
		}
		if(REG.matcher(filter.getMaxPrice()).matches()){
			filter.setMaxPriceValue(new Integer(filter.getMaxPrice()));
		}
		if(REG.matcher(filter.getMinPrice()).matches()){
			filter.setMinPriceValue(new Integer(filter.getMinPrice()));;
		}
		
	}

	
	private void findByColorId(Root<Commodity>root,CriteriaQuery<?>query){
		if(!filter.getColorId().isEmpty()){
			predicates.add(root.get("color").in(filter.getColorId()));
		}
	}
	
	private void findByCategoryId(Root<Commodity>root,CriteriaQuery<?>query){
		if(!filter.getCategoryId().isEmpty()){
			predicates.add(root.get("category").in(filter.getCategoryId()));
		}
	}
	
	private void findByMaterialId(Root<Commodity>root,CriteriaQuery<?>query){
		if(!filter.getMaterialId().isEmpty()){
			predicates.add(root.get("material").in(filter.getMaterialId()));
		}
	}
	
	private void findBySexId(Root<Commodity>root,CriteriaQuery<?>query){
		if(!filter.getSexId().isEmpty()){
			predicates.add(root.get("sex").in(filter.getSexId()));
		}
	}

	
	private void findByWearTypeId(Root<Commodity>root,CriteriaQuery<?>query){
		if(!filter.getWearTypeId().isEmpty()){
			predicates.add(root.get("wearType").in(filter.getWearTypeId()));
		}
	}
	
	private void findBySize(Root<Commodity>root,CriteriaQuery<?>query,CriteriaBuilder cb){
		if(filter.getMinSizeValue()!=0){
			predicates.add(cb.ge(root.get("size"), filter.getMinSizeValue()));
		}
		if(filter.getMaxSizeValue()!=0){
			predicates.add(cb.le(root.get("size"), filter.getMaxSizeValue()));
		}
	}
	
	private void findByPrice(Root<Commodity>root,CriteriaQuery<?>query,CriteriaBuilder cb){
		if(filter.getMinPriceValue()!=0){
			predicates.add(cb.ge(root.get("price"), filter.getMinPriceValue()));
		}
		if(filter.getMaxPriceValue()!=0){
			predicates.add(cb.le(root.get("price"), filter.getMaxPriceValue()));
		}
	}
	
	private void fetch(Root<Commodity> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("color");
			root.fetch("category");
			root.fetch("material");
			root.fetch("sex");
			root.fetch("wearType");
			
		}
	}
	@Override
	public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> query,CriteriaBuilder cb) {
		fetch(root, query);
		findByCategoryId(root, query);
		findByColorId(root, query);
		findByMaterialId(root, query);
		findByPrice(root, query, cb);
		findBySexId(root, query);
		findBySize(root, query, cb);
		findByWearTypeId(root, query);
		if(predicates.isEmpty())return null;
		Predicate array[]=new Predicate[predicates.size()];
		array=predicates.toArray(array);
		return cb.and(array) ;
	}

}
