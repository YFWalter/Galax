package Disparo;

import Inteligencia.Abajo;
import Juego.Logica;
import Visitor.Visitor;
import Visitor.VisitorDisparoEnemigo;

public class DisparoEnemigo extends Disparo{

	public DisparoEnemigo(int x, int y,Logica logica) {
		super(x, y,logica);
		inteligencia = new Abajo();
		velocidad = (int)3.5;
		visitor = new VisitorDisparoEnemigo();
		daño = 1;
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return  "/Graficos/Fire_Ball.gif";
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
		
	}
	
	@Override
	public void mover() {
		inteligencia.mover(this);
		
	}
	
	public void destruirse() {
		logica.removerEntidad(this);
		logica.getDisparosEnemigos().remove(this);
	}

	@Override
	public int getDaño() {
		return daño;
	}

}
