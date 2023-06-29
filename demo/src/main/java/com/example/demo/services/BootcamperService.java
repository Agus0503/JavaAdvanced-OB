package com.example.demo.services;

import com.example.demo.models.Bootcamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootcamperService {
    private final List<Bootcamper> bootcampers = new ArrayList();

    public List<Bootcamper> getAll() {
        return bootcampers;
    }

    public void add(Bootcamper bootcamper) {
        bootcampers.add(bootcamper);
    }

    public void remove(Bootcamper bootcamper) {
        bootcampers.remove(bootcamper);
    }

    public Bootcamper findByName(String name) {
        for (Bootcamper bootcamper : bootcampers) {
            if (bootcamper.getName().equals(name)) { return bootcamper; }
        }
        return null;
    }

    public Bootcamper get(String name) {
        for (Bootcamper bootcamper : bootcampers) {
            if (bootcamper.getName().equalsIgnoreCase(name)) { return bootcamper; }
        }
        return null;
    }

    public Bootcamper update(String name, Double value) {
        Bootcamper bootcamper = findByName(name);
        if(bootcamper != null){
            bootcamper.setValue(value);
            return bootcamper;
        }
        return null;
    }
}
