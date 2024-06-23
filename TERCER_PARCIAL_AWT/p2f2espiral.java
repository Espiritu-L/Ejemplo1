package TERCER_PARCIAL_AWT;


import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
public class p2f2espiral extends JFrame {
    
    // PARA MOSTRAR MENSAJES DE LA PANTALLA
    JLabel L1, L2;
    // PARA LOS BOTONES
    JButton B1, B2;

    int sw = 0;
    public p2f2espiral() {
        super("SOLUCION");

        // SE MOSTRARAN LOS SIG. BOTONES
        B1 = new JButton("VER GRAFICO"); // Aceptar la cadena ingresada
        B2 = new JButton("SALIR");

        // DAR COORDENADAS A LOS BOTONES (SUS POSICIONES)
        add(B1); B1.setBounds(250, 10, 120, 30);
        add(B2); B2.setBounds(650, 10, 100, 30);

        // YA TENEMOS LOS BOTONES, AHORA HACER QUE CADA BOTON HAGA UNA TAREA
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               sw = 1;
               repaint();
            }
        });

        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // ESTABLECER EL TAMAÑO DE LA VENTANA
        setLayout(null);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(0);
        setVisible(true);
    }

    public static void main(String[] args) {
        p2f2espiral pro = new p2f2espiral();
    }

    // realizando todos los graficos
    public void paint (Graphics g) {
        super.paint(g);
        if(sw == 1) {
            // LOS CIRCULOS
            g.setColor(Color.BLACK);
            int c=0, d = 0;
            for (int i=0; i<6;i++) {
                g.drawOval(50, 100+c, 100, 100);
                //d=d+50;
                c= c + 50;
            }
            // los cuadrados
            c = 0; d = 0;
            for (int i=0; i<9;i++) {
                g.drawRect(650+c,100+c,100,100);
                c = c + 25;
            }

            // letra 'ESPIRAL'
            Font fuente = new Font("Algerian", Font.BOLD, 30);
            g.setFont(fuente);
            g.setColor(Color.BLACK);
			g.drawString("ESPIRAL", 430, 420);
            // espiral figura
            int x=1;
            int x1 = 0, y1 = 0;
            int p1 = 0, q1 = 0;
            for (int i=0; i<7; i++) {

                if (x==1) {
                    g.drawLine(250+x1, 100+y1, 600-x1, 100+y1); // linia horizontal
                    g.drawLine(250+x1, 100+y1, 250+x1, 400-y1); // linia vertical
                    
                    x1 = x1 + 50; y1 = y1 + 25;
                    x=0;
                }else {
                    g.drawLine(550-p1, 400-q1, 250+p1, 400-q1);
                    g.drawLine(550-p1, 397-q1, 550-p1, 125+q1);

                    p1 = p1+50; q1=q1+20;
                    x=1;
                }
            }
            
            // triangulo invertidp
            d=0;
            for(int i=0; i<13; i++){
                g.drawLine(500, 580, 250+d, 450);
                d+=38;
            }
        }
    }
    
}

