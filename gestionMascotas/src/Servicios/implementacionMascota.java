package Servicios;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import Entidades.mascota;

public class implementacionMascota implements InterMascota {

	@Override
	public void mostrarMascotas(List<mascota> mas) {
		if(mas.isEmpty())
			System.out.println("No has ingresado ninguna Mascota");
		else {
			for(int i=0;i<mas.size();i++) {
				if(mas.get(i).getFechaSalida().equals("-"))
					System.out.println("Nombre del paciente: "+mas.get(i).getNombre()+" Numero de telefono del propietario: "+mas.get(i).getNumTelefono()+" Fecha de Entrada: "+mas.get(i).getFechaEntrada());
				else
					System.out.println("Nombre del paciente: "+mas.get(i).getNombre()+" Numero de telefono del propietario: "+mas.get(i).getNumTelefono()+" Fecha de Entrada: "+mas.get(i).getFechaEntrada()+" Fecha de Salida: "+mas.get(i).getFechaSalida());
			}
		}

	}

	@Override
	public void ingresoMascota() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Nombre de la mascota: ");
		String nombre= leer.next();
		System.out.println("Numero de telefono del dueño: ");
		String telefono = leer.next();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String fechaCadena="-";
		String fechaCadena2="-";
		boolean bien=true;
		do {
			bien =true;
		System.out.println("Escriba la fecha de ingreso en la siguiente forma: dd-mm-yyyy");
		try {
		fechaCadena=leer.next();
		sdf.parse(fechaCadena);
		}catch(ParseException pe) {
			System.out.println("Error: No escribio de la siguiente forma: dd-mm-yyyy o no puso una fecha correcta");
			bien =false;
		}


		System.out.println("Escriba la fecha de salida en la siguiente forma: dd-mm-yyyy si no ha salido ponga una -");
		try {
		fechaCadena2=leer.next();
			if(fechaCadena2.equals("-"))
				fechaCadena2="0-00-0000";		
		sdf.parse(fechaCadena2);		
			if(fechaCadena2.equals("0-00-0000"))
				fechaCadena2="-";
		
		}catch(ParseException pe) {
			System.out.println("Error: No escribio de la siguiente forma: dd-mm-yyyy o no puso una fecha correcta");
			bien =false;
		}
		if(bien && !fechaCadena2.equals("-")) {
			String [] vector;
			vector=fechaCadena.split("-");
			int diaIngreso=Integer.parseInt(vector[0]);
			int mesIngreso=Integer.parseInt(vector[1]);
			int anyoIngreso=Integer.parseInt(vector[2]);
			vector=fechaCadena2.split("-");
			int diaSalida=Integer.parseInt(vector[0]);
			int mesSalida=Integer.parseInt(vector[1]);
			int anyoSalida=Integer.parseInt(vector[2]);
			if(anyoIngreso>anyoSalida) {
				System.out.println("Error: Puso una fecha de salida inferior a la de ingreso");
				bien=false;
			}
			else {
				if(mesIngreso>mesSalida&&anyoIngreso==anyoSalida) {
					System.out.println("Error: Puso una fecha de salida inferior a la de ingreso");
					bien=false;
				}
				else {
					if(diaIngreso>diaSalida&&mesIngreso==mesSalida) {
						System.out.println("Error: Puso una fecha de salida inferior a la de ingreso");
						bien=false;
				}
				}
			}
		}
		}while(!bien);
		mascota m1= new mascota(nombre,telefono,fechaCadena,fechaCadena2);
		interfazEscritura interEs = new implementacionEscritura();
		PrintWriter pw=interEs.Abrir("C:\\Users\\isidr\\OneDrive\\Escritorio\\Ficheros\\mascotas.txt",true);
		interEs.Escribir(pw, m1.toString());
		interEs.Cerrar(pw);
	}

	@Override
	public void modificarMascota(List<mascota> mas) {
		Scanner leer = new Scanner (System.in);
		System.out.println("Ingrese el telefono del propietario: ");
		String telefonoBuscar= leer.next();
		InterHerramientas herra= new implementacionHerramientas();
		for(int i=0;i<mas.size();i++) {
			if(mas.get(i).getNumTelefono().equals(telefonoBuscar)) {
				if(mas.get(i).getFechaSalida().equals("-"))
					System.out.println("Nombre del paciente: "+mas.get(i).getNombre()+" Numero de telefono del propietario: "+mas.get(i).getNumTelefono()+" Fecha de Entrada: "+mas.get(i).getFechaEntrada());
				else
					System.out.println("Nombre del paciente: "+mas.get(i).getNombre()+" Numero de telefono del propietario: "+mas.get(i).getNumTelefono()+" Fecha de Entrada: "+mas.get(i).getFechaEntrada()+" Fecha de Salida: "+mas.get(i).getFechaSalida());
				
				if(herra.preguntaSiNo("Quiere modificar la fecha de salida")) {
					String fechaCadena2="-";
					boolean bien=true;
					do {
					System.out.println("Escriba la fecha de salida en la siguiente forma: dd-mm-yyyy si no ha salido ponga una -");
					try {
					fechaCadena2=leer.next();
						if(fechaCadena2.equals("-"))
							fechaCadena2="0-00-0000";	
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					sdf.parse(fechaCadena2);		
						if(fechaCadena2.equals("0-00-0000"))
							fechaCadena2="-";
					
					}catch(ParseException pe) {
						System.out.println("Error: No escribio de la siguiente forma: dd-mm-yyyy o no puso una fecha correcta");
						bien =false;
					}
					
					}while(!bien);
					mas.get(i).setFechaSalida(fechaCadena2);
					
					interfazEscritura interEs = new implementacionEscritura();
					PrintWriter pw=interEs.Abrir("C:\\Users\\isidr\\OneDrive\\Escritorio\\Ficheros\\mascotas.txt",false);
					for(int e=0;e<mas.size();e++) {
					interEs.Escribir(pw, mas.get(e).toString());
					}
					interEs.Cerrar(pw);
				}
			}
		}

	}

}
