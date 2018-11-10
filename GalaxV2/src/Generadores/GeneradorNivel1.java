package Generadores;

import Juego.Logica;

public class GeneradorNivel1 extends Generador {

	
	
	public GeneradorNivel1(Logica log) {
		super(log);
		 x_Enemigo = 25;
		 y_Enemigo = 25;
		 filasMax = 5;
		 columnaMax = 10;
		 nivelEnemigo = 1;
	}
	
	

	@Override
	public Generador getSiguienteGenerador() {
		return new GeneradorNivel2(logica);
	}

}
