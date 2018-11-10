package Juego;

import java.awt.Rectangle;
import java.util.Vector;

import Arma.ArmaVacia;
import ObjetosDinamicos.*;
import ObjetosEstaticos.*;
import Sonido.Sonido;
import Controladores.*;
import Disparo.*;
import Generadores.*;
import Inteligencia.EspecialFinal;
import Inteligencia.Kamikaze;
import Inteligencia.Mareado;

public class Logica {

	protected int PuntajeJuego = 0;
	protected int cantidadEnemigos = 0;
	
	protected Jugador jugador;
	
	protected Vector<Enemigo> enemigos;
	protected Vector<Disparo> disparos;
	protected Vector<Obstaculo> obstaculos;
	protected Vector<Disparo> disparosEnemigos;
	protected Vector<PowerUps> powerups;
	
	protected Interfaz interfaz;
	
	protected Mapa mapa;
	protected int nivelMapa;
	
	protected Generador generador;
	
	protected ControladorEnemigos controladorEnemigos;
	protected ControladorDisparo controladorDisparos;
	
	public Logica(Interfaz interfaz){
		
		
		this.interfaz = interfaz;
		
		enemigos = new Vector<Enemigo>();
		disparos = new Vector<Disparo>();
		disparosEnemigos = new Vector<Disparo>();
		obstaculos = new Vector<Obstaculo>();
		powerups = new Vector<PowerUps>();
		
		nivelMapa = 1;
		generarNuevoMapa();
		
		crearGenerador();
		
	}

	public void crearGenerador() {
		generador = new GeneradorNivel1(this);
		generador.generarEnemigos();
	}
	
	public void generarMapa()
	{	
		jugador = new Jugador(370,500,this);
		interfaz.setImage(jugador.getGrafico());
		jugador.setArma();
		interfaz.addObstaculos(obstaculos);
		interfaz.addEnemigos(enemigos);
		
	}
	
	protected void resetearMapa(){
		
		interfaz.deshabilitarTeclado();
	
		controladorEnemigos.terminate(); 
		controladorDisparos.terminate();
		
		while(!disparos.isEmpty()){
			disparos.get(0).destruirse(); 
		}
		
		enemigos = new Vector<Enemigo>();
		disparos = new Vector<Disparo>();
		obstaculos = new Vector<Obstaculo>();
		
		controladorEnemigos = new ControladorEnemigos(this);
		controladorDisparos = new ControladorDisparo(this);
		
		interfaz.reiniciarPanelesJuego();
		interfaz.inicializarPaneles();
		
		generarNuevoMapa();
		
		jugador.restaurarPosicion(); 
			
		generador = generador.getSiguienteGenerador();
		generador.generarEnemigos();
			
		controladorEnemigos.start(); 
		controladorDisparos.start(); 
		
		interfaz.setImage(jugador.getGrafico());
		interfaz.addEnemigos(enemigos);
		interfaz.addObstaculos(obstaculos);
		interfaz.actualizarVidas();
		interfaz.actualizarPuntaje();
		interfaz.actualizarMunicion();
		interfaz.habilitarTeclado();
		interfaz.repaint(); 
	}
	/*
	public void reiniciarJuego() {
		
		interfaz.deshabilitarTeclado(); 
		while(!disparos.isEmpty()){
			disparos.get(0).destruirse(); 
		}
		
		nivelMapa = 1;
		
		enemigos = new Vector<Enemigo>();
		disparos = new Vector<Disparo>();
		obstaculos = new Vector<Obstaculo>();
		
		interfaz.reiniciarPanelesJuego();
		interfaz.inicializarPaneles();
		
		generarNuevoMapa();
		
		jugador.restaurarPosicion(); 
			
		generador = new GeneradorNivel1(this);
		generador.generarEnemigos(); 
			
		interfaz.setImage(jugador.getGrafico());
		interfaz.addEnemigos(enemigos);
		interfaz.addObstaculos(obstaculos);
		interfaz.actualizarVidas();
		interfaz.habilitarTeclado();
		interfaz.repaint();
	}
	*/
	public void finalizarJuego() {
		
		interfaz.deshabilitarTeclado(); 
		controladorEnemigos.terminate();
		controladorDisparos.terminate();
		controladorEnemigos = null; 
		controladorDisparos = null;
		
		if(jugador.getVida() <= 0)
			interfaz.gameOver();
		if(nivelMapa > 4) 
			interfaz.winner();
		
	}
	
	public void actualizar() {
			if(enemigos.size() == 0) {
				nivelMapa++;
				resetearMapa();
				if(nivelMapa <= 4) {
					Sonido sonidoPasarNivel = new Sonido("/Sounds/PasarNivel.wav");
					sonidoPasarNivel.play();
				}
				if(nivelMapa==4) {
						cambiarInteligencia();
						interfaz.sonidoFinal();
				}
			else
				if(nivelMapa>4)
					finalizarJuego();		
		}
	}
	
