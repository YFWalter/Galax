package juego;

import javax.swing.JLabel;
import Colisionadores.*;

public abstract class Malo extends Entidad{
	private int PuntajeEnemigo;

	public Malo(int velocidad, int x, int y,int puntaje) 
	{
		super(velocidad, x, y);
		PuntajeEnemigo=puntaje;
	}

	public Disparo Disparar()
	{
		return null;
	}

	public abstract String getImage();
	public  int getPuntajeEnemigo()
	{
		return PuntajeEnemigo;
	}
}
