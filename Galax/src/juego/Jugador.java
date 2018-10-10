package juego;
import Colisionadores.*;
import gui.GUI;

import java.util.Vector;

import javax.swing.JLabel;
public class Jugador extends Entidad{

	public Jugador(int velocidad, int x, int y) {
		super(velocidad, x, y);
		colisionador=new ColisionadorAliado();
	}


	public DisparoAliado Disparar(Vector<Malo> enemigos,Vector<DisparoAliado>disparosAliados,Vector<Pared>paredes,GUI interfaz)
	{
		DisparoAliado disparo=new DisparoAliado(1,new ColisionadorDisparoAliado(),pos.x,pos.y,25,enemigos,paredes,interfaz,disparosAliados);
		return disparo;
	}
	

	public String getImage() {

		return "/graficos/Nave.png";
	}
}
