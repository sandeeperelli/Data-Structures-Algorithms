package com.teradata.photoalbum.service;

import java.util.List;

import com.teradata.photoalbum.model.Photo;

public interface PhotoService {
	Photo saveOrUpdate(Photo c);
	 Photo findObject(long id);
	 void delete(long id);
	 List<Photo> listObjects();
	 
}
