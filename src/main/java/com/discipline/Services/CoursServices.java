package com.discipline.Services;

import com.discipline.entities.Cours;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoursServices {

    public Cours saveCours(Cours cours);
    public Cours updateCours(Cours cours);
    public Cours findCoursById(Long id);
    public List<Cours> findAllCours();
    public void deleteCoursById(Long id);
    public void deleteAllCours();

}
