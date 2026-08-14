package sn.supdeco.academique.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.supdeco.academique.model.Note;
public interface NoteRepository extends JpaRepository<Note, Long> {}
