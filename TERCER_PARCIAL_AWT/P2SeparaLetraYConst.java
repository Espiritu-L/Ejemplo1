package TERCER_PARCIAL_AWT;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;

public class P2SeparaLetraYConst extends JFrame {
    JLabel L1, L2, L3, L4, L5, L6, L7;
    
    JTextField T1, T2, T3, T4, T5, T6, T7;
    
    JButton B1, B2;

    public P2SeparaLetraYConst() {
        super("SOLUCION");
        L1 = new JLabel("ING. UNA ORACION");
        T1 = new JTextField();

        L2 = new JLabel("TOTAL VOCALES");
        L3 = new JLabel("TOTAL PALABRAS");
        L4 = new JLabel("TOTAL CONSTANTES");
        L5 = new JLabel("TOTAL CARACTERES");
        L6 = new JLabel("TOTAL NUMEROS");

        T2 = new JTextField();
        T3 = new JTextField();
        T4 = new JTextField();
        T5 = new JTextField();
        T6 = new JTextField();

        B1 = new JButton("ACEPTAR");
        B2 = new JButton("SALIR");

        add(L1); L1.setBounds(10, 50, 200, 30); // PARA MOSTRAR MENSAJE DE (ING. UNA ORACION)
        add(T1); T1.setBounds(250, 50, 200, 30);

        add(L2); L2.setBounds(10, 100, 200, 30); //POSICION DEL MSJ (TOTAL VOCALES)
        add(T2); T2.setBounds(250, 100, 100, 30);

        add(L3); L3.setBounds(10, 150, 200, 30); //POSICION DEL MSJ (TOTAL PALABRAS)
        add(T3); T3.setBounds(250, 150, 100, 30); 

        add(L4); L4.setBounds(10, 200, 200, 30); //POSICION DEL MSJ (TOTAL CONSTANTES)
        add(T4); T4.setBounds(250, 200, 100, 30); 

        add(L6); L6.setBounds(10, 250, 200, 30); //Total num
        add(T6); T6.setBounds(250, 250, 100, 30); 
        
        add(L5); L5.setBounds(10, 300, 200, 30); //TOTAL CARACTERES)
        add(T5); T5.setBounds(250, 300, 100, 30);

        add(B1); B1.setBounds(500, 50, 100, 30);
        add(B2); B2.setBounds(500, 100, 100, 30);

        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String cad = T1.getText();

                int vocales = 0;
                for (int i = 0; i < cad.length(); i++) {
                    // char c = cad.charAt(i);
                    char c = Character.toLowerCase(cad.charAt(i));
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vocales++;
                    }
                }

                // cont de palabras
                String[] palabras = cad.split("\\s+"); // split(\\s+) Separar la cadena en palabras
                int totalPalabras = palabras.length; // Obtener el numero total de palabras

                // Contar el número de consonantes
                int consonantes = 0;
                for (int i = 0; i < cad.length(); i++) {
                    // convirtiendo el caracter actual a minuscula
                    char c = Character.toLowerCase(cad.charAt(i));
                    if (c >= 'a' && c <= 'z' && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                        // si cumple la codicion incrementamos consonantes
                        consonantes++;
                    }
                }

                int numeros = 0;
                for (int i = 0; i < cad.length(); i++) {
                    char c = cad.charAt(i);
                    if (c == '1' || c == '2' || c == '3' || c == '4' || c == '6'|| c == '7' || c == '8' || c == '9' || c == '0') {
                        numeros++;
                    }
                }

                // caracteres especiales
                int caracteres = 0;
                for(int i=0; i<cad.length(); i++){
                    
                }

                // Mostrar los resultados en los campos de texto correspondientes
                T2.setText(String.valueOf(vocales));
                T3.setText(String.valueOf(totalPalabras));
                T4.setText(String.valueOf(consonantes));
                
                T6.setText(String.valueOf(numeros));
                T5.setText(String.valueOf(caracteres));
            }
        });

        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // ESTABLECER EL TAMAÑO DE LA VENTANA
        setLayout(null);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(0);
        setVisible(true);
    }

    public static void main(String[] args) {
        P2SeparaLetraYConst pro = new P2SeparaLetraYConst();
    }
}

