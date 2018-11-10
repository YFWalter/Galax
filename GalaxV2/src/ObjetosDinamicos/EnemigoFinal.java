package ObjetosDinamicos;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Disparo.DisparoEnemigo;
import Juego.Logica;

public class EnemigoFinal extends Enemigo {

	public EnemigoFinal( int x, int y,Logica logica) {
		super(x,y,logica);
		velocidad = (int)5.5;
		puntaje = 1000;
		puntosVida = 3000;
		width = 150;
		height = 100;
		vidaMAX = puntosVida;
		CrearGrafico();
	}

	@Override
	public String getImage() {
		return  "/Graficos/Pidgey.gif";
	}

	public void disparar() {
		DisparoEnemigo disparo = new DisparoEnemigo(posicion.x,posicion.y+30,logica);
		logica.getDisparos().add(disparo);
		logica.getInterfaz().setImage(disparo.getGrafico());
	}
	
	public void graficosNivel() {
		graficosNivel = new Icon[2];
		graficosNivel[0] = new ImageIcon(this.getClass().getResource("/Graficos/Final_Lugia.gif"));
		graficosNivel[1] = new ImageIcon(this.getClass().getResource("/Graficos/Final_Hooh.gif"));
	}

	@Override
	public int getDaño() {
		// TODO Auto-generated method stub
		return 0;
	}
}
