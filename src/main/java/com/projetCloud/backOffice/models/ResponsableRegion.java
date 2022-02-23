package com.projetCloud.backOffice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Data
@Entity
@Immutable
@Table(name="view_responsable_region")
public class ResponsableRegion {
	@Id
	@Column(name="idresponsable")
	private Long idResponsable;
	
	@Column(name="idregion")
	private Long idRegion;
	
	private String region;
	private String nom;
	private String prenom;
	private String email;
}
