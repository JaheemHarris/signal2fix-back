package com.projetCloud.backOffice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.Responsable;

@Repository
public interface ResponsableRepository extends CrudRepository<Responsable,Long>{

}
