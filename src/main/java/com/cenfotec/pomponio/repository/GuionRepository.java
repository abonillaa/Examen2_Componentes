package com.cenfotec.pomponio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.pomponio.domain.Guion;

public interface GuionRepository extends JpaRepository<Guion, Long>{
	List<Guion> findByNombreObraContaining(String nombre);
}
