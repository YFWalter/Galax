package juego;

public abstract class Malo extends Entidad{
	
	public Malo(int velocidad, int x, int y) {
		super(velocidad, x, y);
	}

	public abstract String getImage();
}
