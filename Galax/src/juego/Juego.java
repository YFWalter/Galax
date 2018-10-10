package juego;

import java.awt.event.KeyEvent;
import juego.*;
import Colisionadores.*;
import Movimientos.*;
import java.util.Random;
import java.util.Vector;
import javax.swing.JLabel;
import gui.*;

public class Juego {
	private Jugador jugador;
	private Vector<Malo> malo;
	private Vector<Pared> paredes;
	private Vector<DisparoAliado> disparosJugador;
	private int PuntajeJuego=0;
	private GUI interfaz;

	public Juego(GUI gui){
		interfaz=gui;
		malo = new Vector<Malo>();
		paredes=new Vector<Pared>();

		jugador = new Jugador(20,370,500 );
		gui.add(jugador.getGrafico());

		disparosJugador=new Vector<DisparoAliado>();
		MovimientoDisparosAliados moverDisparosAliados=new MovimientoDisparosAliados(disparosJugador);
		moverDisparosAliados.start();

		int x_temp = 25;
		int y_temp = 50;

		//Añadir enemigos 1 por 1
		for(int j=0;j<3;j++)//filas
		{
			for(int i = 0; i < 10; i++)//columnas
			{

				Random rnd = new Random();
				int r = rnd.nextInt(4);
				malo.add(tipoDeMalo(x_temp,y_temp, r));
				x_temp +=75;
				gui.add(malo.get(j*10+i).getGrafico());
			}
			//Al cambiar de fila reseteo el X y aumento el Y para insertar en nueva fila
			y_temp +=75;
			x_temp=25;	
		}

		//Añadir obstaculos 1 por 1
		int XPared=-20;
		int YPared=300;
		for(int j=0;j<4;j++)//Grupos
		{
			for(int i = 0; i < 4; i++)
			{
				paredes.add(new Pared(0,XPared,YPared));
				gui.add(paredes.get(j*4+i).getGrafico());
				XPared+=35;
			}
			//Al cambiar de fila reseteo el X y aumento el Y para insertar en nueva fila
			XPared +=75;	
		}

	}

	public void moverEnemigos()
	{
		MovimientoEnemigos moverEnemigos=new MovimientoEnemigos(malo);
		moverEnemigos.start();
	}

	public void mover(int dir){		

		switch (dir){

		case KeyEvent.VK_LEFT : //Izquierda
			jugador.mover(jugador.MoverIzquierda);
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			jugador.mover(jugador.MoverDerecha);
			break;
		}

	}


	public Entrada<JLabel,Integer>  MatarEnemigo()
	{
		Entrada <JLabel,Integer> aRetornar=new Entrada<JLabel,Integer>(null,null);

		for(int i=malo.size()-1; i>=0; i--)	
			if(EnemigoAlAlcance(malo.get(i)))
			{		
				aRetornar.setClave(malo.get(i).getGrafico());
				aRetornar.setValor(i);
				return aRetornar;
			}
		return null; //no encontre enemigo
	}

	public void RemoverEnemigo(int i)
	{
		PuntajeJuego+=malo.get(i).getPuntajeEnemigo();
		malo.remove(i);
	}

	private boolean EnemigoAlAlcance(Entidad e){
		return(jugador.getPos().x+37.5>=e.getPos().x)&&(jugador.getPos().x+37.5<=e.getPos().x+75);
	}

	private Malo tipoDeMalo(int x,int y,int r){
		Malo m = null;
		int velocidadEnemigo=20;
		switch(r) {
		case 0 : 
			m = new Malo_Uno(velocidadEnemigo,x,y,100);
			break;
		case 1 :
			m = new Malo_Dos(velocidadEnemigo,x,y,200);
			break;
		case 2 :
			m = new Malo_Tres(velocidadEnemigo,x,y,300);
			break;
		case 3 : 
			m = new Malo_Cuatro(velocidadEnemigo,x,y,400);
			break;
		}
		return m;
	}

	public DisparoAliado GenerarDisparo()
	{
		DisparoAliado disparo=jugador.Disparar(malo,disparosJugador,paredes,interfaz);
		disparosJugador.add(disparo);
		return disparo;
	}

	public int getPuntajeJuego()
	{
		return PuntajeJuego;
	}

}
