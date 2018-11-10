package Disparo;

import Inteligencia.*;
import Juego.Logica;
import Visitor.Visitor;
import Visitor.VisitorDisparoJugador;

public class DisparoJugador extends Disparo {

	public DisparoJugador(int x, int y,Logica logica) {
		super(x, y,logica);
		inteligencia = new Arriba();
		daño = 50;
		velocidad = (int) 10.5;
		visitor = new VisitorDisparoJugador();
	}

	@Override
	public String getImage() {
		return "/Graficos/Pokeball.png";
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);		
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
}
