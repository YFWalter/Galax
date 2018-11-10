package Arma;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Disparo.Disparo;
import Disparo.DisparoMisil;
import Juego.Logica;
import ObjetosDinamicos.Entidad;
import Sonido.Sonido;

public class ArmaSuper implements Arma{

	private Entidad entidad;
	private Icon[] imagenes;
	private Logica logica;
	
	public ArmaSuper(Entidad entidad) {
		this.entidad = entidad;
		this.logica = entidad.getLogica();
		imagenes = new Icon[2];
		imagenes[0]= new ImageIcon(this.getClass().getResource("/Graficos/jugador_superball.png"));
		imagenes[1]= new ImageIcon(this.getClass().getResource("/Graficos/superjugador_superball.gif"));
		cambiarGrafico();
	}
	
	@Override
	public void disparar() {
		if(entidad.municionSuper() > 0) {
			Sonido sonidoDisparo = new Sonido("/Sounds/LanzarPokeball.wav");
			sonidoDisparo.play();
			Logica logica = entidad.getLogica();
			Point posicion = entidad.getPosicion();
			Disparo disparo = new DisparoMisil(posicion.x,posicion.y,logica);
			logica.getDisparos().add(disparo);
			logica.getInterfaz().setImage(disparo.getGrafico());
			entidad.reducirMunicionSuper();
			logica.actualizarMunicion();
		}
	}
	
	@Override
	public Arma armaSiguient() {
		return new ArmaComun(entidad);
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
