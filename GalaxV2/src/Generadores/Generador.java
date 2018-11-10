package Generadores;

import java.util.Random;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Arma.ArmaEnemigo;
import Inteligencia.Derecha;
import Inteligencia.Izquierda;
import Inteligencia.Kamikaze;
import Inteligencia.Mareado;
import Juego.Logica;
import ObjetosDinamicos.Enemigo;
import ObjetosDinamicos.EnemigoAlpha;
import ObjetosDinamicos.EnemigoBeta;
import ObjetosDinamicos.EnemigoFinal;
import ObjetosDinamicos.EnemigoGamma;

public abstract class Generador {

	Logica logica;
	
	protected int x_Enemigo = 0;
	protected int y_Enemigo = 0;
	
	protected int filasMax = 0;
	protected int columnaMax = 0;
	
	protected int nivelEnemigo = 0;
	
	Enemigo nuevo = null;
	
	protected Icon[] tipoDisparo;
	protected Icon disparoEnemigoFinal;
 	
	public Generador(Logica log) {
		logica = log;
		crearTipoDisparo();
	}
	
	public void generarEnemigos(){
		
		Vector<Enemigo> enemigos = logica.getEnemigos();
		//A�adir enemigos 1 por 1
		int tipoEnemigo=1;
		for(int fila=0;fila<filasMax;fila++)
		{
			for(int columna = 0; columna< columnaMax; columna++)
			{
				nuevo = tipoDeMalo(x_Enemigo,y_Enemigo, nivelEnemigo);
				
				if(nivelEnemigo < 4) {
					agregarInteligencia(fila);
					agregarGrafico(tipoEnemigo);
					agregarArma(nuevo,fila);
				}
				else
					agregarEnemigoFinal(columna);
				
				enemigos.add(nuevo);
				
				if(nivelEnemigo == 3)
					x_Enemigo +=100;
				else
					if(nivelEnemigo == 4)
						x_Enemigo +=350; 
					else
						x_Enemigo += 75;
			}
			tipoEnemigo++;
			//Al cambiar de fila reseteo el X y aumento el Y para insertar en nueva fila
			switch(nivelEnemigo) {
				case 1:{
					y_Enemigo +=75;
					x_Enemigo=150;
					break;
				}
				case 2:{
					y_Enemigo += 50;
					x_Enemigo = 150;
					break;
				}
				case 3:{
					y_Enemigo +=75;
					x_Enemigo=150;
					break;
				}
				case 4:{
					break;
				}
			}
		}	
	}
	
	private void agregarEnemigoFinal(int indice) {
		nuevo.setGraficoNivelEnemigo(indice);
		nuevo.setArma(new ArmaEnemigo(nuevo));
		nuevo.getArma().setGraficoDisparo(disparoEnemigoFinal);
	}

	private Enemigo tipoDeMalo(int x,int y,int r){
		
		switch(r) {
		case 1 :{ 
			nuevo = new EnemigoAlpha(x,y,logica);
			break;
			}
		case 2 :
			nuevo = new EnemigoBeta(x,y,logica);
			break;
		case 3 :
			nuevo = new EnemigoGamma(x,y,logica);
			break;
		case 4 : 
			nuevo = new EnemigoFinal(x,y,logica);
			break;
		}

		return nuevo;
	}
	
	public void agregarInteligencia(int fila) {
		if(fila % 2 == 0 && fila != 0)
			nuevo.setInteligencia(new Izquierda());
		else
			nuevo.setInteligencia(new Derecha());
		if(fila == 0) {
			Random rnd = new Random();
			int pro = rnd.nextInt(2)+1;
			switch(pro) {
				case 1 :{
					nuevo.setInteligencia(new Kamikaze());
					break;
				}
				case 2 :{
					nuevo.setInteligencia(new Mareado());
					break;
				}
			}		
		}
	}
	
	public void agregarGrafico(int tipoEnemigo) {
		switch(tipoEnemigo) {
			case 1:{
				nuevo.setGraficoNivelEnemigo(0);
				break;
			}
			case 2:{
				nuevo.setGraficoNivelEnemigo(1);
				break;
			}
			case 3:{
				nuevo.setGraficoNivelEnemigo(2);
				break;
			}
			case 4:{
				nuevo.setGraficoNivelEnemigo(3);
				break;
			}
			case 5:{
				nuevo.setGraficoNivelEnemigo(4);
				break;
			}
		}
	}
	
	public void agregarArma(Enemigo enemigo,int fila) {
			if(fila != 0 && nuevo != null) {
				enemigo.setArma(new ArmaEnemigo(enemigo));
				enemigo.getArma().setGraficoDisparo(tipoDisparo[fila-1]);
			}
	}
	
	private void crearTipoDisparo() {
		tipoDisparo = new Icon[4];
		tipoDisparo[0] = new ImageIcon(this.getClass().getResource("/Graficos/DisparoAzul.png"));
		tipoDisparo[1] = new ImageIcon(this.getClass().getResource("/Graficos/DisparoVerde.png"));
		tipoDisparo[2] = new ImageIcon(this.getClass().getResource("/Graficos/DisparoNaranja.png"));
		tipoDisparo[3] = new ImageIcon(this.getClass().getResource("/Graficos/DisparoAmarillo.png"));
		
		disparoEnemigoFinal = new ImageIcon(this.getClass().getResource("/Graficos/Fire_Ball.gif"));
	}
	
	public abstract Generador getSiguienteGenerador();
}
