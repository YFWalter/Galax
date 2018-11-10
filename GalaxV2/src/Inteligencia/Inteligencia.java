package Inteligencia;

import Disparo.*;
import ObjetosDinamicos.*;
import ObjetosEstaticos.Obstaculo;
import ObjetosEstaticos.PowerUps;

public abstract class Inteligencia {
	
	protected int LimiteIzquierdo=-50;
	protected int LimiteDerecho=800;
	protected int LimiteInferior=550;
	protected int LimiteSuperior=-40;

	protected int codeMover;
	
	public abstract void mover(Jugador jugador);
	
	public abstract void mover(Enemigo personaje);
	
	public abstract void mover(Disparo disparo);
	
	public abstract void mover(Obstaculo obstaculo);
	
	public abstract void mover(PowerUps power);
	
	public void setCode(int code) {
		codeMover = code;
	}
	
	public void setLimiteDerecho(int ld) {
		LimiteDerecho = ld;
	}
	
	public void setLimiteIzquierdo(int li) {
		LimiteIzquierdo = li;
	}


	
}
