package Juego;
import javax.swing.*; //JLabel,JFrame
import Elementos.*;
public class Mapa {

	private	JFrame _mapa;

	public  Mapa(int x,int y)// tamaño del mapa
	{
		_mapa=new JFrame("Galax");
		_mapa.setSize(x, y);
	}

	public void GenerarJugador()
	{
		Jugador j=new Jugador();
		_mapa.getContentPane().add(j.Imagen());

	}

	public void GenerarObstaculos()
	{
		//Deberia generar el mismo item una y otra vez en posiciones especificas
	}

	public void GenerarEnemigos()
	{
		//Deberia crear varios tipos de enemigos ya sea leyendo de un archivo, segun el nivel o generandolos de forma iterativa
	}
}
