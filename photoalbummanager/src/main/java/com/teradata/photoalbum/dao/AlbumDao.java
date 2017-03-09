package com.teradata.photoalbum.dao;

import java.util.List;

import com.teradata.photoalbum.model.Album;

public interface AlbumDao {
	Album create(Album album);
	void delete(Album album);
	void delete(long albumId);

	Album getByTitle(String title);
	List getAll();
	Album getById(long id);
	Album update(Album album);
}
