package com.discipline.Services.ServicesImplementations;

import com.discipline.Services.CycleServices;
import com.discipline.entities.Cycle;
import com.discipline.repositories.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CycleServicesImplentation implements CycleServices {
    @Autowired
    CycleRepository cycleRepository;
    @Override
    public Cycle saveCycle(Cycle cycle) {
        return cycleRepository.save(cycle);
    }

    @Override
    public Cycle updateCycle(Cycle cycle) {
        return cycleRepository.save(cycle);
    }

    @Override
    public Cycle findCycleById(Long id) {
        return cycleRepository.findById(id).get();
    }

    @Override
    public List<Cycle> findAllCycles() {
        return cycleRepository.findAll();
    }

    @Override
    public void deleteCycleById(Long id) {
        cycleRepository.deleteById(id);
    }

    @Override
    public void deleteAllCycles() {
        cycleRepository.deleteAll();
    }
}
