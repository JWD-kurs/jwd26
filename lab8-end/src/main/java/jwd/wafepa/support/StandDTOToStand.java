package jwd.wafepa.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Stand;
import jwd.wafepa.service.SajamService;
import jwd.wafepa.service.StandService;
import jwd.wafepa.web.dto.StandDTO;

@Component
public class StandDTOToStand 
	implements Converter<StandDTO, Stand>{
	
	@Autowired
	private StandService standService;
	@Autowired
	private SajamService sajamService;
	
	
	@Override
	public Stand convert(StandDTO source) {
		Stand stand;
		if(source.getId()==null){
			stand = new Stand();
			stand.setSajam(
					sajamService.findOne(
							source.getSajamId()));
		}else{
			stand = standService.findOne(source.getId());
		}
		stand.setPovrsina(source.getPovrsina());
		stand.setZakupac(source.getZakupac());
		
		
		return stand;
	}

}
