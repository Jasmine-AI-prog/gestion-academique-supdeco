package sn.supdeco.academique.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @NotBlank private String code;
    @NotBlank private String intitule;
    private String enseignant;
    @Positive private int credits = 3;
    @OneToMany(mappedBy = "cours") private List<Inscription> inscriptions = new ArrayList<>();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getCode(){return code;} public void setCode(String v){code=v;}
    public String getIntitule(){return intitule;} public void setIntitule(String v){intitule=v;}
    public String getEnseignant(){return enseignant;} public void setEnseignant(String v){enseignant=v;}
    public int getCredits(){return credits;} public void setCredits(int v){credits=v;}
    public List<Inscription> getInscriptions(){return inscriptions;}
}
