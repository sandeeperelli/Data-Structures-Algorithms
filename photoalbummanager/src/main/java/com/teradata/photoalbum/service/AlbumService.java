package com.teradata.photoalbum.service;

import java.util.List;

import com.teradata.photoalbum.model.Album;

public interface AlbumService {
	
	Album saveOrUpdate(Album c);
	 Album findObject(long id);
	 void delete(long id);
	 List<Album> listObjects();
	 
}
