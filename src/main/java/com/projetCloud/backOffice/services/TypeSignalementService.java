package com.projetCloud.backOffice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.TypeSignalement;
import com.projetCloud.backOffice.repositories.TypeSignalementRepository;

@Service
public class TypeSignalementService {
	
	@Autowired
	private TypeSignalementRepository typeRepository;
	
	public List<TypeSignalement> getTypeSignalements(){
		return typeRepository.findAll();
	}
}