	private void cambiarInteligencia() {
		
		//Aplico inteligencias a los obstaculos, jugadores y jefes finales.
		
		jugador.setInteligencia(new EspecialFinal());
		jugador.getInteligencia().setLimiteDerecho(650);
		jugador.getInteligencia().setLimiteIzquierdo(90);
		
		for(Obstaculo o : obstaculos) {
			o.setInteligencia(new EspecialFinal());
			o.getInteligencia().setLimiteIzquierdo(90);
			o.getInteligencia().setLimiteDerecho(725);
		}
		
		// Aplico las inteligencias a los jefes finales
		enemigos.get(0).setInteligencia(new EspecialFinal());
		enemigos.get(1).setInteligencia(new EspecialFinal());
		
		// Aplico las velocidades a los jefes finales
		enemigos.get(0).setVelocidad(4);
		enemigos.get(1).setVelocidad(9);
			
	}

	public Interfaz getInterfaz() {
		return interfaz;
	}
	
	public void generarNuevoMapa() {
		switch(nivelMapa) {
			case 1:{
				mapa = new Mapa(this.getClass().getResourceAsStream("/Archivo/Nivel1.txt"),this);
				break;
			}
			case 2:{
				mapa = new Mapa(this.getClass().getResourceAsStream("/Archivo/Nivel2.txt"),this);
				break;
			}
			case 3:{
				mapa = new Mapa(this.getClass().getResourceAsStream("/Archivo/Nivel3.txt"),this);
				break;
			}
			case 4:{
				mapa = new Mapa(this.getClass().getResourceAsStream("/Archivo/Nivel4.txt"),this);
				break;
			}
		}
	}
	
	public Jugador getJugador() {
		return jugador;
	}
		
	public Vector<Disparo> getDisparos(){
		return disparos;
	}
	
	public Vector<Disparo> getDisparosEnemigos(){
		return disparosEnemigos;
	}
	
	public Vector<Obstaculo> getObstaculos(){
		return obstaculos;
	}
	
	public Vector<Enemigo> getEnemigos(){
		return enemigos;
	}
	
	public Vector<PowerUps> getPowerUps(){
		return powerups;
	}
	
	public ControladorEnemigos getControladorEnemigo() {
		return controladorEnemigos;
	}
	
	public void moverPersonaje(int code) {
		jugador.getInteligencia().setCode(code);
		jugador.mover();
	}
	
	public void moverEntidades() {
		controladorEnemigos = new ControladorEnemigos(this);
		controladorDisparos = new ControladorDisparo(this);

		controladorEnemigos.start();
		controladorDisparos.start();
	}
	
	
	public void removerEntidad(Entidad entidad) {
		interfaz.removeImage(entidad.getGrafico());
		interfaz.repaint();
	}
	
	public void actualizarPuntaje(Enemigo enemigo) {
		PuntajeJuego += enemigo.getPuntaje();
		interfaz.actualizarPuntaje();
	}
	
	public void actualizarVidas(){
		interfaz.actualizarVidas();
	}
	
	public int getPuntajeJuego() {
		return PuntajeJuego;
	}
	
	public int getNivel() {
		return nivelMapa;
	}
	
	public void colisione(Disparo disparo){
		
		colisionePower(disparo);
		colisioneEnemigos(disparo);
		colisioneJugador(disparo);
		colisioneDisparoEnemigo(disparo);
		colisioneObstaculo(disparo); 
	}
	
	private void colisionePower(Disparo disparo) {		
		Rectangle rectanguloDisparo = new Rectangle(disparo.getPosicion().x,disparo.getPosicion().y,50,50);
		PowerUps power = null;
		for(int i = 0 ; i < powerups.size() ; i++) {
			power = powerups.get(i);
			Rectangle rectanguloPower = new Rectangle(power.getPosicion().x,power.getPosicion().y,50,50);
			if(rectanguloPower.intersects(rectanguloDisparo)) {
				power.accept(disparo.getVisitor());
				disparo.accept(power.getVisitor());			
			}
		}
		
	}

	public boolean jugadorAlcance(Enemigo enemigo)
	{
		int posicionJugador=jugador.getPosicion().x;
		int posicionEntidad=enemigo.getPosicion().x;
		if(nivelMapa < 4)
			return (posicionEntidad<posicionJugador+50 && posicionJugador == posicionEntidad);
		else {	
			float resultado = posicionJugador-posicionEntidad;
			return (posicionEntidad<posicionJugador+50 && resultado < 0.1);
		}
		
	}

