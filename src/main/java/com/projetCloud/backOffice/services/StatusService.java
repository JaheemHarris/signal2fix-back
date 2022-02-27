package com.projetCloud.backOffice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetCloud.backOffice.models.Status;
import com.projetCloud.backOffice.repositories.StatusRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository statusRepo;
	
	public List<Status> getAllStatus(){
		return statusRepo.findAll();
	}
}
