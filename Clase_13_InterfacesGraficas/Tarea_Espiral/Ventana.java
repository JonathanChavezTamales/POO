
//Jonathan de Jesus Chavez Tabares A01636160
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class Ventana extends JFrame {
    public Ventana() {
        super("Espiral");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel myP = new Panel();
        this.add(myP);
        PanelInputs pins = new PanelInputs(myP);
        this.add(new PanelInputs(myP), BorderLayout.WEST);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Ventana myVent = new Ventana();
    }

}
