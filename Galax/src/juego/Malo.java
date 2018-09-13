package juego;

import javax.swing.ImageIcon;

public class Malo extends Entidad{
	
	public Malo(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/graficos/Malo_1.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/graficos/Malo_2.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/graficos/Malo_3.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/graficos/Malo_4.gif"));
	}
}
