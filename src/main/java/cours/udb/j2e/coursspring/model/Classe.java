package cours.udb.j2e.coursspring.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 150)
    private String libelle;
    @Column(length = 10)
    private String code;
    private int fraisInscription;
    private int mensualite;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getFraisInscription() {
        return fraisInscription;
    }

    public void setFraisInscription(int fraisInscription) {
        this.fraisInscription = fraisInscription;
    }

    public int getMensualite() {
        return mensualite;
    }

    public void setMensualite(int mensualite) {
        this.mensualite = mensualite;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
