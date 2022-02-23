package com.projetCloud.backOffice.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "auth_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
}
