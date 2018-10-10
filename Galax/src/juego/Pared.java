package juego;


import Colisionadores.*;

import Colisionadores.Colisionador;

public class Pared extends Entidad 
{

	
	public Pared(int velocidad,int CoordenadaX,int CoordenadaY)
	{
		super(velocidad, CoordenadaX, CoordenadaY);	
	}
	
	public void SerChocado(Colisionador colisionador)
	{
		colisionador.GolpearObstaculo(this);//le dice al colisionador contra que choco
	}
	
	public Disparo Disparar()
	{
		return null;
	}
	
	public  void Matar()
	{
		//grafico.setVisible(false);
	}
	
	public String getImage() {
		
		return "/graficos/Malo_3.gif";
	}

	
}
