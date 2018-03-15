package jwd.knjizara.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Knjiga;
import jwd.knjizara.model.Glas;
import jwd.knjizara.repository.KnjigaRepository;
import jwd.knjizara.repository.GlasRepository;
import jwd.knjizara.service.GlasService;

@Service
public class JpaGlasServiceImpl implements GlasService{
	
	@Autowired
	private GlasRepository kupovinaRepository;
	@Autowired
	private KnjigaRepository knjigaRepository;
	
	@Override
	public Glas voteForABook(Long knjigaId) {
		
		if(knjigaId == null) {
			throw new IllegalArgumentException("Id of a book cannot be null!");
		}
		
		Knjiga knjiga = knjigaRepository.findOne(knjigaId);
		if(knjiga == null) {
			throw new IllegalArgumentException("There is no book with given id!");
		}
		

		Glas glas = new Glas();
		glas.setKnjiga(knjiga);
		
		knjiga.setBrojGlasova(knjiga.getBrojGlasova() + 1);
		
		kupovinaRepository.save(glas);
		knjigaRepository.save(knjiga);
			
		return glas;
	}
}
