package sn.supdeco.academique.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"etudiant_id", "cours_id"}))
public class Inscription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private LocalDate dateInscription = LocalDate.now();
    @Enumerated(EnumType.STRING) private StatutInscription statut = StatutInscription.ACTIVE;
    @ManyToOne(optional=false) private Etudiant etudiant;
    @ManyToOne(optional=false) private Cours cours;
    @OneToMany(mappedBy="inscription", cascade=CascadeType.ALL, orphanRemoval=true) private List<Note> notes = new ArrayList<>();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public LocalDate getDateInscription(){return dateInscription;} public void setDateInscription(LocalDate v){dateInscription=v;}
    public StatutInscription getStatut(){return statut;} public void setStatut(StatutInscription v){statut=v;}
    public Etudiant getEtudiant(){return etudiant;} public void setEtudiant(Etudiant v){etudiant=v;}
    public Cours getCours(){return cours;} public void setCours(Cours v){cours=v;}
    public List<Note> getNotes(){return notes;}
    public double getMoyenne(){return notes.stream().mapToDouble(Note::getNotePonderee).average().orElse(0);}
    public enum StatutInscription { ACTIVE, ANNULEE }
}
