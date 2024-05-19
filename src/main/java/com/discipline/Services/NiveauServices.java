package com.discipline.Services;

import com.discipline.entities.Niveau;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NiveauServices {

    public Niveau saveNiveau(Niveau niveau);
    public Niveau updateNiveau(Niveau niveau);
    public Niveau findNiveauById(Long id);
    public List<Niveau> findAllNiveaux();
    public void deleteNiveauById(Long id);
    public void deleteAllNiveaux();

}
