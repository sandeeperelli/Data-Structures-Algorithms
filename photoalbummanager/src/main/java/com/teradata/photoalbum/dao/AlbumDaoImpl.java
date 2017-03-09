package com.teradata.photoalbum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.teradata.photoalbum.model.Album;

@Repository
@Transactional
public class AlbumDaoImpl implements AlbumDao {
	 @PersistenceContext
	  private EntityManager entityManager;
  

  public Album create(Album album) {
    entityManager.persist(album);
    return album;
  }
  
//here applying the constraint Album should not be deleted if any photos associated to album.
  public void delete(long albumId) {
	  Album album = getById(albumId);
    if (entityManager.contains(album))
      entityManager.remove(album);
    else
      entityManager.remove(entityManager.merge(album));
    return;
  }
  

  @SuppressWarnings("unchecked")
  public List getAll() {
    return entityManager.createQuery("from Album").getResultList();
  }
  
  /**
   * Return the user having the passed email.
   */
  public Album getByTitle(String title) {
    return (Album) entityManager.createQuery(
        "from Album where title = :tilte")
        .setParameter("title", title)
        .getSingleResult();
  }


  public Album getById(long id) {
    return entityManager.find(Album.class, id);
  }


  public Album update(Album album) {
    entityManager.merge(album);
    return album;
  }


@Override
public void delete(Album album) {
	
}

 
  
}
