package com.wildcodeschool.solotoband.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.solotoband.SoloToBandApplication;
import com.wildcodeschool.solotoband.models.Musician;
import com.wildcodeschool.solotoband.models.WantAd;

@Controller
public class AdController {

	@GetMapping("/annonces/{id}")
	public String AdPage(Model model,@PathVariable String id) {

		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<Musician> myMusicien = new ArrayList<Musician>();

		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdMusician() == Integer.parseInt(id)
					&& SoloToBandApplication.getAdList().get(i).getIdGroup() == 0)
				myAds.add(SoloToBandApplication.getAdList().get(i));

		for (int i = 0; i < SoloToBandApplication.getMusicianList().size(); i++) {
			if (Integer.parseInt(id) == SoloToBandApplication.getMusicianList().get(i).getIdMusician())
				myMusicien.add(SoloToBandApplication.getMusicianList().get(i));
		}
		
		model.addAttribute("myAds", myAds);
		model.addAttribute("account", myMusicien.get(0));
		return "Annonce";
	}

	@GetMapping(value = "/deleteAd/{id}")
	public String handleDeleteAd(Model model, @PathVariable String id, @RequestParam(value = "adId", required = true) String adId) {

		ArrayList<Musician> myMusicien = new ArrayList<Musician>();
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();

		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdAnnonce() == Integer.parseInt(adId)
					&& SoloToBandApplication.getAdList().get(i).getIdGroup() == 0)
				SoloToBandApplication.getAdList().remove(i);

		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdMusician() == Integer.parseInt(id)
					&& SoloToBandApplication.getAdList().get(i).getIdGroup() == 0)
				myAds.add(SoloToBandApplication.getAdList().get(i));

		for (int i = 0; i < SoloToBandApplication.getMusicianList().size(); i++) {
				if (Integer.parseInt(id) == SoloToBandApplication.getMusicianList().get(i).getIdMusician())
					myMusicien.add(SoloToBandApplication.getMusicianList().get(i));
		}
		
		model.addAttribute("myAds", myAds);
		model.addAttribute("account", myMusicien.get(0));

		return "Annonce";
	}

	@GetMapping(value = "/createAd/{id}")
	public String handleCreateAd(Model model, @PathVariable String id,
											  @RequestParam(value = "titre", required = true) String title,
											  @RequestParam(value = "localisation", required = true) String localisation,
											  @RequestParam(value = "description", required = true) String description)
											  {

		ArrayList<Musician> myMusicien = new ArrayList<Musician>();
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();

		WantAd myAdd = new WantAd();
		int myId = 0;
		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdAnnonce() > myId)
				myId = SoloToBandApplication.getAdList().get(i).getIdAnnonce();

		myAdd.setIdAnnonce(myId + 1);
		myAdd.setIdMusician(Integer.parseInt(id));
		myAdd.setIdGroup(0);
		myAdd.setTitle(title);
		myAdd.setDescription(description);
		myAdd.setLocate(localisation);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date(System.currentTimeMillis());
		myAdd.setDate(formatter.format(date));
		/*
		 * private String style; private String instrument;
		 */
		SoloToBandApplication.getAdList().add(myAdd);

		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdMusician() == Integer.parseInt(id)
					&& SoloToBandApplication.getAdList().get(i).getIdGroup() == 0)
				myAds.add(SoloToBandApplication.getAdList().get(i));

		for (int i = 0; i < myAds.size(); i++) {
			for (int j = 0; j < SoloToBandApplication.getMusicianList().size(); j++)
				if (myAds.get(i).getIdMusician() == SoloToBandApplication.getMusicianList().get(j).getIdMusician())
					myMusicien.add(SoloToBandApplication.getMusicianList().get(j));
		}

		model.addAttribute("myAds", myAds);
		model.addAttribute("account", myMusicien.get(0));

		return "Annonce";
	}
	
	@GetMapping(value = "/updateAd/{id}/{adId}")
	public String handleUpdateAd(Model model, @PathVariable String id,
											  @PathVariable(value = "adId", required = true) String adId,
											  @RequestParam(value = "titre", required = true) String title,
											  @RequestParam(value = "localisation", required = true) String localisation,
											  @RequestParam(value = "description", required = true) String description,
											  @RequestParam(value= "instrument", required =true)String instrument)
											  {

		ArrayList<Musician> myMusicien = new ArrayList<Musician>();
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		
		WantAd myAdd = new WantAd();
		
		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdAnnonce() == Integer.parseInt(adId))
				myAdd = SoloToBandApplication.getAdList().get(i);


		myAdd.setTitle(title);
		myAdd.setDescription(description);
		myAdd.setLocate(localisation);
		myAdd.setInstrument(instrument);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date(System.currentTimeMillis());
		myAdd.setDate(formatter.format(date));

		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdMusician() == Integer.parseInt(id) 
			 && SoloToBandApplication.getAdList().get(i).getIdGroup() == 0)
				myAds.add(SoloToBandApplication.getAdList().get(i));

		for (int i = 0; i < myAds.size(); i++) {
			for (int j = 0; j < SoloToBandApplication.getMusicianList().size(); j++)
				if (myAds.get(i).getIdMusician() == SoloToBandApplication.getMusicianList().get(j).getIdMusician())
					myMusicien.add(SoloToBandApplication.getMusicianList().get(j));
		}

		model.addAttribute("myAds", myAds);
		model.addAttribute("account", myMusicien.get(0));

		return "Annonce";
	}
}
