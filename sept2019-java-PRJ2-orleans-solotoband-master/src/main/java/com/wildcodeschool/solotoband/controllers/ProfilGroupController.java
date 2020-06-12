package com.wildcodeschool.solotoband.controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.wildcodeschool.solotoband.SoloToBandApplication;
import com.wildcodeschool.solotoband.models.Band;
import com.wildcodeschool.solotoband.models.Musician;
import com.wildcodeschool.solotoband.models.WantAd;

@Controller
public class ProfilGroupController {

	@GetMapping("/profilgroup/{id}")
	public String profilGroup(Model model, 
			@PathVariable String id) {
		ArrayList<WantAd> myAds = SoloToBandApplication.getAdList();
		ArrayList<Musician> musicians = SoloToBandApplication.getMusicianList();
		ArrayList<WantAd> ads = new ArrayList<WantAd>();
		Musician myMusician = new Musician();
		ArrayList<Band> myMusicianBand = new ArrayList<Band>();
		
		
		for (int i = 0; i < musicians.size();i++)
			if (musicians.get(i).getIdMusician() == Integer.parseInt(id)) {
				myMusician = musicians.get(i);
				model.addAttribute("account",myMusician);
			}
		
		for (int i = 0; i < myAds.size(); i++)
			if (myAds.get(i).getIdGroup() == 0)
				ads.add(myAds.get(i));

		for (int i = 0; i < ads.size(); i++)
			for (int j = 0; j < musicians.size(); j++)
				if (musicians.get(j).getIdMusician() == ads.get(i).getIdMusician()) {
					ads.get(i).setMusicianLastName(musicians.get(j).getLastName());
					ads.get(i).setMusicianFirstName(musicians.get(j).getFirstName());
					ads.get(i).setMusicianImg(musicians.get(j).getImg());
				}
		
		for (int i = 0; i < SoloToBandApplication.getBandList().size(); i++)
			if (SoloToBandApplication.getBandList().get(i).getIdLead() == Integer.parseInt(id))
				myMusicianBand.add(SoloToBandApplication.getBandList().get(i));
				
		model.addAttribute("ads", ads);
		model.addAttribute("myBand", myMusicianBand);
		return "profilgroup";
	}

}
