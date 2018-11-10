package ObjetosEstaticos;

import Inteligencia.Abajo;
import Juego.Logica;
import Sonido.Sonido;
import Visitor.Visitor;
import Visitor.VisitorPowerPocion;

public class PowerPocion extends PowerUps{

	public PowerPocion(int x, int y, Logica logica) {
		super(x, y, logica);
		visitor = new VisitorPowerPocion();
		inteligencia = new Abajo();
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
		
	}

	@Override
	public void activar() {
		Sonido sonidoPowerUps = new Sonido("/Sounds/RecuperarVida.wav");
		sonidoPowerUps.play();
		logica.getJugador().sumarVida();
		logica.actualizarVidas();
		
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return "/Graficos/Power_Pocion.png";
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
