package juego;

import java.awt.Point;

import Colisionadores.Colisionador;
import Colisionadores.Disparo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public abstract class Entidad {

	protected JLabel grafico;
	protected final int width = 75;
	protected final int height = 75;
	protected final int MoverIzquierda=2;
	protected final int MoverDerecha=3;
	protected int velocidad;
	protected Colisionador colisionador;

	protected Point pos;

	protected Entidad(int velocidad, int x, int y) {
		this.pos = new Point(x, y);
		this.velocidad = velocidad;
		colisionador=null;
	}

	
	public int getVelocidad() {
		return velocidad;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(int x,int y)
	{
		pos.x=x;
		pos.y=y;
	}



	public void mover(int dir)
	{	
		int LimiteIzquierdo=-50;
		int LimiteDerecho=800;
		switch (dir) {

		case 2 : //Izquierda
			if (pos.x<=LimiteIzquierdo)				
				pos.setLocation(LimiteDerecho,pos.y);
			else
				pos.setLocation(pos.x - velocidad, pos.y);
			break;
		case 3 : //Derecha
			if (pos.x>=LimiteDerecho)
				pos.setLocation(LimiteIzquierdo,pos.y);
			else		
				pos.setLocation(pos.x + velocidad, pos.y);
			break;
		}
		if(this.grafico!=null)
			this.grafico.setBounds(this.getPos().x, this.getPos().y, width, height);
	}

	public JLabel getGrafico(){
		if(this.grafico == null){
			Icon img = new ImageIcon(this.getClass().getResource(getImage()));
			this.grafico = new JLabel(img);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		return this.grafico;
	}
	
	public Colisionador getColisionador()
	{
		return this.colisionador;
	}
	

	//public abstract void SerChocado(Colisionador colisionador);
	public abstract String getImage();
}
