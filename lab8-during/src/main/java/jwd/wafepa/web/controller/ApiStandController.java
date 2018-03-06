package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Stand;
import jwd.wafepa.service.StandService;
import jwd.wafepa.support.StandDTOToStand;
import jwd.wafepa.support.StandToStandDTO;
import jwd.wafepa.web.dto.StandDTO;

@RestController
@RequestMapping("/api/standovi")
public class ApiStandController {
	@Autowired
	private StandService standService;
	@Autowired
	private StandToStandDTO toDTO;
	@Autowired
	private StandDTOToStand toStand;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<StandDTO>> get(
			@RequestParam(required=false) String zakupac,
			@RequestParam(required=false) Integer minP,
			@RequestParam(required=false) Integer maxP,
			@RequestParam(defaultValue="0") int pageNum){
		
		Page<Stand> standovi;
		
		if(zakupac != null || minP != null || maxP != null) {
			standovi = standService.pretraga(zakupac, minP, maxP, pageNum);
		}else{
			standovi = standService.findAll(pageNum);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(standovi.getTotalPages()) );
		return  new ResponseEntity<>(
				toDTO.convert(standovi.getContent()),
				headers,
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,
					value="/{id}")
	public ResponseEntity<StandDTO> get(
			@PathVariable Long id){
		Stand stand = standService.findOne(id);
		
		if(stand==null){
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(stand),
				HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<StandDTO> add(
			@RequestBody StandDTO noviStand){
		
		Stand stand = toStand.convert(noviStand); 
		standService.save(stand);
		
		return new ResponseEntity<>(toDTO.convert(stand),
				HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<StandDTO> edit(
			@PathVariable Long id,
			@RequestBody StandDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Stand stand = toStand.convert(izmenjen); 
		standService.save(stand);
		
		return new ResponseEntity<>(toDTO.convert(stand),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public ResponseEntity<StandDTO> delete(@PathVariable Long id){
		standService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
