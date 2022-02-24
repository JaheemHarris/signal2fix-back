package com.projetCloud.backOffice.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.projetCloud.backOffice.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.projetCloud.backOffice.models.Utilisateur;
import com.projetCloud.backOffice.repositories.UtilisateurRepository;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public Iterable<Utilisateur> getUtilisateurs(){
		return utilisateurRepository.findAll();
	}
	
	public Optional<Utilisateur> getUtilisateur(final Long id){
		return utilisateurRepository.findById(id);
	}
	
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
		return savedUtilisateur;
	}

	public Utilisateur saveResponsable(Utilisateur responsable){
		Set<Role> roles = new HashSet<Role>();
		roles.add(new Role(Long.valueOf(1),"ROLE_ADMIN"));
		roles.add(new Role(Long.valueOf(2),"ROLE_CHIEF"));
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		responsable.setMotDePasse(bcrypt.encode(responsable.getMotDePasse()));
		responsable.setRoles(roles);
		Utilisateur savedResponsable = utilisateurRepository.save(responsable);
		return savedResponsable;
	}

	public void deleteResponsable(Long id){
		utilisateurRepository.deleteById(id);
	}
	
	public Utilisateur updateUtilisateur(final Long id,Utilisateur utilisateur) {
		Optional<Utilisateur> user = utilisateurRepository.findById(id);
		Utilisateur updatedUtilisateur = null;
		if(user.isPresent()) {
			Utilisateur currentUser = user.get();
			if(utilisateur.getNom() != null)
				currentUser.setNom(utilisateur.getNom());
			if(utilisateur.getPrenom() != null)
				currentUser.setPrenom(utilisateur.getPrenom());
			if(utilisateur.getEmail() != null)
				currentUser.setEmail(utilisateur.getEmail());
			if(utilisateur.getMotDePasse() != null)
				currentUser.setMotDePasse(utilisateur.getMotDePasse());
			updatedUtilisateur = utilisateurRepository.save(currentUser);
		}
		return updatedUtilisateur;
	}
}
