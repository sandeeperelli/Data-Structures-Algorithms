package com.teradata.photoalbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teradata.photoalbum.model.User;
import com.teradata.photoalbum.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserRestController {
	@Autowired
	 UserService service;

    
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public User getUser(@RequestParam long id){		
		return service.findObject(id);
	}
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public List<User> getUsers(@RequestParam long userId){		
		return service.listObjects();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public User saveUpdateCustomer(@PathVariable long id ,@RequestBody User c) throws Exception{		
		return service.saveOrUpdate(c);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable long id){		
		service.delete(id);
	}
}
