package SEGUNDO_PARCIAL_J_SWING;

import javax.swing.*;
public class P3Examen_Inf_de_Persona {


    // impletacion de datos para nodo de la lista
    public static class Datos{
        int ci,estado;
        String nombre, profesion;
        char sexo;
        float sueldo;

        Datos sig;
    }
    

    // class para la resolucion del ejercicio
    public static class SOLUCION {

        Datos ingreso (Datos p, Datos u) {

            String dat = "";
            do{
                if(p == null){ p = new Datos();

                    p.nombre = JOptionPane.showInputDialog("INGRESE NOMBRE");
                    p.ci = Integer.parseInt(dat = JOptionPane.showInputDialog("INGRESE CI"));
                    p.profesion = JOptionPane.showInputDialog("INGRESE SU PROFESION");
                    p.sueldo = Float.parseFloat(dat = JOptionPane.showInputDialog("INGRESE SUELDO"));
                    dat = JOptionPane.showInputDialog("INGRESE SU SEXO M/F");
                    p.sexo = dat.charAt(0);
                    p.estado = Integer.parseInt(dat = JOptionPane.showInputDialog("ESTADO: ACTIVO 1: NO ACTIVO 0:",1));

                    p.sig = null;
                } else { u = new Datos();
                    u.nombre = JOptionPane.showInputDialog("INGRESE NOMBRE");
                    u.ci = Integer.parseInt(dat = JOptionPane.showInputDialog("INGRESE CI"));
                    u.profesion = JOptionPane.showInputDialog("INGRESE SU PROFESION");
                    u.sueldo = Float.parseFloat(dat = JOptionPane.showInputDialog("INGRESE SUELDO"));
                    dat = JOptionPane.showInputDialog("INGRESE SU SEXO M/F");
                    u.sexo = dat.charAt(0);
                    u.estado = Integer.parseInt(dat = JOptionPane.showInputDialog("ESTADO: ACTIVO 1: NO ACTIVO 0:",1));

                    u.sig = p;
                    p = u;

                }
                dat = JOptionPane.showInputDialog("PRESIONE * PARA FINALIZAR");
            }while(dat.compareTo("*") != 0);

            return p;
        }
        
        // mostrar por profesion
        void VerProfesion (Datos p, String men) {
            String dat = "";

            while (p!=null) {
                
                if(men.compareTo(p.profesion)==0 && p.estado == 1)
                {
                    dat = dat + "Nombre: "+p.nombre+"\nCi: "+p.ci+
                    "\nProfesion: "+p.profesion+"\nSexo: "+p.sexo+"\nSueldo: "+p.sueldo+"\n";
                }
                p = p.sig;
            }

            JOptionPane.showMessageDialog(null,"LISTA DE PROFESION "+men+"\n"+dat);
        }
    
        void ver(Datos p){
            String dat = "";
            while (p!=null) {
                dat = dat + "Nombre: "+p.nombre+"\nCi: "+p.ci+
                "\nProfesion: "+p.profesion+"\nSexo: "+p.sexo+"\nSueldo: "+p.sueldo+"\n";
                p = p.sig;
            }
            JOptionPane.showMessageDialog(null,"INFORMACION\n"+dat);
        }


        // para eliminar por nombre 
        void elim (Datos p){
            String dat = "", eli="";
            eli = JOptionPane.showInputDialog("INGRESE EL NOMBRE QUE DESEA ELIMINAR");
            while (p!=null) {
                if(eli.compareTo(p.nombre) == 0){
                    dat = dat + "Nombre: "+p.nombre+"\nCi: "+p.ci+
                    "\nProfesion: "+p.profesion+"\nSexo: "+p.sexo+"\nSueldo: "+p.sueldo+"\n";
                    p.estado = 0; break;
                }
                p=p.sig;
            }

            JOptionPane.showMessageDialog(null,"SE ELIMINO\n"+dat);
           
        }
    
    }


    public static void main(String[] args){

        SOLUCION sol = new SOLUCION();
        Datos p1 = null, u1 = null;
        String men="";

        String m1 = "1.- INGRESAR\n", m2 = "2.- VER PROFESION\n";
        String m3 = "3.- ELIMINAR FISCAMENTE INGRESANDO NOMBRE\n", m4 = "4.- SALIR\n";

        int op=0;
        do{
            men = JOptionPane.showInputDialog(m1+m2+m3+m4+"ELIJA UNA OPC");
            op = Integer.parseInt(men);
            switch (op) {
                case 1: p1 = sol.ingreso(p1, u1);
                    break;
                case 2: String pro = JOptionPane.showInputDialog("INGRESE PROFESION A BUSCAR");
                        sol.VerProfesion(p1, pro);
                    break;
                case 3: sol.elim(p1);
                    break;
                case 4: 
                    break;
            }

        }while(op!=4);
    }
}

