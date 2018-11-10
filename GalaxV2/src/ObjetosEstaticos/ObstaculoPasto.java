package ObjetosEstaticos;

import Inteligencia.Loca;
import Juego.Logica;
import Visitor.Visitor;
import Visitor.VisitorObstaculoPasto;

public class ObstaculoPasto extends Obstaculo{

	public ObstaculoPasto(int x, int y,Logica logica) {
		super(x, y,logica);
		
		inteligencia = new Loca();
		visitor = new VisitorObstaculoPasto();
		puntosVida = 3;
	}
	
	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
		
	}

	@Override
	public String getImage() {
		
		return "/Graficos/Pared.png";
	}
	
	@Override
	public Visitor getVisitor() {
		return visitor;
	}
	
	@Override
	public void mover() {
		inteligencia.mover(this);
	}

	@Override
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}

}
