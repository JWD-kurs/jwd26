package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Sajam;
import jwd.wafepa.web.dto.SajamDTO;

@Component
public class SajamToSajamDTO 
	implements Converter<Sajam, SajamDTO> {

	@Override
	public SajamDTO convert(Sajam sajam) {
		SajamDTO sajamDTO = new SajamDTO();
		sajamDTO.setId(sajam.getId());
		sajamDTO.setNaziv(sajam.getNaziv());
		//TODO konvertovati ostala polja
		return sajamDTO;
	}

	public List<SajamDTO> convert(List<Sajam> sajmovi) {
		List<SajamDTO> ret = new ArrayList<>();
		
		for(Sajam s: sajmovi){
			ret.add(convert(s));
		}
		
		return ret;
	}
}
