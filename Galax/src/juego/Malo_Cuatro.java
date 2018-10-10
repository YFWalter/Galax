package juego;
import javax.swing.JLabel;
public class Malo_Cuatro extends Malo {

	public Malo_Cuatro(int velocidad, int x, int y,int puntaje) {
		super(velocidad, x, y,puntaje);
	}

	
	
	public String getImage() {
		
		return "/graficos/Malo_4.gif";
	}

}
