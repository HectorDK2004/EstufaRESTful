package estufaRestful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estufaRestful.entity.TemperaturaRegistro;
import estufaRestful.repository.TemperaturaRepository;

@Service
public class EstufaService {

	private final int TEMP_MINIMA = 30;
	private final int TEMP_MAXIMA = 40;

	@Autowired
	private TemperaturaRepository temperaturaRepository;
	
	public TemperaturaRegistro registrarTemperatura(int temperatura, int hora) {
		Boolean acimaLimite = temperatura > TEMP_MAXIMA;
		
		TemperaturaRegistro registro = new TemperaturaRegistro(temperatura, hora, acimaLimite);
		return temperaturaRepository.save(registro);
	}
	
	public RelatorioEstufa gerarRelatorio() {
		Double media = temperaturaRepository.findMediaTemperatura();
		Long contagemAcimaLimite = temperaturaRepository.countRegistrosAcimaLimite();
		int minima = temperaturaRepository.findMinimaTemperatura();
		int maxima = temperaturaRepository.findMaximaTemperatura();
		
		return new RelatorioEstufa (media, contagemAcimaLimite, maxima, minima);
	}
	
	public List<TemperaturaRegistro> listarTodosRegistros(){
		return temperaturaRepository.findAll();
	}
	
	public static class RelatorioEstufa {
		private final Double temperaturaMedia;
		private final Long contagemAcimaLimite;
		private final int temperaturaMinima;
		private final int temperaturaMaxima;
		
		public RelatorioEstufa(Double temperaturaMedia, Long contagemAcimaLimite, int temperaturaMaxima, int temperaturaMinima) {
			this.temperaturaMedia = temperaturaMedia;
			this.contagemAcimaLimite = contagemAcimaLimite;
			this.temperaturaMinima = temperaturaMinima;
			this.temperaturaMaxima = temperaturaMaxima;
		}
		
		public Double getTemperaturaMedia() { return temperaturaMedia; }
        public Long getContagemAcimaLimite() { return contagemAcimaLimite; }
        public Integer getTemperaturaMaxima() { return temperaturaMaxima; }
        public Integer getTemperaturaMinima() { return temperaturaMinima; }
        
	}
	
}
