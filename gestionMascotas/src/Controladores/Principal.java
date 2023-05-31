package Controladores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entidades.mascota;
import Servicios.InterMascota;
import Servicios.implementacionLectura;
import Servicios.implementacionMascota;
import Servicios.interfazLectura;

public class Principal {

	public static void main(String[] args) {
		int opcion =0;
		Scanner leer = new Scanner(System.in);		
		interfazLectura interlec = new implementacionLectura();
		InterMascota interMas= new implementacionMascota ();
		
		do {
			
		List <mascota> mascotas= new ArrayList <mascota>();
		FileReader archivo = interlec.AbrirFichero("C:\\Users\\isidr\\OneDrive\\Escritorio\\Ficheros\\mascotas.txt");
		BufferedReader br = new BufferedReader(archivo);
		interlec.LeerDatos(br, mascotas);
		interlec.CerrarFichero(archivo);
		
		System.out.println("1-Ingresar Mascota");
		System.out.println("2-Mostrar ingresos de Mascotas");
		System.out.println("3-Modificar ingreso de Mascota");
		System.out.println("0-Salir");
		opcion=leer.nextInt();
		
		switch(opcion) {
		case 1:
			interMas.ingresoMascota();
			break;
		case 2:
			interMas.mostrarMascotas(mascotas);
			break;
		case 3:
			interMas.modificarMascota(mascotas);
			break;
		}
			
		}while(opcion!=0);
		leer.close();
		

	}

}
