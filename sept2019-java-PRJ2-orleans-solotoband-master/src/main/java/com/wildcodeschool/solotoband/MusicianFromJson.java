package com.wildcodeschool.solotoband;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildcodeschool.solotoband.models.Musician;

public class MusicianFromJson {

	
	private final static String JSON_MUSICIAN_PATH = "musician.json";
	

	public static ArrayList<Musician> createMusicians () {
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Musician> myMusicians = new ArrayList<Musician>();
		try {
		    JsonNode root = objectMapper.readTree(new File(JSON_MUSICIAN_PATH));
		    Musician[] musicians  = objectMapper.convertValue(root.get("musician"), Musician[].class);
		    for (int i = 0; i < musicians.length; i++) {
				myMusicians.add(musicians[i]);
		    }	
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return myMusicians;
	}
}
