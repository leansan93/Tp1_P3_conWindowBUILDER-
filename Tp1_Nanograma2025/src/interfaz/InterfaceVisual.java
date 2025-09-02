package interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

 
import Negocio.TablaJuego;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class InterfaceVisual {

	private JFrame frame;
	private JToggleButton[][] botones;
	private TablaJuego tabla;
	
	
	private JPanel panelPistaColumna; 
    private	JPanel panelPistaFila ;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceVisual window = new InterfaceVisual();
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
	public InterfaceVisual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Nanograma");
		lblTitulo.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblTitulo.setBounds(144, 0, 107, 38);
		frame.getContentPane().add(lblTitulo);
		
		
		JPanel panelMatriz = new JPanel();
		panelMatriz.setBounds(109, 69, 366, 261);
		frame.getContentPane().add(panelMatriz);
		
		JButton btnVerificar = new JButton("verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*  con los botones matriz de la matriz que se pinto del usuario  se usara en el oto evento de "verificar" pero eso sera mas adelante
				 *  y ahi se comparara la  matriz del usuario con el creado y dira si gano o no */
				
			}
		});
		btnVerificar.setBounds(0, 307, 71, 23);
		frame.getContentPane().add(btnVerificar);
		
		
		
		
		panelPistaColumna= new JPanel();
		panelPistaColumna.setBounds(109, 40, 366, 29);
		frame.getContentPane().add(panelPistaColumna);
		
		panelPistaFila= new JPanel();
		panelPistaFila.setBounds(81, 71, 29, 259);
		frame.getContentPane().add(panelPistaFila);
		
		JButton btnTabla5x5 = new JButton("Tabla 5x5");
		btnTabla5x5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* 
				 * lo que hay que hacer dentro del evento de crear la tabla con el boton 5x5 
					es hacer un metodo a parte como clkearTabla()  donde se pueda recibir los clicks y guardarlos  
					tambien otro a parte que muestre las pistas directamente que esta ya en la parte logica 
					en los labels
					
					
				*/ 
		
				
				tabla = new TablaJuego (5); // crea desde la logica la tabla con un unico parametro
				int fila = tabla.getTamano(); // tamno de fila del tablero
				int columna = tabla.getTamano(); // tamano del tablero 
				botones = new JToggleButton [fila][columna]; // y creo el boton con esos tamanos 
				panelMatriz.removeAll(); // limpia antes por si había otra tabla
			    panelMatriz.setLayout(new GridLayout(fila, columna, 2, 2)); 
			    panelPistaFila.removeAll();
		        panelPistaColumna.removeAll();
			  
			  
			    
			    // los recorre y pinta  
			        for(int fil = 0; fil < fila; fil++) {
			            for(int col = 0; col < columna; col++) {
			                botones[fil][col] = new JToggleButton();
			                botones[fil][col].setOpaque(true);
			               
			                botones[fil][col].setBackground(Color.WHITE);
			                panelMatriz.add(botones[fil][col]);
			                
			                
			              
			             
			                
			            }
			        }
			        ///// muestra pista filas 
			        ArrayList<String> listaPistaFila = tabla.getPistasFilasComoTexto();
			       
			        for (String pista : listaPistaFila) {
			            JLabel labelFila = new JLabel(pista);
			            panelPistaFila.add(labelFila);
			        }
			        
			        
			        ////// muestra pistas columnas 
			        
				    ArrayList<String> listaPistaColumna= tabla.getPistasColumnasComoTexto();
			        
			      
			        for (String pista : listaPistaColumna) {
			           panelPistaColumna.add(new JLabel(pista));
			        }

			         
			         
			         
			         
			        panelMatriz.revalidate();
			        panelMatriz.repaint();
			        /// lo incorpora en la pantalla 
			        panelPistaFila.revalidate();
			        panelPistaFila.repaint();
			        panelPistaColumna.revalidate();
			        panelPistaColumna.repaint();
			       
			} 
		});
		btnTabla5x5.setBounds(0, 37, 79, 23);
		frame.getContentPane().add(btnTabla5x5);
		
		
		
	
		
				
	}
}
