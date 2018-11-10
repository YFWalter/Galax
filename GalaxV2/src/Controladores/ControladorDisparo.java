package Controladores;

import java.util.Vector;

import Disparo.*;
import Juego.Logica;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public class ControladorDisparo extends Thread{

	private volatile boolean corriendo = true;
	private Logica logica;
	private Vector<Disparo> disparos;
	private Vector<Disparo> disparosEnemigos;
	private Vector<PowerUps> powerups;
	private Vector<Obstaculo> obstaculos;
	
	public ControladorDisparo(Logica logica) {
		this.logica = logica;
		disparos = logica.getDisparos();
		disparosEnemigos = logica.getDisparosEnemigos();
		powerups = logica.getPowerUps();
		obstaculos = logica.getObstaculos();
	}

	public void run()
	{

		while(corriendo){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				corriendo=false;
			}
			
			moverDisparos();
			moverDisparosEnemigos();
			moverPowerUps();
			moverObstaculos();
		}
	}
	
	
	public void moverDisparos() {
		Disparo disparo = null;
		for(int i = 0 ; i < disparos.size(); i++) {
			disparo = disparos.get(i);
			if(disparo!=null) { 
				logica.colisione(disparo);
				disparo.mover();
			}
		}

	}
	
	public void moverDisparosEnemigos() {
		Disparo disparoEnemigo = null;
		for(int i = 0 ; i < disparosEnemigos.size() ; i++) {
			disparoEnemigo = disparosEnemigos.get(i);
			disparoEnemigo.mover();
			if(disparosEnemigos.size() != 0)
				logica.colisione(disparoEnemigo);
		}
	}
	
	public void moverPowerUps() {
		PowerUps power = null;
		for(int i = 0 ; i < powerups.size() ; i++) {
			power = powerups.get(i);
			power.mover();
			if(powerups.size() != 0)
				logica.colisionePower(power);
		}
	}
	
	public void moverObstaculos() {
		Obstaculo obstaculo = null;
		for(int i = 0 ; i < obstaculos.size() ; i++) {
			obstaculo = obstaculos.get(i);
			obstaculo.mover();
			//if(powerups.size() != 0)
				//logica.colisionePower(power);
		}
	}
	

	public void terminate() {
		corriendo = false;
	}
}
