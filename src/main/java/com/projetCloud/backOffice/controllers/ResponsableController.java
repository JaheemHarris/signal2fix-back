package com.projetCloud.backOffice.controllers;

import java.util.List;

import com.projetCloud.backOffice.models.Utilisateur;
import com.projetCloud.backOffice.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projetCloud.backOffice.models.Region;
import com.projetCloud.backOffice.models.Responsable;
import com.projetCloud.backOffice.services.RegionService;
import com.projetCloud.backOffice.services.ResponsableService;

@Controller
public class ResponsableController {
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private RegionService regionService;
	
	@GetMapping("/ajoutResponsable")
	public ModelAndView ajoutResponsable(Authentication authentication) {
		ModelAndView modelView = new ModelAndView();
		List<Region> regions = regionService.getRegions();
		Utilisateur responsable = new Utilisateur();
		modelView.addObject("nom",authentication.getName());
		modelView.addObject("regions", regions);
		modelView.addObject("responsable", responsable);
		modelView.setViewName("ajoutResponsable");
		return modelView;
	}
	
	@PostMapping("/ajoutResponsable")
	public String createResponsable(@ModelAttribute Utilisateur responsable,Model model) {
		Utilisateur nouveauResponsable = utilisateurService.saveResponsable(responsable);
		model.addAttribute("responsable",nouveauResponsable);
		return "redirect:ajoutResponsable";
	}
	
	@GetMapping("/destituer")
	public String deleteResponsable(@RequestParam("responsable") final Long id) {
		utilisateurService.deleteResponsable(id);
		return "redirect:/listeResponsable";
	}
}
