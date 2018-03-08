package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Stand;
import jwd.wafepa.web.dto.StandDTO;

@Component
public class StandToStandDTO 
	implements Converter<Stand, StandDTO> {

	@Override
	public StandDTO convert(Stand source) {
		StandDTO dto = new StandDTO();
		dto.setId(source.getId());
		dto.setPovrsina(source.getPovrsina());
		dto.setZakupac(source.getZakupac());
		dto.setSajamId(source.getSajam().getId());
		dto.setSajamNaziv(source.getSajam().getNaziv());
		
		return dto;
	}
	
	public List<StandDTO> convert(List<Stand> standovi){
		List<StandDTO> ret = new ArrayList<>();
		
		for(Stand s : standovi){
			ret.add(convert(s));
		}
		
		return ret;
	}

}
