package jwd.wafepa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Stand;

@Repository
public interface StandRepository 
	extends JpaRepository<Stand, Long> {

	Page<Stand> findBySajamId(Long sajamId, Pageable pageRequest);

	@Query("SELECT s FROM Stand s WHERE "
			+ "(:zakupac IS NULL or s.zakupac like :zakupac ) AND "
			+ "(:minP IS NULL OR s.povrsina >= :minP  ) AND "
			+ "(:maxP IS NULL OR s.povrsina <= :maxP)"
			)
	Page<Stand> pretraga(
			@Param("zakupac") String zakupac, 
			@Param("minP") Integer min, 
			@Param("maxP") Integer max,
			Pageable pageRequest);

}
