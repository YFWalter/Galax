package juego;

import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;
import javax.swing.JLabel;
import gui.*;

public class Juego {
	private Jugador jugador;
	private Vector<Malo> malo;
	private int PuntajeJuego=0;

	public Juego(GUI gui){

		malo = new Vector<Malo>();

		jugador = new Jugador(20,370,500 );
		gui.add(jugador.getGrafico());

		int x_temp = 25;
		int y_temp = 50;


		for(int j=0;j<3;j++)//filas
			for(int i = 0; i < 10; i++)//columnas
			{

				Random rnd = new Random();
				int r = rnd.nextInt(4);
				malo.add(tipoDeMalo(x_temp,y_temp, r));
				x_temp +=75;
				gui.add(malo.get(j*10+i).getGrafico());
			}
	}

	public void mover(){
		for(int i = 0 ; i < malo.size()  ; i++) {
				malo.get(i).mover(3);
			else
				malo.get(i).mover(2);
		}
	}

	public void mover(int dir){		
		int direccion = 0;

		switch (dir){

		case KeyEvent.VK_LEFT : //Izquierda
			direccion = 2;
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			direccion = 3;
			break;
		}

		jugador.mover(direccion);


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

	{
		PuntajeJuego+=malo.get(i).getPuntajeEnemigo();
	}

	private boolean EnemigoAlAlcance(Entidad e){
	}

	private Malo tipoDeMalo(int x,int y,int r){
		Malo m = null;
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

	public int getPuntajeJuego()
	{
		return PuntajeJuego;
	}

}
