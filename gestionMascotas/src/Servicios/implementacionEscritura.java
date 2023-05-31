package Servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class implementacionEscritura implements interfazEscritura {

	@Override
	public PrintWriter Abrir(String ruta,boolean sobreEscribir) {
		//Se pone los objetos a nulos
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
        	//se pasa la ruta y se pone a true para que sobrecriba y dej alo anterior
            fichero = new FileWriter(ruta,sobreEscribir);
            pw = new PrintWriter(fichero);

        } catch (IOException ioe) {
        	//Si no lo encunetra manada el error
        	System.out.print("[ERROR] - FICHERO NO ENCONTRARO: " + fichero + "\n" + ioe);
        } 
        return pw;
	}
	@Override
	public PrintWriter Escribir(PrintWriter pw,String texto) {
		//Escribe en el fichero
		pw.println(texto);
		return pw;
	}
	
	@Override
	public void Cerrar(PrintWriter fichero) {
		//Cierra el fichero
		fichero.close();
	}
	

}
