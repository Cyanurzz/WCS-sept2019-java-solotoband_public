package com.wildcodeschool.solotoband.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.solotoband.ResearchForAds;
import com.wildcodeschool.solotoband.SoloToBandApplication;
import com.wildcodeschool.solotoband.models.Band;
import com.wildcodeschool.solotoband.models.Musician;
import com.wildcodeschool.solotoband.models.WantAd;

@Controller
public class SearchController {

	@RequestMapping(value = {"/search", "/search/{id}"}, method = { RequestMethod.GET, RequestMethod.POST })
	public String searchPage(Model model,
			@PathVariable Optional<String> id,
			@RequestParam(value = "pseudo", required = false, defaultValue = "0") String pseudo,
			@RequestParam(value = "password", required = false, defaultValue = "0") String password,
			@RequestParam(value = "firstChoiceListBox", required = true, defaultValue = "0") String firstChoiceListBox,
			@RequestParam(value = "firstChoiceInput", required = true, defaultValue = "0") String firstChoiceInput,
			@RequestParam(value = "secondChoiceListBox", required = false, defaultValue = "0") String SecondChoiceListBox,
			@RequestParam(value = "secondChoiceInput", required = false, defaultValue = "0") String SecondChoiceInput) {

		ArrayList<Musician> musicians = SoloToBandApplication.getMusicianList();		
		ArrayList<WantAd> ads = new ArrayList<WantAd>();
		ArrayList<WantAd> bandAds = new ArrayList<WantAd>();
		ArrayList<Band> bands = new ArrayList<Band>();
		ArrayList<Band> bandsSearch = new ArrayList<Band>();
		Musician myMusician = new Musician();
		
		if (id.isPresent()) {
			for (int i = 0; i < musicians.size();i++)
				if (musicians.get(i).getIdMusician() == Integer.parseInt(id.get())) {
					myMusician =musicians.get(i);
					model.addAttribute("account",myMusician);
				}
		}
		else {
			for (int i = 0; i < musicians.size();i++) {
				if (musicians.get(i).getPseudo().equalsIgnoreCase(pseudo) && musicians.get(i).getPwd().equals(password)) {
					myMusician =musicians.get(i);
					model.addAttribute("account",myMusician);
				}
			}
			if(myMusician.getIdMusician() == 0) {
				model.addAttribute("error","1");
				return "Index";
			}
		}

		for (int i = 0; i < SoloToBandApplication.getAdList().size(); i++)
			if (SoloToBandApplication.getAdList().get(i).getIdGroup() != 0)
				bandAds.add(SoloToBandApplication.getAdList().get(i));

		// trouver les groupes des ads
		for (int i = 0; i < bandAds.size(); i++)
			for (int j = 0; j < SoloToBandApplication.getBandList().size(); j++)
				if (bandAds.get(i).getIdGroup() == SoloToBandApplication.getBandList().get(j).getIdGroup())
					bands.add(SoloToBandApplication.getBandList().get(j));

		model.addAttribute("AdSelection", bandAds);
		model.addAttribute("bands", bands);
		

		if (SecondChoiceListBox.equals("Critère de recherche") || SecondChoiceListBox.equals("0")) {

			switch (firstChoiceListBox) {

			case "Par Instrument":
				ads = ResearchForAds.returnAdByInstument(firstChoiceInput, false);
				model.addAttribute("adsToPut", ads);
				model.addAttribute("count", ads.size());

				break;

			case "Par Style":
				ads = ResearchForAds.returnAdByStyle(firstChoiceInput, false);
				model.addAttribute("adsToPut", ads);
				model.addAttribute("count", ads.size());
				break;

			case "Par Localisation":
				ads = ResearchForAds.returnAdByCity(firstChoiceInput, false);
				model.addAttribute("adsToPut", ads);
				model.addAttribute("count", ads.size());
				break;
			case "Par Groupe":
				ads = ResearchForAds.returnAdByGroup(firstChoiceInput);
				model.addAttribute("adsToPut", ads);
				model.addAttribute("count", ads.size());
				break;
			default:
			}
		}
		else if (firstChoiceListBox.equals("Par Instrument") & SecondChoiceListBox.equals("Par Style")) {
			ads = ResearchForAds.returnAdByInstumentStyle(firstChoiceInput, SecondChoiceInput, false);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Style") & SecondChoiceListBox.equals("Par Instrument")) {
			ads = ResearchForAds.returnAdByInstumentStyle(SecondChoiceInput, firstChoiceInput,  false);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Instrument") & SecondChoiceListBox.equals("Par Localisation")) {
			ads = ResearchForAds.returnAdByInstumentCity(firstChoiceInput, SecondChoiceInput, false);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Localisation") & SecondChoiceListBox.equals("Par Instrument")) {
			ads = ResearchForAds.returnAdByInstumentCity(SecondChoiceInput,firstChoiceInput,  false);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Style") & SecondChoiceListBox.equals("Par Localisation")) {
			ads = ResearchForAds.returnAdByStyleCity(firstChoiceInput, SecondChoiceInput, false);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		} else if (firstChoiceListBox.equals("Par Localisation") & SecondChoiceListBox.equals("Par Style")) {
			ads = ResearchForAds.returnAdByStyleCity(SecondChoiceInput,firstChoiceInput, false);
			model.addAttribute("adsToPut", ads);
			model.addAttribute("count", ads.size());
		}
		
		for (int i = 0; i < ads.size(); i++) {
			for (int j = 0; j < SoloToBandApplication.getBandList().size(); j++) {
				if (ads.get(i).getIdGroup() == SoloToBandApplication.getBandList().get(j).getIdGroup()) {
					bandsSearch.add(SoloToBandApplication.getBandList().get(j));
				}
			}
		}
		
		model.addAttribute("bandsSearch", bandsSearch);
		return "search";
	}
}
