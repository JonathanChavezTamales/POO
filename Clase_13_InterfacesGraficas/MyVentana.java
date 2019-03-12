import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

public class MyVentana extends JFrame{

    public MyVentana(){
        super("Mi primer ventana");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setSize(800, 600);
        MyPanel p = new MyPanel();
        this.add(p);
        this.add(new MyPanelControles(p), BorderLayout.WEST);
        //Pack agarra el preferred size de MyPanel y es el tamano del interior de la ventana (canvas)
        this.pack();
        this.setVisible(true);
    }


    public static void main(String[] args){
        MyVentana v = new MyVentana();
    }

}

/*

JFrame tiene problemas a la hora de exportarlo a otras resoluciones, para eso se usa el JPanel

*/