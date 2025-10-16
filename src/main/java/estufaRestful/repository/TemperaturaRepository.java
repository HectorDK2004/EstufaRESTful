package estufaRestful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import estufaRestful.entity.TemperaturaRegistro;

public interface TemperaturaRepository extends JpaRepository<TemperaturaRegistro, Long>{
	List<TemperaturaRegistro> findByHoraRegistro (int horaRegistro);
	
	@Query("SELECT COUNT (t) FROM TemperaturaRegistro t WHERE t.acimaLimite = true")
	Long countRegistrosAcimaLimite();
	
	@Query("SELECT MIN (t.temperatura) FROM TemperaturaRegistro t")
	int findMinimaTemperatura();
	
	@Query("SELECT MAX (t.temperatura) FROM TemperaturaRegistro t")
	int findMaximaTemperatura();
	
	@Query("SELECT AVG (t.temperatura) FROM TemperaturaRegistro t")
	Double findMediaTemperatura();
}
