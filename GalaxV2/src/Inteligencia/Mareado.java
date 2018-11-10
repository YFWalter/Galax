package Inteligencia;

import java.util.Random;

import Disparo.Disparo;
import ObjetosDinamicos.Enemigo;
import ObjetosDinamicos.Jugador;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class Mareado extends Inteligencia {

	public void mover(Enemigo personaje) {

		if (personaje.getPosicion().x>=LimiteDerecho)
			personaje.setPos(LimiteIzquierdo,personaje.getPosicion().y);
		
		if(personaje.getPosicion().x<=LimiteIzquierdo)
			personaje.setPos(LimiteDerecho, personaje.getPosicion().y);
		
		if (personaje.getPosicion().y>=LimiteInferior)
			personaje.setPos(personaje.getPosicion().x,LimiteSuperior);

		if (personaje.getPosicion().y<=LimiteSuperior)
			personaje.setPos(personaje.getPosicion().x,LimiteInferior);

		Random rnd = new Random();
		int movimiento=rnd.nextInt(4);
		switch (movimiento) {
		//Izquierda
		case 0:personaje.setPos(personaje.getPosicion().x - personaje.getVelocidad(), personaje.getPosicion().y);
		break;
		//Derecha
		case 1:personaje.setPos(personaje.getPosicion().x + personaje.getVelocidad(), personaje.getPosicion().y);
		break;
		//Arriba
		case 2:personaje.setPos(personaje.getPosicion().x , personaje.getPosicion().y- personaje.getVelocidad());
		break;
		//Abajo
		case 3:personaje.setPos(personaje.getPosicion().x , personaje.getPosicion().y+ personaje.getVelocidad());
		break;
		}

		if(personaje.getGrafico()!=null)
			personaje.getGrafico().setBounds(personaje.getPosicion().x, personaje.getPosicion().y, personaje.getWidth(), personaje.getHeight());

	}

	@Override
	public void mover(Jugador jugador) {
		// TODO Auto-generated method stub
		
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
