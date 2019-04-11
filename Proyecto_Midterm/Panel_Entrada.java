
/*
PROYECTO DE MEDIO TERMINO POO
Metodos Numerote:
Jonathan de Jesus Chavez Tabares A01636160
GUI:
Jose Miguel Perez Gonzalez A01636355
*/
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class Panel_Entrada extends JPanel {
	private JTextField tfNum1, tfNum2;
	private JLabel lbNum1, lbNum2, lbSigno, lbEtiqResultado, lbResultado;

	public Panel_Entrada() {
		super();
		this.setBorder(new MatteBorder(30, 0, 0, 0, this.getBackground()));
		// Etiqueta Numerote_1
		this.lbNum1 = new JLabel("Numerote 1");
		this.lbNum1.setBorder(new MatteBorder(0, 110, 0, 0, this.getBackground()));
		// Etiqueta Numerote_2
		this.lbNum2 = new JLabel("Numerote 2");
		this.lbNum2.setBorder(new MatteBorder(0, 270, 0, 100, this.getBackground()));
		Font fuenteLabel = this.lbNum1.getFont();
		// TextFiel_1
		this.tfNum1 = new JTextField(20);
		this.tfNum1.setHorizontalAlignment(SwingConstants.CENTER);
		Font fuenteTextField = this.tfNum1.getFont();
		this.tfNum1.setFont(new Font(fuenteTextField.getName(), fuenteTextField.getStyle(), 20));
		// Operador
		this.lbSigno = new JLabel(" ");
		this.lbSigno.setFont(new Font(fuenteLabel.getName(), fuenteLabel.getStyle(), 20));
		// TextFiel_2
		this.tfNum2 = new JTextField(20);
		this.tfNum2.setHorizontalAlignment(SwingConstants.CENTER);
		this.tfNum2.setFont(new Font(fuenteTextField.getName(), fuenteTextField.getStyle(), 20));
		// Etiqueta_Resultado
		this.lbEtiqResultado = new JLabel("Resultado:");
		this.lbEtiqResultado.setBorder(new MatteBorder(0, 400, 0, 400, this.getBackground()));
		;
		// Resultado
		this.lbResultado = new JLabel("");
		this.lbResultado.setFont(new Font(fuenteLabel.getName(), fuenteLabel.getStyle(), 30));

		this.add(this.lbNum1);
		this.add(this.lbNum2);
		this.add(this.tfNum1);
		this.add(this.lbSigno);
		this.add(this.tfNum2);
		this.add(this.lbEtiqResultado);
		this.add(this.lbResultado);
		this.setVisible(true);
	}

	public JTextField getTfNum1() {
		return this.tfNum1;
	}

	public JTextField getTfNum2() {
		return this.tfNum2;
	}

	public JLabel getLbSigno() {
		return lbSigno;
	}

	public void setLabelSigno(String operacion) {
		this.lbSigno.setText(operacion);
	}

	public JLabel getLbResultado() {
		return this.lbResultado;
	}

}
