package ObjetosEstaticos;

import Inteligencia.Abajo;
import Juego.Logica;
import ObjetosDinamicos.Entidad;
import Visitor.Visitable;

public abstract class PowerUps extends Entidad implements Visitable{

	protected final int width = 50;
	protected final int height = 50;
	protected boolean afectar;
	
	protected int probabilidad;
	
	public PowerUps(int x,int y,Logica logica) 
	{
		super(x,y,logica);
		velocidad = (int) 2.5;
		inteligencia = new Abajo();
		puntosVida = 1;
		daño = 0;
		CrearGrafico();
	}
	
	@Override
	public void mover() {
		inteligencia.mover(this);
	}
	
	@Override
	public void destruirse() {
		logica.getPowerUps().remove(this);
		if(this!=null)
			logica.removerEntidad(this);
	}
	
	public abstract void activar();
}
