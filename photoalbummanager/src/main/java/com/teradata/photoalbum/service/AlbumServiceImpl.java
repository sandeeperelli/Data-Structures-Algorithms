package com.teradata.photoalbum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teradata.photoalbum.model.Album;
import com.teradata.photoalbum.dao.AlbumDao;;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{
	@Autowired
	AlbumDao AlbumDao;

	@Override
	public Album saveOrUpdate(Album c) {
		if(AlbumDao.getById(c.getId()) == null){
			return AlbumDao.create(c);			
		}
		else{
			return AlbumDao.update(c);
		}
	}

	@Override
	public Album findObject(long id) {		
		return AlbumDao.getById(id);
	}
//con
	@Override
	public void delete(long id) {
		AlbumDao.delete(id);		
	}

	@Override
	public List<Album> listObjects() {
		return AlbumDao.getAll();
	}

}
