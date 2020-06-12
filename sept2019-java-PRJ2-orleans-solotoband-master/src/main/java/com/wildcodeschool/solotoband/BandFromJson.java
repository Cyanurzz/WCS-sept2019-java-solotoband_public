package com.wildcodeschool.solotoband;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildcodeschool.solotoband.models.Band;

public class BandFromJson {

	
	private final static String JSON_BAND_PATH = "band.json";
	

	public static ArrayList<Band> createBands () {

		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<Band> myBands = new ArrayList<Band>();
			try {
			    JsonNode root = objectMapper.readTree(new File(JSON_BAND_PATH));
			    Band[] bands  = objectMapper.convertValue(root.get("band"), Band[].class);
			    for (int i = 0; i < bands.length; i++) {
					myBands.add(bands[i]);
			    }
			    
			} catch (IOException e) {
			    e.printStackTrace();
			}
		return myBands;
	}
	
}
