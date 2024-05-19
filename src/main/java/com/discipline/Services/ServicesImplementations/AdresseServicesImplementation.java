package com.discipline.Services.ServicesImplementations;

import com.discipline.Services.AdresseServices;
import com.discipline.entities.Adresse;
import com.discipline.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseServicesImplementation implements AdresseServices {
    @Autowired
    AdresseRepository adresseRepository;
    @Override
    public Adresse saveAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public Adresse updateAdresse(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public Adresse findAdresseById(Long id) {
        return adresseRepository.findById(id).get();
    }

    @Override
    public List<Adresse> findAllAdresses() {
        return adresseRepository.findAll();
    }

    @Override
    public void deleteAdresseById(Long id) {
        adresseRepository.deleteById(id);
    }

    @Override
    public void deleteAllAdresses() {
        adresseRepository.deleteAll();
    }
}
