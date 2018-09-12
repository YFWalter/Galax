package juego;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Entidad {

	protected JLabel grafico;
	protected Icon image[];
	protected final int width = 75;
	protected final int height = 75;

	protected int velocidad;

	protected Point pos;

	protected Entidad(int velocidad, int x, int y) {
		this.pos = new Point(x, y);
		this.velocidad = velocidad;

		this.image = new Icon[4];
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

	protected void cambiarGrafico(int dir){
		if(this.grafico != null){
			//this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}

	public void mover(int dir){	
		switch (dir) {
		/*

			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - velocidad);
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + velocidad);
				break;
		 */
		case 2 : //Izquierda
			if (pos.x<=-50)				
				pos.setLocation(800,pos.y);
			else
				pos.setLocation(pos.x - velocidad, pos.y);
			break;
		case 3 : //Derecha
			if (pos.x>=800)
				pos.setLocation(-50,pos.y);
			else		
				pos.setLocation(pos.x + velocidad, pos.y);
			break;
		}
		cambiarGrafico(dir);
	}

	public JLabel getGrafico(int i){
		if(this.grafico == null){
			this.grafico = new JLabel(image[i]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}

		return this.grafico;
	}

}
