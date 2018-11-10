package Arma;

import javax.swing.Icon;

public interface Arma {

	public void disparar();
	
	public Arma armaSiguient();
	
	public void cambiarGrafico();
	
	public void setDaño();
	
	public void setGraficoDisparo(Icon icono);
}
