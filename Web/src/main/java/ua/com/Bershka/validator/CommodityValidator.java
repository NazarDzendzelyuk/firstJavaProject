package ua.com.Bershka.validator;



import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.Service.CommodityService;
import ua.com.Bershka.dto.form.CommodityForm;

public class CommodityValidator implements Validator {
	
	private final static Pattern REG = Pattern.compile("^[0-9]+$");

	
	private final CommodityService commodityService;
	
	public CommodityValidator(CommodityService commodityService) {
		super();
		this.commodityService = commodityService;
	}

	public boolean supports(Class<?> clazz) {
		return CommodityForm.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		CommodityForm form=(CommodityForm)target;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "Can't be empty");
		if(!REG.matcher(form.getPrice()).matches()){
			errors.rejectValue("price","", "Enter number");
		}
		if(!REG.matcher(form.getSize()).matches()){
			errors.rejectValue("size", "", "Enter number");
			
		}
		if(errors.getFieldError("price")==null || errors.getFieldError("size")==null){
			if(commodityService.findUnique(form.getPrice(), form.getSize(), form.getCommodity(), form.getCategory(), form.getColor(), form.getMaterial(), form.getWearType(), form.getSex())!=null){
				errors.rejectValue("commodity", "", "Already exist");
				


			}
		}
	}

}
