package com.wildcodeschool.solotoband.controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.wildcodeschool.solotoband.SoloToBandApplication;
import com.wildcodeschool.solotoband.models.Band;
import com.wildcodeschool.solotoband.models.Musician;
import com.wildcodeschool.solotoband.models.WantAd;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String AdPage(Model model) {

		ArrayList<WantAd> myAds = new ArrayList<WantAd>();
		ArrayList<Musician> myMusicians = new ArrayList<Musician>();
		ArrayList<Band> myBands = new ArrayList<Band>();

		
		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			myAds.add(SoloToBandApplication.getAdList().get(i));

		for (int i = 0; i < SoloToBandApplication.getMusicianList().size(); i++)
			myMusicians.add(SoloToBandApplication.getMusicianList().get(i));

		for (int i = 0; i < SoloToBandApplication.getBandList().size(); i++)
			myBands.add(SoloToBandApplication.getBandList().get(i));
		
		model.addAttribute("myAds", myAds);
		model.addAttribute("myMusicians", myMusicians);
		model.addAttribute("myBands", myBands);
		
		return "admin";
	}
}