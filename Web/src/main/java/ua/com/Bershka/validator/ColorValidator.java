package ua.com.Bershka.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Bershka.Classes.Color;
import ua.com.Bershka.Service.ColorService;

public class ColorValidator implements Validator {

	private final ColorService colorService;

	public ColorValidator(ColorService colorService) {
		super();
		this.colorService = colorService;
	}

	public boolean supports(Class<?> clazz) {
		return Color.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Color color = (Color) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "color", "","Can't be empty");
		if(colorService.findByColor(color.getColor())!=null){
			errors.rejectValue("color", "", "Already exist");
		}
	}
}
