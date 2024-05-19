package com.discipline.Services.ServicesImplementations;

import com.discipline.Services.NiveauServices;
import com.discipline.entities.Niveau;
import com.discipline.repositories.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauServicesImplementation implements NiveauServices {
    @Autowired
    NiveauRepository niveauRepository;

    @Override
    public Niveau saveNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau updateNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau findNiveauById(Long id) {
        return niveauRepository.findById(id).get();
    }

    @Override
    public List<Niveau> findAllNiveaux() {
        return niveauRepository.findAll();
    }

    @Override
    public void deleteNiveauById(Long id) {
        niveauRepository.deleteById(id);
    }

    @Override
    public void deleteAllNiveaux() {
        niveauRepository.deleteAll();
    }
}
