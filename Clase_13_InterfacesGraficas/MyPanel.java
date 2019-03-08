import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.lang.InterruptedException;


public class MyPanel extends JPanel implements Runnable{

    private Image fondo;
    private int xV, yV;

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