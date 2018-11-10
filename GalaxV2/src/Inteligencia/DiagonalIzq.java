package Inteligencia;

import java.awt.Point;

import Disparo.Disparo;
import ObjetosDinamicos.Enemigo;
import ObjetosDinamicos.Jugador;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class DiagonalIzq extends Inteligencia {

	@Override
	public void mover(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(Enemigo personaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(Disparo disparo) {
		Point posicion_disparo = disparo.getPosicion();
		
		int x_disparo = posicion_disparo.x;
		int y_disparo = posicion_disparo.y;
		
		disparo.setPos(disparo.getPosicion().x - disparo.getVelocidad()/2, disparo.getPosicion().y-disparo.getVelocidad());
	
		if(disparo.getGrafico()!=null)
			disparo.getGrafico().setBounds(x_disparo, y_disparo, disparo.getWidth(), disparo.getHeight());
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
