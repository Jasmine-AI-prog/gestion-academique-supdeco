package sn.supdeco.academique.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sn.supdeco.academique.model.*;
import sn.supdeco.academique.repository.*;

@Controller
public class WebController {
    private final EtudiantRepository etudiants; private final CoursRepository cours; private final InscriptionRepository inscriptions; private final NoteRepository notes;
    public WebController(EtudiantRepository e, CoursRepository c, InscriptionRepository i, NoteRepository n){etudiants=e;cours=c;inscriptions=i;notes=n;}
    @GetMapping({"/", "/tableau-de-bord"}) String dashboard(Model m){m.addAttribute("nbEtudiants",etudiants.count());m.addAttribute("nbCours",cours.count());m.addAttribute("nbInscriptions",inscriptions.count());m.addAttribute("nbNotes",notes.count());return "dashboard";}
    @GetMapping("/connexion") String login(){return "login";}
    @GetMapping("/etudiants") String students(Model m){m.addAttribute("etudiants",etudiants.findAll());return "etudiants";}
    @GetMapping("/etudiants/nouveau") String newStudent(Model m){m.addAttribute("etudiant",new Etudiant());return "etudiant-form";}
    @GetMapping("/etudiants/{id}/modifier") String editStudent(@PathVariable Long id, Model m){m.addAttribute("etudiant",etudiants.findById(id).orElseThrow());return "etudiant-form";}
    @PostMapping("/etudiants/enregistrer") String saveStudent(@Valid @ModelAttribute Etudiant e, BindingResult r){if(r.hasErrors())return "etudiant-form";etudiants.save(e);return "redirect:/etudiants";}
    @PostMapping("/etudiants/{id}/supprimer") String deleteStudent(@PathVariable Long id){etudiants.deleteById(id);return "redirect:/etudiants";}
    @GetMapping("/cours") String courses(Model m){m.addAttribute("cours",cours.findAll());return "cours";}
    @GetMapping("/cours/nouveau") String newCourse(Model m){m.addAttribute("cours",new Cours());return "cours-form";}
    @GetMapping("/cours/{id}/modifier") String editCourse(@PathVariable Long id, Model m){m.addAttribute("cours",cours.findById(id).orElseThrow());return "cours-form";}
    @PostMapping("/cours/enregistrer") String saveCourse(@Valid @ModelAttribute("cours") Cours c, BindingResult r){if(r.hasErrors())return "cours-form";cours.save(c);return "redirect:/cours";}
    @PostMapping("/cours/{id}/supprimer") String deleteCourse(@PathVariable Long id){cours.deleteById(id);return "redirect:/cours";}
    @GetMapping("/inscriptions") String registrations(Model m){m.addAttribute("inscriptions",inscriptions.findAll());m.addAttribute("etudiants",etudiants.findAll());m.addAttribute("cours",cours.findAll());return "inscriptions";}
    @PostMapping("/inscriptions/enregistrer") String saveRegistration(@RequestParam Long etudiantId,@RequestParam Long coursId){Inscription i=new Inscription();i.setEtudiant(etudiants.findById(etudiantId).orElseThrow());i.setCours(cours.findById(coursId).orElseThrow());inscriptions.save(i);return "redirect:/inscriptions";}
    @PostMapping("/inscriptions/{id}/supprimer") String deleteRegistration(@PathVariable Long id){inscriptions.deleteById(id);return "redirect:/inscriptions";}
    @GetMapping("/notes") String grades(Model m){m.addAttribute("notes",notes.findAll());m.addAttribute("inscriptions",inscriptions.findAll());return "notes";}
    @PostMapping("/notes/enregistrer") String saveGrade(@RequestParam Long inscriptionId,@RequestParam double valeur,@RequestParam double coefficient,@RequestParam String evaluation){Note n=new Note();n.setInscription(inscriptions.findById(inscriptionId).orElseThrow());n.setValeur(valeur);n.setCoefficient(coefficient);n.setEvaluation(evaluation);notes.save(n);return "redirect:/notes";}
}
