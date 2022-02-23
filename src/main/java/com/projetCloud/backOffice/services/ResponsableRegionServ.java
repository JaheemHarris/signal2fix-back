package com.projetCloud.backOffice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.ResponsableRegion;
import com.projetCloud.backOffice.repositories.ResponsableRegionRepo;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResponsableRegionServ {
	
	@Autowired
	public ResponsableRegionRepo responsableRegionRepo;
	
	public List<ResponsableRegion> getResponsableRegions(){
		return responsableRegionRepo.findAll();
	}
	
	public ResponsableRegion getResponsableRegionByIdResponsable(final Long idResponsable){
		Optional<ResponsableRegion> responsableOpt = responsableRegionRepo.findByIdResponsable(idResponsable);
		ResponsableRegion responsable = null;
		if(responsableOpt.isPresent())
			responsable = responsableOpt.get();
		return responsable;
	}
}
