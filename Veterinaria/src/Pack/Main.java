package Pack;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente papucho = new Cliente(555 , "papucho" , 234 , "Echeverri");
		
		papucho.agregarMascota("Sara", "Perro");
		
		papucho.agregarMascota("luther", "Perro");

		papucho.imprimirMascotas();
		
		papucho.vacunarMascota("Sara", "Cas");
		papucho.vacunarMascota("Sara", "Miaui");
		papucho.vacunarMascota("Sara", "Coli");
		
		papucho.masCantidadRaza();
		
		
	
		
	}

}

