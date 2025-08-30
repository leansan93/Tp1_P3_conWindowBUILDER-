package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelGrilla extends JPanel {
	
	private JToggleButton[][] botones; // MATRIZ DE BOTONES
	
	// INTERFAZ CeldaListener
	public interface CeldaListener {
		void celdaClickeada(int fila, int columna);
	}
	
	// CONSTRUCTOR DE LA GRILLA
	public PanelGrilla(int filas, int columnas) {
		this.setBackground(new Color(255, 255, 240));
		this.setBounds(125, 125, 250, 250);
		setLayout(new GridLayout(filas, columnas));
		botones = new JToggleButton[filas][columnas];
		
		// RECORREMOS LAS FILAS Y COLUMNAS
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				// CREAMOS LOS BOTONES PARA CADA CELDA
				JToggleButton btn = new JToggleButton();
				btn.setBackground(Color.WHITE);
				btn.setOpaque(true);
				btn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				botones[i][j] = btn;
				add(btn);
			}
		}
		/*
		
		
		for(JToggleButton[] filasArray : botones) {
			
			for(JToggleButton items : filasArray) {
				items = new JToggleButton();
				items.setOpaque(true);
				items.setBackground(Color.WHITE);
				items.isSelected();
				SwingUtilities.updateComponentTreeUI(items);
				this.add(items);
				//myLabel.addMouseListener(myListener);
			}
			
		}
		*/
	}
	
	// ACTIVAR CELDA CLICKEADA, PASAMOS COMO PARAMETRO LA INTERFAZ CeldaListener
	public void activarClickCelda(CeldaListener listener) {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[0].length; j++) {
				int fila = i;
				int columna = j;
				botones[i][j].addActionListener(e -> listener.celdaClickeada(fila, columna));
			}
		}
	}
	
	// ACTUALIZAR CELDAS AL CLICKEAR, PARA PODER CAMBIAR DE COLOR Y A X.
	public void actualizar(int[][] celdas) {
	    for (int i = 0; i < botones.length; i++) {
	        for (int j = 0; j < botones[0].length; j++) {
	            JToggleButton btn = botones[i][j];
	            switch (celdas[i][j]) {
	                case 0 -> { btn.setBackground(Color.WHITE); btn.setText(""); } // BLANCO
	                case 1 -> { btn.setBackground(Color.BLACK); btn.setText(""); } // NEGRO
	                case -1 -> { btn.setBackground(Color.WHITE); btn.setText("X"); } // X
	            }
	        }
	    }
	}
	
	// METODO PARA MOSTRAR SOLUCION AL PRINCIPIO
	public void mostrarSolucion(int[][] solucion) {
	    for (int i = 0; i < botones.length; i++) {
	        for (int j = 0; j < botones[0].length; j++) {
	            JToggleButton btn = botones[i][j];
	            switch (solucion[i][j]) {
	            case 0 -> { btn.setBackground(Color.WHITE); btn.setText(""); } // BLANCO
                case 1 -> { btn.setBackground(Color.BLACK); btn.setText(""); } // NEGRO
                case -1 -> { btn.setBackground(Color.WHITE); btn.setText("X"); } // X
	            }
	        }
	    }
	}
	
	// GETTERS
	public JToggleButton getBoton(int fila, int columna) { return botones[fila][columna]; }
	public void mostrarMensaje(String msg) { JOptionPane.showMessageDialog(this, msg); }
	
}
