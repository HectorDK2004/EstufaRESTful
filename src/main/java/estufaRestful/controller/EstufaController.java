package estufaRestful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import estufaRestful.entity.TemperaturaRegistro;
import estufaRestful.service.EstufaService;

@RestController
@RequestMapping("/api/estufa")
public class EstufaController {

	@Autowired
	private EstufaService estufaService;
	
	@PostMapping("/registrar")
	public ResponseEntity<TemperaturaRegistro> registrarTemperatura (@RequestParam int temperatura, @RequestParam int hora){
		if (hora < 0 || hora > 23) {
			return ResponseEntity.badRequest().body(null);
		}
		
		TemperaturaRegistro registro = estufaService.registrarTemperatura(temperatura, hora);
		return ResponseEntity.ok(registro);
	}
	
	@GetMapping("/relatorio")
	public ResponseEntity<EstufaService.RelatorioEstufa> gerarRelatorio() {
		EstufaService.RelatorioEstufa relatorio = estufaService.gerarRelatorio();
		return ResponseEntity.ok(relatorio);
	}
	
	@GetMapping("/registros")
	public ResponseEntity<List<TemperaturaRegistro>> listarRegistros() {
		List<TemperaturaRegistro> registros = estufaService.listarTodosRegistros();
		return ResponseEntity.ok(registros);	
	}

}
