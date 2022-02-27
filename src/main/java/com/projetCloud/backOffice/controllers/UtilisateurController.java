package com.projetCloud.backOffice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetCloud.backOffice.models.Utilisateur;
import com.projetCloud.backOffice.services.UtilisateurService;

@RestController
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;
	
	public Iterable<Utilisateur> getUtilisateurs(){
		return utilisateurService.getUtilisateurs();
	}
	
	public Optional<Utilisateur> getUtilisateur(@PathVariable("id") final Long id){
		return utilisateurService.getUtilisateur(id);
	}
	
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.saveUtilisateur(utilisateur);
	}
	
	public Utilisateur updateUtilisateur(@PathVariable("id") final Long id, @RequestBody Utilisateur utilisateur) {
		return utilisateurService.updateUtilisateur(id, utilisateur);
	}
}
