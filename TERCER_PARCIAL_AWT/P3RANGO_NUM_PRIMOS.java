package TERCER_PARCIAL_AWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class P3RANGO_NUM_PRIMOS extends JFrame {
    // PARA MOSTRAR MENSAJES DE LA PANTALLA
    JLabel L1;
    // PARA INGRESAR UN NUMERO
    JTextField T1;
    // PARA LOS BOTONES
    JButton B1, B2, B3, B4, B5;
    int v[], v1[], i, j, n=0, n1=0, sw; // v[] para todos los num. v1[] para numeros primos
    
    public P3RANGO_NUM_PRIMOS () {
        super ("VECTORES");
        v = new int[100];
        v1 = new int[100];
        // SE MOSTRARA EL SIG. MSJ PARA INGRESAR UN NUMERO ()
        L1 = new JLabel("ING. NUMERO");
        T1 = new JTextField(); // PARA INGRESAR EL NUMERO Y ALMACENAR EN EL VECTOR
        // SE MOSTRARAN LOS SIG. BOTONES
        B1 = new JButton("ACEPTAR");// al ingresar el numero guardara
        B2 = new JButton("VER"); // para ver la solucion
        B3 = new JButton("VER PRIMOS"); //
        B4 = new JButton("ORDENAR");
        B5 = new JButton("SALIR");

        // DAR COORDENADA AL ESPACIO VACIO PARA INGRESAR UN NUM.
        add(L1); L1.setBounds(300, 50, 100, 30);
        add(T1); T1.setBounds(450, 50, 100, 30); 
        // DAR COORDENADAS A LOS BOTONES (SUS POSICIONES)
        add(B1); B1.setBounds(650, 50, 100, 30);
        add(B2); B2.setBounds(650, 100, 100, 30);
        add(B3); B3.setBounds(650, 150, 150, 30);
        add(B4); B4.setBounds(650, 200, 100, 30);
        add(B5); B5.setBounds(650, 250, 100, 30);
        
        // YA TENEMOS LOS BOTONES, AHORA HACER QUE CADA BOTON HAGA UNA TAREA
        B1.addActionListener(new ActionListener(){
            //funcion para verificar si el numero ingresado es primo
            boolean isPrimo(int num){
                if(num <= 1) return false;
                if(num <= 3) return true;
                if(num % 2 == 0 || num % 3 == 0) return false;
                for(int i = 5; i * i <= num; i += 6){
                    if(num % i == 0 || num % (i + 2) == 0){
                        return false;
                    }
                }
                return true;
            }
            
            public void actionPerformed (ActionEvent e) {
                int num = Integer.parseInt(T1.getText());
                if(num >= 500 && num <= 1500){
                    v[n] = num;
                    n++;
                    T1.setText("");
                    T1.setFocusable(true);
                    if(isPrimo(num)){
                        v1[n1] = num;
                        n1++;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR SOLO NUMEROS ENTRE 500 Y 1500", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
                sw = 2;
                repaint();                                
            }
        });
        
        B4.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                // ordenar ambos vectores
                Arrays.sort(v, 0, n);
                Arrays.sort(v1, 0, n1);
                sw = 3;
                repaint();
            }
        });
        
        B5.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        Font fuente = new Font("Algerian", Font.BOLD, 25);
        g.setFont(fuente);
        g.setColor(Color.BLACK);
        
        if (sw == 1) {
            // Dibujar el vector original
            g.drawString("VECTOR ORIGINAL", 50, 150);
            for (i = 0; i < n; i++) {
                g.drawString(String.valueOf(v[i]), 80, 150 + (i + 1) * 40);
            }
        } else if (sw == 2) {
            // Dibujar el vector de números primos
            g.drawString("VECTOR PRIMOS", 300, 150);
            for (i = 0; i < n1; i++) {
                g.drawString(String.valueOf(v1[i]), 320, 150 + (i + 1) * 40);
            }
        } else if (sw == 3) {
            // Dibujar el vector original ordenado
            g.drawString("VECTOR ORIGINAL", 50, 150);
            for (i = 0; i < n; i++) {
                g.drawString(String.valueOf(v[i]), 80, 150 + (i + 1) * 40);
            }
            // Dibujar el vector de números primos ordenado
            g.drawString("VECTOR PRIMOS", 300, 150);
            for (i = 0; i < n1; i++) {
                g.drawString(String.valueOf(v1[i]), 320, 150 + (i + 1) * 40);
            }
        }
    }
    
    public static void main(String[] args) {
        P3RANGO_NUM_PRIMOS pro = new P3RANGO_NUM_PRIMOS();
        pro.setLayout(null);
        pro.setSize(900,700);
        pro.setLocationRelativeTo(null);
        pro.setDefaultCloseOperation(0);
        pro.setVisible(true);
    }
}

