package cours.udb.j2e.coursspring.service;

import cours.udb.j2e.coursspring.model.Classe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClasseService {
    Classe saveClasse(Classe classe);
    List<Classe> findAllClasses();
    Classe findClasseByLibelle(String libelle);

}
