package com.discipline.Services;


import com.discipline.entities.Cycle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CycleServices {

    public Cycle saveCycle(Cycle cycle);
    public Cycle updateCycle(Cycle cycle);
    public Cycle findCycleById(Long id);
    public List<Cycle> findAllCycles();
    public void deleteCycleById(Long id);
    public void deleteAllCycles();

}
