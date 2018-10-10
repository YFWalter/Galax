package Movimientos;
import juego.*;
import java.util.Vector;

public class MovimientoEnemigos  extends Thread
{
	private Vector<Malo> enemigos;

	public MovimientoEnemigos(Vector<Malo> enemigos)
	{
		this.enemigos=enemigos;
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
			for(Malo enemigo:enemigos)
				if(enemigo.getPos().y==125)//Fila del medio
					enemigo.mover(3);//Derecha
				else {
					enemigo.mover(2);//Izquierda
				}
		}
	}
}
