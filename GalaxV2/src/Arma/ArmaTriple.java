package Arma;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Disparo.Disparo;
import Disparo.DisparoTriple;
import Inteligencia.DiagonalDer;
import Inteligencia.DiagonalIzq;
import Juego.Logica;
import ObjetosDinamicos.Entidad;
import Sonido.Sonido;

public class ArmaTriple implements Arma {

	private Entidad entidad;
	private Logica logica;
	private Icon[] imagenes;
	
	public ArmaTriple(Entidad entidad) {
		this.entidad = entidad;
		this.logica = entidad.getLogica();
		imagenes = new Icon[2];
		imagenes[0]= new ImageIcon(this.getClass().getResource("/Graficos/jugador_tripleball.png"));
		imagenes[1]= new ImageIcon(this.getClass().getResource("/Graficos/superjugador_tripleball.gif"));
		cambiarGrafico();
	}
	
	@Override
	public void disparar() {
		
		if(entidad.municionTriple() > 0) {
			Sonido sonidoDisparo = new Sonido("/Sounds/LanzarPokeball.wav");
			sonidoDisparo.play();
			Logica logica = entidad.getLogica();
			Point posicion = entidad.getPosicion();
			Disparo disparo_medio = new DisparoTriple(posicion.x,posicion.y,logica);
			Disparo disparo_izq = new DisparoTriple(posicion.x,posicion.y,logica);
			Disparo disparo_der = new DisparoTriple(posicion.x,posicion.y,logica);
			disparo_izq.setInteligencia(new DiagonalIzq());
			disparo_der.setInteligencia(new DiagonalDer());
			
			logica.getDisparos().add(disparo_medio);
			logica.getDisparos().add(disparo_izq);
			logica.getDisparos().add(disparo_der);
			
			logica.getInterfaz().setImage(disparo_medio.getGrafico());
			logica.getInterfaz().setImage(disparo_izq.getGrafico());
			logica.getInterfaz().setImage(disparo_der.getGrafico());
			entidad.reducirMunicionTriple();
			logica.actualizarMunicion();
		}
	}
	
	public Arma armaSiguient() {
		return new ArmaSuper(entidad);
	}
	
	public void cambiarGrafico() {
		if(logica.getJugador().invulnerable())
			logica.getJugador().setGrafico(imagenes[1]);
		else
			logica.getJugador().setGrafico(imagenes[0]);
	}

	@Override
	public void setDaño() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGraficoDisparo(Icon icono) {
		// TODO Auto-generated method stub
		
	}

}
