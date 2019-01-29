package cine;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

public class Cartelera {

	static List<Pelicula> peliculas;
	
	public Cartelera() {
		peliculas = new ArrayList<Pelicula>();
		leerFichero();
	}

	public static List<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	void leerFichero() {
	    String nombreFichero = "files/cartelera.txt";
	    String linea="";
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

	      //Mientras quede información
	      while (fichero.ready()) {
	        linea = fichero.readLine();
	        String[] trozos = linea.split(";");
	        peliculas.add(new Pelicula(trozos[0],trozos[1],trozos[2],
	        		trozos[3],trozos[4],trozos[5]));
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe){
	        System.out.println("El archivo no se ha encontrado.");
	    }
	    catch(IOException ioe){
	        new RuntimeException("Error de entrada/salida.");
	    }
	 }
	
	public float getPrecio(int personas) {
		float p = (float) 8.5;
		float precio = p*personas;
		return precio;
	}
	
	public float getPrecioConTresDe(int personas) {
		float p = (float) 8.5;
		float precio = (float) (p + (p*0.15));
		
		return precio*personas;
	}
	
	public String muestraSinopsis(String titulo) {
		for(Pelicula p:peliculas) {
			if(p.getTitulo()==titulo) {
				return p.getCodigo() + "\n" + p.getSinopsis();
			}
		}
		return String.valueOf("nada");
	}
	
}
