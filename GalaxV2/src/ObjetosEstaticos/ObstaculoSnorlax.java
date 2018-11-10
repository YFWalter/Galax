package ObjetosEstaticos;

import Inteligencia.Boba;
import Juego.Logica;
import Visitor.Visitor;
import Visitor.VisitorObstaculoSnorlax;

public class ObstaculoSnorlax extends Obstaculo{

	public ObstaculoSnorlax(int x, int y, Logica logica) {
		super(x, y, logica);
		inteligencia = new Boba();
		visitor = new VisitorObstaculoSnorlax();
		width = 70;
		height = 55;
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
		return "/Graficos/Snorlax.png";
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
