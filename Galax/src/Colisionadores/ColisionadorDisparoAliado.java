package Colisionadores;

import juego.*;

public class ColisionadorDisparoAliado implements Colisionador {

public void GolpearAliado(Jugador entidad){}//no deberia ocurrir
	
	public void GolpearEnemigo(Malo entidad)
	{

	}
	
	public void GolpearObstaculo(Pared obstaculo)
	{
		obstaculo.Matar();
	}
	
	public void GolpearPowerUp(Entidad entidad)
	{
		
	}
}
