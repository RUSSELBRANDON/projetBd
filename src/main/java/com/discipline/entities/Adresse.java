package com.discipline.entities;

import javax.validation.constraints.NotNull;

import com.discipline.enums.TypeAdresse;

import jakarta.persistence.*;
import lombok.*;
@Getter @Setter @ToString @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "adresse")
public class Adresse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String adresse;
    @Enumerated(EnumType.STRING)
    private TypeAdresse type_adresse;

     //Relation ManyToOne avec Enseignant
    @ManyToOne
    @JoinColumn(name = "enseignant_id")

    @NotNull
    private Enseignant enseignant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public TypeAdresse getType_adresse() {
        return type_adresse;
    }

    public void setType_adresse(TypeAdresse type_adresse) {
        this.type_adresse = type_adresse;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }
}
