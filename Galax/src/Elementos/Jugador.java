package Elementos;
import Armas.*;
import javax.swing.*;	//JLabel
import java.util.*;	//algo
import java.awt.*; 	//Point

public class Jugador implements Elemento {

	private int _salud;
	private ArmaJugador _armaJ;
	private JLabel _imagen;
	private Point _posicion;

	public Jugador()
	{	
		_salud=3;
		_armaJ=new ArmaJugador();
		_imagen=new JLabel();
		//Deberia aparecer en el medio del mapa en la ultima fila. Posicion exacta pendiente.
		_posicion.setLocation(JFrame.HEIGHT/2,0);
	}

	public JLabel Imagen()
	{
		return _imagen;
	}

	public void ReducirSalud(int cantidad)
	{
		_salud-=cantidad;
		//Si salud menor a 0 llamar a algun metodo que termine el juego.
	}

	public Point Posicion()
	{
		return _posicion;
	}

	public void Mover(boolean operacion)
	{
		//Asumo que  1 significa mover derecha y 0 mover izquierda
		if (operacion)//derecha
			if (_posicion.getX()!=JFrame.WIDTH) //no estoy en el borde derecho
				_posicion.setLocation(_posicion.getX()+1, 0);
			else	//izquierda
				if(_posicion.getX()!=0) // no estoy en el borde izquierdo 
					_posicion.setLocation(_posicion.getX()-1, 0);
	}

}
