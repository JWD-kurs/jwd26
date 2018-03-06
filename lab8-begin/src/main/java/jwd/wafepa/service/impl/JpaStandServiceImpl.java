package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Stand;
import jwd.wafepa.repository.StandRepository;
import jwd.wafepa.service.StandService;

@Service
@Transactional
public class JpaStandServiceImpl implements StandService {
	
	@Autowired
	private StandRepository standRepository;

	@Override
	public Page<Stand> findAll(int pageNum) {
		return standRepository.findAll(
				new PageRequest(pageNum, 5));
	}

	@Override
	public Stand findOne(Long id) {
		return standRepository.findOne(id);
	}

	@Override
	public void save(Stand stand) {
		standRepository.save(stand);
	}

	@Override
	public void remove(Long id) {
		standRepository.delete(id);
	}

	@Override
	public Page<Stand> findBySajamId(int pageNum, Long sajamId) {
		
		return standRepository.findBySajamId(sajamId, new PageRequest(pageNum, 5));
	}

	@Override
	public Page<Stand> pretraga(String zakupac, Integer min, Integer max, int page) {
		if(zakupac != null ){
			zakupac = "%" + zakupac + "%";
		}
		return standRepository.pretraga(zakupac, min, max, new PageRequest(page, 5));
	}

}
