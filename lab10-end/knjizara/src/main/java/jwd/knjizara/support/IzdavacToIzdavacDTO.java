package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Izdavac;
import jwd.knjizara.web.dto.IzdavacDTO;

@Component
public class IzdavacToIzdavacDTO 
	implements Converter<Izdavac, IzdavacDTO> {

	@Override
	public IzdavacDTO convert(Izdavac izdavac) {
		IzdavacDTO izdavacDTO = new IzdavacDTO();
		izdavacDTO.setId(izdavac.getId());
		izdavacDTO.setNaziv(izdavac.getNaziv());
		izdavacDTO.setAdresa(izdavac.getAdresa());
		izdavacDTO.setTelefon(izdavac.getTelefon());
		return izdavacDTO;
	}

	public List<IzdavacDTO> convert(List<Izdavac> izdavaci) {
		List<IzdavacDTO> ret = new ArrayList<>();
		
		for(Izdavac i: izdavaci){
			ret.add(convert(i));
		}
		
		return ret;
	}
}
