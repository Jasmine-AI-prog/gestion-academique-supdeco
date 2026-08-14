package sn.supdeco.academique.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.supdeco.academique.model.Inscription;
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {}
