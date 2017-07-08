package ua.com.Bershka.Editor;

import java.beans.PropertyEditorSupport;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Service.CategoryService;

public class CategoryEditor extends PropertyEditorSupport {

	private CategoryService categorySevice;

	public CategoryEditor(CategoryService categorySevice) {
		this.categorySevice = categorySevice;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Category category=categorySevice.findOne(Integer.valueOf(text));
		setValue(category);
	}
	
	
	
}
