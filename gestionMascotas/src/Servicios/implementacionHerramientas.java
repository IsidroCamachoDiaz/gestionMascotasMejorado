package Servicios;

import java.util.Scanner;

public class implementacionHerramientas implements InterHerramientas {

	@Override
	public boolean preguntaSiNo(String texto) {
		Scanner leer = new Scanner (System.in);
		do {
			System.out.println(texto+"Responda Si o No");
			String respuesta=leer.next();
			
			if(respuesta.equals("Si"))
				return true;
			else if(respuesta.equals("No"))
				return false;
			else
				System.out.println("Responda Si o No");
			
		}while(true);
	}

}
