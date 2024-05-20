package com.discipline.Controlers;

import java.util.List;

import com.discipline.Services.ServicesImplementations.AdresseServicesImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discipline.entities.Adresse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/adresse")
public class AdresseRestController {
    @Autowired
    AdresseServicesImplementation adresseServicesImplementation;
    @PostMapping("/ajouterAdresse")
    public ResponseEntity<Object> createAdresse(@RequestBody Adresse adresseDTO){
        if (adresseServicesImplementation.ifExistsByAdresseId(adresseDTO.getId())){
            return new ResponseEntity<>("L'adresse existe déjà",HttpStatus.BAD_REQUEST);
        }
        Long enseignantId =  (adresseServicesImplementation.findAdresseById(adresseDTO.getId()).getEnseignant().getId());
        if (enseignantId == null){
            return new ResponseEntity<>("Enseignant non trouvé", HttpStatus.NOT_FOUND);
        }
        Adresse savedAdresse = adresseServicesImplementation.saveAdresse(adresseDTO);
        return new ResponseEntity<>(savedAdresse,HttpStatus.CREATED);
    }
    @PutMapping("/modifierAdresse/{id}")
    public ResponseEntity<Object> updateAdresse(@PathVariable Long id, @RequestBody Adresse adresseDTO ){
        if (!adresseServicesImplementation.ifExistsByAdresseId(id)){
            return new ResponseEntity<>("Cet adresse n'existe pas",HttpStatus.NOT_FOUND);
        }
        Adresse adresse = adresseServicesImplementation.findAdresseById(id);
        adresse.setAdresse(adresseDTO.getAdresse());
        adresse.setType_adresse(adresseDTO.getType_adresse());
        adresse.setEnseignant(adresseDTO.getEnseignant());

        Adresse updatedAdresse = adresseServicesImplementation.saveAdresse(adresse);
        return new ResponseEntity<>(updatedAdresse, HttpStatus.OK);
    }
    @DeleteMapping("/supprimerAdresse/{id}")
    public ResponseEntity<String> deleteAdresse(@PathVariable Long id){
        if (!adresseServicesImplementation.ifExistsByAdresseId(id)){
            return new ResponseEntity<>("Cet adresse n'existe pas",HttpStatus.NOT_FOUND);
        }
        adresseServicesImplementation.deleteAdresseById(id);
        return new ResponseEntity<>("L'adresse a été supprimée avec succès",HttpStatus.OK);
    }

    @DeleteMapping("/supprimerLesAdresses")
    public ResponseEntity<String> deleteAllAdresses(){
        adresseServicesImplementation.deleteAllAdresses();
        return new ResponseEntity<>("Les adresses ont été supprimées avec succès",HttpStatus.OK);
    }

    @GetMapping("/rechercherAdresse/{id}")
    public ResponseEntity<Object> findAdresse(@PathVariable Long id){
        if (!adresseServicesImplementation.ifExistsByAdresseId(id)){
            return new ResponseEntity<>("Cet adresse n'existe pas",HttpStatus.NOT_FOUND);
        }
        Adresse adresseFound = adresseServicesImplementation.findAdresseById(id);
        return new ResponseEntity<>(adresseFound,HttpStatus.FOUND);
    }
    @GetMapping("/listeAdresses")
    public ResponseEntity<List<Adresse>> listesAdresses(){
        List<Adresse> adresses = adresseServicesImplementation.findAllAdresses();
        return new ResponseEntity<>(adresses, HttpStatus.FOUND);
    }

}
