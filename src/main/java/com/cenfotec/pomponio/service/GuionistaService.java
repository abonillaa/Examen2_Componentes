package com.cenfotec.pomponio.service;

import java.util.List;
import com.cenfotec.pomponio.domain.Guionista;
import java.util.Optional;

public interface GuionistaService {
	public void saveGuionista(Guionista guionista);  
	public List<Guionista> getAllGuionistas();
	public Optional<Guionista> getGuionista(Long id);
}
