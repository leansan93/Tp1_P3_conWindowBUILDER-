package Negocio;

import java.util.ArrayList;
import java.util.Random;

public class TablaJuego {

	private  int [][] tabla;
	private int tamano ;
	 
	
	/// constructor 
	 public TablaJuego ( int tamano ) {
		 	this.tamano= tamano; // le damos el tamano de la matriz 
 		 	this.tabla= new int [tamano][tamano]; // se crea la tabla con ese tamano 
 		 	
		 	
		  crearTabla(); // crea la tabla sin parametros   
		 
	 }
	 
//------------------------------------------------------------------------------------------------------------------------------	 
	 // crea la tabla   con el random de pintados  con 1 es pintado  y 0 no pintado 
	public  void crearTabla() {
		Random rand = new Random();
		for ( int fil=0 ; fil< tabla.length ; fil ++ ) {
			
			for (int col= 0 ; col < tabla[0].length ; col++) {
				
				 tabla[fil][col] = rand.nextInt(2); // crea entre 1 y 0 el random 
		
			
			}
		
		}
		
	}
		

//----------------------------------------------------------------------------------------------------------------	


	 // muestra como texto a las pistas filas para la interfaz con la matriz creada aleatoria del juego
	
	
	public ArrayList<String> getPistasFilasComoTexto() {
	    int[][] pistas = calculaPistaFila(tabla); // recorre la tabla que se creo 
	    ArrayList<String> resultado = new ArrayList<>();

	    for (int i = 0; i < pistas.length; i++) {
	        StringBuilder sb = new StringBuilder();

	        for (int j = 0; j < pistas[i].length; j++) {
	            if (pistas[i][j] != 0) {
	                sb.append(pistas[i][j]).append(" ");
	            }
	        }

	        if (sb.length() == 0) {
	            sb.append("0"); // si la fila no tiene bloques
	        }

	        resultado.add(sb.toString().trim());
	    }

	    return resultado;
	}
/////////////////////////////////////////////////////////////////////////////////////////
	// calcula la pista fila 
	
	
		public  int [][] calculaPistaFila(int[][] matriz) {
				int filas = matriz.length;
			    int columnas = matriz[0].length;
			     // MATRIZ DONDE SE GUARDARAN LAS PISTAS DE CADA FILA
			     int[][] pistasFilas = new int[filas][columnas];
			     
			     // RECORREMOS CADA FILA DE LA SOLUCION
			     for (int i = 0; i < filas; i++) {
			         int indice = 0;   // POSICION DENTRO DE LA FILA DE PISTAS DONDE SE VA A ESCRIBIR
			         int contador = 0; // CUENTA LA CANTIDAD DE 1 CONSECUTIVOS
			         
			         for (int j = 0; j < columnas; j++) {
			             if (matriz[i][j] == 1) { 
			                 // SI LA CELDA ESTA PINTADA, INCREMENTAMOS EL CONTADOR
			                 contador++;
			             } else {
			                 // SI ENCONTRAMOS UN 0
			                 if (contador > 0) {
			                     // GUARDAMOS LA LONGITUD DEL BLOQUE EN LAS PISTAS
			                     pistasFilas[i][indice++] = contador;
			                     contador = 0; // REINICIAMOS EL CONTADOR
			                 }
			             }
			         }
			         // SI LA FILA TERMINO CON UN BLOQUE DE 1s, TAMBIEN LO GUARDAMOS
			         if (contador > 0) {
			             pistasFilas[i][indice] = contador;
			         }
			     }
			     return pistasFilas;
			}
			
			
			 
		
//-------------------------------------------------------------------------------------------------------------------------------------
/// muestra la pista de las columnas 
		
		public ArrayList<String> getPistasColumnasComoTexto() {
		    int[][] pistas = calculaPistaColumna(tabla); // recorre la tabla que se creo 
		    ArrayList<String> resultado = new ArrayList<>();

		    for (int i = 0; i < pistas.length; i++) {
		        StringBuilder sb = new StringBuilder();

		        for (int j = 0; j < pistas[i].length; j++) {
		            if (pistas[i][j] != 0) {
		                sb.append(pistas[i][j]).append(" ");
		            }
		        }

		        if (sb.length() == 0) {
		            sb.append("0"); // si la fila no tiene bloques
		        }

		        resultado.add(sb.toString().trim());
		    }

		    return resultado;
		}
		
		
		
		
		
		
		
		
//-----------------------------------------------------------------------------		
		//guarda en un ArrayList las pistas de las columnas
			public  int [][] calculaPistaColumna(int[][] tablacreada) {
				 int filas = tablacreada.length;
			     int columnas = tablacreada[0].length;

			     // MATRIZ DONDE SE GUARDARAN LAS PISTAS DE CADA COLUMNA
			     int[][] pistasColumnas = new int[columnas][filas];
			     
			     for (int j = 0; j < columnas; j++) {
			         int indice = 0;   // POSICION DENTRO DE LA COLUMNA DE PISTAS DONDE SE VA A ESCRIBIR
			         int contador = 0; // CUENTA LA CANTIDAD DE 1 CONSECUTIVOS
			         
			         for (int i = 0; i < filas; i++) {
			             if (tablacreada[i][j] == 1) {
			                 // SI LA CELDA ESTA PINTADA, INCREMENTAMOS EL CONTADOR
			                 contador++;
			             } else {
			                 // SI ENCONTRAMOS UN 0
			                 if (contador > 0) {
			                     // GUARDAMOS LA LONGITUD DEL BLOQUE EN LAS PISTAS
			                     pistasColumnas[j][indice++] = contador;
			                     contador = 0; // REINICIAMOS CONTADOR
			                 }
			             }
			         }
			         // SI LA COLUMNA TERMINO CON UN BLOQUE DE 1s, TAMBIEN LO GUARDAMOS
			         if (contador > 0) {
			             pistasColumnas[j][indice] = contador;
			         }
			     }
			     return pistasColumnas;
			}
			

			
			
			
			
			

//--------------------------------------------------------------------------------------------------------------------------------------------
	// ACA HAY QUE CREAR EL METODO DE SI HACERTO LA TABLA PINTADA, en ves de hacer una constante comprobacion de si hacerto o no 
			// le damos la tabla entera luego de que el usuario halla terminado (lo envia por un boton "confirmar") se chequea si hacerto de manera
			// correcta todo seguido sin darle a una x , en el caso de que halla solo uno que se equivoco perdera 
			
			
			
			
//-----------------------------------------------------------------------------------------------------------------------------------------
			// getters and setters de TABLA 
			
			public int[][] getTabla() {
				return tabla;
			}

			public void setTabla(int[][] tabla) {
				this.tabla = tabla;
			}

			public int getTamano() {
				return tamano;
			}

			public void setTamano(int tamano) {
				this.tamano = tamano;
			}
			 
	
	

}
