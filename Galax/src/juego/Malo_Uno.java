package juego;
import javax.swing.JLabel;

public  class Malo_Uno extends Malo {

	public Malo_Uno(int velocidad, int x, int y,int puntaje) {
		super(velocidad, x, y,puntaje);
	}

	
	public String getImage() {
		
		return "/graficos/Malo_1.gif";
	}
	
	

}
