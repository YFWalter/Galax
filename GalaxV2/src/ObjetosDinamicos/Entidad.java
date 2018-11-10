package ObjetosDinamicos;

import java.awt.Point;
import java.util.Random;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparo.Disparo;
import Inteligencia.*;
import Juego.Logica;
import Visitor.Visitable;
import Visitor.Visitor;

public abstract class Entidad implements Visitable {
	
	protected int puntosVida;
	protected int daño;
	protected int velocidad;
	protected int probabilidad;
	protected int superball,tripleball;
	
	
	protected Point posicion;
	protected Inteligencia inteligencia;
	protected JLabel grafico;
	protected Icon[] graficosNivel;
	
	protected int width;
	protected int height;
	
	protected Visitor visitor;
	
	protected Vector<Disparo> disparos;
	
	protected Logica logica;
	
	public Entidad(int x,int y,Logica logica) {
		posicion = new Point(x,y);
		this.logica = logica;
		CrearGrafico();
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public Point getPosicion() {
		return posicion;
	}
	
	public void setPos(int x , int y) {
		posicion.x = x;
		posicion.y = y;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}
	
	public void setInteligencia(Inteligencia i) {
		inteligencia = i;
	}
	
	public int getVida() {
		return puntosVida;
	}
	
	public void setVida(int vida) {
		puntosVida = vida;
	}
	
	public void actualizarPosicionGrafico(Entidad entidad) {
		getGrafico().setBounds(entidad.getPosicion().x,entidad.getPosicion().y,entidad.getWidth(),entidad.getHeight());
	}
	
	public void setGrafico(Icon image) {
		grafico.setIcon(image);
	}
	
	public  void CrearGrafico () 
	{
		Icon img = new ImageIcon(this.getClass().getResource(getImage()));
		this.grafico = new JLabel(img);
		this.grafico.setBounds(this.posicion.x, this.posicion.y, this.getWidth(), this.getHeight());
	}

	public  JLabel getGrafico() 
	{
		return grafico;
	}
	
	public int getProbabilidad() {
		Random rnd = new Random();
		probabilidad = rnd.nextInt(2);
		return probabilidad;
	}
	
	public void reducirSalud(int daño) {
		puntosVida -= daño;
	}
	
	public Logica getLogica() {
		return logica;
	}
	
	public int municionTriple() {
		return tripleball;
	}
	
	public int municionSuper() {
		return superball;
	}
	
	public void reducirMunicionTriple() {
		tripleball--;
	}
	
	public void reducirMunicionSuper() {
		superball--;
	}
	
	public abstract int getDaño();
	public abstract void mover();
	public abstract void destruirse();
	public abstract String getImage();
	public abstract Visitor getVisitor();
}
