package Colisionadores;

import java.awt.Point;

import juego.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Disparo extends Thread 
{
	int daño;
	Colisionador colisionador;
	protected JLabel grafico;
	protected final int width = 75;
	protected final int height = 75;
	protected int velocidad;
	protected Point pos;
	
	public Disparo(int daño,Colisionador colisionador,int CoordenadaX,int CoordenadaY,int velocidad)
	{
		this.daño=daño;
		this.colisionador=colisionador;
		pos=new Point();
		pos.x=CoordenadaX;
		pos.y=CoordenadaY;
		this.velocidad=velocidad;
		Icon img = new ImageIcon(this.getClass().getResource("/graficos/Malo_2.gif"));
		this.grafico = new JLabel(img);
		this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		
	}
	
	public Point getPos()
	{
		return pos;
	}
	
	public JLabel getGrafico()
	{
		if(this.grafico == null){
			Icon img = new ImageIcon(this.getClass().getResource(getImage()));
			this.grafico = new JLabel(img);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		return this.grafico;
	}
	
	public String getImage() {

		return "/graficos/Malo_2.gif";
	}
	
	public Colisionador getColisionador()
	{
		return colisionador;
	}
	
}
