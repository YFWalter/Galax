package Colisionadores;
import java.util.Vector;

import gui.GUI;
import javafx.geometry.Rectangle2D;
import juego.*;

public class DisparoAliado extends Disparo 
{
	private Vector<Malo> enemigos;
	private Vector<Pared> paredes;
	private GUI interfaz;
	private int disparoARemover=-1;
	private int paredARemover=-1;
	private Vector<DisparoAliado> disparos;

	public DisparoAliado(int daño, Colisionador colisionador,int CoordenadaX,int CoordenadaY,int velocidad,Vector<Malo> enemigos,Vector<Pared>paredes,GUI interfaz,Vector<DisparoAliado>disparos)
	{
		super(daño,colisionador,CoordenadaX,CoordenadaY, velocidad);
		this.enemigos=enemigos;
		this.paredes=paredes;
		this.interfaz=interfaz;
		this.disparos=disparos;
	}


	public void mover()
	{
		boolean colisione=false;
		Rectangle2D rectanguloDisparo=new Rectangle2D(pos.getX(),pos.getY(),width, height);
		for(int indicePared=0; indicePared<paredes.size();indicePared++)
		{
			Rectangle2D rectanguloPared=new Rectangle2D(paredes.get(indicePared).getPos().getX(), paredes.get(indicePared).getPos().getY(), 25, 25);
			if(rectanguloDisparo.intersects(rectanguloPared))
			{
				colisione=true;
				paredes.get(indicePared).SerChocado(colisionador);
				disparoARemover=disparos.indexOf(this);
				paredARemover=indicePared;
				break;
			}

		}
		if(!colisione)	
		{
			pos.setLocation(pos.x,pos.y-velocidad);		

			if(this.grafico!=null)
				this.grafico.setBounds(pos.x, pos.y, width, height);

		}
		else
		{
			interfaz.remove(paredes.get(paredARemover).getGrafico());
			paredes.remove(paredARemover);
			
			interfaz.remove(disparos.get(disparoARemover).getGrafico());
			disparos.remove(disparoARemover);
			interfaz.repaint();
			
		}

	}


}
