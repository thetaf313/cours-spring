package cours.udb.j2e.coursspring.service;

import cours.udb.j2e.coursspring.model.Classe;
import cours.udb.j2e.coursspring.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService implements IClasseService {
    private final ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public List<Classe> findAllClasses() {
        return classeRepository.findAll();
    }

    @Override
    public Classe findClasseByLibelle(String libelle) {
        return classeRepository.findByLibelle(libelle);
    }
}
