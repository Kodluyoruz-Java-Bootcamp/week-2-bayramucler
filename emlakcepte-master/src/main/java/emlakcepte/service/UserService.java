package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.UserDao;
import emlakcepte.model.User;


public class UserService implements EmlakCepteService {
		
	private UserDao userDao = new UserDao();

	
	// Singleton Pattern	
	private static UserService userServiceInstance;
	
	private UserService() {
		
	}
	
	public static UserService getInstance() {
		if(userServiceInstance==null)
			userServiceInstance = new UserService();
		return userServiceInstance;
	}

	@Override
	public void printAdress(){
		System.out.println("UserService adress: " + userServiceInstance.hashCode());
	}

	public void createUser(User user) {
		System.out.println("ben bir userDao objesiyim:" + userDao.toString());
		
		if (user.getPassword().length() < 5) {
			System.out.println("Şifre en az 5 karakterli olmalı");
		}			
		userDao.createUser(user);		
	}
	
	public List<User> getAllUser() {
		//UserDao userDao = new UserDao();		
		return userDao.findAllUsers();
	}
	
	public void printAllUser() {
		
		getAllUser().forEach(user -> System.out.println(user.getName()));
		
	}
	
	public void updatePassword(User user, String newPassword) {
		// önce hangi user bul ve passwordü update et.
	}

}
