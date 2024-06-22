package TERCER_PARCIAL_AWT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class P1ContarTodo extends JFrame {
    JButton B1,B2;
    JTextField T1;
    JLabel L1;
    int sw=0;
    int TPalabras=0, TVocal=0, TConsonante=0, TNumero=0, TEspeciales=0;
    public P1ContarTodo()
    {
    	super("Frase");
    	L1=new JLabel("");
		T1= new JTextField(); 
    	B1= new JButton("Convertir");
    	B2= new JButton("SALIR");
    	//add(L1);L1.setBounds(20,50,150,30);
    	add(T1);T1.setBounds(20,50,300,30);
    	add(B1);B1.setBounds(20,100,100,30); 
		add(B2);B2.setBounds(270,100,100,30);
    	B1.addActionListener(new ActionListener ()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			String frase=T1.getText();
                TPalabras=frase.split("\\s+").length;
                TVocal=0;
                TConsonante=0;
                TNumero=0;
                TEspeciales=0;
                for (char c:frase.toCharArray())
                {
                    if (c>='0' && c<='9')
                    {
                        TNumero++;
                    }
                    else if ((c>='A' && c<='Z') || (c>='a' && c<='z'))
                    {
                        if (c=='A' || c=='E' || c=='I' || c=='O' || c=='U' ||
                            c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                        {
                            TVocal++;
                        } 
                        else
                        {
                            TConsonante++;
                        }
                    } else if (c!=' ' && c!='\t' && c!='\n' && c!='\r') {
                        TEspeciales++;
                    }
                }
                sw = 1;
                repaint();
    		}
    	}
    	);
    	B2.addActionListener(new ActionListener ()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			System.exit(0);
    		}
    	}
    	);
    }
    public void paint(Graphics g) {
	    super.paint(g);
	    if (sw == 1) {
            Font fuente = new Font("Algerian", Font.BOLD, 25);
            g.setFont(fuente);
            g.setColor(Color.BLACK);
	        g.drawString("TOTAL PALABRAS: " + TPalabras, 50, 300);
            g.drawString("TOTAL VOCALES: " + TVocal, 50, 320);
            g.drawString("TOTAL CONSONANTES: " + TConsonante, 50, 340);
            g.drawString("TOTAL NUMEROS: " + TNumero, 50, 360);
            g.drawString("TOTAL CARACTERES ESPECIALES: " + TEspeciales, 50, 380);
	    }
	}	
    public static void main(String[] args) {
    	P1ContarTodo proy= new P1ContarTodo();
    	proy.setLayout(null);
    	proy.setSize(500,500);
    	proy.setLocationRelativeTo(null);
    	proy.setDefaultCloseOperation(0);
    	proy.setVisible(true);
    	
    }
}
