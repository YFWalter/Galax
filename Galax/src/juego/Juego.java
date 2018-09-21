package juego;

import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

import gui.GUI;

public class Juego {
	private Jugador jugador;
	private GUI gui;
	private Vector<Malo> malo;

	public Juego(GUI gui){
		this.gui=gui;
		
		malo = new Vector<Malo>();

		jugador = new Jugador(20,370,500 );
		gui.add(jugador.getGrafico());

		int x_temp = 370;
		int y_temp = 50;


		for(int i = 0; i < 30; i++){
			
			Random rnd = new Random();
			int r = rnd.nextInt(4);
			
			malo.add(tipoDeMalo(x_temp,y_temp, r));
			
			x_temp +=50;
			if(i > 10)
				y_temp +=30;
			gui.add(malo.get(i).getGrafico());

		}
	}

	public void mover(){
		for(int i = 0 ; i < malo.size()  ; i++) {
				if( i % 2 == 0 )				
					malo.get(i).mover(3);
				else
					malo.get(i).mover(2);
		}
	}

	public void mover(int dir){		
		int direccion = 0;

		switch (dir){

		case KeyEvent.VK_SPACE: //Disparar
			MatarEnemigo(gui);
			break;
		case KeyEvent.VK_LEFT : //Izquierda
			direccion = 2;
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			direccion = 3;
			break;
		}

		jugador.mover(direccion);


	}


	private void MatarEnemigo(GUI gui){
		for(int i=malo.size()-1; i>=0; i--)	
				if(EnemigoAlAlcance(malo.get(i)))
				{		
					gui.remove(malo.get(i).getGrafico());
					malo.remove(i);
					break;
				}
	}

	private boolean EnemigoAlAlcance(Entidad e){
		return (e.getPos().x>=(jugador.getPos().x)-60) && (e.getPos().x<=(jugador.getPos().x)+60);
	}

	private Malo tipoDeMalo(int x,int y,int r){
		Malo m = null;
		switch(r) {
			case 0 : 
				m = new Malo_Uno(30,x,y);
				break;
			case 1 :
				m = new Malo_Dos(20,x,y);
				break;
			case 2 :
				m = new Malo_Tres(15,x,y);
				break;
			case 3 : 
				m = new Malo_Cuatro(10,x,y);
				break;
		}
		return m;
	}
}
