package com.wildcodeschool.solotoband;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.wildcodeschool.solotoband.models.Band;
import com.wildcodeschool.solotoband.models.Musician;
import com.wildcodeschool.solotoband.models.WantAd;


@SpringBootApplication
public class SoloToBandApplication {
	private static ArrayList<WantAd> adList = new ArrayList<WantAd>();
	private static ArrayList<Band> bandList = new ArrayList<Band>();
	private static ArrayList<Musician> musicianList = new ArrayList<Musician>();
	
	
	public static void main(String[] args) {
		SpringApplication.run(SoloToBandApplication.class, args);	
		adList = WantAdFromJson.createAds();
		bandList = BandFromJson.createBands();
		musicianList = MusicianFromJson.createMusicians();
	}
		
	
	public static ArrayList<WantAd> getAdList() {
		return adList;
	}
	
	
	public static ArrayList<Band> getBandList(){
		return bandList;
	}
	
	
	public static ArrayList<Musician> getMusicianList(){
		return musicianList;
	}
}
