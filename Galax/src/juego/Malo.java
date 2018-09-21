package juego;

public abstract class Malo extends Entidad{
	int PuntajeEnemigo;
	public Malo(int velocidad, int x, int y,int puntaje) {
		super(velocidad, x, y);
		PuntajeEnemigo=puntaje;
	}

	public abstract String getImage();
	public  int getPuntajeEnemigo()
	{
		return PuntajeEnemigo;
	}
}
