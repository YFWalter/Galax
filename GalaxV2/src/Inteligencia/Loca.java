package Inteligencia;

import Disparo.Disparo;
import ObjetosDinamicos.Enemigo;
import ObjetosDinamicos.Jugador;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class Loca extends Inteligencia {
	
	public boolean izquierda;

	@Override
	public void mover(Jugador jugador) {
	}

	@Override
	public void mover(Enemigo personaje) {
	}

	@Override
	public void mover(Disparo disparo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(PowerUps powerUps) {
		// TODO Auto-generated method stub
	}

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


}
