package ua.com.Bershka.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Bershka.Classes.Sex;
import ua.com.Bershka.Service.SexService;

public class SexValidator implements Validator {
	
	private final SexService sexService;
	

	public SexValidator(SexService sexService) {
		super();
		this.sexService = sexService;
	}

	public boolean supports(Class<?> clazz) {
		return Sex.class.equals(clazz);
		
	}

	public void validate(Object target, Errors errors) {
		Sex sex=(Sex)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","", "Can't be empty");
		if(sexService.findByName(sex.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
