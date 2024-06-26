package com.discipline.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discipline.Services.ServicesImplementations.EnseignantServicesImplementation;
import com.discipline.entities.Enseignant;

import java.util.List;
import javax.validation.Valid;
@RestController

@RequestMapping("/enseignants")
public class EnseignantRestController {
    @Autowired
    EnseignantServicesImplementation enseignantServicesImplementation;

    @GetMapping

    public List<Enseignant> listeEnseignant() {
        return enseignantServicesImplementation.findAllEnseignants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEnseignant(@PathVariable("id") Long id) {
        Enseignant enseignant = enseignantServicesImplementation.findEnseignantById(id);
        if (enseignant != null) {
            return ResponseEntity.ok(enseignant);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Enseignant not found with id: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<?> ajouterEnseignant(@Valid @RequestBody Enseignant enseignant, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Erreur de validation", HttpStatus.BAD_REQUEST);
        }

        Enseignant savedEnseignant = enseignantServicesImplementation.saveEnseignant(enseignant);

        return new ResponseEntity<>(savedEnseignant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> mettreAJourEnseignant(@PathVariable Long id, @Valid @RequestBody Enseignant enseignantDetails, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Erreur de validation", HttpStatus.BAD_REQUEST);
        }

        Enseignant enseignant = enseignantServicesImplementation.findEnseignantById(id);

        if (enseignant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Enseignant not found with id: " + id);
        }

        // Mettre à jour les champs de l'Enseignant
        enseignant.setMatricule(enseignantDetails.getMatricule());
        enseignant.setNom(enseignantDetails.getNom());
        enseignant.setPrenom(enseignantDetails.getPrenom());

        Enseignant updatedEnseignant = enseignantServicesImplementation.saveEnseignant(enseignant);

        return new ResponseEntity<>(updatedEnseignant, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerEnseignant(@PathVariable Long id) {
        Enseignant Enseignant = enseignantServicesImplementation.findEnseignantById(id);

        if (Enseignant == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Enseignant not found with id: " + id);
        }

        enseignantServicesImplementation.deleteEnseignantById(Enseignant.getId());

        return new ResponseEntity<>("Enseignant supprimé avec succès", HttpStatus.OK);
    }
    
}
