package ObjetosDinamicos;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Juego.Logica;

public class EnemigoBeta extends Enemigo {

	public EnemigoBeta(int x, int y,Logica logica) {
		super(x, y,logica);
		velocidad = (int) 8.5;
		puntaje = 200;
		puntosVida = 350;
		vidaMAX = puntosVida;
		CrearGrafico();
	}

	@Override
	public String getImage() {
		return  "/Graficos/Pidgeotto.gif";
	}
	
	@Override
	public void graficosNivel() {
		graficosNivel = new Icon[5];
		graficosNivel[0] = new ImageIcon(this.getClass().getResource("/Graficos/Pidgeotto.gif"));
		graficosNivel[1] = new ImageIcon(this.getClass().getResource("/Graficos/Wartortle.gif"));
		graficosNivel[2] = new ImageIcon(this.getClass().getResource("/Graficos/Ivysaur.gif"));
		graficosNivel[3] = new ImageIcon(this.getClass().getResource("/Graficos/Charmeleon.gif"));
		graficosNivel[4] = new ImageIcon(this.getClass().getResource("/Graficos/Raichu.gif"));
		
	}

	@Override
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}

}
