package Pack;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class Cliente {
	
	private int dni;
	private String nombre;
	private int telefono;
	private String direccion;
	
	private Mascota[] mascotas = new Mascota[0];
	
	public Cliente(int dni , String nombre , int telefono , String direccion) {
		
		
		
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		
	}
	
	public void imprimirMascotas() {
		
		for(Mascota m : this.mascotas) {
			
			System.out.println("Mascota : " + m.getNombre());
			
		}
		
		
		
	}
	
	public void agregarMascota(String nombre , String raza) {
		boolean existe =this.yaExisteMascota(nombre);
		
		if(existe) {
			System.out.println("Ya existe una mascota con ese nombre , elige otro");
			return;
		}
		
		Mascota mascotaNueva = new Mascota(nombre , raza);
		
		int tamanoMascotas =this.mascotas.length;
		
		Mascota[] nuevaLista = new Mascota[tamanoMascotas + 1];
		
		int index = 0;
		
		for(Mascota m : this.mascotas) {
			nuevaLista[index] = m;
			index = index + 1;
		}
		
		nuevaLista[tamanoMascotas] = mascotaNueva;
		
		this.mascotas = nuevaLista;
		
	}
	
	public boolean yaExisteMascota(String nombre) {
		for(Mascota m:this.mascotas) {
			if(m.getNombre() == nombre) {
				return true;}
		}
		return false;
		
	}
	
	public void vacunarMascota(String nombre , String vacuna) {
		
		for(Mascota m: mascotas) {
			if(m.getNombre() == nombre) {
				m.vacunar(vacuna);
				return;
			}
		System.out.println("error no encontro la mascota");
			
		}
		
		
		
	}
	
	public void masCantidadRaza() {
	    HashMap<String, Integer> contadorRazas = new HashMap<>();

	    for (Mascota m : this.mascotas) {
	        String raza = m.getRaza();
	        contadorRazas.put(raza, contadorRazas.getOrDefault(raza, 0) + 1);
	    }

	    String razaMasComun = null;
	    int maxCantidad = 0;

	    for (Map.Entry<String, Integer> entry : contadorRazas.entrySet()) {
	        if (entry.getValue() > maxCantidad) {
	            razaMasComun = entry.getKey();
	            maxCantidad = entry.getValue();
	        }
	    }

	    if (razaMasComun != null) {
	        System.out.println("La raza más común es: " + razaMasComun + " con " + maxCantidad + " apariciones.");
	    } else {
	        System.out.println("No hay razas registradas.");
	    }
	}
	
	public String proximaVacuna() {
		
		LocalDate[] fechas = new LocalDate[this.mascotas.length];
		LocalDate fechaProxima = LocalDate.now();
		
		for(int i = 0 ; i < this.mascotas.length;i++) {
			if(this.mascotas[i].proximaVacuna() != null) {
				fechas[i] = this.mascotas[i].proximaVacuna();	
			}
		}
		
		for(LocalDate f:fechas) {
			if(f != null) {
				if(fechaProxima.isAfter(f)) {
					fechaProxima = f;
				}
			}
		}
		return "La proxima fecha es : " + fechaProxima;
	}
	
	
}
