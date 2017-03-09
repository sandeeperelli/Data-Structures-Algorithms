package com.teradata.photoalbum.service;

import java.util.List;

import com.teradata.photoalbum.model.User;


public interface UserService {
	User saveOrUpdate(User c);
	User findObject(long id);
	 void delete(long id);
	 List<User> listObjects();
	 
}
