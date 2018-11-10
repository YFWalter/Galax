package Juego;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.ControladorDisparo;
import Controladores.ControladorEnemigos;
import ObjetosDinamicos.Enemigo;
import ObjetosEstaticos.Obstaculo;
import Sonido.Sonido;

public class Interfaz extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800, HEIGHT = 600;

	private JPanelFondo contentPane;
	protected JPanel menu;
	protected JLabel municionSuper,municionTriple,municionComun;
	protected JPanel contentPuntaje; 
	protected JPanel contentJuego; 
	protected JPanel contentPower; 
	
	protected Logica logica;
	
	protected boolean tecladoHabilitado;
	protected boolean enterHabilitado;
	protected boolean gameOver;
	protected boolean winner;
	
	protected Timer timerFinJuego;
	
	protected JLabel Puntaje;
	protected JLabel Vidas[];
	protected ImageIcon corazones[];
	
	protected ControladorDisparo controladorDisparos;				
	protected ControladorEnemigos controladorEnemigos;
	
	protected Sonido sonidoFondo,sonidoStart,sonidoFinal,sonidoWinner,sonidoGameOver;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */



	public Interfaz() {
		habilitarEnter();
		habilitarTeclado();
		gameOver = false;
		addKeyListener(new OyenteTeclado(this));
		getContentPane().setLayout(null);		
		setTitle("Galax");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanelFondo();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TimerClass tc = new TimerClass(); 
		timerFinJuego = new Timer(2500,tc);
		
		logica = new Logica(this);
		

			sonidoFondo= new Sonido("/Sounds/Pokemon8Bit.wav");
			sonidoFondo.setLooping(true);
			sonidoFondo.play();
		
		sonidoStart = new Sonido("/Sounds/Start.wav");
	
		crearMenu();
	}
	
	public void actualizarPuntaje() {
		Puntaje.setText("Puntaje : "+logica.getPuntajeJuego());
	}
	
	public void actualizarVidas(){
		int vidas = logica.getJugador().getVida();
		switch(vidas) {
			case 6:{
				Vidas[0].setIcon(corazones[0]);
				Vidas[1].setIcon(corazones[0]);
				Vidas[2].setIcon(corazones[0]);
				break;
			}
			case 5:{ 
				Vidas[0].setIcon(corazones[1]);
				Vidas[1].setIcon(corazones[0]);
				Vidas[2].setIcon(corazones[0]);
				break;
				}
			case 4:{
				Vidas[0].setIcon(corazones[2]);
				Vidas[1].setIcon(corazones[0]);
				Vidas[2].setIcon(corazones[0]);
				break;
			}
			case 3:{
				Vidas[0].setIcon(corazones[2]);
				Vidas[1].setIcon(corazones[1]);
				Vidas[2].setIcon(corazones[0]);
				break;
			}
			case 2:{
				Vidas[0].setIcon(corazones[2]);
				Vidas[1].setIcon(corazones[2]);
				Vidas[2].setIcon(corazones[0]);
				break;
			}
			case 1:{
				Vidas[0].setIcon(corazones[2]);
				Vidas[1].setIcon(corazones[2]);
				Vidas[2].setIcon(corazones[1]);
				break;
			}
			case 0:{
				Vidas[0].setIcon(corazones[2]);
				Vidas[1].setIcon(corazones[2]);
				Vidas[2].setIcon(corazones[2]);
				break;
			}
		}
	}
		
	public void corazonesGraficos() {
		corazones = new ImageIcon[3];
		corazones[0] = new ImageIcon(this.getClass().getResource("/Graficos/corazon_lleno.png"));
		corazones[1] = new ImageIcon(this.getClass().getResource("/Graficos/corazon_mitad.png"));
		corazones[2] = new ImageIcon(this.getClass().getResource("/Graficos/corazon_vacio.png"));
	}
	
	public JLabel[] GenerarVidas() {
		
		JLabel Vidas[] = new JLabel[3];
		
		Vidas[0] = new JLabel(new ImageIcon(this.getClass().getResource("/Graficos/corazon_lleno.png")));
		Vidas[1] = new JLabel(new ImageIcon(this.getClass().getResource("/Graficos/corazon_lleno.png")));
		Vidas[2] = new JLabel(new ImageIcon(this.getClass().getResource("/Graficos/corazon_lleno.png")));
		
		Vidas[0].setBounds(650, 0, 50, 50);
		Vidas[1].setBounds(700, 0, 50, 50);
		Vidas[2].setBounds(750, 0, 50, 50);
		
		add(Vidas[0]);
		add(Vidas[1]);
		add(Vidas[2]);
		
		return Vidas;
	}
	
	public Icon[] GenerarMuniciones() {
		
		Icon Municiones[] = new Icon[3];
		
		Municiones[0] = new ImageIcon(this.getClass().getResource("/Graficos/Pokeball_Municion.png"));
		Municiones[1] = new ImageIcon(this.getClass().getResource("/Graficos/Tripleball_Municion.png"));
		Municiones[2] = new ImageIcon(this.getClass().getResource("/Graficos/Superball_Municion.png"));
		
		return Municiones;
 	}
	
	public void setImage(JLabel image) {
		add(image);
		repaint();
	}
	
	public void removeImage(JLabel image) {
		remove(image);
	}
	
	public void addObstaculos(Vector<Obstaculo> obstaculos) {
		for(Obstaculo o : obstaculos)
			add(o.getGrafico());
	}
	
	public void addEnemigos(Vector<Enemigo> enemigos) {		
		for(Enemigo e : enemigos)
			add(e.getGrafico());
	}
	
	
	public void reiniciarPanelesJuego(){
		
		contentPane.removeAll(); 
		cambiarFondo();	
		this.repaint(); 
	}
	
	private void jugadorDispara() {
		logica.getJugador().disparar(logica);
	}
	
	public void mover(KeyEvent key) {
		logica.moverPersonaje(key.getKeyCode());
		this.repaint();
	}
	
	public void habilitarEnter() {
		enterHabilitado = true;
	}
	
	private void deshabilitarEnter() {
		enterHabilitado = false;
		
	}
	
	public void habilitarTeclado() {
		tecladoHabilitado = true;
	}

	public void deshabilitarTeclado() {
		tecladoHabilitado = false;
	}
	
	public void actualizarMunicion() {
		municionTriple.setText(logica.getJugador().municionTriple()+"x");
		municionSuper.setText(logica.getJugador().municionSuper()+"x");
		
	}
	
	public void cambiarFondo(){
		Image img = new ImageIcon(getClass().getResource("/Graficos/mapa.png")).getImage(); 		
		contentPane.setImage(img);
	}
	
	
	protected void crearMenu(){
		
		menu = new JPanel(); 
		menu.setBounds(0, 0, 800, 600);
		menu.setOpaque(false);
		menu.setLayout(null); 
		
		Image inicio = new ImageIcon(getClass().getResource("/Graficos/inicio.png")).getImage();
		contentPane.setImage(inicio);
		contentPane.add(menu);
		
		JLabel start =new JLabel();
		start.setBounds(300,210,250,106);
		start.setIcon( new ImageIcon(getClass().getResource("/Graficos/Start.gif")));
		addKeyListener(new OyenteStart());
		add(start);
		
		this.repaint(); 
	}
	
	public void inicializarPanelesJuego(){
		habilitarTeclado();
		inicializarPaneles();	
		cambiarFondo();
		
		logica.generarMapa();
		logica.moverEntidades();
		
		actualizarMunicion();
		actualizarPuntaje();
		
		this.repaint(); 
	}
	
	public void inicializarPaneles(){
		crearPanelPuntajeJuego();
		inicializarPanelesAux();
	}
	
	public void inicializarPanelesAux(){
		
		corazonesGraficos();
		Vidas = GenerarVidas();
		
		Icon Municiones[] = GenerarMuniciones();
		
		municionComun = new JLabel();
		municionComun.setText("∞x");
		municionComun.setHorizontalTextPosition(2);
		municionComun.setIcon(Municiones[0]);
		municionComun.setFont(new Font("Arial",1,20));
		municionComun.setBounds(200,0,100, 25);
		
		
		municionTriple = new JLabel();
		municionTriple.setText("0x");
		municionTriple.setHorizontalTextPosition(2);
		municionTriple.setIcon(Municiones[1]);
		municionTriple.setFont(new Font("Arial",1,20));
		municionTriple.setBounds(300,0,100, 25);
				
		municionSuper = new JLabel();
		municionSuper.setText("0x");
		municionSuper.setHorizontalTextPosition(2);
		municionSuper.setIcon(Municiones[2]);
		municionSuper.setFont(new Font("Arial",1,20));
		municionSuper.setBounds(400,0,100, 25);
		
		add(municionComun);
		add(municionTriple);
		add(municionSuper);
		
		this.repaint();
	}
	
	protected void crearPanelPuntajeJuego(){
			
		Puntaje=new JLabel("Puntaje:");
		Puntaje.setBounds(0,-40,500,100);
		Puntaje.setForeground(Color.black);
		add(Puntaje);
		
		this.repaint();
	}
	
	private class TimerClass implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			timerFinJuego.stop();
			contentPane.removeAll(); 
			contentPane.setLayout(null);
			reiniciarPanelesJuego();
			//inicializarPanelesDos();
			inicializarPanelesJuego(); 
		}
	}
	
	@SuppressWarnings("unused")
	private class OyenteStart extends KeyAdapter{
		
		public void keyPressed(KeyEvent arg0) {
			if(gameOver || winner) {
				System.exit(0);
			}
			if(arg0.getKeyCode() == KeyEvent.VK_ENTER && enterHabilitado && !gameOver) {
				sonidoStart.play();
				contentPane.removeAll();
				inicializarPanelesJuego();
				deshabilitarEnter();
			}
		}

		
	}
	
	private class OyenteTeclado extends KeyAdapter{
		@SuppressWarnings("unused")
		protected Interfaz interfaz;

		public OyenteTeclado(Interfaz interfaz){
			this.interfaz = interfaz; 
		}

		private boolean esFlecha(KeyEvent e){
			return (e.getKeyCode()==KeyEvent.VK_UP || 
					e.getKeyCode()==KeyEvent.VK_DOWN ||
					e.getKeyCode()==KeyEvent.VK_LEFT || 
					e.getKeyCode()==KeyEvent.VK_RIGHT);
		}

		public void keyPressed(KeyEvent arg0) {

			if(esFlecha(arg0)){
				mover(arg0);
			}
			if(arg0.getKeyCode() == KeyEvent.VK_B)
				cambiarArma();
		}

		private void cambiarArma() {
			logica.getJugador().cambiarArma();
		}

		public void keyReleased(KeyEvent arg0)
		{
			if(logica!=null && tecladoHabilitado)
				if(arg0.getKeyCode()==KeyEvent.VK_SPACE )
					jugadorDispara();

		}
	}
	
	private class JPanelFondo extends JPanel{ 
		private static final long serialVersionUID = 1L;
		private Image image = null; 
	
		protected void paintComponent(Graphics g) { 
			Graphics2D g2 =(Graphics2D) g; 
			if(getImage()!=null){ 
				g2.drawImage(getImage(), 0, 0, getWidth(), getHeight(), null); 
			} 
		} 
	
		public Image getImage() { 
			return image; 
		} 
	
		public void setImage(Image image) { 
			this.image = image; 
		} 
	}

	public void winner() {
	
		actualizarPuntaje();
		deshabilitarTeclado();
		habilitarEnter();
		winner = true;
		
		String puntos = Puntaje.getText(); 
		
		JLabel score = new JLabel();
		score.setBounds(0,350,600,300);
		score.setForeground(Color.black);
		score.setHorizontalAlignment(JLabel.CENTER);
		score.setFont(new Font("Arial",1,24));
		score.setText(puntos);
		
		JPanel Winner = new JPanel();
		Winner.setOpaque(false);
		Winner.setBounds(0, 0, 800, 600);
		Winner.add(score);
		
		contentPane.removeAll();
		repaint();
		
		Image img = new ImageIcon(getClass().getResource("/Graficos/Winner.png")).getImage(); 		
		contentPane.setImage(img);
		
		if(sonidoFinal != null)
			sonidoFinal.stop();
		else
			sonidoFondo.stop();
		
		sonidoWinner = new Sonido("/Sounds/Winner.wav");
		sonidoWinner.play();
		
		contentPane.add(Winner); 	
		repaint();
	}
	
	public void gameOver(){
		actualizarPuntaje();
		deshabilitarTeclado();
		habilitarEnter();
		gameOver = true;
		String puntos = Puntaje.getText();
				
		JLabel score = new JLabel();
		score.setBounds(250,290,300,100);
		score.setForeground(Color.black);
		score.setHorizontalAlignment(JLabel.CENTER);
		score.setFont(new Font("Arial",1,24));
		score.setText(puntos);
		
		JPanel GameOver = new JPanel();
		GameOver.setOpaque(false);
		GameOver.setBounds(0, 0, 800, 600);
		GameOver.add(score);
		
		contentPane.removeAll();
		repaint();
		
		Image img = new ImageIcon(getClass().getResource("/Graficos/GameOver.jpg")).getImage(); 		
		contentPane.setImage(img);
		
		if(sonidoFinal != null)
			sonidoFinal.stop();
		else
			sonidoFondo.stop();
		
		sonidoGameOver = new Sonido("/Sounds/GameOver.wav");
		sonidoGameOver.play();
		
		contentPane.add(GameOver);
		repaint();
	}

	public void sonidoFinal() {
		sonidoFondo.stop();
		sonidoFinal = new Sonido("/Sounds/Final.wav");
		sonidoFinal.play();
	}
}


