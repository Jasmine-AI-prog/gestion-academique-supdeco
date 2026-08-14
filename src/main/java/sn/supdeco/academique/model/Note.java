package sn.supdeco.academique.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;

@Entity
public class Note {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @DecimalMin("0.0") @DecimalMax("20.0") private double valeur;
    @Positive private double coefficient = 1;
    private String evaluation;
    @ManyToOne(optional=false) private Inscription inscription;
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public double getValeur(){return valeur;} public void setValeur(double v){valeur=v;}
    public double getCoefficient(){return coefficient;} public void setCoefficient(double v){coefficient=v;}
    public String getEvaluation(){return evaluation;} public void setEvaluation(String v){evaluation=v;}
    public Inscription getInscription(){return inscription;} public void setInscription(Inscription v){inscription=v;}
    public double getNotePonderee(){return valeur*coefficient;}
}
