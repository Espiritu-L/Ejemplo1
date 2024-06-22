package TERCER_PARCIAL_AWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays; // Importa la clase Arrays

public class P5MEDIANA_VECTORES extends  JFrame {
    // PARA MOSTRAR MENSAJES DE LA PANTALLA
    JLabel L1;
    // PARA INGRESAR UN NUMERO
    JTextField T1;
    // PARA LOS BOTONES
    JButton B1, B2, B3;
    int v[], i, j, n=0, sw;
    public P5MEDIANA_VECTORES () {

    	super ("VECTORES");
    	v = new int[100];
    	// SE MOSTRARA EL SIG. MSJ PARA INGRESAR UN NUMERO ()
    	L1 = new JLabel("ING. NUM. PARA EL VECTOR ");
    	T1 = new JTextField(); // PARA INGRESAR EL NUMERO Y ALMACENAR EN EL VECTOR
    	// SE MOSTRARAN LOS SIG. BOTONES
    	B1 = new JButton("ACEPTAR");// al ingresar el numero guardara
    	B2 = new JButton("SOLUCION"); // para ver la solucion
    	B3 = new JButton("SALIR"); // 
    	// DAR COORDENADA AL ESPACIO VACIO PARA INGRESAR UN NUM.
    	add(L1); L1.setBounds(10, 30, 200, 30);
    	add(T1); T1.setBounds(210, 30, 80, 30); 
    	// DAR COORDENADAS A LOS BOTONES (SUS POSICIONES)
    	add(B1); B1.setBounds(310, 30, 100, 30);
    	add(B2); B2.setBounds(440, 30, 100, 30);
    	add(B3); B3.setBounds(570, 30, 100, 30);
    	
    	// YA TENEMOS LOS BOTONES, AHORA HACER QUE CADA BOTON HAGA UNA TAREA
    	B1.addActionListener(new ActionListener(){
    		public void actionPerformed (ActionEvent e) {
    			v[n] = Integer.parseInt(T1.getText());
    			n++;
    			T1.setText("");
    			T1.setFocusable(true);	
    		}
    	});
    	
    	B2.addActionListener(new ActionListener(){
    		public void actionPerformed (ActionEvent e) {
    			sw = 1;
    			repaint();								
    		}
    	});
	
    	B3.addActionListener(new ActionListener(){
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
        	g.drawString("VECTOR ORIGINAL", 80, 150);
        	g.drawString("VECTOR ORDENADO", 400, 150);
        	// Dibujar el vector original
        	for (i = 0; i < n; i++) {
            	g.drawString(String.valueOf(v[i]), 100, 150 + (i + 1) * 40);
        	}
        
        
        	//ordenar el vector
			Arrays.sort(v, 0, n);

        
        	// Dibujar el vector ordenado
        	for (i = 0; i < n; i++) {
        		// Dibuja cada elemento del vector ordenado en la ventana
// Convierte el elemento del vector v[i] a una cadena de texto usando String.valueOf()
// Establece la posición horizontal del texto en 450 píxeles desde el borde izquierdo
// Calcula la posición vertical del texto de la siguiente manera:
//   - 150 es la distancia vertical inicial desde el borde superior
//   - (i + 1) * 40 calcula la distancia vertical para cada elemento del vector
//     (i + 1 para empezar en la segunda línea, y 40 es la separación entre líneas)
//   - Esto posiciona cada elemento del vector ordenado debajo del encabezado "VECTOR ORDENADO"
                                                    // de izq. a der.+, de a         
            	g.drawString(String.valueOf(v[i]), 450, 150 + (i + 1) * 40);
        	}
        	// Calcular la mediana
        	int medio = n / 2;
        	double mediana;
        	if (n % 2 == 0) {
            	mediana = (v[medio - 1] + v[medio]) / 2.0;
        	} else {
            	mediana = v[medio];
        	}
        	// Mostrar la mediana
        	g.drawString("LA MEDIANA ES: " + mediana, 100, 150 + (n + 1) * 40);
    	}
	}

    public static void main(String[] args) {
    	P5MEDIANA_VECTORES pro = new P5MEDIANA_VECTORES();
    	pro.setLayout(null);
    	pro.setSize(800,700);
    	pro.setLocationRelativeTo(null);
    	pro.setDefaultCloseOperation(0);
    	pro.setVisible(true);
    	
    }
}


