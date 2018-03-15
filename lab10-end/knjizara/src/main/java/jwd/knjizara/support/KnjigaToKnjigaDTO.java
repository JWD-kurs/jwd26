package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Knjiga;
import jwd.knjizara.web.dto.KnjigaDTO;

@Component
public class KnjigaToKnjigaDTO 
	implements Converter<Knjiga, KnjigaDTO> {

	@Override
	public KnjigaDTO convert(Knjiga source) {
		KnjigaDTO dto = new KnjigaDTO();
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setIzdanje(source.getIzdanje());
		dto.setPisac(source.getPisac());
		dto.setIsbn(source.getIsbn());
		dto.setBrojGlasova(source.getBrojGlasova());
		dto.setIzdavacId(source.getIzdavac().getId());
		dto.setIzdavacNaziv(source.getIzdavac().getNaziv());
		
		return dto;
	}
	
	public List<KnjigaDTO> convert(List<Knjiga> knjige){
		List<KnjigaDTO> ret = new ArrayList<>();
		
		for(Knjiga k : knjige){
			ret.add(convert(k));
		}
		
		return ret;
	}

}
