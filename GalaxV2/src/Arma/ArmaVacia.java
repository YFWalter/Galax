package Arma;

import javax.swing.Icon;

public class ArmaVacia implements Arma {

	@Override
	public void disparar() {
	}

	@Override
	public Arma armaSiguient() {
		return this;
	}

	@Override
	public void cambiarGrafico() {
		
	}

	@Override
	public void setDaño() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGraficoDisparo(Icon icono) {
		// TODO Auto-generated method stub
		
	}

}
