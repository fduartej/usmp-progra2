package com.example.demo.model;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface PersonaRepository extends Repository<Persona, Integer>{

	void save(Persona persona) throws DataAccessException;
}
