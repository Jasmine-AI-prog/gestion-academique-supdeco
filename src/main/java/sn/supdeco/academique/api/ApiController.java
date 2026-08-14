package sn.supdeco.academique.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import sn.supdeco.academique.model.*;
import sn.supdeco.academique.repository.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name="Gestion académique")
public class ApiController {
    private final EtudiantRepository etudiants; private final CoursRepository cours; private final InscriptionRepository inscriptions; private final NoteRepository notes;
    public ApiController(EtudiantRepository e,CoursRepository c,InscriptionRepository i,NoteRepository n){etudiants=e;cours=c;inscriptions=i;notes=n;}
    @GetMapping("/etudiants") @Operation(summary="Lister les étudiants") public List<Etudiant> etudiants(){return etudiants.findAll();}
    @PostMapping("/etudiants") public Etudiant createStudent(@RequestBody Etudiant e){return etudiants.save(e);}
    @GetMapping("/etudiants/{id}") public Etudiant student(@PathVariable Long id){return etudiants.findById(id).orElseThrow();}
    @PutMapping("/etudiants/{id}") public Etudiant updateStudent(@PathVariable Long id,@RequestBody Etudiant e){e.setId(id);return etudiants.save(e);}
    @DeleteMapping("/etudiants/{id}") public void deleteStudent(@PathVariable Long id){etudiants.deleteById(id);}
    @GetMapping("/cours") public List<Cours> cours(){return cours.findAll();}
    @PostMapping("/cours") public Cours createCourse(@RequestBody Cours c){return cours.save(c);}
    @GetMapping("/inscriptions") public List<Inscription> inscriptions(){return inscriptions.findAll();}
    @PostMapping("/inscriptions") public Inscription createRegistration(@RequestBody Inscription i){return inscriptions.save(i);}
    @GetMapping("/notes") public List<Note> notes(){return notes.findAll();}
    @PostMapping("/notes") public Note createGrade(@RequestBody Note n){return notes.save(n);}
}
