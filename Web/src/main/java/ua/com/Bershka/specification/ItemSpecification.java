package ua.com.Bershka.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.Bershka.Classes.Item;
import ua.com.Bershka.dto.filter.ItemFilter;

public class ItemSpecification implements Specification<Item> {
	

	private ItemFilter filter;
	
	private List<Predicate>predicates=new ArrayList<>();
	
	public ItemSpecification(ItemFilter filter) {
		super();
		this.filter = filter;
	}

	private void findByUserName(Root<Item>root,CriteriaQuery<?>query){
		
		if(!filter.getUserName().isEmpty()){
			predicates.add(root.get("userName").in(filter.getUserName()));
		}
	}

	@Override
	public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		findByUserName(root, query);
		if(predicates.isEmpty())return null;
		Predicate array[]=new Predicate[predicates.size()];
		array=predicates.toArray(array);
		return cb.and(array);
	}

	
}