	public void colisioneJugador(Disparo disparo){
		
		Rectangle rectanguloDisparo = new Rectangle(disparo.getPosicion().x,disparo.getPosicion().y,10,10);
		Rectangle rectanguloEnemigo = new Rectangle(jugador.getPosicion().x,jugador.getPosicion().y,50,50);
		
		if(rectanguloDisparo.intersects(rectanguloEnemigo)) {
			jugador.accept(disparo.getVisitor());
			disparo.accept(jugador.getVisitor());
		}
	}
	
	public void colisioneJugador(Enemigo enemigo){
		
		Rectangle rectanguloEnemigo = new Rectangle(enemigo.getPosicion().x,enemigo.getPosicion().y,enemigo.getWidth(),enemigo.getHeight());
		Rectangle rectanguloJugador = new Rectangle(jugador.getPosicion().x,jugador.getPosicion().y,50,50);
		
				if(rectanguloJugador.intersects(rectanguloEnemigo)) {
					jugador.accept(enemigo.getVisitor());
					enemigo.reducirSalud(jugador.getDaño());
					enemigo.accept(jugador.getVisitor());
				}
				
	}
	
	public void colisioneDisparoEnemigo(Disparo disparoEnemigo) {
		Rectangle rectanguloDisparo = new Rectangle(disparoEnemigo.getPosicion().x,disparoEnemigo.getPosicion().y,disparoEnemigo.getWidth(),disparoEnemigo.getHeight());
		Disparo disparoJugador;
		
		for(int i = 0 ; i < getDisparos().size() ; i++) {
			disparoJugador = getDisparos().get(i);
			Rectangle rectanguloEnemigo = new Rectangle(disparoJugador.getPosicion().x,disparoJugador.getPosicion().y,disparoJugador.getWidth(),disparoJugador.getHeight());
				if(rectanguloDisparo.intersects(rectanguloEnemigo)) {
					disparoEnemigo.accept(disparoJugador.getVisitor());
					disparoJugador.accept(disparoEnemigo.getVisitor());
					break;
				}
		}
	}

	public void colisioneEnemigos(Disparo disparo){
		Rectangle rectanguloDisparo = new Rectangle(disparo.getPosicion().x,disparo.getPosicion().y,disparo.getWidth(),disparo.getHeight());
		Enemigo enemigo;
		
		for(int i = 0 ; i < getEnemigos().size() ; i++) {
			enemigo = getEnemigos().get(i);
			Rectangle rectanguloEnemigo = new Rectangle(enemigo.getPosicion().x,enemigo.getPosicion().y,enemigo.getWidth(),enemigo.getHeight());
				if(rectanguloDisparo.intersects(rectanguloEnemigo)) {
					disparo.accept(enemigo.getVisitor());
					afectar(disparo,enemigo);
					enemigo.accept(disparo.getVisitor());
					break;
				}
		}
	}
	
	private void afectar(Disparo disparo, Enemigo enemigo) {
		enemigo.reducirSalud(disparo.getDaño());
		if(enemigo.getArma() != null) {
			if(enemigo.getVida() <= (20*enemigo.VidaMaxima())/100) { 
				enemigo.setInteligencia(new Kamikaze());
				enemigo.setArma(new ArmaVacia());
			}
		}
		else
			if(enemigo.getVida() <= (50*enemigo.VidaMaxima())/100)
				enemigo.setInteligencia(new Mareado());
	}

	public void colisionePower(PowerUps power) {
		
		Rectangle rectanguloPower = new Rectangle(power.getPosicion().x,power.getPosicion().y,50,50);		
		Rectangle rectanguloJugador = new Rectangle(jugador.getPosicion().x,jugador.getPosicion().y,50,50);
				
		if(rectanguloPower.intersects(rectanguloJugador)) {
			power.accept(jugador.getVisitor());
			jugador.accept(power.getVisitor());			
		}
	}	
	
	public void colisioneObstaculo(Disparo disparo) {
		
		Rectangle rectanguloDisparo = new Rectangle(disparo.getPosicion().x,disparo.getPosicion().y,15,15);
		Obstaculo obstaculo;
		
		for(int i = 0 ; i < getObstaculos().size() ; i++) {
			obstaculo = getObstaculos().get(i);
			Rectangle rectanguloObstaculo = new Rectangle(obstaculo.getPosicion().x,obstaculo.getPosicion().y,obstaculo.getWidth(),obstaculo.getHeight());
				if(rectanguloDisparo.intersects(rectanguloObstaculo)) {
					disparo.accept(obstaculo.getVisitor());
					obstaculo.accept(disparo.getVisitor());
					break;
				}
		}
	}
	

	public void actualizarMunicion() {
		interfaz.actualizarMunicion();
	}
	
}
