package br.com.spotippo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.spotippo.model.PropertyEntity;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
	
	@Modifying
	@Query("select p from PropertyEntity p where (p.x between :ax AND :bx) AND (p.y between :by AND :ay)")
	List<PropertyEntity> buscarImoveisEmSpottipos(@Param("ax") int ax, @Param("ay") int ay, @Param("bx") int bx, @Param("by") int by);
	
}
