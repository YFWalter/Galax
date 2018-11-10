package ObjetosDinamicos;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Juego.Logica;

public class EnemigoAlpha extends Enemigo {

	public EnemigoAlpha( int x, int y,Logica logica) {
		super(x, y,logica);
		velocidad = (int) 5.0;
		puntaje = 100;
		puntosVida = 150;
		vidaMAX = puntosVida;
		CrearGrafico();
	}

	@Override
	public String getImage() {
		return "/Graficos/Pidgey.gif";
	}

	@Override
	public void graficosNivel() {
		graficosNivel = new Icon[5];
		graficosNivel[0] = new ImageIcon(this.getClass().getResource("/Graficos/Pidgey.gif"));
		graficosNivel[1] = new ImageIcon(this.getClass().getResource("/Graficos/Squirtle.gif"));
		graficosNivel[2] = new ImageIcon(this.getClass().getResource("/Graficos/Bulbasaur.gif"));
		graficosNivel[3] = new ImageIcon(this.getClass().getResource("/Graficos/Charmander.gif"));
		graficosNivel[4] = new ImageIcon(this.getClass().getResource("/Graficos/Pikachu.gif"));
		
	}

	@Override
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}

}
