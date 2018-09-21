package juego;

import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

public class Juego {
	private Jugador jugador;
	private Vector<Malo> malo;

	public Juego(GUI gui){

		malo = new Vector<Malo>();

		jugador = new Jugador(20,370,500 );
		gui.add(jugador.getGrafico());

		int y_temp = 50;



		}
	}

	public void mover(){
		for(int i = 0 ; i < malo.size()  ; i++) {
		}
	}

	public void mover(int dir){		
		int direccion = 0;

		switch (dir){

		case KeyEvent.VK_LEFT : //Izquierda
			direccion = 2;
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			direccion = 3;
			break;
		}

		jugador.mover(direccion);


	}


		for(int i=malo.size()-1; i>=0; i--)	
	}

	private boolean EnemigoAlAlcance(Entidad e){
		return (e.getPos().x>=(jugador.getPos().x)-30) && (e.getPos().x<=(jugador.getPos().x)+30);
	}

	private Malo tipoDeMalo(int x,int y,int r){
		Malo m = null;
		switch(r) {
		}
		return m;
	}
}
