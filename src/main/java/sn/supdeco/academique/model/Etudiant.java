package sn.supdeco.academique.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Etudiant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String matricule;
    @NotBlank private String prenom;
    @NotBlank private String nom;
    @Email @NotBlank private String email;
    private String telephone;
    private String filiere;
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscription> inscriptions = new ArrayList<>();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getMatricule(){return matricule;} public void setMatricule(String v){matricule=v;}
    public String getPrenom(){return prenom;} public void setPrenom(String v){prenom=v;}
    public String getNom(){return nom;} public void setNom(String v){nom=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getTelephone(){return telephone;} public void setTelephone(String v){telephone=v;}
    public String getFiliere(){return filiere;} public void setFiliere(String v){filiere=v;}
    public List<Inscription> getInscriptions(){return inscriptions;}
}
