package com.teradata.photoalbum.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teradata.photoalbum.model.Album;
import com.teradata.photoalbum.model.Photo;
import com.teradata.photoalbum.utils.JsonUtils;
@Component
public class AlbumManagerInitializeService{
	@Autowired
	JsonUtils jsonUtils;
	public   List<Photo> photoList;
	public  List<Album> albumList;
	public final static HashMap<Long, List<Photo>> albumMap = new HashMap<Long, List<Photo>>();
	public final static HashMap<Long, List<Album>> userMap = new HashMap<Long, List<Album>>();
	public final static HashMap<Long, Album> albumMapWithId = new HashMap<Long, Album>();
	public void initilize() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("src//main//resources//url.properties");
			prop.load(input);

			initilizePhotos(jsonUtils.readUrl(prop.getProperty("photos")));
			initilizeAlbums(jsonUtils.readUrl(prop.getProperty("albums")));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void initilizeAlbums(JSONArray array) {
		for (Object o : array) {

			JSONObject jsonobj = (JSONObject) o;

			long userId = (long) jsonobj.get("userId");
			long id= (long) jsonobj.get("id");
			String title= (String) jsonobj.get("title");
			Album album= new Album(id, title, albumMap.get(id));
			albumMapWithId.put(id, album);
			if(userMap.containsKey(userId)){
				userMap.get(userId).add(album);
			}else{
				albumList= new ArrayList<Album>();
				albumList.add(album);
				userMap.put(userId, albumList);
			}
			
		}
		
	}

	public void initilizePhotos(JSONArray array) {
		for (Object o : array) {

			JSONObject jsonobj = (JSONObject) o;

			long id = (long) jsonobj.get("id");
			long albumId = (long) jsonobj.get("albumId");
			String title = (String) jsonobj.get("title");
			String url = (String) jsonobj.get("url");
			String thumbnailUrl = (String) jsonobj.get("thumbnailUrl");
			Photo photo = new Photo(id, albumId, title, url, thumbnailUrl);
			if(albumMap.containsKey(albumId)){
				albumMap.get(albumId).add(photo);
			}else{
				photoList=new ArrayList<Photo>();
				photoList.add(photo);
				albumMap.put(albumId, photoList);
			}
		}
	}

}
