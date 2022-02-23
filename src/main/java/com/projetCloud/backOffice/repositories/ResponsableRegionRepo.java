package com.projetCloud.backOffice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.ResponsableRegion;

@Repository
public interface ResponsableRegionRepo extends JpaRepository<ResponsableRegion,Long>{
	Optional<ResponsableRegion> findByIdResponsable(final Long idResponsable);
}
