import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import java.lang.InterruptedException;


public class MyPanel extends JPanel implements Runnable, MouseListener{

    private Image fondo;
    private int xV, yV;
    private String nombre = "Pocoyo";

    public MyPanel(){
        super();
        this.setPreferredSize(new Dimension(500,500));
        //Imagen de Fondo
        this.fondo = new ImageIcon("planeta.jpeg").getImage();
        Thread hilo = new Thread(this);
        hilo.start();
    }

    //Esta funcion es un override de java.awt.paint()
    //Esta funcion no se llama en el main porque JFrame lo llama cada que hay cambios en la ventana automaticamente.
    public void paintComponent(Graphics g){
        g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), this);
        //Set color pone un color al grafico actual.
        g.setColor(Color.GREEN);
        g.drawLine(xV+100, yV+200, 300, 400);

        g.setColor(Color.GRAY);
        g.fillOval(xV+20, yV+40, 300, 200);
        g.setColor(Color.WHITE);
        g.drawString("Vamos "+this.nombre+"!", xV+120, yV+260);
    }

    public void setNombre(String n){
        this.nombre = n;
    }

    public void setyV(int n){
        this.yV = -n;
        repaint();
    }

    @Override
    public void run(){
        while(true){
            try{
                this.xV++;
                this.yV--;
                Thread.sleep(40);
                this.repaint();
            }catch(InterruptedException ex){
                System.out.println("Error de Hilo");
            }
        }
    }

}