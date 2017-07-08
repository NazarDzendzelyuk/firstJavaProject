package ua.com.Bershka.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.Bershka.Classes.User;
import ua.com.Bershka.Service.UserService;

public class UserValidator implements Validator {

	private UserService userService;

	private final static Pattern REG = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	public UserValidator(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","", "Can't be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address","", "Can't be empty");

		if (!REG.matcher(user.getEmail()).matches()) {
			errors.rejectValue("email", "", "Invalid format");
		}

		if(userService.findByEmail(user.getEmail())!=null){
			errors.rejectValue("email", "", "Already exist");
		}
	}
}
