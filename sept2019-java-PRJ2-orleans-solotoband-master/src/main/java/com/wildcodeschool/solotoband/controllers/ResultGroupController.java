package com.wildcodeschool.solotoband.controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.solotoband.ResearchForAds;
import com.wildcodeschool.solotoband.SoloToBandApplication;
import com.wildcodeschool.solotoband.models.Musician;
import com.wildcodeschool.solotoband.models.WantAd;

@Controller
public class ResultGroupController {

	@GetMapping("/resultgroup/{id}")
	public String searchPage(Model model,
			@PathVariable String id,
			@RequestParam(value = "firstChoiceListBox", required = true, defaultValue = "0") String firstChoiceListBox,
			@RequestParam(value = "firstChoiceInput", required = true, defaultValue = "0") String firstChoiceInput,
			@RequestParam(value = "secondChoiceListBox", required = true, defaultValue = "0") String SecondChoiceListBox,
			@RequestParam(value = "secondChoiceInput", required = true, defaultValue = "0") String SecondChoiceInput) {

		ArrayList<WantAd> ads = new ArrayList<WantAd>();
		ArrayList<WantAd> musicianAds = new ArrayList<WantAd>();
		ArrayList<Musician> musicians = new ArrayList<Musician>();
		ArrayList<Musician> musiciansSearch = new ArrayList<Musician>();
		Musician myMusicien = new Musician();

		for (int i = 0; i < SoloToBandApplication.getMusicianList().size(); i++)
			if (Integer.parseInt(id) == SoloToBandApplication.getMusicianList().get(i).getIdMusician())
				myMusicien = (SoloToBandApplication.getMusicianList().get(i));
		
		// renvoie des 2 premieres annonces

		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdMusician() != 0)
				musicianAds.add(SoloToBandApplication.getAdList().get(i));

		// trouver les groupes des ads
		for (int i = 0; i < musicianAds.size(); i++)
			for (int j = 0; j < SoloToBandApplication.getMusicianList().size(); j++)
				if (musicianAds.get(i).getIdMusician() == SoloToBandApplication.getMusicianList().get(j).getIdMusician())
					musicians.add(SoloToBandApplication.getMusicianList().get(j));

		model.addAttribute("AdSelection", musicianAds);
		model.addAttribute("musicians", musicians);
		model.addAttribute("account", myMusicien);
		

		if (SecondChoiceListBox.equals("Critère de recherche") || SecondChoiceListBox.equals("0")) {

			switch (firstChoiceListBox) {

			case "Par Instrument":
				ads = ResearchForAds.returnAdByInstument(firstChoiceInput, true);
				System.out.println("siza ads" + ads.size());
				model.addAttribute("adsToPut", ads);
				model.addAttribute("count", ads.size());

				break;

			case "Par Style":
				ads = ResearchForAds.returnAdByStyle(firstChoiceInput, true);
				model.addAttribute("adsToPut", ads);
				model.addAttribute("count", ads.size());
				break;

			case "Par Localisation":
				ads = ResearchForAds.returnAdByCity(firstChoiceInput, true);
				model.addAttribute("adsToPut", ads);
				model.addAttribute("count", ads.size());
				break;
			case "Par Musicien":
				ads = ResearchForAds.returnAdByMusician(firstChoiceInput);
				model.addAttribute("adsToPut", ads);
				model.addAttribute("count", ads.size());
				break;
			default:
			}
		}
		else if (firstChoiceListBox.equals("Par Instrument") & SecondChoiceListBox.equals("Par Style")) {
			ads = ResearchForAds.returnAdByInstumentStyle(firstChoiceInput, SecondChoiceInput, true);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Style") & SecondChoiceListBox.equals("Par Instrument")) {
			ads = ResearchForAds.returnAdByInstumentStyle(SecondChoiceInput, firstChoiceInput,  true);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Instrument") & SecondChoiceListBox.equals("Par Localisation")) {
			ads = ResearchForAds.returnAdByInstumentCity(firstChoiceInput, SecondChoiceInput, true);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Localisation") & SecondChoiceListBox.equals("Par Instrument")) {
			ads = ResearchForAds.returnAdByInstumentCity(SecondChoiceInput,firstChoiceInput,  true);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Style") & SecondChoiceListBox.equals("Par Localisation")) {
			ads = ResearchForAds.returnAdByStyleCity(firstChoiceInput, SecondChoiceInput, true);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Localisation") & SecondChoiceListBox.equals("Par Style")) {
			ads = ResearchForAds.returnAdByStyleCity(SecondChoiceInput,firstChoiceInput, true);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		}

		for (int i = 0; i < ads.size(); i++)
			for (int j = 0; j < musicians.size(); j++)
				if (ads.get(i).getIdMusician() == musicians.get(j).getIdMusician())
					musiciansSearch.add(musicians.get(j));

		model.addAttribute("musiciansSearch", musiciansSearch);
		return "resultgroup";
	}
}
	
/*
	@GetMapping("/resultgroup")
	public String searchPage(Model model,
			@RequestParam(value = "firstChoiceListBox", required = true, defaultValue = "0") String firstChoiceListBox,
			@RequestParam(value = "firstChoiceInput", required = true, defaultValue = "0") String firstChoiceInput,
			@RequestParam(value = "secondChoiceListBox", required = false, defaultValue = "0") String SecondChoiceListBox,
			@RequestParam(value = "secondChoiceInput", required = false, defaultValue = "0") String SecondChoiceInput) {



		ArrayList<WantAd> ads = new ArrayList<WantAd>();
		ArrayList<WantAd> myAds = SoloToBandApplication.getAdList();
		ArrayList<Musician> musicians = SoloToBandApplication.getMusicianList();

		for (int i = 0; i < myAds.size(); i++)
			if (myAds.get(i).getIdGroup() == 0)
				ads.add(myAds.get(i));

		if (SecondChoiceInput.equals("Critère de recherche") || SecondChoiceInput.equals("0")) {

			switch (firstChoiceListBox) {
			
			case "Par Instrument":
				ads = ResearchForAds.returnAdByInstument(firstChoiceInput, true);
				for (int i = 0; i < ads.size(); i++)
					for (int j = 0; j < musicians.size(); j++)
						if (musicians.get(j).getIdMusician() == ads.get(i).getIdMusician()) {
							ads.get(i).setMusicianLastName(musicians.get(j).getLastName());
							ads.get(i).setMusicianFirstName(musicians.get(j).getFirstName());
							ads.get(i).setMusicianImg(musicians.get(j).getImg());
							System.out.println(ads.get(i).getMusicianFirstName());
						}

				model.addAttribute("input1", ads);
				model.addAttribute("count", ads.size());
				break;
				
			case "genre":

			case "localité":

			case "nom":
				// code block
				break;
			default:
			}
		}

		return "resultgroup";
	}
}*/
