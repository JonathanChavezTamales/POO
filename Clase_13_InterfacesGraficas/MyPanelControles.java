import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.*;

import java.awt.Color;


public class MyPanelControles extends JPanel implements ActionListener, ChangeListener{
    private JTextField tfNombre;
    private JButton btnNombre, btnColor;
    private JRadioButton rbRojo, rbVerde, rbAzul;
    private MyPanel p;
    private JSlider slider;



    public MyPanelControles(MyPanel p){
        super();
        this.p = p;
        this.setPreferredSize(new Dimension(150, 600));
        this.tfNombre = new JTextField(10);
        this.btnNombre = new JButton("Saluda");
        this.btnNombre.addActionListener(this);

        ButtonGroup bg = new ButtonGroup();

        this.rbRojo =  new JRadioButton("Rojo", true);
        this.rbVerde =  new JRadioButton("Verde");
        this.rbAzul =  new JRadioButton("Azul");

        bg.add(rbRojo);
        bg.add(rbVerde);
        bg.add(rbVerde);

        this.btnColor = new JButton("Cambia color");


        this.add(this.tfNombre);
        this.add(this.btnNombre);
        this.add(this.rbAzul);
        this.add(this.rbRojo);
        this.add(this.rbVerde);
        this.add(this.btnColor);

        this.slider = new JSlider(JSlider.VERTICAL, 0, 200, 0);
        this.slider.setMinorTickSpacing(10);
        this.slider.setMajorTickSpacing(100);
        this.slider.setPaintTicks(true);
        this.slider.setPaintLabels(true);
        this.slider.addChangeListener(this);
        this.add(this.slider);


    }

    //Metodo de la interfaz Action Listener para cuando cambia el texto
    public void actionPerformed(ActionEvent evt){
        

        if(evt.getSource() == this.btnNombre){
            System.out.println("Hola "+this.tfNombre.getText());
            this.p.setNombre(this.tfNombre.getText());
            repaint();
        }

        //TODO: Cuando se seleccione radiobutton cambiar el background de todo los controles
    }


    @Override
    public void stateChanged(ChangeEvent e){
        this.p.setyV(this.slider.getValue());
    }

}