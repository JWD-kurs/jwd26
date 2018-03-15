package jwd.knjizara.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Izdavac;
import jwd.knjizara.repository.IzdavacRepository;
import jwd.knjizara.service.IzdavacService;

@Service
@Transactional
public class JpaIzdavacServiceImpl implements IzdavacService {
	@Autowired
	private IzdavacRepository izdavacRepository;

	@Override
	public List<Izdavac> findAll() {
		return izdavacRepository.findAll();
	}

	@Override
	public Izdavac findOne(Long id) {
		return izdavacRepository.findOne(id);
	}

	@Override
	public void save(Izdavac izdavac) {
		izdavacRepository.save(izdavac);
	}

	@Override
	public void remove(Long id) {
		izdavacRepository.delete(id);
	}

	
	
}
