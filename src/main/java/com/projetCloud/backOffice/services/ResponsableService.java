package com.projetCloud.backOffice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.Responsable;
import com.projetCloud.backOffice.repositories.ResponsableRepository;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResponsableService {

	@Autowired
	private ResponsableRepository responsableRepository;
	
	public Iterable<Responsable> getResponsables(){
		return responsableRepository.findAll();
	}
	
	public Optional<Responsable> getResponsable(final Long id){
		return responsableRepository.findById(id);
	}
	
	public Responsable saveResponsable(Responsable responsable) {
		Responsable savedResponsable = responsableRepository.save(responsable);
		return savedResponsable;
	}
	
	public Responsable updateResponsable(final Long id,Responsable responsable) {
		Optional<Responsable> responsible = responsableRepository.findById(id);
		Responsable updatedResponsable = null;
		if(responsible.isPresent()) {
			Responsable currentResponsable = responsible.get();
			if(responsable.getIdRegion() != null)
				currentResponsable.setIdRegion(responsable.getIdRegion());
			if(responsable.getNom() != null)
				currentResponsable.setNom(responsable.getNom());
			if(responsable.getPrenom() != null)
				currentResponsable.setPrenom(responsable.getPrenom());
			if(responsable.getEmail() != null)
				currentResponsable.setEmail(responsable.getEmail());
			if(responsable.getMotDePasse() != null)
				currentResponsable.setMotDePasse(responsable.getMotDePasse());
			updatedResponsable = responsableRepository.save(currentResponsable);
		}
		return updatedResponsable;
	}
	
	public void deleteResponsable(final Long id) {
		responsableRepository.deleteById(id);
	}
}
