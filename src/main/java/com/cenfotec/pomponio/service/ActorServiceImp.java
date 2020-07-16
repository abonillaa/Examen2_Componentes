package com.cenfotec.pomponio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.pomponio.domain.Actor;
import com.cenfotec.pomponio.repository.ActorRepository;

@Service
public class ActorServiceImp implements ActorService{
	@Autowired
	ActorRepository repository;

	@Override
	public void saveActor(Actor actor) {
		repository.save(actor);
	}

	@Override
	public List<Actor> getAllActores() {
		return repository.findAll();
	}

	@Override
	public Optional<Actor> getActor(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Actor> findbyNombre(String nombre) {
		return repository.findByNombreContaining(nombre);
	}
}
