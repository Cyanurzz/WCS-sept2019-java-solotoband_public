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
import com.wildcodeschool.solotoband.models.Band;
import com.wildcodeschool.solotoband.models.Musician;
import com.wildcodeschool.solotoband.models.WantAd;

@Controller
public class AdBandController {


	@GetMapping("/annoncesBand/{id}")
	public String AdPage(Model model,@PathVariable String id) {

		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<Band> myMusicianBand = new ArrayList<Band>();
		Musician myMusicien = new Musician();

		for (int i = 0; i < SoloToBandApplication.getMusicianList().size(); i++)
			if (Integer.parseInt(id) == SoloToBandApplication.getMusicianList().get(i).getIdMusician())
				myMusicien = (SoloToBandApplication.getMusicianList().get(i));
		
		for (int i = 0; i < SoloToBandApplication.getBandList().size(); i++)
			if (SoloToBandApplication.getBandList().get(i).getIdLead() == Integer.parseInt(id))
				myMusicianBand.add(SoloToBandApplication.getBandList().get(i));
		
		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdLead() == Integer.parseInt(id))
				myAds.add(SoloToBandApplication.getAdList().get(i));
		
		model.addAttribute("myAds", myAds);
		model.addAttribute("myBand", myMusicianBand);
		model.addAttribute("account", myMusicien);
		
		return "AnnonceBand";
	}

	@GetMapping(value = "/deleteAdBand/{id}")
	public String handleDeleteAd(Model model, @PathVariable String id, @RequestParam(value = "adId", required = true) String adId) {

		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		Musician myMusicien = new Musician();
		ArrayList<Band> myMusicianBand = new ArrayList<Band>();

		for (int i = 0; i < SoloToBandApplication.getMusicianList().size(); i++)
			if (Integer.parseInt(id) == SoloToBandApplication.getMusicianList().get(i).getIdMusician())
				myMusicien = (SoloToBandApplication.getMusicianList().get(i));
		

		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdAnnonce() == Integer.parseInt(adId))
				SoloToBandApplication.getAdList().remove(i);

		for (int i = 0; i < SoloToBandApplication.getBandList().size(); i++)
			if (SoloToBandApplication.getBandList().get(i).getIdLead() == Integer.parseInt(id))
				myMusicianBand.add(SoloToBandApplication.getBandList().get(i));
		
		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdLead() == Integer.parseInt(id))
				myAds.add(SoloToBandApplication.getAdList().get(i));
		

		model.addAttribute("myAds", myAds);
		model.addAttribute("myBand", myMusicianBand);
		model.addAttribute("account", myMusicien);

		return "AnnonceBand";
	}

	@GetMapping(value = "/createAdBand/{id}")
	public String handleCreateAd(Model model, @PathVariable String id,
											  @RequestParam(value = "titre", required = true) String title,
											  @RequestParam(value = "localisation", required = true) String localisation,
											  @RequestParam(value = "description", required = true) String description){

		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<Band> myMusicianBand = new ArrayList<Band>();
		Musician myMusicien = new Musician();

		for (int i = 0; i < SoloToBandApplication.getMusicianList().size(); i++)
			if (Integer.parseInt(id) == SoloToBandApplication.getMusicianList().get(i).getIdMusician())
				myMusicien = (SoloToBandApplication.getMusicianList().get(i));
		
		for (int i = 0; i < SoloToBandApplication.getBandList().size(); i++)
			if (SoloToBandApplication.getBandList().get(i).getIdLead() == Integer.parseInt(id))
				myMusicianBand.add(SoloToBandApplication.getBandList().get(i));
		
		WantAd myAdd = new WantAd();
		int myId = 0;
		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdAnnonce() > myId)
				myId = SoloToBandApplication.getAdList().get(i).getIdAnnonce();

		myAdd.setIdAnnonce(myId + 1);
		myAdd.setIdMusician(0);
		myAdd.setIdLead(Integer.parseInt(id));
		myAdd.setIdGroup(myMusicianBand.get(0).getIdGroup());
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
			if (SoloToBandApplication.getAdList().get(i).getIdLead() == Integer.parseInt(id))
				myAds.add(SoloToBandApplication.getAdList().get(i));
		
		model.addAttribute("myAds", myAds);
		model.addAttribute("myBand", myMusicianBand);
		model.addAttribute("account", myMusicien);

		return "AnnonceBand";
	}

	@GetMapping(value = "/updateAdBand/{id}/{adId}")
	public String handleUpdateAd(Model model, @PathVariable String id,
											  @PathVariable(value = "adId", required = true) String adId,
											  @RequestParam(value = "titre", required = true) String title,
											  @RequestParam(value = "localisation", required = true) String localisation,
											  @RequestParam(value = "description", required = true) String description,
											  @RequestParam(value= "instrument", required =true)String instrument)
											  {

		ArrayList<Musician> myMusicien = new ArrayList<Musician>();
		ArrayList<Band> myMusicianBand = new ArrayList<Band>();
		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		
		WantAd myAdd = new WantAd();
		
		for (int i = 0; i < SoloToBandApplication.getBandList().size(); i++)
			if (SoloToBandApplication.getBandList().get(i).getIdLead() == Integer.parseInt(id))
				myMusicianBand.add(SoloToBandApplication.getBandList().get(i));
		

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
			if (SoloToBandApplication.getAdList().get(i).getIdLead() == Integer.parseInt(id)) 

				myAds.add(SoloToBandApplication.getAdList().get(i));

		for (int i = 0; i < myAds.size(); i++) {
			for (int j = 0; j < SoloToBandApplication.getMusicianList().size(); j++)

				if (myAds.get(i).getIdLead() == SoloToBandApplication.getMusicianList().get(j).getIdMusician())
					myMusicien.add(SoloToBandApplication.getMusicianList().get(j));
		}

		model.addAttribute("myAds", myAds);
		model.addAttribute("myBand", myMusicianBand);
		model.addAttribute("account", myMusicien.get(0));

		return "AnnonceBand";
	}
}
