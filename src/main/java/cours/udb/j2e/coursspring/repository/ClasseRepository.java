package cours.udb.j2e.coursspring.repository;

import cours.udb.j2e.coursspring.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    Classe findByLibelle(String libelle);
    Classe findByCodeOrLibelle(String code, String libelle);

}
