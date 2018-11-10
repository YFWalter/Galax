package Disparo;

import Inteligencia.Arriba;
import Juego.Logica;
import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoMisil extends Disparo{
	
	public DisparoMisil(int x, int y, Logica logica) {
		super(x, y, logica);
		velocidad = (int) 3.2;
		inteligencia = new Arriba();
		visitor = new VisitorDisparoJugador();
		width = 50;
		height = 50;
		daño = 300;
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
	}

	@Override
	public String getImage() {
		return "/Graficos/Superball.png";
	}

	@Override
	public void mover() {
		inteligencia.mover(this);
	}
	
	public int getDaño() {
		return daño;
	}
	
	public void destruirse() {
		logica.removerEntidad(this);
		logica.getDisparos().remove(this);
	}
	
	public void disparar() {
		
	}

}
