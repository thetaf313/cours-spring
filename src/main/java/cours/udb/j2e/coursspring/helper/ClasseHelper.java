package cours.udb.j2e.coursspring.helper;

import cours.udb.j2e.coursspring.dto.ClasseDTO;
import cours.udb.j2e.coursspring.exception.ScolariteException;
import cours.udb.j2e.coursspring.exception.ScolariteExceptionHandler;
import cours.udb.j2e.coursspring.model.Classe;
import cours.udb.j2e.coursspring.repository.ClasseRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClasseHelper {

    private final ClasseRepository classeRepository;

    public ClasseHelper(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    //    Verifier existence Classe via le code et le libelle
    public void checkIfClasseExist(ClasseDTO classe) {
        Classe c = classeRepository.findByCodeOrLibelle(classe.getCode(), classe.getLibelle());

        if (c != null) {
            throw new ScolariteException("Une classe existe avec le code " + classe.getCode() +
                    " ou le libelle " + classe.getLibelle());
        }
    }
//    Voir si les montants sont positifs
//    Verifier les frais d'inscription et les mensualites


}
