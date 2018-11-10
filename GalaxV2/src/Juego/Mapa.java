package Juego;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.ObstaculoArbol;
import ObjetosEstaticos.ObstaculoPared;
import ObjetosEstaticos.ObstaculoPasto;
import ObjetosEstaticos.ObstaculoSnorlax;

public class Mapa {
	
	protected Point[][] matriz;

	public Mapa(InputStream inputStream, Logica logica){
		BufferedReader br = null; 
		try{
			br = new BufferedReader(new InputStreamReader(inputStream));
			int fila = Integer.parseInt(br.readLine()); 
			int columna = Integer.parseInt(br.readLine());
			
			matriz = new Point[fila][columna];
			String [] arr = new String[fila];
			String actual,caracter;
			Point posicion;
			Obstaculo obst = null;
			
			for(int i=0; i<fila; i++){
				actual = br.readLine(); 
				arr = actual.split(" ");
				for(int j=0; j<columna; j++){
					caracter = arr[j];
					posicion = new Point(j*50,i*50);
					 
					switch (caracter){
						case "P":{
							obst = new ObstaculoPasto((800-(posicion.x)),(600-posicion.y),logica); 
							break; 
						}
						case "O":{
							obst = new ObstaculoPared((800-(posicion.x+50)),(600-posicion.y),logica);
							break;
						}
						case "A":{
							obst = new ObstaculoArbol(800-(posicion.x),600-posicion.y,logica); 
							break; 
						}
						case "S":{
							obst = new ObstaculoSnorlax(800-(posicion.x),600-posicion.y,logica); 
							break; 
						}
						case "N":{
							obst = null;
							break; 
						}
					}
					matriz[i][j] = posicion; 
					if (obst!=null)
						logica.getObstaculos().add(obst);
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null)
					br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
