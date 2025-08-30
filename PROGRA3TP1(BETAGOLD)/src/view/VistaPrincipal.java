package view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controller.ControladorJuego;
import model.Tablero;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaPrincipal extends JFrame {

	private JFrame frame;
	private JToggleButton[][] botones;
	

	public VistaPrincipal(Tablero tableroActual) {
		initialize(tableroActual);
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Tablero tableroActual) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal window = new VistaPrincipal(tableroActual);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	private void initialize(Tablero tablero) {
		
		//frame = new JFrame();
		this.getContentPane().setBackground(new Color(240, 248, 255));
		this.setBounds(100, 100, 600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
        setTitle("Nonograma 5x5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel titulo = new JLabel("Nanograma!");
		titulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		titulo.setBounds(200, 11, 100, 50);
		this.getContentPane().add(titulo);
		this.setVisible(true);
		
		UIManager.put("ToggleButton.select", Color.BLACK);

		
		
		JPanel pistasColumnas = new JPanel();
		pistasColumnas.setBounds(125, 60, 250, 50);
		this.getContentPane().add(pistasColumnas);
		pistasColumnas.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel pistasFilas = new JPanel();
		pistasFilas.setBounds(60, 125, 50, 250);
		this.getContentPane().add(pistasFilas);
		pistasFilas.setLayout(new GridLayout(5, 0, 0, 0));
		
		//////////////////////////
		/*
		int cantFilas = 7;
		int cantColumnas = 7;
		
		
		JPanel Grilla5X5 = new JPanel();
		Grilla5X5.setBackground(new Color(255, 255, 240));
		Grilla5X5.setBounds(125, 125, 250, 250);
		frame.getContentPane().add(Grilla5X5);
		Grilla5X5.setLayout(new GridLayout(cantFilas, cantColumnas, 0, 0));
		*/

		
		int cantFilas = tablero.getFilas();
		int cantColumnas = tablero.getColumnas();
		PanelGrilla panelGrilla = new PanelGrilla(cantFilas, cantColumnas);
		this.getContentPane().add(panelGrilla);
		
		ControladorJuego controlador = new ControladorJuego(tablero, panelGrilla);
		
		JButton botonConfirmar = new JButton("CONFIRMAR");
		botonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.verificarSolucion();
				
			}
		});
		botonConfirmar.setBounds(157, 417, 114, 23);
		this.getContentPane().add(botonConfirmar);
		

		
		JButton mostrarSolucionBoton = new JButton("mostrarSolucionBoton");
		mostrarSolucionBoton.setBounds(0, 55, 89, 23);
		mostrarSolucionBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirMatriz(tablero.getSolucion());
			}
		});
		this.getContentPane().add(mostrarSolucionBoton);
		
		/*
		botones = new JToggleButton[cantFilas][cantColumnas];
		
		for(JToggleButton[] filas : botones) {
			
			for(JToggleButton items : filas) {
				items = new JToggleButton();
				items.setOpaque(true);
				items.setBackground(Color.WHITE);
				items.isSelected();
				SwingUtilities.updateComponentTreeUI(items);
				Grilla5X5.add(items);
				//myLabel.addMouseListener(myListener);
			}
			
		}
		*/
	////////////////////////////////////
	}
	
	
	private void imprimirMatriz(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
		
	}


	
}


