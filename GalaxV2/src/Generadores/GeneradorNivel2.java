package Generadores;

import Juego.Logica;

public class GeneradorNivel2 extends Generador {

	public GeneradorNivel2(Logica log) {
		super(log);
		x_Enemigo = 50;
		y_Enemigo = 50;
		filasMax = 5;
		columnaMax = 7;
		nivelEnemigo = 2;
	}

	@Override
	public Generador getSiguienteGenerador() {
		return new GeneradorNivel3(logica);
	}

}
