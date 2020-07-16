package com.cenfotec.pomponio.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.pomponio.domain.Actor;
import com.cenfotec.pomponio.domain.Guion;

public interface GuionService {
	public void saveGuion(Guion guion);  
	public List<Guion> getAllGuiones();
	public Optional<Guion> getGuion(Long id);
	public List<Guion> findbyNombre(String nombre);
}
