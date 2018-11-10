package Inteligencia;

import Disparo.Disparo;
import ObjetosDinamicos.*;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class Izquierda extends Inteligencia
{

	public void mover(Enemigo personaje)
	{
		if (personaje.getPosicion().x<=LimiteIzquierdo)
			personaje.setPos(LimiteDerecho,personaje.getPosicion().y);		
		else		
			personaje.setPos(personaje.getPosicion().x - personaje.getVelocidad(), personaje.getPosicion().y);

		if(personaje.getGrafico()!=null)
			personaje.getGrafico().setBounds(personaje.getPosicion().x, personaje.getPosicion().y, personaje.getWidth(), personaje.getHeight());
	}

	@Override
	public void mover(Disparo disparo) {
		
		disparo.setPos(disparo.getPosicion().x - disparo.getVelocidad(), disparo.getPosicion().y);

		if(disparo.getGrafico()!=null)
			disparo.getGrafico().setBounds(disparo.getPosicion().x, disparo.getPosicion().y, disparo.getWidth(), disparo.getHeight());
		
	}

	@Override
	public void mover(PowerUps powerUps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(Obstaculo obstaculo) {
		// TODO Auto-generated method stub
		
	}

}
