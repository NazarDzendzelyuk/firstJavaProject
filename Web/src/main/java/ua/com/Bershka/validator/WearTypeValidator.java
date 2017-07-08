package ua.com.Bershka.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Bershka.Classes.WearType;
import ua.com.Bershka.Service.WearTypeService;
import ua.com.Bershka.dto.form.WearTypeForm;

public class WearTypeValidator implements Validator {

	private final WearTypeService wearTypeService;
	
	public WearTypeValidator(WearTypeService wearTypeService) {
		super();
		this.wearTypeService = wearTypeService;
	}

	public boolean supports(Class<?> clazz) {
		return WearTypeForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		WearTypeForm form=(WearTypeForm)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "wearType", "", "Can't be empty");
		
		if(wearTypeService.findUnique(form.getWearType(), form.getCategory())!=null){
			errors.rejectValue("wearType", "", "Already exist");
			


		}
	}

}
