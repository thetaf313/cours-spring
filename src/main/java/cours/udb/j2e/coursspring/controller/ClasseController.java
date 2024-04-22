package cours.udb.j2e.coursspring.controller;

import cours.udb.j2e.coursspring.dto.ClasseDTO;
import cours.udb.j2e.coursspring.exception.ScolariteException;
import cours.udb.j2e.coursspring.exception.ScolariteNotFound;
import cours.udb.j2e.coursspring.helper.ClasseHelper;
import cours.udb.j2e.coursspring.mapper.ClasseMapper;
import cours.udb.j2e.coursspring.model.Classe;
import cours.udb.j2e.coursspring.service.IClasseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseController {
    private final IClasseService classeService;
    private final ClasseMapper classeMapper;
    private final ClasseHelper classeHelper;

    public ClasseController(IClasseService classeService, ClasseMapper classeMapper, ClasseHelper classeHelper) {
        this.classeService = classeService;
        this.classeMapper = classeMapper;
        this.classeHelper = classeHelper;
    }

    @GetMapping
    public List<Classe> allClasses() {

        return classeService.findAllClasses();
    }

    @PostMapping("/save")
    public Classe addClasse(@RequestBody ClasseDTO classeDTO) {

        try {
            Classe classe = classeMapper.classeDtoToClasseEntity(classeDTO);

            if (classeDTO.getId() != null) {
                if (classeService.findClasseById(Long.parseLong(classeDTO.getId())) == null) {
                    throw new ScolariteNotFound("Aucune classe trouvée avec l'id " + classeDTO.getId());
                }
                classe.setId(Long.parseLong(classeDTO.getId()));
            }
            else {
                classeHelper.checkIfClasseExist(classeDTO);
            }

            return classeService.saveClasse(classe);

        } catch (ScolariteException e) {
            throw new ScolariteException(e.getMessage());
        }
    }

    @GetMapping ("/edit/{id}")
    public Classe findClasse(@PathVariable long id) {

        try {
//            classeHelper.checkIfClasseExist(classeDTO);
            Classe c = classeService.findClasseById(id);

            if (c == null) {
                throw new ScolariteNotFound("Aucune classe trouvée avec l'id " + id);
            }
            return c;
        } catch (ScolariteException e) {
            throw new ScolariteException(e.getMessage());
        }
    }

    @GetMapping ("/remove/{id}")
    public void removeClasse(@PathVariable long id) {

        try {
//            classeHelper.checkIfClasseExist(classeDTO);
            Classe c = classeService.findClasseById(id);

            if (c == null) {
                throw new ScolariteNotFound("Aucune classe trouvée avec l'id " + id);
            }
            classeService.removeClasse(c);

        } catch (ScolariteException e) {
            throw new ScolariteException(e.getMessage());
        }
    }


}
