package ua.com.Bershka.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Bershka.Classes.Material;
import ua.com.Bershka.Service.MaterialService;

public class MaterialValidator implements Validator {
	private final MaterialService materialService;
	
	public MaterialValidator(MaterialService materialService) {
		super();
		this.materialService = materialService;
	}

	public boolean supports(Class<?> clazz) {
		return Material.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Material material=(Material)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "material", "", "Can't be empty");
		if(materialService.findByMaterial(material.getMaterial())!=null ){
			errors.rejectValue("material", "", "Already exist");
			
			
		}
		
	}

}
