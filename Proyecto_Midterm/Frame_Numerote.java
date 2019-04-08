/*-Back
	Multiplicación
	*** Generador Aleatorio ***
-Front
	ZEROS Y - ZERO
	Archivos*/

package proyecto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

public class Frame_Numerote extends JFrame{
	private Panel_Entrada pE;
	private Panel_Controles pC;
	public Frame_Numerote() {
		super("Convertidor Numerote");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(pantalla.width/2, pantalla.height/2);		
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(740,300));
		this.setResizable(false);
		//Ingreso Paneles
		pE = new Panel_Entrada();
		pC = new Panel_Controles(pE);
		this.add(pE,BorderLayout.CENTER);
		this.add(pC,BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Frame_Numerote fN = new Frame_Numerote();
		
	}
	
}
