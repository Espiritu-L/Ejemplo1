package TERCER_PARCIAL_AWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P7Cuatro4Triangulares extends JFrame {
    // PARA MOSTRAR MENSAJES DE LA PANTALLA
    JLabel L1;
    // PARA INGRESAR UN NUMERO
    JTextField T1;
    // PARA LOS BOTONES
    JButton B1, B2;

    int m[][], i, j, n=0, sw;

    public P7Cuatro4Triangulares () {
        super ("MATRIZ");
        m = new int[10][10];
        // SE MOSTRARA EL SIG. MSJ PARA INGRESAR UN NUMERO ()
        L1 = new JLabel("INGRESE DIMENSION PAR");
        T1 = new JTextField(); // PARA INGRESAR EL NUMERO Y ALMACENAR EN EL VECTOR
        // SE MOSTRARAN LOS SIG. BOTONES
        B1 = new JButton("ACEPTAR");// BOTON PARA GENERAR
        B2 = new JButton("SALIR");  // '' SALIR
        
        // DAR COORDENADA AL ESPACIO VACIO PARA INGRESAR UN NUM.
        add(L1); L1.setBounds(20, 10, 180, 30);
        add(T1); T1.setBounds(190, 10, 100, 30); 
        // DAR COORDENADAS A LOS BOTONES (SUS POSICIONES)
        add(B1); B1.setBounds(310, 10, 100, 30);
        add(B2); B2.setBounds(430, 10, 100, 30);
        
        // YA TENEMOS LOS BOTONES, AHORA HACER QUE CADA BOTON HAGA UNA TAREA
        B1.addActionListener(new ActionListener(){
    		public void actionPerformed (ActionEvent e) {
        		n = Integer.parseInt(T1.getText()); // dimension de la matriz
        		int x = n-1;
                if(n%2==0){
            		// LLENAR LA MATRIZ
            		for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            
                            if (j == x - i) {
                                m[i][j] = 2; // Diagonal secundaria
                            }
                            else if (i == j) {
                                m[i][j] = 1; // Diagonal principal
                            }
                            else if (i < j && (i + j) < n) {
                                m[i][j] = 4; // triangulo superior
                            }
                            else if (i > j && (i + j) < n) {
                                m[i][j] = 3; // triangulo izquierdo
                            }
                            else if (i < j && (i + j) >= n) {
                                m[i][j] = 5; // triangulo derecho
                            }
                            else if (i > j && (i + j) >= n) {
                                m[i][j] = 6; // triangulo inferior
                            }
                            
                        }
                    }
                
            		sw = 1;
            		repaint();
        		}else {
            		  JOptionPane.showMessageDialog(null,"SOLO DIMENSION PAR");
            		  
        		}
    		}
		});

        
        B2.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                System.exit(0);                            
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (sw == 1) {
            Font fuente = new Font("Algerian", Font.BOLD, 25);
            
            g.setFont(fuente);
            g.setColor(Color.BLACK);
			g.drawString("MATRIZ GENERADO", 220, 150);

            // Imprimir la matriz espiral
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                		// 					220->de izq. a der. + 200-> de arriba a abajo
                    g.drawString(String.valueOf(m[i][j]), 220 + j * 50, 200 + i * 50);
                }
            }
        }
    }

    public static void main(String[] args) {
        P7Cuatro4Triangulares pro = new P7Cuatro4Triangulares();
        pro.setLayout(null);
        pro.setSize(800,600);
        pro.setLocationRelativeTo(null);
        pro.setDefaultCloseOperation(0);
        pro.setVisible(true);
    }

}

