package com.cenfotec.pomponio.service;

import java.util.List;
import java.util.Optional;
import com.cenfotec.pomponio.domain.Actor;

public interface ActorService {
	public void saveActor(Actor actor);  
	public List<Actor> getAllActores();
	public Optional<Actor> getActor(Long id);
}
