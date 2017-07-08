package ua.com.Bershka.ServiceImplementation;


import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.com.Bershka.Classes.Role;
import ua.com.Bershka.Classes.User;
import ua.com.Bershka.Dao.UserDao;
import ua.com.Bershka.Service.UserService;

@Service("userDetailsService")
public class UserServiceImplementation implements UserService,UserDetailsService {
	
	@Autowired
	UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		userDao.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User findByPassword(String password) {
		return userDao.findByPassword(password);
	}

	@Override
	public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException {
		return userDao.findByEmail(email);
	}
	@PostConstruct
	public void addAdmin(){
		User user=userDao.findByEmail("admin");
		if(user==null){
			user=new User();
			user.setPassword(encoder.encode("admin"));
			user.setEmail("admin");
			user.setRole(Role.ROLE_ADMIN);
			userDao.save(user);
		}
	}

	@Override
	public void sendMail(String content, String email, String mailBody) {
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties,
		new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("mandarunn@gmail.","biba1996");
		}
		});
		try {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("mandarunn@gmail.com"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
		email));
		message.setSubject(content, "UTF-8");
		message.setText(mailBody);
		Transport.send(message);
		} catch (MessagingException е) {
		е.printStackTrace();
		}
	}

}
