package Inteligencia;

import java.awt.Point;

import Disparo.Disparo;
import ObjetosDinamicos.Enemigo;
import ObjetosDinamicos.Jugador;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class Kamikaze extends Inteligencia {

	@Override
	public void mover(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	public void mover(Enemigo personaje) {

		Point posicionJugador = personaje.getLogica().getJugador().getPosicion();
		Point miPosicion = personaje.getPosicion();

		int x_enemigo = miPosicion.x;
		int y_enemigo = miPosicion.y;

		int x_jugador = posicionJugador.x;

		if (y_enemigo>=LimiteInferior)
			personaje.setPos(x_enemigo,LimiteSuperior);

		if(x_enemigo < x_jugador)
			personaje.setPos(personaje.getPosicion().x + personaje.getVelocidad(), personaje.getPosicion().y);
		else
			if(x_enemigo > x_jugador+25)
				personaje.setPos(personaje.getPosicion().x - personaje.getVelocidad(), personaje.getPosicion().y);

		personaje.setPos(personaje.getPosicion().x, personaje.getPosicion().y+personaje.getVelocidad());

		if(personaje.getGrafico()!=null)
		{	
			personaje.getGrafico().setBounds(personaje.getPosicion().x, personaje.getPosicion().y, personaje.getWidth(), personaje.getHeight());
		}
}

	@Override
	public void mover(Disparo disparo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(Obstaculo obstaculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(PowerUps power) {
		// TODO Auto-generated method stub
		
	}


}
