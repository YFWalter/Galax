package Disparo;

import java.util.Vector;
import Juego.Logica;
import ObjetosDinamicos.Entidad;
import Visitor.Visitor;

public abstract class Disparo extends Entidad{
	
	Vector<Disparo> disparos;
	
	public Disparo(int x ,int y,Logica logica) {
		super(x,y,logica);
		height = 25;
		width = 25;
		puntosVida =1;
	}
	
	public abstract String getImage();
	
	@Override
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void setDaño(int d) {
		daño = d;
	}
	
}
