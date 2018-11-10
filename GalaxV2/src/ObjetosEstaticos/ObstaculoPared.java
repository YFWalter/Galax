package ObjetosEstaticos;

import Inteligencia.Loca;
import Juego.Logica;
import Visitor.Visitor;
import Visitor.VisitorObstaculoParedMov;

public class ObstaculoPared extends Obstaculo {
	
	public ObstaculoPared(int x, int y, Logica logica) {
		super(x, y, logica);
		visitor = new VisitorObstaculoParedMov();
		inteligencia = new Loca();
		velocidad = (int)2.5;
		width = 200;
		height = 50;
		CrearGrafico();
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
	}

	@Override
	public void mover() {
		inteligencia.mover(this);
	}


	@Override
	public String getImage() {
		return "/Graficos/ParedMov.png";
	}

	@Override
	public Visitor getVisitor() {
		return visitor;
	}

	@Override
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}

}
