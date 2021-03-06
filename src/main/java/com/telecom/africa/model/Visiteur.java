package com.telecom.africa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Visiteur {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
}
