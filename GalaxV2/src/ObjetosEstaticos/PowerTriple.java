package ObjetosEstaticos;

import Juego.Logica;
import Sonido.Sonido;
import Visitor.Visitor;
import Visitor.VisitorPowerTriple;

public class PowerTriple extends PowerUps {

	public PowerTriple(int x, int y, Logica logica) {
		super(x, y, logica);
		visitor = new VisitorPowerTriple();
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
	}

	@Override
	public void activar() {
		Sonido sonidoPowerUps = new Sonido("/Sounds/PowerUps.wav");
		sonidoPowerUps.play();
		logica.getJugador().TripleBall();
		logica.actualizarMunicion();
	}

	@Override
	public String getImage() {
		return "/Graficos/Power_Triple.png";
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
