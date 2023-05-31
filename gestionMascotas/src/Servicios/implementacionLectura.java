package Servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Entidades.mascota;

public class implementacionLectura implements interfazLectura {

	@Override
	public FileReader AbrirFichero(String ruta) {
		 File fichero = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try {
	    	  
	    	 fichero = new File (ruta);
	         fr = new FileReader (fichero);
	         //br = new BufferedReader(fr);
	         
	      }		
	      catch(FileNotFoundException fnfe){
			  System.out.print("Error: - FICHERO NO ENCONTRARO: " + fichero + "\n" +
			  fnfe); 
	      }
	         return fr;
	      
	}

	@Override
	public void LeerDatos(BufferedReader br,List <mascota> mas) {
		String linea;
		String [] vector;
		try {
		 while((linea=br.readLine())!=null) {
	            vector=linea.split(";");
	            if(vector[0].equals("Mascota")) {
	            	mascota v1= new mascota(vector[1],vector[2],vector[3],vector[4]);
	            	mas.add(v1);
	            }            	
	         }
		}catch(IOException io) {
			System.out.println(io.getMessage());
		}

	}

	@Override
	public void CerrarFichero(FileReader fr) {
		try {
		fr.close();
		}catch(IOException io){
			System.out.println(io.getMessage());
		}

	}

}
