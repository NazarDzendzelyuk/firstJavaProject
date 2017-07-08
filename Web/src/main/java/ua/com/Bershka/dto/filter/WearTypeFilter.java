package ua.com.Bershka.dto.filter;

import java.util.LinkedList;
import java.util.List;

public class WearTypeFilter {

	private List<Integer>categoryId=new LinkedList<>();
	

	public List<Integer> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(List<Integer> categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
