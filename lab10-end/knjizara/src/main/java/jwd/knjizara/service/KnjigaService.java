package jwd.knjizara.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.knjizara.model.Knjiga;

public interface KnjigaService {
	Page<Knjiga> findAll(int pageNum);
	Knjiga findOne(Long id);
	void save(Knjiga knjiga);
	void remove(Long id);
	Page<Knjiga> findByIzdvacId(int pageNum, Long izdavacId);
	Page<Knjiga> pretraga(
			@Param("naziv") String naziv, 
			@Param("pisac") String pisac, 
			@Param("minGlasova") Integer minGlasova,
			int page);
}
