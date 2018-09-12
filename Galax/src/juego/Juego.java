package juego;

import java.awt.event.KeyEvent;
import java.util.Random;

import Entrada.KeyBoard;
import gui.GUI;

public class Juego {
	private Malo malos[];
	private Jugador jugador;
	
	public Juego(GUI gui){
		malos = new Malo[4];
		
		jugador = new Jugador(15, 10, 10);
		gui.add(jugador.getGrafico());
		
		for(int i = 0; i < malos.length; i++){
			Random r = new Random();
			malos[i] = new Malo(10, r.nextInt(gui.getWidth() - 100), r.nextInt(gui.getHeight() - 100));
			gui.add(malos[i].getGrafico());
		}
	}
	
	public void mover(){
		for(int i = 0; i < malos.length; i++){
			
			// Inteligencia de los malos
			Random r = new Random();
			
			int dir = r.nextInt(4);
			
			malos[i].mover(dir);
		}
	}
	
	public void mover(int dir){		
		int direccion = 0;
		
		switch (dir){
		/*
			case KeyEvent.VK_UP : //Arriba
				direccion = 0;
				break;
			case KeyEvent.VK_DOWN : //Abajo
				direccion = 1;
				break;
		*/		
			case KeyEvent.VK_LEFT : //Izquierda
				direccion = 2;
				break;
			case KeyEvent.VK_RIGHT : //Derecha
				direccion = 3;
				break;
		}
		
		jugador.mover(direccion);
	}

}
