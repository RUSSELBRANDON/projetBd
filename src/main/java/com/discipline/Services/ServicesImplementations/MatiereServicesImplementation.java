package com.discipline.Services.ServicesImplementations;

import com.discipline.Services.MatiereServices;
import com.discipline.entities.Matiere;
import com.discipline.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereServicesImplementation implements MatiereServices {
    @Autowired
    MatiereRepository matiereRepository;
    @Override
    public Matiere saveMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere updateMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere findMatiereById(Long id) {
        return matiereRepository.findById(id).get();
    }

    @Override
    public List<Matiere> findAllMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public void deleteMatiereById(Long id) {
        matiereRepository.deleteById(id);
    }

    @Override
    public void deleteAllMatieres() {
        matiereRepository.deleteAll();
    }
}
