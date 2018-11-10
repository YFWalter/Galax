package ObjetosEstaticos;

import java.util.Timer;
import java.util.TimerTask;
import Juego.Logica;
import Sonido.Sonido;
import Visitor.Visitor;
import Visitor.VisitorPowerDD;

public class PowerMagia extends PowerUps{

	public PowerMagia(int x, int y,Logica logica) {
		super(x, y,logica);
		visitor = new VisitorPowerDD();
	}

	@Override
	public String getImage() {
		return "/Graficos/Power_Estrella.png";
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
	}

	@Override
	public Visitor getVisitor() {
		return visitor;
	}

	@Override
	public void activar() {
		Sonido sonidoPowerUps = new Sonido("/Sounds/PowerUps.wav");
		sonidoPowerUps.play();
		logica.getJugador().siInvulnerable();
		logica.getJugador().cambiarGrafico();
		Timer timer = new Timer();
		TimerTask timertask = new TimerTask() {
			public void run() {
				logica.getJugador().noInvulnerable();
				logica.getJugador().cambiarGrafico();
			}
		};
		timer.schedule(timertask, 5000);
	}

	@Override
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
