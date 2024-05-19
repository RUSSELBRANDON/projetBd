package com.discipline.Controlers;

import java.util.List;

import javax.validation.Valid;

import com.discipline.Services.ServicesImplementations.AdresseServicesImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discipline.entities.Adresse;
import com.discipline.entities.Enseignant;
import com.discipline.repositories.AdresseRepository;
import com.discipline.repositories.EnseignantRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;




    @RestController
    
    @RequestMapping("/adresses")
public class AdresseRestController {
        @Autowired
    AdresseServicesImplementation adresseServicesImplementation;
    @Autowired
    private EnseignantRepository enseignantRepository;

    @GetMapping("/listeAdresses")
    public List<Adresse> listeAdresses(){
        return adresseServicesImplementation.findAllAdresses();
    }
    @GetMapping("/adresse/{id}")
    public Adresse adresse(@PathVariable Long id){
        return adresseServicesImplementation.findAdresseById(id);
    }

    @PostMapping("/ajouterAdresse")
    public ResponseEntity<?> ajouterAdresse(@Valid @RequestBody Adresse adresse, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Erreur de validation", HttpStatus.BAD_REQUEST);
        }

        Long enseignantId = adresse.getEnseignant().getId();
        Enseignant enseignant = enseignantRepository.findById(enseignantId).orElse(null);
        if (enseignant == null) {
            return new ResponseEntity<>("Enseignant non trouvé", HttpStatus.NOT_FOUND);
        }

        adresse.setEnseignant(enseignant);

        Adresse savedAdresse = adresseServicesImplementation.saveAdresse(adresse);

        return new ResponseEntity<>(savedAdresse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> mettreAJourAdresse(@PathVariable Long id, @Valid @RequestBody Adresse adresseDetails, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Erreur de validation", HttpStatus.BAD_REQUEST);
        }

        Adresse adresse = adresseServicesImplementation.findAdresseById(id);
        // Récupérer l'enseignant complet à partir de la base de données
        Long enseignantId = adresseDetails.getEnseignant().getId();
        Enseignant enseignant = enseignantRepository.findById(enseignantId).orElse(null);
        if (enseignant == null) {
            return new ResponseEntity<>("Enseignant non trouvé", HttpStatus.NOT_FOUND);
        }

        // Mettre à jour les champs de l'adresse
        adresse.setAdresse(adresseDetails.getAdresse());
        adresse.setType_adresse(adresseDetails.getType_adresse());
        adresse.setEnseignant(enseignant);

        Adresse updatedAdresse = adresseServicesImplementation.saveAdresse(adresse);

        return new ResponseEntity<>(updatedAdresse, HttpStatus.OK);
    }

     @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerAdresse(@PathVariable Long id) {
        Adresse adresse = adresseServicesImplementation.findAdresseById(id);

        adresseServicesImplementation.deleteAdresseById(adresse.getId());

        return new ResponseEntity<>("Enseignant supprimé avec succès", HttpStatus.OK);
    }

}
