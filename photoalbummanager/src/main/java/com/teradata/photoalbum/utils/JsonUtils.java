package com.teradata.photoalbum.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teradata.photoalbum.model.Album;
import com.teradata.photoalbum.model.Photo;

@Component
public class JsonUtils {

	public JSONArray readUrl(String urlname) {

		JSONParser parser = new JSONParser();
		InputStreamReader reader = null;
		JSONArray arr = null;
		try {
			URL urlstring = new URL(urlname);
			reader = new InputStreamReader(urlstring.openStream());
			arr = (JSONArray) parser.parse(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
   				e.printStackTrace();
			}
		}
		return arr;
	}

}
