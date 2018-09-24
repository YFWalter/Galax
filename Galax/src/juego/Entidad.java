package juego;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Entidad {

	protected JLabel grafico;
	protected final int width = 75;
	protected final int height = 75;

	protected int velocidad;

	protected Point pos;

	protected Entidad(int velocidad, int x, int y) {
		this.pos = new Point(x, y);
		this.velocidad = velocidad;
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


		switch (dir) {
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
	}

	public JLabel getGrafico(){
		if(this.grafico == null){
			Icon img = new ImageIcon(this.getClass().getResource(getImage()));
			this.grafico = new JLabel(img);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		return this.grafico;
	}

	public abstract String getImage();
}
