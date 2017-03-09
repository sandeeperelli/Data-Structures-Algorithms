package com.teradata.photoalbum.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PHOTO")
public class Photo implements java.io.Serializable {
	
	private  long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ALBUM_ID", nullable = false)
	private  long albumId;
	private  String title;
	private  String url;
	private  String thumbnailUrl;
	
	public Photo(long id,long albumId,String title,String url,String thumbnailUrl){
		this.id=id;
		this.albumId=albumId;
		this.title=title;
		this.url=url;
		this.thumbnailUrl=thumbnailUrl;
	}
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public long getAlbumId() {
		return albumId;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}
	public void setId(long id) {
		this.id = id;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public String toString(){
		return id+" "+albumId+" "+title+" "+url+" "+thumbnailUrl;
		
	}

}
