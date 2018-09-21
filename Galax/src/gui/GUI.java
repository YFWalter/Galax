package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800, HEIGHT = 600;

	private JPanel contentPane;

	private Juego j;
	private ContadorTiempo tiempo;
	final GUI gui=this; 
	private JLabel Puntaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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



	public GUI() {

		addKeyListener(new Oyente());

		getContentPane().setLayout(null);		
		setTitle("Galax");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		//setBounds(100, 100, 450, 300);


		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		j = new Juego(this);
		tiempo = new ContadorTiempo(j);
		tiempo.start();
		
		Puntaje=new JLabel("Puntaje:");
		Puntaje.setBounds(0,-40,500,100);
		Puntaje.setForeground(Color.white);
		add(Puntaje);
		//this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
	}

	protected void mover(KeyEvent key){
		j.mover(key.getKeyCode());

		this.repaint();
	}

	private class Oyente extends java.awt.event.KeyAdapter{
		Entrada<JLabel,Integer> numero=null;
		@Override
		public void keyPressed(KeyEvent arg0) {

			if(arg0.getKeyCode()==KeyEvent.VK_SPACE)
			{
				numero=j.MatarEnemigo();
				if(numero!=null)
				{
					gui.remove(numero.getClave());
					j.RemoverEnemigo(numero.getValor());
					Puntaje.setText("Puntaje: "+j.getPuntajeJuego());
				}
			}
			else mover(arg0);
		}
	}
}
