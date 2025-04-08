package Pack;

import java.time.*;

public class Mascota {
	private String nombre;
	private String raza;
	private Vacuna[] vacunas = new Vacuna[0];
	
	public Mascota(String nombre , String raza) {
		this.nombre = nombre;
		this.raza = raza;
	}
	
	public void vacunar(String vacunaNombre) {
		int tamanoVacunas = this.vacunas.length;
		
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaSiguiente = fechaActual.plusMonths(1);
		
		Vacuna vacunaNueva  = new Vacuna(fechaActual , vacunaNombre , fechaSiguiente);
		
		Vacuna[] nuevaLista = new Vacuna[tamanoVacunas + 1];
		int index = 0;
		
		for(Vacuna v: this.vacunas) {
			
			nuevaLista[index] = v;
			
			index = index + 1;
		}
		
		nuevaLista[tamanoVacunas] = vacunaNueva;
		
		this.vacunas = nuevaLista;
		
	}
	
	public boolean tieneVacunas() {
		
		for(int i =0;i < this.vacunas.length ;i++) {
			if(this.vacunas[i] == null) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public LocalDate proximaVacuna() {
		
		if(this.tieneVacunas() == false) {
			System.out.println("HASTA AQUI");
			return null;
		}
		
		LocalDate fechaComprobar = null;
		
		for(Vacuna v: this.vacunas) {
			
			LocalDate fechaDeVacuna = v.getFechaDeProximaDosis();
			
			if(fechaComprobar == null) {
				fechaComprobar = fechaDeVacuna; 
			}
			if(fechaComprobar.isBefore(fechaDeVacuna)) {
				fechaComprobar = fechaDeVacuna;
			}
		}
		return fechaComprobar;
	}
	
	
	public String getRaza() {
		return this.raza;
	}

	public String getNombre() {
		return this.nombre;
	}

}
