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

public class VisitorEnemigo implements Visitor {

	@Override
	public void visit(Jugador jugador) {
		if(!jugador.invulnerable()) {
			Sonido sonidoPerderVida = new Sonido("/Sounds/PerderVida.wav");
			sonidoPerderVida.play();
			jugador.reducirSalud(1);
			jugador.restaurarPosicion();
		}
		if(jugador.getVida() <= 0) {
			jugador.destruirse();
			jugador.getLogica().finalizarJuego();
		}
	}

	@Override
	public void visit(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ObstaculoPasto obstaculoPasto) {
		obstaculoPasto.reducirSalud(1);
		
	}

	@Override
	public void visit(DisparoEnemigo disparoEnemigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DisparoJugador disparoJugador) {
		disparoJugador.destruirse();
		
	}

	@Override
	public void visit(PowerTimer powerTimer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PowerMagia powerDD) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PowerMisil powerMisil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DisparoMisil disparoMisil) {
		disparoMisil.destruirse();
		
	}

	@Override
	public void visit(ObstaculoPared obstaculoPared) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DisparoTriple disparoTriple) {
		disparoTriple.destruirse();
		
	}

	@Override
	public void visit(PowerTriple powerTriple) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ObstaculoArbol obstaculoArbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PowerPocion powerPocion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ObstaculoSnorlax obstaculoSnorlax) {
		// TODO Auto-generated method stub
		
	}

}
