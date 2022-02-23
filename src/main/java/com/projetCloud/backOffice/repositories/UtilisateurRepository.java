package com.projetCloud.backOffice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetCloud.backOffice.models.Utilisateur;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {

    @Query(value="SELECT au.* FROM auth_user au JOIN user_role ur ON au.id=ur.iduser JOIN auth_role ar ON ur.idrole=ar.id WHERE ar.id=1 AND au.email = :email",nativeQuery = true)
    Optional<Utilisateur> findByEmailAndRoleAdmin(@Param("email") String email);
}
