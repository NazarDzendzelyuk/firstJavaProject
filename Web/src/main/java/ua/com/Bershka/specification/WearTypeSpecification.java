package ua.com.Bershka.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.dto.filter.WearTypeFilter;

public class WearTypeSpecification implements Specification<WearType> {
	
	private WearTypeFilter filter;

	private List<Predicate>predicates=new ArrayList<>();

	public WearTypeSpecification(WearTypeFilter filter) {
		super();
		this.filter = filter;
	}
	
	private void findByCategoryId(Root<WearType>root,CriteriaQuery<?>query){
		if(!filter.getCategoryId().isEmpty()){
			predicates.add(root.get("category").in(filter.getCategoryId()));
		}
	}
	
	private void fetch (Root<WearType>root,CriteriaQuery<?>query){
		if(!query.getResultType().equals(Long.class)){
			root.fetch("category");
		}
		
	}

	@Override
	public Predicate toPredicate(Root<WearType> root, CriteriaQuery<?> query,CriteriaBuilder cb) {
		fetch(root,query);
		findByCategoryId(root, query);
		if(predicates.isEmpty())return null;
		Predicate array[]=new Predicate[predicates.size()];
		array=predicates.toArray(array);
		return cb.and(array);
	}
	
}
