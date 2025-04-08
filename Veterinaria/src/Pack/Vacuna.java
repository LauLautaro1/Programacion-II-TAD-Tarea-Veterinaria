package Pack;

import java.time.*;

public class Vacuna {
	private LocalDate fecha;
	private String nombreVac;
	private LocalDate fechaDeProximaDosis;
	
	public Vacuna(LocalDate fecha , String nombreVac , LocalDate fechaDeProximaDosis) {
		this.fecha = fecha;
		this.nombreVac = nombreVac;
		this.fechaDeProximaDosis = fechaDeProximaDosis;
	}
	
	public String getNombreVac() {
		return nombreVac;
	}
	
	public LocalDate getFechaDeProximaDosis() {
		return fechaDeProximaDosis;
	}

	public void imprimirDatos() {
		System.out.println("Nombre de VACUNA : " + this.nombreVac + 
				"  Fecha de ultima dosis : " + this.fecha +
				"  fecha de siguiente dosis : " + this.fechaDeProximaDosis);
	}
}
