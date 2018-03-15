package jwd.knjizara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.knjizara.model.Izdavac;

@Repository
public interface IzdavacRepository 
	extends JpaRepository<Izdavac, Long> {

}
