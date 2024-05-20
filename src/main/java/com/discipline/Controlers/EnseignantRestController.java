package com.discipline.Controlers;

import com.discipline.Services.ServicesImplementations.EnseignantServicesImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/enseignants")
public class EnseignantRestController {
    @Autowired
    EnseignantServicesImplementation enseignantServicesImplementation;

    @PostMapping("/ajouterEnseignant")
    public ResponseEntity<Object> createEnseignant(@RequestBody Enseignant enseignantDTO){
        if (enseignantServicesImplementation.ifExistsByEnseignantMatricule(enseignantDTO.getMatricule())) {
            return new ResponseEntity<>("L'enseignant existe déjà", HttpStatus.BAD_REQUEST);
        }
        Enseignant enseignantCreated = enseignantServicesImplementation.saveEnseignant(enseignantDTO);
        return new ResponseEntity<>(enseignantCreated, HttpStatus.CREATED);
    }
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Object> updateEnseignant(@PathVariable Long id, @RequestBody Enseignant enseignantDTO){
        if (!enseignantServicesImplementation.ifExistsByEnseignantMatricule(enseignantDTO.getMatricule())) {
            return new ResponseEntity<>("Cet enseignant n'existe pas", HttpStatus.NOT_FOUND);
        }
        Enseignant enseignantUpdated = enseignantServicesImplementation.findEnseignantById(id);
        enseignantUpdated.setAdresses(enseignantDTO.getAdresses());
        enseignantUpdated.setCours(enseignantDTO.getCours());
        enseignantUpdated.setNom(enseignantDTO.getNom());
        enseignantUpdated.setPrenom(enseignantDTO.getPrenom());
        enseignantUpdated.setMatieres(enseignantDTO.getMatieres());
        enseignantUpdated.setMatricule(enseignantDTO.getMatricule());
        return new ResponseEntity<>(enseignantUpdated,HttpStatus.OK);
    }

    @DeleteMapping("/supprimerEnseignant/{id}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable Long id){
        Enseignant enseignant = enseignantServicesImplementation.findEnseignantById(id);
        if (!enseignantServicesImplementation.ifExistsByEnseignantMatricule(enseignant.getMatricule())) {
            return new ResponseEntity<>("Cet enseignant n'existe pas", HttpStatus.NOT_FOUND);
        }
        enseignantServicesImplementation.deleteEnseignantById(id);
        return new ResponseEntity<>("Enseignant supprimé avec succès",HttpStatus.OK);
    }

    @DeleteMapping("/supprimerLesEnseignants")
    public ResponseEntity<String> deleteAllEnseignants(){
        enseignantServicesImplementation.deleteAllEnseignants();
        return new ResponseEntity<>("Les enseignants ont été supprimé avec succès",HttpStatus.OK);
    }

    @GetMapping("/rechercherEnseignant/{id}")
    public ResponseEntity<Object> findEnseignantById(@PathVariable Long id){
        Enseignant enseignant = enseignantServicesImplementation.findEnseignantById(id);
        if (!enseignantServicesImplementation.ifExistsByEnseignantMatricule(enseignant.getMatricule())) {
            return new ResponseEntity<>("Cet enseignant n'existe pas", HttpStatus.NOT_FOUND);
        }
        Enseignant enseignantFound = enseignantServicesImplementation.findEnseignantById(id);
        return new ResponseEntity<>(enseignantFound,HttpStatus.FOUND);
    }
    @GetMapping("/listeEnseignant")
    public ResponseEntity<List<Enseignant>> listEnseignants(){
        List<Enseignant> enseignants = enseignantServicesImplementation.findAllEnseignants();
        return new ResponseEntity<>(enseignants, HttpStatus.FOUND);
    }

}
