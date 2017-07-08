package ua.com.Bershka.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.Bershka.Classes.Commodity;
import ua.com.Bershka.Classes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	User findByPhoneNumber(String phoneNumber);

	
	User findByPassword(String password);

//	@Query("SELECT u FROM User u WHERE u.email=?1 and u.password=?2")
//	User findUnique(String email,String password);
	
	
}
