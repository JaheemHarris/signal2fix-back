package com.projetCloud.backOffice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {

}
