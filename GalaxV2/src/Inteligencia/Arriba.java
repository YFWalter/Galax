package Inteligencia;

import Disparo.Disparo;
import ObjetosDinamicos.Enemigo;
import ObjetosDinamicos.Jugador;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class Arriba extends Inteligencia {
	
	@Override
	public void mover(Enemigo personaje) {
		
		if (personaje.getPosicion().y<=LimiteSuperior) 
			personaje.setPos(personaje.getPosicion().x,LimiteInferior);					
		else		
			personaje.setPos(personaje.getPosicion().x , personaje.getPosicion().y - personaje.getVelocidad());

		if(personaje.getGrafico()!=null)
			personaje.getGrafico().setBounds(personaje.getPosicion().x, personaje.getPosicion().y, personaje.getWidth(), personaje.getHeight());
	}

	@Override
	public void mover(Disparo disparo) {

		if(disparo.getPosicion().y <= LimiteSuperior) {
			//disparo.destruirse();
		}
		else
			disparo.getPosicion().setLocation(disparo.getPosicion().x , disparo.getPosicion().y - disparo.getVelocidad());

		if(disparo.getGrafico()!=null)
			disparo.getGrafico().setBounds(disparo.getPosicion().x, disparo.getPosicion().y, disparo.getWidth(), disparo.getHeight());
		
		disparo.getLogica().getInterfaz().repaint();
		
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
