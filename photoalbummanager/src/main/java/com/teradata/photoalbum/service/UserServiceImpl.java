package com.teradata.photoalbum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teradata.photoalbum.dao.UserDao;
import com.teradata.photoalbum.model.Photo;
import com.teradata.photoalbum.model.User;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public User saveOrUpdate(User c) {
		/*if(UserDao.findObject(c.getUser_id()) == null){
			return UserDao.save(c);			
		}
		else{
			return UserDao.update(c);
		}*/
		return null;
	}

	@Override
	public User findObject(long id) {		
		return null ;//UserDao.findObject(id);
	}

	@Override
	public void delete(long id) {
		//UserDao.delete(id);		
	}

	@Override
	public List<User> listObjects() {
		return null ;//UserDao.listObjects();
	}

}
