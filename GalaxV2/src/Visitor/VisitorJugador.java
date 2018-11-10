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

public class VisitorJugador implements Visitor {

	@Override
	public void visit(Jugador jugador) {
		// TODO Auto-generated method stu
	}

	@Override
	public void visit(Enemigo enemigo) {
		enemigo.getLogica().actualizarVidas();
		
	}

	@Override
	public void visit(ObstaculoPasto obstaculoPasto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DisparoEnemigo disparoEnemigo) {
		disparoEnemigo.destruirse();
		disparoEnemigo.getLogica().actualizarVidas();
	}

	@Override
	public void visit(DisparoJugador disparoJugador) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(PowerTimer powerTimer) {
		powerTimer.activar();
		powerTimer.destruirse();
		
	}

	@Override
	public void visit(PowerMagia powerDD) {
		powerDD.activar();
		powerDD.destruirse();
		
	}

	@Override
	public void visit(PowerMisil powerMisil) {
		powerMisil.activar();
		powerMisil.destruirse();
		
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
		powerTriple.activar();
		powerTriple.destruirse();
	}

	@Override
	public void visit(ObstaculoArbol obstaculoArbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PowerPocion powerPocion) {
		powerPocion.activar();
		powerPocion.destruirse();
		
	}

	@Override
	public void visit(ObstaculoSnorlax obstaculoSnorlax) {
		// TODO Auto-generated method stub
		
	}

}
