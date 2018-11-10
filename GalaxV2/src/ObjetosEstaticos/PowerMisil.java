package ObjetosEstaticos;

import Juego.Logica;
import Sonido.Sonido;
import Visitor.Visitor;
import Visitor.VisitorPowerMisil;

public class PowerMisil extends PowerUps {

	public PowerMisil(int x, int y, Logica logica) {
		super(x, y, logica);
		visitor = new VisitorPowerMisil();
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
	}

	@Override
	public String getImage() {
		return "/Graficos/Power_Misil.png";
	}

	@Override
	public Visitor getVisitor() {
		return visitor;
	}

	@Override
	public void activar() {
		Sonido sonidoPowerUps = new Sonido("/Sounds/PowerUps.wav");
		sonidoPowerUps.play();
		logica.getJugador().SuperBall();
		logica.actualizarMunicion();
	}

	@Override
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}

}
