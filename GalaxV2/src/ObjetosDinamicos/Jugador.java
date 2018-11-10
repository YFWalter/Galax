package ObjetosDinamicos;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import javax.swing.JLabel;

import Arma.Arma;
import Arma.ArmaComun;
import Disparo.Disparo;
import Inteligencia.*;
import Juego.Logica;
import Visitor.Visitor;
import Visitor.VisitorJugador;

public class Jugador extends Entidad
{
	protected int daño;
	protected JLabel[] corazones;
	protected boolean invulnerable = false;
	protected Arma arma;
	
	public Jugador( int x, int y,Logica logica) {
		
		super(x, y,logica);
		disparos = new Vector<Disparo>();
		inteligencia = new Humana();
		velocidad = (int)(15);
		puntosVida = 6;
		visitor = new VisitorJugador();
		width = 60;
		height = 70;
		daño = 20;
		CrearGrafico();
	}
		
	@Override
	public String getImage() {
		return "/Graficos/jugador_pokeball.png";
	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
		
	}

	@Override
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void disparar(Logica logica) {
		arma.disparar();
	} 
	
	public void destruirse() {
		if(this!=null)
			logica.removerEntidad(this);
	}

	@Override
	public void mover() {
			inteligencia.mover(this);
	}
	
	public boolean invulnerable() {
		return invulnerable;
	}
	
	public void siInvulnerable() {
		invulnerable = true;
	}
	
	public void noInvulnerable() {
		invulnerable = false;
	}
	
	public void SuperBall() {
		superball++;
	}
	
	public void TripleBall() {
		tripleball++;
	}
	
	public void restaurarPosicion() {
		try {
			logica.getInterfaz().deshabilitarTeclado();
			getGrafico().setVisible(false);
			setPos(370,500);			
			actualizarPosicionGrafico(this);
			
			Thread.sleep(1000);
			getGrafico().setVisible(true);
			logica.getInterfaz().habilitarTeclado();
			noInvulnerable();
			cambiarGrafico();
				
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		siInvulnerable();
		cambiarGrafico();
		Timer timer = new Timer();
		TimerTask timertask = new TimerTask() {
			public void run() {
				noInvulnerable();
				cambiarGrafico();
			}
		};
		timer.schedule(timertask, 1000);
	}

	public void setArma() {
		this.arma = new ArmaComun(this);
	}
	
	public void cambiarGrafico() {
		arma.cambiarGrafico();
	}
	
	public void cambiarArma() {
		arma = arma.armaSiguient();
	}
	
	public void sumarVida() {
		puntosVida++;
	}
	
	public int getDaño() {
		return daño;
	}
	
}
