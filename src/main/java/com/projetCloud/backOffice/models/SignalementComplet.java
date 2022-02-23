package com.projetCloud.backOffice.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;

import lombok.Data;

@Data
@Entity
@Immutable
@Table(name="view_signalementdetails")
public class SignalementComplet {
	
	@Id
	@Column(name="idsignalement")
	private Long idSignalement;
	
	@Column(name="idtype")
	private Long idType;
	private String type;
	
	@Column(name="idregion")
	private Long idRegion;
	private String region;
	
	@Column(name="idutilisateur")
	private Long idUtilisateur;
	
	private String nom;
	
	private String prenom;
	
	@Column(name="idstatus")
	private Long idStatus;
	
	private String status;
	private String description;
	private String image;
	
	@CreationTimestamp
	@Column(name="datesignalement")
	private Timestamp dateSignalement;
	
	private Double latitude;
	private Double longitude;
}
