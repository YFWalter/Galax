package Visitor;

import Disparo.DisparoEnemigo;
import Disparo.DisparoJugador;
import Disparo.DisparoMisil;
import Disparo.DisparoTriple;
import ObjetosDinamicos.Enemigo;
import ObjetosDinamicos.Jugador;
import ObjetosEstaticos.PowerMagia;
import ObjetosEstaticos.ObstaculoArbol;
import ObjetosEstaticos.ObstaculoPared;
import ObjetosEstaticos.ObstaculoPasto;
import ObjetosEstaticos.ObstaculoSnorlax;
import ObjetosEstaticos.PowerMisil;
import ObjetosEstaticos.PowerPocion;
import ObjetosEstaticos.PowerTimer;
import ObjetosEstaticos.PowerTriple;
import Sonido.Sonido;

public class VisitorDisparoJugador implements Visitor {

	@Override
	public void visit(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Enemigo enemigo) {
		if(enemigo.getVida() <= 0) {
			Sonido sonidoMatarEnemigo = new Sonido("/Sounds/MatarEnemigo.wav");
			sonidoMatarEnemigo.play();
			enemigo.crearPowerUp();
			enemigo.getLogica().actualizarPuntaje(enemigo);
			enemigo.destruirse();
			enemigo.getLogica().actualizar();
		}
	}

	@Override
	public void visit(ObstaculoPasto obstaculoPasto) {
		obstaculoPasto.reducirSalud(1);
		if(obstaculoPasto.getVida() <= 0)
			obstaculoPasto.destruirse();
	}

	@Override
	public void visit(DisparoEnemigo disparoEnemigo) {
		disparoEnemigo.destruirse();
		
	}

	@Override
	public void visit(DisparoJugador disparoJugador) {
		//disparoJugador.reducirSalud();
	}

	@Override
	public void visit(DisparoMisil disparoMisil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ObstaculoPared obstaculoPared) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DisparoTriple disparoTriple) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PowerTriple powerTriple) {
		powerTriple.destruirse();
		
	}
	
	@Override
	public void visit(PowerPocion powerPocion) {
		powerPocion.destruirse();
		
	}
	
	@Override
	public void visit(PowerTimer powerTimer) {
		powerTimer.destruirse();
		
	}

	@Override
	public void visit(PowerMagia powerDD) {
		powerDD.destruirse();
		
	}

	@Override
	public void visit(PowerMisil powerMisil) {
		powerMisil.destruirse();
		
	}

	@Override
	public void visit(ObstaculoArbol obstaculoArbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ObstaculoSnorlax obstaculoSnorlax) {
		// TODO Auto-generated method stub
		
	}

}
