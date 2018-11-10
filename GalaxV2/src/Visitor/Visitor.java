package Visitor;

import Disparo.DisparoEnemigo;
import Disparo.DisparoJugador;
import Disparo.DisparoMisil;
import Disparo.DisparoTriple;
import ObjetosDinamicos.*;
import ObjetosEstaticos.PowerMagia;
import ObjetosEstaticos.ObstaculoArbol;
import ObjetosEstaticos.ObstaculoPared;
import ObjetosEstaticos.ObstaculoPasto;
import ObjetosEstaticos.ObstaculoSnorlax;
import ObjetosEstaticos.PowerMisil;
import ObjetosEstaticos.PowerPocion;
import ObjetosEstaticos.PowerTimer;
import ObjetosEstaticos.PowerTriple;

public interface Visitor {

	public void visit(Jugador jugador);
	public void visit(Enemigo enemigo);
	public void visit(ObstaculoPasto obstaculoPasto);
	public void visit(ObstaculoPared obstaculoPared);
	public void visit(ObstaculoArbol obstaculoArbol);
	public void visit(ObstaculoSnorlax obstaculoSnorlax);
	public void visit(PowerMisil powerMisil);
	public void visit(PowerTimer powerTimer);
	public void visit(PowerMagia powerDD);
	public void visit(PowerTriple powerTriple);
	public void visit(PowerPocion powerPocion);
	public void visit(DisparoEnemigo disparoEnemigo);
	public void visit(DisparoJugador disparoJugador);
	public void visit(DisparoMisil disparoMisil);
	public void visit(DisparoTriple disparoTriple);
	
}
