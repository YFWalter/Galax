package Colisionadores;
import juego.*;


public interface Colisionador {

	public void GolpearAliado(Jugador entidad);
	public void GolpearEnemigo(Malo entidad);
	public void GolpearObstaculo(Pared obstaculo);
	public void GolpearPowerUp(Entidad entidad);
}
