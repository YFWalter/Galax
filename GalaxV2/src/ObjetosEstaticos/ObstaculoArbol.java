package ObjetosEstaticos;

import Inteligencia.Boba;
import Juego.Logica;
import Visitor.Visitor;
import Visitor.VisitorObstaculoArbol;

public class ObstaculoArbol extends Obstaculo {

	public ObstaculoArbol(int x, int y, Logica logica) {
		super(x, y, logica);
		inteligencia = new Boba();
		visitor = new VisitorObstaculoArbol();
		width = 50;
		height = 50;
		CrearGrafico();
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getImage() {
		return "/Graficos/Arbol.png";
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
