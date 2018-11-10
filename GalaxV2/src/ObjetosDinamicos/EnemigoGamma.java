package ObjetosDinamicos;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Juego.Logica;

public class EnemigoGamma extends Enemigo {

	public EnemigoGamma( int x, int y,Logica logica) {
		super(x, y,logica);
		velocidad =(int) 6.5;
		puntaje = 500;
		puntosVida = 1000;
		width = 70;
		height = 70;
		vidaMAX = puntosVida;
		CrearGrafico();
	} 

	@Override
	public String getImage() {
		return  "/Graficos/Pidgeot.gif";
	}
	
	public void graficosNivel() {
		graficosNivel = new Icon[4];
		graficosNivel[0] = new ImageIcon(this.getClass().getResource("/Graficos/Pidgeot.gif"));
		graficosNivel[1] = new ImageIcon(this.getClass().getResource("/Graficos/Blastoise.gif"));
		graficosNivel[2] = new ImageIcon(this.getClass().getResource("/Graficos/Venusaur.gif"));
		graficosNivel[3] = new ImageIcon(this.getClass().getResource("/Graficos/Charizard.gif"));
	}

	@Override
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}
}
