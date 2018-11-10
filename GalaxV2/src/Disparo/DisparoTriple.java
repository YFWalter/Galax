package Disparo;

import Inteligencia.Arriba;
import Juego.Logica;
import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoTriple extends Disparo {

	public DisparoTriple(int x, int y, Logica logica) {
		super(x, y, logica);
		inteligencia = new Arriba();
		velocidad = (int)3.5;
		visitor = new VisitorDisparoJugador();
		daño = 100;
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
		
	}

	@Override
	public String getImage() {
		return "/Graficos/Tripleball.png";
	}

	@Override
	public void mover() {
		inteligencia.mover(this);
	}
	
	public int getDaño() {
		return daño;
	}

	@Override
	public void destruirse() {
		logica.removerEntidad(this);
		logica.getDisparos().remove(this);
	}

}
