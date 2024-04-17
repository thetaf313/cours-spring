package cours.udb.j2e.coursspring.repository;

import cours.udb.j2e.coursspring.model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {

}
