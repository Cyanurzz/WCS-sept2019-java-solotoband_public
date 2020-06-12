package com.wildcodeschool.solotoband;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildcodeschool.solotoband.models.WantAd;


public class WantAdFromJson {
	private final static String JSON_ANNONCE_PATH = "annonces.json";
	
	
	public static ArrayList<WantAd> createAds () {
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		try {
		    JsonNode root = objectMapper.readTree(new File(JSON_ANNONCE_PATH));
		    WantAd[] ads  = objectMapper.convertValue(root.get("annonces"), WantAd[].class);
		    for (int i = 0; i < ads.length; i++) {
				myAds.add(ads[i]);
		    }	
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return myAds;
	}
	
}
