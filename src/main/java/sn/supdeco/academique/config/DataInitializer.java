package sn.supdeco.academique.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sn.supdeco.academique.model.*;
import sn.supdeco.academique.repository.*;

@Configuration
public class DataInitializer {
    @Bean CommandLineRunner seed(EtudiantRepository er, CoursRepository cr, InscriptionRepository ir, NoteRepository nr){
        return args -> { if(er.count()>0)return;
            Etudiant e=new Etudiant();e.setMatricule("ETU-2026-001");e.setPrenom("Awa");e.setNom("Diop");e.setEmail("awa.diop@supdeco.sn");e.setTelephone("770000000");e.setFiliere("Management");er.save(e);
            Cours c=new Cours();c.setCode("JEE301");c.setIntitule("Technologie JEE");c.setEnseignant("M. Ndiaye");c.setCredits(4);cr.save(c);
            Inscription i=new Inscription();i.setEtudiant(e);i.setCours(c);ir.save(i);
            Note n=new Note();n.setInscription(i);n.setValeur(15.5);n.setCoefficient(2);n.setEvaluation("Projet final");nr.save(n);
        };
    }
}
