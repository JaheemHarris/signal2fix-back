package com.projetCloud.backOffice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projetCloud.backOffice.models.Region;
import com.projetCloud.backOffice.models.SignalementComplet;
import com.projetCloud.backOffice.models.Status;
import com.projetCloud.backOffice.models.TypeSignalement;
import com.projetCloud.backOffice.services.RegionService;
import com.projetCloud.backOffice.services.SignalementCompletService;
import com.projetCloud.backOffice.services.StatusService;
import com.projetCloud.backOffice.services.TypeSignalementService;

import java.util.List;

@Controller
public class SignalementCompletController {
	
	@Autowired
	private SignalementCompletService signalCompletServ;
	
	@Autowired
	private TypeSignalementService typeService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping("/listeSignalement")
	public ModelAndView recherche(@RequestParam(name="region",required=false) final Long idRegion,@RequestParam(name="type",required=false) final Long idType,@RequestParam(name="status",required=false) final Long idStatus) {
		List<SignalementComplet> signalements = signalCompletServ.filter(idRegion, idType, idStatus);
		ModelAndView modelView = new ModelAndView();
		List<TypeSignalement> types = typeService.getTypeSignalements();
		List<Region> regions = regionService.getRegions();
		List<Status> allStatus = statusService.getAllStatus();
		modelView.addObject("signalementcomplets", signalements);
		modelView.addObject("types", types);
		modelView.addObject("regions", regions);
		modelView.addObject("allStatus",allStatus);
		modelView.setViewName("listeSignalement");
		return modelView;
	}
	
	@GetMapping("/signalementsNonAffectes")
	public String signalementNonAffectes(Model model,@RequestParam(name="region",required=false)final Long idRegion,@RequestParam(name="type",required=false) final Long idType) {
		List<TypeSignalement> types = typeService.getTypeSignalements();
		List<Region> regions = regionService.getRegions();
		List<SignalementComplet> signalements = signalCompletServ.getSignalementsNonAffectes(idRegion,idType);
		model.addAttribute("signalementsNonAffectes", signalements);
		model.addAttribute("types", types);
		model.addAttribute("regions", regions);
		return "signalementsNonAffectes";
	}
	
	@GetMapping("/signalementDetails")
	public String detailsSignalement(Model model,@RequestParam(name="signalement") final Long idSignalement) {
		SignalementComplet signalement = signalCompletServ.getSignalementCompletById(idSignalement);
		model.addAttribute("signalement", signalement);
		return "signalementDetails";
	}
//	@GetMapping("/home")
//	public ModelAndView listeSignalement() {
//		List<SignalementComplet> liste = signalCompletServ.getSignalementDetails();
//		ModelAndView modelView = new ModelAndView();
//		modelView.addObject("signalementcomplets", liste);
//		modelView.setViewName("tables");
//		return modelView;
//	}
}
