package com.teradata.photoalbum.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "user")
public class User {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "USER_ID", unique = true, nullable = false)
	    private  long user_id;
	

	private  List<Album> albums;
	
	public User(long user_id, List<Album> albums){
		this.user_id=user_id;
		this.albums=albums;
	}

	public long getUser_id() {
		return user_id;
	}
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public List<Album> getAlbums() {
		return albums;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
}
