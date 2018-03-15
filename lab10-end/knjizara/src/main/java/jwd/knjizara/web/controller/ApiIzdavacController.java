package jwd.knjizara.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.knjizara.model.Knjiga;
import jwd.knjizara.model.Izdavac;
import jwd.knjizara.service.KnjigaService;
import jwd.knjizara.service.IzdavacService;
import jwd.knjizara.support.KnjigaToKnjigaDTO;
import jwd.knjizara.support.IzdavacToIzdavacDTO;
import jwd.knjizara.web.dto.KnjigaDTO;
import jwd.knjizara.web.dto.IzdavacDTO;

@RestController
@RequestMapping(value="/api/izdavaci")
public class ApiIzdavacController {
	@Autowired
	private IzdavacService izdavacService;
	@Autowired
	private KnjigaService knjigaService;
	@Autowired
	private IzdavacToIzdavacDTO toDTO;
	@Autowired
	private KnjigaToKnjigaDTO toKnjigaDTO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<IzdavacDTO>> get(){
		return new ResponseEntity<>(
				toDTO.convert(izdavacService.findAll()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<IzdavacDTO> get(
			@PathVariable Long id){
		
		Izdavac izdavac = izdavacService.findOne(id);
		
		if(izdavac == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(izdavac),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{izdavacId}/knjige")
	public ResponseEntity<List<KnjigaDTO>> knjigeIzdavac(
			@PathVariable Long izdavacId,
			@RequestParam(defaultValue="0") int pageNum){
		Page<Knjiga> knjige = knjigaService.findByIzdvacId(pageNum, izdavacId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(knjige.getTotalPages()) );
		return  new ResponseEntity<>(
				toKnjigaDTO.convert(knjige.getContent()),
				headers,
				HttpStatus.OK);
	}
}
