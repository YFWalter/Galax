package Generadores;

import Juego.Logica;

public class GeneradorFinal extends Generador {

	public GeneradorFinal(Logica log) {
		super(log);
		 x_Enemigo = 150;
		 y_Enemigo = 25;
		 filasMax = 1;
		 columnaMax = 2;
		 nivelEnemigo = 4;
	}

	@Override
	public Generador getSiguienteGenerador() {
		return new GeneradorNivel1(logica);
	}

}
