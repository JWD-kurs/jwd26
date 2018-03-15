package jwd.knjizara.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Glas;
import jwd.knjizara.web.dto.GlasDTO;

@Component
public class KupovinaToKupovinaDTO implements Converter<Glas, GlasDTO> {

	@Override
	public GlasDTO convert(Glas arg0) {
		
		GlasDTO dto = new GlasDTO();
		dto.setId(arg0.getId());
		
		return dto;
	}

}
