package com.discipline.Services;

import com.discipline.entities.Filiere;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FiliereServices {

    public Filiere saveFiliere(Filiere filiere);
    public Filiere updateFiliere(Filiere filiere);
    public Filiere findFiliereById(Long id);
    public List<Filiere> findAllFilieres();
    public void deleteFiliereById(Long id);
    public void deleteAllFilieres();

}
