package com.teradata.photoalbum.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "album")
public class Album {

    private long id;
    private String content;
    private List<Photo> photos;
    private User user;

    public Album(long id, String content, List<Photo> photos) {
        this.id = id;
        this.content = content;
        this.photos=photos;
        
    }
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALBUM_ID", unique = true, nullable = false)
	public long getId() {
        return id;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
    public List<Photo> getPhotos() {
		return photos;
	}

    public String getContent() {
        return content;
    }

	public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
