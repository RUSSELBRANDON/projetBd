package com.discipline.Services.ServicesImplementations;

import com.discipline.Services.FiliereServices;
import com.discipline.entities.Filiere;
import com.discipline.repositories.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereServicesImplementation implements FiliereServices {
    @Autowired
    FiliereRepository filiereRepository;
    @Override
    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public Filiere updateFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public Filiere findFiliereById(Long id) {
        return filiereRepository.findById(id).get();
    }

    @Override
    public List<Filiere> findAllFilieres() {
        return filiereRepository.findAll();
    }

    @Override
    public void deleteFiliereById(Long id) {
        filiereRepository.deleteById(id);
    }

    @Override
    public void deleteAllFilieres() {
        filiereRepository.deleteAll();
    }
}
