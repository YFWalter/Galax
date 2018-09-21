package juego;

public class Jugador extends Entidad{

	public Jugador(int velocidad, int x, int y) {
		super(velocidad, x, y);
	}

	@Override
	public String getImage() {
		
		return "/graficos/Nave.png";
	}
}
