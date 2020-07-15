package com.cenfotec.pomponio.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.pomponio.domain.Actor;
import com.cenfotec.pomponio.domain.Guionista;
import com.cenfotec.pomponio.repository.GuionistaRepository;

@Service
public class GuionistaServiceImp implements GuionistaService{
	
	@Autowired
	GuionistaRepository repository;

	@Override
	public void saveGuionista(Guionista guionista) {
		repository.save(guionista);
	}

	@Override
	public List<Guionista> getAllGuionistas() {
		return repository.findAll();
	}

	@Override
	public Optional<Guionista> getGuionista(Long id) {
		return repository.findById(id);
	}
}
