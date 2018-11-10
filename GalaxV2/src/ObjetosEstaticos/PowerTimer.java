package ObjetosEstaticos;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import Inteligencia.Boba;
import Inteligencia.Inteligencia;
import Juego.Logica;
import ObjetosDinamicos.Enemigo;
import Sonido.Sonido;
import Visitor.Visitor;
import Visitor.VisitorPowerTimer;

public class PowerTimer extends PowerUps {

	public PowerTimer(int x, int y,Logica logica) {
		super(x, y,logica);
		visitor = new VisitorPowerTimer();
	}

	@Override
	public String getImage() {
		return "/Graficos/Power_Timer.png";
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
		
	}

	@Override
	public Visitor getVisitor() {
		return visitor;
	}

	public void activar() {
		Sonido sonidoPowerUps = new Sonido("/Sounds/PowerUps.wav");
		sonidoPowerUps.play();
		Map<Enemigo,Inteligencia> mapeo = new HashMap<Enemigo,Inteligencia>();
		Enemigo e = null;
		for(int i = 0 ; i < logica.getEnemigos().size() ; i ++) {
			e = logica.getEnemigos().get(i);
			mapeo.put(e,e.getInteligencia());
			e.setInteligencia(new Boba());
		}
		Timer timer = new Timer();
		TimerTask timertask = new TimerTask() {
			public void run() {
				Enemigo e;
				for(int i = 0 ; i < logica.getEnemigos().size() ; i ++) {
					e = logica.getEnemigos().get(i);
					e.setInteligencia(mapeo.get(e));
				}
			}
		};
		timer.schedule(timertask, 3000);
	}

	@Override
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}

}
