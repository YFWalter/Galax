package Inteligencia;

import Disparo.*;
import ObjetosDinamicos.*;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class Abajo extends Inteligencia{
	
	public void mover(Enemigo personaje){
		if (personaje.getPosicion().y<=LimiteInferior)
			personaje.setPos(personaje.getPosicion().x,LimiteSuperior);
		else		
			personaje.setPos(personaje.getPosicion().x , personaje.getPosicion().y + personaje.getVelocidad());

		if(personaje.getGrafico()!=null)
			personaje.getGrafico().setBounds(personaje.getPosicion().x, personaje.getPosicion().y, personaje.getWidth(), personaje.getHeight());
	}
	
	@Override
	public void mover(Disparo disparo) {
		if(disparo.getPosicion().y >= LimiteInferior)
			disparo.destruirse();
		else
			disparo.setPos(disparo.getPosicion().x , disparo.getPosicion().y + disparo.getVelocidad());

		if(disparo.getGrafico()!=null)
			disparo.getGrafico().setBounds(disparo.getPosicion().x, disparo.getPosicion().y, disparo.getWidth(), disparo.getHeight());
		
		disparo.getLogica().getInterfaz().repaint();
		
	}

	@Override
	public void mover(PowerUps powerUps) {
		powerUps.setPos(powerUps.getPosicion().x , powerUps.getPosicion().y + powerUps.getVelocidad());

		if(powerUps.getGrafico()!=null)
			powerUps.getGrafico().setBounds(powerUps.getPosicion().x, powerUps.getPosicion().y, powerUps.getWidth(), powerUps.getHeight());
		
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
