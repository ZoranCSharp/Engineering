package it.eng.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.eng.spring.dao.User;
import it.eng.spring.dao.UsersDao;

@Service
public class UserService {

	@Autowired
	private UsersDao usersDao;

	//get all users
	public List<User> getAllUsers() {

		return usersDao.getUsers();
	}

	//get user by ID
	public User getUser(String username) {

		return usersDao.getUserById(username);
	}

	//delete user by ID
	public boolean deleteUser(String username) {

		return usersDao.deleteUserById(username);
	}

	//create user
	public boolean createUser(User user) {
		return usersDao.createUser(user);
	}

	//update one user
	public boolean updateUser(User user) {
		return usersDao.updateUser(user);
	}

	//check user existence
	public boolean exists(User user) {

		return usersDao.exists(user);
	}
}
