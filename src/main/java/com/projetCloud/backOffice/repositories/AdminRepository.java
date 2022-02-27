package com.projetCloud.backOffice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	
	Optional<Admin> findByEmail(String email);
}
