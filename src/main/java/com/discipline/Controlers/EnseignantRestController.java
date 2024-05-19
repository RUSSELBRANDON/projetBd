package com.discipline.Controlers;

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
import com.discipline.entities.Enseignant;
import java.util.List;
import com.discipline.repositories.EnseignantRepository;
import javax.validation.Valid;
@RestController

@RequestMapping("/enseignants")
public class EnseignantRestController {
    private EnseignantRepository enseignantRepository;
    public EnseignantRestController(EnseignantRepository enseignantRepository){
        this.enseignantRepository = enseignantRepository;
    }

    @GetMapping
    public List<Enseignant> enseignantList(){
        return enseignantRepository.findAll();
    }
    @GetMapping("/{id}")

    public Enseignant enseignant(@PathVariable Long id){
        Enseignant enseignant = enseignantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Enseignant non trouvé avec l'id: " + id));
                return enseignant;
    }
    @PostMapping
    public ResponseEntity<?> ajouterEnseignant(@Valid @RequestBody Enseignant enseignant, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Erreur de validation", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(enseignantRepository.save(enseignant), HttpStatus.CREATED);
    }

    // Mettre à jour un enseignant existant avec validation des données
    @PutMapping("/{id}")
    public ResponseEntity<?> mettreAJourEnseignant(@PathVariable Long id, @Valid @RequestBody Enseignant enseignantDetails, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Erreur de validation", HttpStatus.BAD_REQUEST);
        }

        Enseignant enseignant = enseignantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Enseignant non trouvé avec l'id: " + id));

        enseignant.setMatricule(enseignantDetails.getMatricule());
        enseignant.setNom(enseignantDetails.getNom());
        enseignant.setPrenom(enseignantDetails.getPrenom());

        // Mettre à jour d'autres champs si nécessaire

        return new ResponseEntity<>(enseignantRepository.save(enseignant), HttpStatus.OK);
    }

    // Supprimer un enseignant
    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerEnseignant(@PathVariable Long id) {
        Enseignant enseignant = enseignantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Enseignant non trouvé avec l'id: " + id));

        enseignantRepository.delete(enseignant);

        return new ResponseEntity<>("Enseignant supprimé avec succès", HttpStatus.OK);
    }
    
}
