package sn.supdeco.academique.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.supdeco.academique.model.Cours;
public interface CoursRepository extends JpaRepository<Cours, Long> {}
