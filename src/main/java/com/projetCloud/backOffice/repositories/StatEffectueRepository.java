package com.projetCloud.backOffice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.StatPourcentageEffectue;

@Repository
public interface StatEffectueRepository extends JpaRepository<StatPourcentageEffectue,Long>{
	
	List<StatPourcentageEffectue> findByIdRegion(final Long idRegion);
}
