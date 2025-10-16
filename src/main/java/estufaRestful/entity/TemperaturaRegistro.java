package estufaRestful.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "temperatura_registro")
public class TemperaturaRegistro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "temperatura", nullable = false)
	private int temperatura;
	
	@Column(name = "hora_registro", nullable = false)
	private int horaRegistro;
	
	@Column(name = "acima_limite")
	private Boolean acimaLimite;
	
	@Column(name = "data_registro", nullable = false)
	private LocalDateTime dataRegistro;
	
	public TemperaturaRegistro() {}

	public TemperaturaRegistro(int temperatura, int horaRegistro, Boolean acimaLimite) {
		this.temperatura = temperatura;
		this.horaRegistro = horaRegistro;
		this.acimaLimite = acimaLimite;
		this.dataRegistro = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(int horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	public Boolean getAcimaLimite() {
		return acimaLimite;
	}

	public void setAcimaLimite(Boolean acimaLimite) {
		this.acimaLimite = acimaLimite;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	

}
