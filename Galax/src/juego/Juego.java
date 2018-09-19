package juego;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


import gui.GUI;

public class Juego {
	private Malo malos[];
	private Jugador jugador;
	private GUI gui;
	private int EnemigosRestantes=4;

	public Juego(GUI gui){
		this.gui=gui;
		malos = new Malo[4];

		jugador = new Jugador(20,370,500 );
		gui.add(jugador.getGrafico(0));

		int x_temp = 370;
		int y_temp = 50;


		for(int i = 0; i < malos.length; i++){			
			malos[i] = new Malo(50, x_temp,y_temp);			 
			gui.add(malos[i].getGrafico(i));
			y_temp +=50;

		}
	}

	public void mover(){
		for(int i = 0 ; i < malos.length ; i++) {
			if(malos[i]!=null)
				if( i % 2 == 0 )				
					malos[i].mover(3);
				else
					malos[i].mover(2);
		}
	}

	public void mover(int dir){		
		int direccion = 0;

		switch (dir){

		case KeyEvent.VK_SPACE:
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


	private void MatarEnemigo(GUI gui)
	{

		for(int i=malos.length-1; i>=0; i--)	
			if(malos[i]!=null)
				if(EnemigoAlAlcance(malos[i]))
				{		
					gui.remove(malos[i].getGrafico(i));
					malos[i]=null;
					EnemigosRestantes--;
					break;
				}

	}



	private boolean EnemigoAlAlcance(Entidad e)
	{
		return (e.getPos().x>=(jugador.getPos().x)-60) && (e.getPos().x<=(jugador.getPos().x)+60);

	}

}
