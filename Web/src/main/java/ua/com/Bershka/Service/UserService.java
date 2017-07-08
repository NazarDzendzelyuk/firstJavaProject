package ua.com.Bershka.Service;


import ua.com.Bershka.Classes.User;

public interface UserService {

	void save (User user);
//	User findUnique(String password,String email);
	User findByEmail(String email);

	User findByPassword(String password);
	void sendMail(String content, String email, String mailBody);
}
