package cours.udb.j2e.coursspring.controller;

import cours.udb.j2e.coursspring.dto.ClasseDTO;
import cours.udb.j2e.coursspring.exception.ScolariteException;
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
            classeHelper.checkIfClasseExist(classeDTO);
            return classeService.saveClasse(classeMapper.classeDtoToClasseEntity(classeDTO));
        } catch (ScolariteException e) {
            throw new ScolariteException(e.getMessage());
        }
    }
}
