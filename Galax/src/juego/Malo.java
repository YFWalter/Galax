package juego;

import javax.swing.ImageIcon;

public class Malo extends Entidad{
	
	public Malo(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/Galaxia/Malo_1.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Galaxia/Malo_2.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Galaxia/Malo_3.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Galaxia/Malo_4.png"));
	}
}
