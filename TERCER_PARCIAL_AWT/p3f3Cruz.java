package TERCER_PARCIAL_AWT;


import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.*;
import java.awt.event.*;

public class p3f3Cruz extends JFrame {
    // PARA MOSTRAR MENSAJES DE LA PANTALLA
    JLabel L1, L2;
    // PARA LOS BOTONES
    JButton B1, B2;

    int sw = 0;
    public p3f3Cruz() {
        super("SOLUCION");

        // SE MOSTRARAN LOS SIG. BOTONES
        B1 = new JButton("DIBUJAR"); // Aceptar la cadena ingresada
        B2 = new JButton("SALIR");

        // DAR COORDENADAS A LOS BOTONES (SUS POSICIONES)
        add(B1); B1.setBounds(250, 0, 100, 30);
        add(B2); B2.setBounds(450, 0, 100, 30);

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
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(0);
        setVisible(true);
    }
    public static void main(String[] args) {
        p3f3Cruz pro = new p3f3Cruz ();
    }

    public void paint (Graphics g) {
        super.paint(g);
        if(sw == 1) {
            // linias de interseccion
            g.setColor(Color.RED);
            g.drawLine(0,0, 800, 600);
            g.drawLine(0,600, 800, 0);
            // hacer el cuadro repetido
            g.setColor(Color.blue);
            int c=0, d = 0;
            for (int i=0; i<5;i++) {
                g.drawRect(30+c,180+c,180-d,240-d);
                c = c + 20; d = d + 40;
            }
            c = 0; d = 0;
            for (int i=0; i<5;i++) {
                g.drawRect(580+c,180+c,180-d,240-d);
                c = c + 20; d = d + 40;
            }

            //realizando los circulos
            c=0; d=0;
            for (int i=0; i<4; i++) {
                /* g.drawOval(x1,y1,x2,y2);
                x1, y1: coordenadas del punto superior izquier del rectangulo
                que encierra al circulo

                x2: representa el ancho del rectangulo que encierra al circulo
                y2: representa el ancho del rectangulo que encierra al circulo
                */
                g.drawOval(380-c, 280-c, 50+d, 50+d);
                d=d+50;
                c= c +25;
            }
            // realizando el triangulo
            g.setColor(Color.GREEN);
            g.drawLine(400, 420, 200, 580);
            g.drawLine(400, 420, 600, 580);
            g.drawLine(200, 580, 600, 580);
            //g.draw3DRect(d, c, d, d, rootPaneCheckingEnabled);
            //g.drawImage(getIconImage(), c, d, getForeground(), rootPane);
        }
    }

}

