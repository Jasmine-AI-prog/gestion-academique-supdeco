package sn.supdeco.academique.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.supdeco.academique.model.Etudiant;
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {}
