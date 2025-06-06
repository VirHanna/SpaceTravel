package org.example.service;

import org.example.dao.PlanetDao;
import org.example.model.Planet;

import java.util.Optional;

public class PlanetCrudService {

    private final PlanetDao planetDao = new PlanetDao();

    public void savePlanet(Planet planet) {
        planetDao.save(planet);
    }

    public Optional<Planet> findPlanetById(String id) {
        return planetDao.getById(id);
    }

    public Optional<Planet> getPlanet(String id) {
        return findPlanetById(id);
    }

    public void updatePlanet(Planet planet) {
        planetDao.update(planet);
    }

    public void deletePlanet(Planet planet) {
        planetDao.delete(planet);
    }

    public void createPlanet(String id, String name) {
        Planet planet = new Planet(id, name);
        savePlanet(planet);
    }
}
