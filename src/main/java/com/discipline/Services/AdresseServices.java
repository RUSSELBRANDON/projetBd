package com.discipline.Services;

import com.discipline.entities.Adresse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdresseServices {

    public Adresse saveAdresse(Adresse adresse);
    public Adresse updateAdresse(Adresse adresse);
    public Adresse findAdresseById(Long id);
    public List<Adresse> findAllAdresses();
    public void deleteAdresseById(Long id);
    public void deleteAllAdresses();
    public Boolean ifExistsByAdresseId(Long id);
}
