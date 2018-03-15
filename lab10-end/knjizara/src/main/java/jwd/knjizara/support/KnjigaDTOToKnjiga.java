package jwd.knjizara.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Knjiga;
import jwd.knjizara.service.KnjigaService;
import jwd.knjizara.service.IzdavacService;
import jwd.knjizara.web.dto.KnjigaDTO;

@Component
public class KnjigaDTOToKnjiga 
	implements Converter<KnjigaDTO, Knjiga>{
	
	@Autowired
	private KnjigaService knjigaService;
	@Autowired
	private IzdavacService izdavacService;
	
	
	@Override
	public Knjiga convert(KnjigaDTO source) {
		Knjiga knjiga;
		if(source.getId()==null){
			knjiga = new Knjiga();
			knjiga.setIzdavac(
					izdavacService.findOne(
							source.getIzdavacId()));
		}else{
			knjiga = knjigaService.findOne(source.getId());
		}
		knjiga.setNaziv(source.getNaziv());
		knjiga.setIzdanje(source.getIzdanje());
		knjiga.setPisac(source.getPisac());
		knjiga.setIsbn(source.getIsbn());
		
		return knjiga;
	}

}
