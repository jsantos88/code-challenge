package br.com.spotippo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.spotippo.model.ProvinceEntity;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
	
	@Modifying
	@Query("select p from ProvinceEntity p where (:x between p.boundaries.upperLeft.x AND p.boundaries.bottomRight.x) AND (:y between p.boundaries.bottomRight.y AND p.boundaries.upperLeft.y)")
	List<ProvinceEntity> buscarProvinciasDoImovel(@Param("x") int x, @Param("y") int y);
	
	

}
