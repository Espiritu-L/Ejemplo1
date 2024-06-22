package TERCER_PARCIAL_AWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P8MATRIZ_ESPIRAL extends JFrame {
    // PARA MOSTRAR MENSAJES DE LA PANTALLA
    JLabel L1;
    // PARA INGRESAR UN NUMERO
    JTextField T1;
    // PARA LOS BOTONES
    JButton B1, B2;
    
    int m[][], i, j, n=0, sw;
    int fi=0, ff = 0, ci=0, cf=0, c=0; // variables para hacer la matriz espiral
    
    public P8MATRIZ_ESPIRAL () {
        super ("MATRIZ");
        m = new int[10][10];
        // SE MOSTRARA EL SIG. MSJ PARA INGRESAR UN NUMERO ()
        L1 = new JLabel("INGRESE TAMANIO");
        T1 = new JTextField(); // PARA INGRESAR EL NUMERO Y ALMACENAR EN EL VECTOR
        // SE MOSTRARAN LOS SIG. BOTONES
        B1 = new JButton("GENERAR");// BOTON PARA GENERAR
        B2 = new JButton("SALIR");  // '' SALIR
        
        // DAR COORDENADA AL ESPACIO VACIO PARA INGRESAR UN NUM.
        add(L1); L1.setBounds(20, 30, 180, 30);
        add(T1); T1.setBounds(180, 30, 100, 30); 
        // DAR COORDENADAS A LOS BOTONES (SUS POSICIONES)
        add(B1); B1.setBounds(290, 30, 100, 30);
        add(B2); B2.setBounds(420, 30, 100, 30);
        
        // YA TENEMOS LOS BOTONES, AHORA HACER QUE CADA BOTON HAGA UNA TAREA
        B1.addActionListener(new ActionListener(){
    		public void actionPerformed (ActionEvent e) {
        		n = Integer.parseInt(T1.getText());
        		if(n%2==0){
            		// Inicializar variables para la matriz espiral
            		fi = 0; ff = n-1; ci = 0; cf = n-1; c = 1;
            		// LLENAR LA MATRIZ
            		while(c <= n*n){
                		// Llenar la fila inicial de der. a izq.
                		for(i=ci; i<=cf; i++){
                    		m[fi][i] = c++;
                		}
                		fi++;
                		//Llenar la columna de derecha, de arriba hacia abajo
                		for(i=fi; i<=ff; i++){
                    		m[i][cf] = c++;
                		}
                		cf--;
                		//Llenar la fila de abajo, de der. a izq.
                		for(i=cf; i>=ci; i--){
                    		m[ff][i] = c++;
                		}
                		ff--;
                		//Llenar la columna de izquierda, de abajo hacia arriba
                		for(i=ff; i>=fi; i--){
                    		m[i][ci] = c++;
                		}
                		ci++;
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
			g.drawString("MATRIZ ESPIRAL", 200, 150);

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
        P8MATRIZ_ESPIRAL pro = new P8MATRIZ_ESPIRAL();
        pro.setLayout(null);
        pro.setSize(800,600);
        pro.setLocationRelativeTo(null);
        pro.setDefaultCloseOperation(0);
        pro.setVisible(true);
    }
}


