package cours.udb.j2e.coursspring.dto;

import cours.udb.j2e.coursspring.model.Filiere;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClasseDTO {
    private String libelle;
    private String code;
    private int fraisInscription;
    private int mensualite;
    private Filiere filiere;



}
