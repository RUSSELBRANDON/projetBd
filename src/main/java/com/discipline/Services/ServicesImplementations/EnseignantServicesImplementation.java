package com.discipline.Services.ServicesImplementations;

import com.discipline.Services.EnseignantServices;
import com.discipline.entities.Enseignant;
import com.discipline.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EnseignantServicesImplementation implements EnseignantServices {
    @Autowired
    EnseignantRepository enseignantRepository;
    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public Enseignant findEnseignantById(Long id) {
        return enseignantRepository.findById(id).get();
    }

    @Override
    public List<Enseignant> findAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public void deleteEnseignantById(Long id) {
        enseignantRepository.deleteById(id);
    }

    @Override
    public void deleteAllEnseignants() {
        enseignantRepository.deleteAll();
    }
}
