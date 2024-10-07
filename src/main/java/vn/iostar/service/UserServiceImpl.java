package vn.iostar.service;

import vn.iostar.dao.UserDao;
import vn.iostar.dao.UserDaoImpl;
import vn.iostar.model.User;
public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public User login(String name, String password) {
		User user = this.findByUserName(name);
		if(user!= null && password.equals(user.getPassWord())) {
			return user;
		}else
			return null;
	}
	private User findByUserName(String name) {
		return userDao.findByUserName(name);
	}
	public void insert(User user) {
		userDao.insert(user);
	}
	@Override
	public boolean register(int id, String username, String password, String fullname) {
		if(userDao.checkExistUsername(username)) {
			return false;
		}
		userDao.insert(new User(id, username, password, fullname));
		return true;
	}
	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}
	public boolean checkExistId(int id) {
		return userDao.checkExistId(id);
	}
	@Override
	public boolean forgotPassWord(String username, String password) {
		if(userDao.checkExistUsername(username))
		{
			userDao.update(username, password);
			return true;
		}
		return false;
	}
	
}
