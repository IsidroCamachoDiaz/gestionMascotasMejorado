package Entidades;

public class mascota {
String nombre;
String numTelefono;
String fechaEntrada;
String fechaSalida;

public mascota(String nombre, String numTelefono, String fechaEntrada, String fechaSalida) {
	super();
	this.nombre = nombre;
	this.numTelefono = numTelefono;
	this.fechaEntrada = fechaEntrada;
	this.fechaSalida = fechaSalida;
}

@Override
public String toString() {
	return "Mascota;" + nombre + ";" + numTelefono + ";" + fechaEntrada
			+ ";" + fechaSalida;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getNumTelefono() {
	return numTelefono;
}
public void setNumTelefono(String numTelefono) {
	this.numTelefono = numTelefono;
}
public String getFechaEntrada() {
	return fechaEntrada;
}
public void setFechaEntrada(String fechaEntrada) {
	this.fechaEntrada = fechaEntrada;
}
public String getFechaSalida() {
	return fechaSalida;
}
public void setFechaSalida(String fechaSalida) {
	this.fechaSalida = fechaSalida;
}


}
