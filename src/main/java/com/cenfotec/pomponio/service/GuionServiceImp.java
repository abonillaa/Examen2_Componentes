package com.cenfotec.pomponio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cenfotec.pomponio.domain.Guion;
import com.cenfotec.pomponio.repository.GuionRepository;

@Service
public class GuionServiceImp implements GuionService{

	@Autowired
	GuionRepository repository;
	
	@Override
	public void saveGuion(Guion guion) {
		repository.save(guion);
	}

	@Override
	public List<Guion> getAllGuiones() {
		return repository.findAll();
	}

	@Override
	public Optional<Guion> getGuion(Long id) {
		return repository.findById(id);
	}
}
