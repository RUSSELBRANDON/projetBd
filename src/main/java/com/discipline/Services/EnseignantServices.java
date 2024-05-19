package com.discipline.Services;

import com.discipline.entities.Enseignant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnseignantServices {

    public Enseignant saveEnseignant(Enseignant enseignant);
    public Enseignant updateEnseignant(Enseignant enseignant);
    public Enseignant findEnseignantById(Long id);
    public List<Enseignant> findAllEnseignants();
    public void deleteEnseignantById(Long id);
    public void deleteAllEnseignants();

}
