package com.discipline.Services;

import com.discipline.entities.Salle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalleServices {

    public Salle saveSalle(Salle salle);
    public Salle updateSalle(Salle salle);
    public Salle findSalleById(Long id);
    public List<Salle> findAllSalles();
    public void deleteSalleById(Long id);
    public void deleteAllSalles();

}
