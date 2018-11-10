package Inteligencia;

import java.awt.Point;
import java.awt.event.KeyEvent;

import Disparo.Disparo;
import ObjetosDinamicos.Enemigo;
import ObjetosDinamicos.Jugador;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class EspecialFinal extends Inteligencia {
	
	private boolean izquierda;
	private boolean pase;

	@Override
	public void mover(Jugador jugador) {
			
			switch (codeMover){
	
			case KeyEvent.VK_LEFT : //Izquierda
				if (jugador.getPosicion().x>=LimiteIzquierdo)
				jugador.getPosicion().setLocation(jugador.getPosicion().x - jugador.getVelocidad(), jugador.getPosicion().y);
				break;
			case KeyEvent.VK_RIGHT : //Derecha
				if (jugador.getPosicion().x<=LimiteDerecho)
				jugador.getPosicion().setLocation(jugador.getPosicion().x + jugador.getVelocidad(), jugador.getPosicion().y);
				break;
		}
		
		if(jugador.getGrafico()!=null)
			
			jugador.getGrafico().setBounds(jugador.getPosicion().x, jugador.getPosicion().y, jugador.getWidth(), jugador.getHeight());
	}

	@Override
	public void mover(Enemigo personaje) {
		
		Point posicionJugador = personaje.getLogica().getJugador().getPosicion();
		Point miPosicion = personaje.getPosicion();

		int x_enemigo = miPosicion.x;
		int y_enemigo = miPosicion.y;

		int x_jugador = posicionJugador.x;

		if (y_enemigo>=LimiteInferior) {
			//personaje.setPos(x_enemigo,LimiteSuperior);
			pase = false;
		}
		if(y_enemigo <= LimiteSuperior)
			pase = true;

		if(pase) {
			if(x_enemigo < x_jugador)
				personaje.setPos(personaje.getPosicion().x + personaje.getVelocidad(), personaje.getPosicion().y);
			else
				if(x_enemigo > x_jugador+25)
					personaje.setPos(personaje.getPosicion().x - personaje.getVelocidad(), personaje.getPosicion().y);
			personaje.setPos(personaje.getPosicion().x, personaje.getPosicion().y+personaje.getVelocidad());
		}
		else
			personaje.setPos(personaje.getPosicion().x , personaje.getPosicion().y- personaje.getVelocidad());

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
		if (obstaculo.getPosicion().x<=LimiteIzquierdo)
			izquierda=false;		
	
		if(obstaculo.getPosicion().x>=LimiteDerecho-200)
			izquierda=true;	
	
		if(izquierda)
			obstaculo.setPos(obstaculo.getPosicion().x - obstaculo.getVelocidad(), obstaculo.getPosicion().y);
		else
			obstaculo.setPos(obstaculo.getPosicion().x + obstaculo.getVelocidad(), obstaculo.getPosicion().y);

		if(obstaculo.getGrafico()!=null)
			obstaculo.getGrafico().setBounds(obstaculo.getPosicion().x, obstaculo.getPosicion().y, obstaculo.getWidth(), obstaculo.getHeight());
	}

	@Override
	public void mover(PowerUps power) {
		// TODO Auto-generated method stub
		
	}

}
