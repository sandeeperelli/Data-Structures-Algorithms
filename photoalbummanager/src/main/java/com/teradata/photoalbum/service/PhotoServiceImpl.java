package com.teradata.photoalbum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teradata.photoalbum.dao.PhotoDao;
import com.teradata.photoalbum.model.Album;
import com.teradata.photoalbum.model.Photo;
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {
	@Autowired
	private PhotoDao photoDao;

	@Override
	public Photo saveOrUpdate(Photo c) {
		/*if(PhotoDao.findObject(c.getId()) == null){
			return PhotoDao.save(c);			
		}
		else{
			return PhotoDao.update(c);
		}*/
		return null;
	}

	@Override
	public Photo findObject(long id) {		
		return null;//PhotoDao.findObject(id);
	}

	@Override
	public void delete(long id) {
		//PhotoDao.delete(id);		
	}

	@Override
	public List<Photo> listObjects() {
		return null; //PhotoDao.listObjects();
	}

}
