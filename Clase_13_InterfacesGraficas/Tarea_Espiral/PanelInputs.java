
//Jonathan de Jesus Chavez Tabares A01636160

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInputs extends JPanel implements ActionListener {

    private TextField n, radioInicial, stepSize;
    private JCheckBox clockWise;
    private Button dibujar;
    private Panel p;

    public PanelInputs(Panel p) {
        super();
        this.p = p;
        setPreferredSize(new Dimension(200, 100));

        // Inicializa los inputs
        this.n = new TextField(3);
        this.radioInicial = new TextField(2);
        this.stepSize = new TextField(2);
        this.clockWise = new JCheckBox("Direccion del reloj:", true);
        this.dibujar = new Button("Dibujar");

        // Agrega los textfields
        this.add(new JLabel("Numero de puntos:"));
        this.add(this.n);
        this.add(new JLabel("Radio inicial:"));
        this.add(this.radioInicial);
        this.add(new JLabel("Variacion del radio:"));
        this.add(this.stepSize);
        // Agrega el checkbox
        this.add(this.clockWise);
        // Agrega el boton que redibuja
        this.add(this.dibujar);
        this.dibujar.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == this.dibujar) {

            p.puntos = p.generaPuntos(Integer.parseInt(this.n.getText()), Integer.parseInt(this.radioInicial.getText()),
                    Integer.parseInt(this.stepSize.getText()), this.clockWise.isSelected());
            p.n = Integer.parseInt(this.n.getText());
            p.repaint();
        }
    }

}