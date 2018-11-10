package Inteligencia;

import Disparo.Disparo;
import ObjetosDinamicos.*;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class Derecha extends Inteligencia
{

	public void mover(Enemigo personaje)
	{
		if (personaje.getPosicion().x>=LimiteDerecho)
			personaje.setPos(LimiteIzquierdo,personaje.getPosicion().y);
		else		
			personaje.setPos(personaje.getPosicion().x + personaje.getVelocidad(), personaje.getPosicion().y);

		if(personaje.getGrafico()!=null)
			personaje.getGrafico().setBounds(personaje.getPosicion().x, personaje.getPosicion().y, personaje.getWidth(), personaje.getHeight());
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
	public void mover(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(Obstaculo obstaculo) {
		// TODO Auto-generated method stub
		
	}


}
