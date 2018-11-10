package ObjetosEstaticos;

import Juego.Logica;
import ObjetosDinamicos.Entidad;
import Visitor.Visitable;


public abstract class Obstaculo extends Entidad implements Visitable {
	
	protected boolean cambiarDireccion = false;
	
	public Obstaculo(int x, int y,Logica logica) 
	{
		super(x,y,logica);
		width = 50;
		height = 50;
		daño = 0;
		puntosVida = 1;
		CrearGrafico();
	} 
	
	public void destruirse() {
		logica.getObstaculos().remove(this);
		if(this!=null)
			logica.removerEntidad(this);
	}

}
