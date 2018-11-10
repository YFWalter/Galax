package Inteligencia;

import java.awt.event.KeyEvent;

import Disparo.Disparo;
import ObjetosDinamicos.Enemigo;
import ObjetosDinamicos.Entidad;
import ObjetosDinamicos.Jugador;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;


public class Humana extends Inteligencia{
	
	
	@Override
	public void mover(Jugador jugador) {
				
			switch (codeMover){

				case KeyEvent.VK_LEFT : //Izquierda
					moverDerecha(jugador);
					break;
				case KeyEvent.VK_RIGHT : //Derecha
					moverIzquierda(jugador);
					break;
			}
			
			if(jugador.getGrafico()!=null)
				
				jugador.getGrafico().setBounds(jugador.getPosicion().x, jugador.getPosicion().y, jugador.getWidth(), jugador.getHeight());
		
	}
	

	private void moverDerecha(Entidad personaje) {
		
		if (personaje.getPosicion().x<=LimiteIzquierdo)				
			personaje.getPosicion().setLocation(LimiteDerecho,personaje.getPosicion().y);
		else
			personaje.getPosicion().setLocation(personaje.getPosicion().x - personaje.getVelocidad(), personaje.getPosicion().y);
	}
	
	private void moverIzquierda(Entidad personaje) {
		
		if (personaje.getPosicion().x>=LimiteDerecho)
			personaje.getPosicion().setLocation(LimiteIzquierdo,personaje.getPosicion().y);
		else		
			personaje.getPosicion().setLocation(personaje.getPosicion().x + personaje.getVelocidad(), personaje.getPosicion().y);
	}

	
	@Override
	public void mover(Disparo disparo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(PowerUps powerUps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(Enemigo personaje) {
		switch (codeMover){

		case KeyEvent.VK_LEFT : //Izquierda
			moverDerecha(personaje);
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			moverIzquierda(personaje);
			break;
	}
	
	if(personaje.getGrafico()!=null)
		personaje.getGrafico().setBounds(personaje.getPosicion().x, personaje.getPosicion().y, personaje.getWidth(), personaje.getHeight());
	} 

	@Override
	public void mover(Obstaculo obstaculo) {
		// TODO Auto-generated method stub
		
	}
}
