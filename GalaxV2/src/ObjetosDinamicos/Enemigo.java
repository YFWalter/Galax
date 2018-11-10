package ObjetosDinamicos;

import java.util.Random;

import Arma.Arma;
import Juego.Logica;
import ObjetosEstaticos.PowerMagia;
import ObjetosEstaticos.PowerMisil;
import ObjetosEstaticos.PowerPocion;
import ObjetosEstaticos.PowerTimer;
import ObjetosEstaticos.PowerTriple;
import ObjetosEstaticos.PowerUps;
import Visitor.Visitor;
import Visitor.VisitorEnemigo;

public abstract class Enemigo extends Entidad
{
	protected int puntaje;
	protected int probabilidad;
	protected Arma arma;
	protected int vidaMAX;


	public Enemigo( int x, int y,Logica logica) {
		super(x, y,logica);
		visitor = new VisitorEnemigo();
		width = 32;
		height = 32;
		daño = 1; 
		graficosNivel();
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public Arma getArma() {
		return arma;
	}
	
	public abstract String getImage();
	
	@Override
	public void accept(Visitor vis) {
		vis.visit(this);
	}
	
	@Override
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void destruirse() {
		logica.getEnemigos().remove(this);
		if(this!=null)
			logica.removerEntidad(this);
	}
	
	@Override
	public void mover() {
		inteligencia.mover(this);
	}

	public void crearPowerUp() {
		Random rnd = new Random();
		PowerUps power = null;	
		if(getProbabilidad() == 1) {
			int num = 1+rnd.nextInt(5);
			switch(num) {
			case 1 :
				power = new PowerTimer(getPosicion().x,getPosicion().y,logica);
				break;
			case 2 :
				power = new PowerMagia(getPosicion().x,getPosicion().y,logica);
				break;
			case 3 :
				power = new PowerMisil(getPosicion().x,getPosicion().y,logica);
				break;
			case 4 :
				power = new PowerTriple(getPosicion().x,getPosicion().y,logica);
				break;
			case 5 :
				power = new PowerPocion(getPosicion().x,getPosicion().y,logica);
				break;
			}
			logica.getInterfaz().setImage(power.getGrafico());
			logica.getPowerUps().add(power);
		}
	}
	
	public void setGraficoNivelEnemigo(int indice) {
		getGrafico().setIcon(graficosNivel[indice]);
	}
	
	public int VidaMaxima() {
		return vidaMAX;
	}
	
	public abstract void graficosNivel();
}
