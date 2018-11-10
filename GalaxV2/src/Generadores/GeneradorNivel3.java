package Generadores;

import Juego.Logica;

public class GeneradorNivel3 extends Generador {

	public GeneradorNivel3(Logica log) {
		super(log);
		x_Enemigo = 100;
		y_Enemigo = 0;
		filasMax = 4;
		columnaMax = 5;
		nivelEnemigo = 3;
	}
	
	

	@Override
	public Generador getSiguienteGenerador() {
		return new GeneradorFinal(logica);
	}

}
