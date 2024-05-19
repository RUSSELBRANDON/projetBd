package com.discipline.Services;

import com.discipline.entities.Matiere;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatiereServices {

    public Matiere saveMatiere(Matiere matiere);
    public Matiere updateMatiere(Matiere matiere);
    public Matiere findMatiereById(Long id);
    public List<Matiere> findAllMatieres();
    public void deleteMatiereById(Long id);
    public void deleteAllMatieres();

}
