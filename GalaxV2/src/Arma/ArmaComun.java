package Arma;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Disparo.Disparo;
import Disparo.DisparoJugador;
import Juego.Logica;
import ObjetosDinamicos.Entidad;
import Sonido.Sonido;

public class ArmaComun implements Arma {
	
	private Entidad entidad;
	private Logica logica;
	private Icon[] imagenes;
	
	public ArmaComun(Entidad entidad) {
		this.entidad = entidad;
		this.logica = entidad.getLogica();
		setImagenes();
		cambiarGrafico();
	}

	@Override
	public void disparar() {
		Sonido sonidoDisparo = new Sonido("/Sounds/LanzarPokeball.wav");
		sonidoDisparo.play();
		Logica logica = entidad.getLogica();
		Point posicion = entidad.getPosicion();
		Disparo disparo = new DisparoJugador(posicion.x,posicion.y,logica);
		logica.getDisparos().add(disparo);
		logica.getInterfaz().setImage(disparo.getGrafico());
		
	}

	@Override
	public Arma armaSiguient() {
		return new ArmaTriple(entidad);
	}
	
	public void cambiarGrafico() {
		if(logica.getJugador().invulnerable())
			logica.getJugador().setGrafico(imagenes[1]);
		else
			logica.getJugador().setGrafico(imagenes[0]);
	}
	
	private void setImagenes() {
		imagenes = new Icon[2];
		imagenes[0]= new ImageIcon(this.getClass().getResource("/Graficos/jugador_pokeball.png"));
		imagenes[1]= new ImageIcon(this.getClass().getResource("/Graficos/superjugador_pokeball.gif"));
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
