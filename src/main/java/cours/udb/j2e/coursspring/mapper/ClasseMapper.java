package cours.udb.j2e.coursspring.mapper;

import cours.udb.j2e.coursspring.dto.ClasseDTO;
import cours.udb.j2e.coursspring.dto.FiliereDTO;
import cours.udb.j2e.coursspring.model.Classe;
import cours.udb.j2e.coursspring.model.Filiere;
import org.springframework.stereotype.Component;

@Component
public class ClasseMapper {

    public Classe classeDtoToClasseEntity(ClasseDTO classeDTO) {

        return Classe.builder()
                .libelle(classeDTO.getLibelle())
                .code(classeDTO.getCode())
                .mensualite(classeDTO.getMensualite())
                .fraisInscription(classeDTO.getFraisInscription())
                .filiere(classeDTO.getFiliere())
                .build();
    }

    public ClasseDTO classeEntityToClasseDto(Classe classe) {

        return ClasseDTO.builder()
                .libelle(classe.getLibelle())
                .code(classe.getCode())
                .mensualite(classe.getMensualite())
                .fraisInscription(classe.getFraisInscription())
                .filiere(classe.getFiliere())
                .build();
    }
}
