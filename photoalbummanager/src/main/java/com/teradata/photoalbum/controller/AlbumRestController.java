package com.teradata.photoalbum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.teradata.photoalbum.model.Album;
import com.teradata.photoalbum.model.Photo;
import com.teradata.photoalbum.model.User;
import com.teradata.photoalbum.service.AlbumManagerInitializeService;
import com.teradata.photoalbum.service.AlbumService;
import com.teradata.photoalbum.utils.JsonUtils;


@RestController
@RequestMapping("/Albums")
public class AlbumRestController {
	@Autowired
	 AlbumService service;
	@Autowired
	AlbumManagerInitializeService initService;

    
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Album getAlbum(@RequestParam long id){		
		return service.findObject(id);
	}
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public List<Album> getAlbums(@RequestParam long userId){		
		return service.listObjects();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Album saveUpdateCustomer(@PathVariable long id ,@RequestBody Album c) throws Exception{		
		return service.saveOrUpdate(c);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable long id){		
		service.delete(id);
	}
	@RequestMapping("/init")
	public Map<Long, List<Album>> getUsersWithAlbums(){
		initService.initilize();
		return initService.userMap;
		
	}
}
