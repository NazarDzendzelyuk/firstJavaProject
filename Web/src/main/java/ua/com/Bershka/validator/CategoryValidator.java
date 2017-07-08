package ua.com.Bershka.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Bershka.Classes.Category;
import ua.com.Bershka.Service.CategoryService;

public class CategoryValidator implements Validator {
	
	private final CategoryService categoryService;
	
	public CategoryValidator(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	public boolean supports(Class<?> clazz) {
		return Category.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Category category=(Category)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category","", "Can't be empty");
		if(categoryService.findByCategory(category.getCategory())!=null ){
			errors.rejectValue("category", "", "Already exist");
		}
	}
}
