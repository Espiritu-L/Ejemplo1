package TERCER_PARCIAL_AWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P6Matri_Con4Cuadros extends JFrame {

    JLabel L1;
    
    JTextField T1;
    
    JButton B1, B2;
    
    int[][] m;
    int i, j, n=0, sw;
    
    public P6Matri_Con4Cuadros () {
        super ("MATRIZ");
        m = new int[10][10];
        
        
        L1 = new JLabel("INGRESE TAMANIO");
        T1 = new JTextField();
        
        B1 = new JButton("GENERAR");// BOTON PARA GENERAR
        B2 = new JButton("SALIR");  // '' SALIR
        
        
        add(L1); L1.setBounds(20, 30, 180, 30);
        add(T1); T1.setBounds(180, 30, 100, 30); 
    
        add(B1); B1.setBounds(290, 30, 100, 30);
        add(B2); B2.setBounds(420, 30, 100, 30);
        
        
        B1.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e) {
                n = Integer.parseInt(T1.getText());
                if(n%2!=0){
                    int k = n/2;
                    for(i=0; i<n; i++){
                        for(j=0; j<n; j++){
                            if(i<k && j<k){
                                m[i][j] = 1;
                            }
                            else if(i<k && j>k){
                                m[i][j] = 3;
                            } 
                            else if(i>k && j<k){
                                m[i][j] = 2;
                            }
                            else if(i>k && j>k){
                                m[i][j] = 4;
                            }
                            else {
                                m[i][j] = 8;
                            }

                        }
                    }
                    sw = 1;
                    repaint();
                }else {
                    JOptionPane.showMessageDialog(null,"SOLO DIMENSION IMPAR");
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
            int suma = 0;
            g.setFont(fuente);
            g.setColor(Color.BLACK);
            g.drawString("MATRIZ GENERADO", 200, 150);

            
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    g.drawString(String.valueOf(m[i][j]), 220 + j * 50, 200 + i * 50);
                    if(i==j || i+j==n-1 || i+j==n-1){
                        suma = suma + m[i][j];
                    }
                }
            }
            suma = suma + 8;
            g.drawString(String.valueOf("la suma es ") + suma, 200, 550);

        }
    }
    
    public static void main(String[] args) {
        P6Matri_Con4Cuadros pro = new P6Matri_Con4Cuadros();
        pro.setLayout(null);
        pro.setSize(800,600);
        pro.setLocationRelativeTo(null);
        pro.setDefaultCloseOperation(0);
        pro.setVisible(true);
    }
}

