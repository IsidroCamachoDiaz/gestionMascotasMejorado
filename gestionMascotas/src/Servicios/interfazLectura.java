package Servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import Entidades.mascota;

public interface interfazLectura {
	public FileReader AbrirFichero(String ruta);
	public void LeerDatos(BufferedReader br,List <mascota> mas);
	public void CerrarFichero(FileReader fr);

}
