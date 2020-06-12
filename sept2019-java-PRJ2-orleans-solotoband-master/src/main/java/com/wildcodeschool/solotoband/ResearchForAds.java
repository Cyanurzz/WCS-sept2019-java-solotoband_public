package com.wildcodeschool.solotoband;

import java.util.ArrayList;
import com.wildcodeschool.solotoband.models.*;

public class ResearchForAds {

	
	public static ArrayList<WantAd> returnAdByGroup(String group) {	
		ArrayList<Band> myBands = SoloToBandApplication.getBandList();
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<WantAd> ads = SoloToBandApplication.getAdList();
		
		int idGroup = 0;
		
		for (int i = 0; i<myBands.size();i++)
			if (myBands.get(i).getName().equalsIgnoreCase(group))
				idGroup = myBands.get(i).getIdGroup();

		
		for (int i = 0; i < ads.size(); i++)
			if(ads.get(i).getIdGroup() == idGroup)
				myAds.add(ads.get(i));
		return myAds;
	}
	
	public static ArrayList<WantAd> returnAdByMusician(String musician) {	
		ArrayList<Musician> myMusicians = SoloToBandApplication.getMusicianList();
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<WantAd> ads = SoloToBandApplication.getAdList();
		
		int idMusician = 0;
		
		for (int i = 0; i<myMusicians.size();i++)
			if (myMusicians.get(i).getFirstName().equalsIgnoreCase(musician) || myMusicians.get(i).getLastName().equalsIgnoreCase(musician) || myMusicians.get(i).getPseudo().equalsIgnoreCase(musician))
				idMusician = myMusicians.get(i).getIdMusician();

		
		for (int i = 0; i < ads.size(); i++)
			if(ads.get(i).getIdMusician() == idMusician)
				myAds.add(ads.get(i));
		return myAds;
	}
	
	public static ArrayList<WantAd> returnAdByStyle(String style, boolean bandOrMusician) {	
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<WantAd> ads = SoloToBandApplication.getAdList();
		ArrayList<WantAd> resultAds = new ArrayList<WantAd>();
		
		if (bandOrMusician)
			for(int i =0; i< ads.size(); i++) {
				if(ads.get(i).getIdGroup() == 0)
					myAds.add(ads.get(i));		
		}
		else
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() != 0)
					myAds.add(ads.get(i));			
		
		for (int i = 0; i < myAds.size();i++)
			if (myAds.get(i).getStyle().equalsIgnoreCase(style) )
				resultAds.add(myAds.get(i));
		
		return resultAds;
	}
	
	
	public static ArrayList<WantAd> returnAdByCity(String city, boolean bandOrMusician) {
		
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<WantAd> ads = SoloToBandApplication.getAdList();
		ArrayList<WantAd> resultAds = new ArrayList<WantAd>();
		
		if (bandOrMusician) {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() == 0)
					myAds.add(ads.get(i));
		}
		else {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() != 0)
					myAds.add(ads.get(i));		
		}
		
		for (int i = 0; i < myAds.size();i++) 
			if (myAds.get(i).getLocate().equalsIgnoreCase(city))
				resultAds.add(myAds.get(i));
		return resultAds;
	}
	
	
	public static ArrayList<WantAd> returnAdByInstument(String instrument, boolean bandOrMusician) {	
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<WantAd> ads = SoloToBandApplication.getAdList();
		ArrayList<WantAd> resultAds = new ArrayList<WantAd>();
		
		if (bandOrMusician) {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() == 0)
					myAds.add(ads.get(i));
		}
		else {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() != 0)
					myAds.add(ads.get(i));
		}
		
		for (int i = 0; i<myAds.size();i++)
			if (myAds.get(i).getInstrument().equalsIgnoreCase(instrument))
				resultAds.add(myAds.get(i));
		return resultAds;	
	}
	
	
	public static ArrayList<WantAd> returnAdByInstumentStyle(String instrument, String style, boolean bandOrMusician) {
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<WantAd> ads = SoloToBandApplication.getAdList();
		ArrayList<WantAd> resultAds = new ArrayList<WantAd>();
		
		if (bandOrMusician) {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() == 0)
					myAds.add(ads.get(i));
		}
		else {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() != 0)
					myAds.add(ads.get(i));		
		}
		
		for (int i = 0; i<myAds.size();i++) {
			if (myAds.get(i).getInstrument().equalsIgnoreCase(instrument))
				if (myAds.get(i).getStyle().equalsIgnoreCase(style))
					resultAds.add(myAds.get(i));
		}
		return resultAds;
	}
	
	
	public static ArrayList<WantAd> returnAdByInstumentCity(String instrument, String locate, boolean bandOrMusician) {
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<WantAd> ads = SoloToBandApplication.getAdList();
		ArrayList<WantAd> resultAds = new ArrayList<WantAd>();
		
		if (bandOrMusician) {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() == 0)
					myAds.add(ads.get(i));
		}
		else {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() != 0)
					myAds.add(ads.get(i));		
		}
		for (int i = 0; i<myAds.size();i++)
			if (myAds.get(i).getInstrument().equalsIgnoreCase(instrument))
				if (myAds.get(i).getLocate().equalsIgnoreCase(locate))
					resultAds.add(myAds.get(i));
		return resultAds;
	}
	
	
	public static ArrayList<WantAd> returnAdByStyleCity(String style, String city, boolean bandOrMusician) {
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<WantAd> ads = SoloToBandApplication.getAdList();
		ArrayList<WantAd> resultAds = new ArrayList<WantAd>();
		
		if (bandOrMusician) {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() == 0)
					myAds.add(ads.get(i));
		}
		else {
			for(int i =0; i< ads.size(); i++)
				if(ads.get(i).getIdGroup() != 0)
					myAds.add(ads.get(i));		
		}
		for (int i = 0; i<myAds.size();i++)
			if (myAds.get(i).getStyle().equalsIgnoreCase(style))
				if (myAds.get(i).getLocate().equalsIgnoreCase(city))
					resultAds.add(myAds.get(i));
		return resultAds;
	}
}
