package TERCER_PARCIAL_AWT;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
public class p1f1SDNHV extends JFrame {
    
    
    JLabel L1, L2;
    
    JButton B1, B2, B3;

    int sw = 0;
    public p1f1SDNHV() {
        super("SOLUCION");

        B1 = new JButton("LINIAS"); // Aceptar la cadena ingresada
        B2 = new JButton("CIRCULOS");
        B3 = new JButton("SALIR");

        add(B1); B1.setBounds(250, 10, 100, 30);
        add(B2); B2.setBounds(350, 10, 100, 30);
        add(B3); B3.setBounds(450, 10, 100, 30);

        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               sw = 1;
               repaint();
            }
        });

        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               sw = 2;
               repaint();
            }
        });

        B3.addActionListener(new ActionListener() {
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
        p1f1SDNHV pro = new p1f1SDNHV();
    }

    
    public void paint (Graphics g) {
        super.paint(g);
        int c=0, d = 0;
        // LINIAS
        if(sw == 1) {
            // LINIAS 1
            g.setColor(Color.BLUE);
            for (int i=0; i<8;i++) {
                g.drawLine(400, 200, 400-d, 400);
                d=d+25;
            }
            // linias 2 
            c = 0; d = 0;
            for (int i=0; i<8;i++) {
                g.drawLine(600, 400, 420, 200+c);
                c = c + 25;
            }

            // letra 'SIN DIOS NO HAY VIDAL'
            Font fuente = new Font("Cambria", Font.BOLD, 35);
            g.setFont(fuente);
            g.setColor(Color.BLACK);
			g.drawString("SIN DIOS NO HAY VIDA", 200, 250);

            // LINIAS U
            d = 0; c = 0;
            for(int i=0; i<3; i++){
                g.drawLine(20, 200 + c, 50 + c, 100); // 1
                g.drawLine(50 + c, 100, 50 + c, 550 - c); // 2
                g.drawLine(50+c, 550-c, 750 - c, 550 - c); // 3
                g.drawLine(750 - c, 550 - c, 750 - c, 100); // 4
                g.drawLine(750 - c, 100, 780, 200+c); // 5
                
                c = c + 10;

            }
            
        }

        // CIRCULOS
        else if(sw == 2) {
            c = 0;
            // circulos de arriba
            g.setColor(Color.BLACK);
            for(int i=0; i<5; i++){
                g.drawOval(200+c, 100, 80, 70);
                c = c + 80;
            }
            c = 0;
            // circulos de la diagonal principal
            for(int i=0; i<10; i++){
                g.setColor(Color.black);
                g.fillOval(18+c, 98 + c, 57, 57);
                g.setColor(Color.WHITE);
                g.fillOval(20+c, 100 + c, 54, 54);
                c = c + 23;
            }
            c=0;
            // grupo de circulos 2
            for(int i=0; i<11; i++){
                g.setColor(Color.BLACK);
                g.fillOval(348+c, 436, 58, 58);
                g.setColor(Color.WHITE);
                g.fillOval(350+c, 438, 54, 54);
                c = c + 23;
            }
            g.setColor(Color.black);
            g.drawRect(20, 200, 40, 380);// cuadrado 1
            g.drawRect(450, 200, 300, 35);// cuadrado 

            Font fuente = new Font("Algerian", Font.BOLD, 35);
            g.setFont(fuente);
            g.setColor(Color.BLACK);
			g.drawString("VIVA LA U.T.O",180,230);

        }
    }
    
}
