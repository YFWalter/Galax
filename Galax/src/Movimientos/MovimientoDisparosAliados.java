package Movimientos;

import java.util.Vector;
import Colisionadores.*;

public class MovimientoDisparosAliados  extends Thread
{
	private Vector<DisparoAliado> disparos;
	

	public MovimientoDisparosAliados(Vector<DisparoAliado> disparos)
	{
		this.disparos=disparos;
	}

	public void run()
	{
		boolean corriendo=true;

		while(corriendo){
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
				corriendo=false;
			}
			for(int indiceDisparo=0; indiceDisparo<disparos.size();indiceDisparo++)
				disparos.get(indiceDisparo).mover();
		}
	}
}
