package Controladores;

import Arma.Arma;
import Juego.Logica;
import ObjetosDinamicos.*;

public class ControladorEnemigos extends Thread {
	
	private volatile boolean corriendo = true;
	private Logica logica;
	
	public ControladorEnemigos(Logica logica) {
		this.logica = logica;
	}
	
	public void terminate() {
		corriendo = false;
	}
	
	public void run()
	{

		while(corriendo){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				corriendo=false;
			}		
				Enemigo e = null;
				Arma arma = null;
				for(int i = 0 ; i < logica.getEnemigos().size() ; i++) {
			        	 e = logica.getEnemigos().get(i);
			        	 arma = e.getArma();			     
			        	 if(arma != null && logica.jugadorAlcance(e)) {
			        		 		arma.disparar(); 
			        	 }
			        	 logica.colisioneJugador(e);
			        	 e.mover();
				}
		}
	}

	
	
}
