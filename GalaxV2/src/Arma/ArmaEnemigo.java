package Arma;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;

import Disparo.Disparo;
import Disparo.DisparoEnemigo;
import Juego.Logica;
import ObjetosDinamicos.Enemigo;

public class ArmaEnemigo implements Arma {

	private Enemigo enemigo;
	private Icon tipoDisparo;

	public ArmaEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}
	
	public void disparar() {				  
    	Timer timer = new Timer();
		TimerTask timertask = new TimerTask() {
			Logica logica = enemigo.getLogica();
			public void run() {
					Disparo disparo = new DisparoEnemigo(enemigo.getPosicion().x +(enemigo.getWidth()/2),enemigo.getPosicion().y,logica);
					disparo.setGrafico(tipoDisparo);
			    	logica.getDisparosEnemigos().add(disparo);
			    	logica.getInterfaz().setImage(disparo.getGrafico());
			}
		};
		timer.schedule(timertask, 100);
	}
	
	@Override
	public Arma armaSiguient() {
		return this;
	}

	@Override
	public void cambiarGrafico() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDaño() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGraficoDisparo(Icon icono) {
		tipoDisparo = icono;
		
	}

}
