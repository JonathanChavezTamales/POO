package proyecto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class Panel_Controles extends JPanel implements ActionListener{
	private Panel_Entrada pE;
	private Numerote num1,
					 num2,
					 numR;
	private JButton btnSuma,
					btnResta,
					btnMulti,
					btnClear,
					btnArchivo;
	public Panel_Controles(Panel_Entrada pE) {
		super();
		this.pE = pE;
		this.setBorder(new MatteBorder(0,220,50,220,this.getBackground()));
		this.btnSuma = new JButton("Sumar");
		this.btnSuma.addActionListener(this);
		
		this.btnResta = new JButton("Restar");
		this.btnResta.addActionListener(this);
		
		this.btnMulti = new JButton("Multiplicar");
		this.btnMulti.addActionListener(this);
		
		this.btnClear = new JButton("Clear");
		this.btnClear.addActionListener(this);
		
		this.btnArchivo = new JButton("Archivo");
		this.btnArchivo.addActionListener(this);
		
		this.add(this.btnSuma);
		this.add(this.btnResta);
		this.add(this.btnMulti);
		this.add(this.btnArchivo, BorderLayout.SOUTH);
		this.add(this.btnClear, BorderLayout.SOUTH);
	}
	public String verificarNumerote(String dato) throws Exception {
		boolean negativo = false,
				error = false;
		String numeros = "0123456789";
		dato = dato.trim();
		
		if (dato.charAt(0) == '-') {
			negativo = true;
			dato = dato.substring(1);
		}
		for(int i=0;i<dato.length();i++){
			for(int j=0;j<numeros.length();j++) {
				if(dato.charAt(i) == numeros.charAt(j)){
					error = false;
					break;
				}
				error = true;
			}
			if(error) {
				throw new RuntimeException("Entra de datos no valida");
			}
		}
		dato = this.trimCeros(dato);
		if(negativo && !dato.equals("0")){
			dato = "-"+dato;
		}
		return dato;
	}
	public String trimCeros(String dato) {
		int posicion = 0;
		int contador = 0;
		while(posicion < dato.length() && contador == posicion){
			if(dato.charAt(posicion) == '0') {
				posicion++;
			}
			contador++;
		}
		
		dato = dato.substring(posicion);
		
		if(dato.equals("")) {
			return "0";
		}
		return dato;
	}

	public void generarMensaje(String excepcion) {
		JOptionPane oP = new JOptionPane();
		oP.showMessageDialog(null,excepcion);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnSuma) {
			try {
				this.num1 = new	Numerote(this.verificarNumerote(pE.getTfNum1().getText()));
				this.num2 = new Numerote(this.verificarNumerote(pE.getTfNum2().getText()));
				this.pE.getLbSigno().setText("+");
				this.numR = this.num1.suma(num2);
				this.pE.getLbResultado().setText(numR.toString());
			} catch(StringIndexOutOfBoundsException sE) {
				generarMensaje("Por favor llene todos los campos");
			} catch (Exception ex) {
				generarMensaje(ex.getMessage());
			}
			
		}else if(e.getSource() == btnResta) {
			try {
				this.num1 = new	Numerote(this.verificarNumerote(pE.getTfNum1().getText()));
				this.num2 = new Numerote(this.verificarNumerote(pE.getTfNum2().getText()));
				this.pE.getLbSigno().setText("-");
				this.numR = this.num1.resta(num2);
				this.pE.getLbResultado().setText(numR.toString());
			} catch(StringIndexOutOfBoundsException sE) {
				generarMensaje("Por favor llene todos los campos");
			} catch (Exception ex) {
				generarMensaje(ex.getMessage());
			}
		}else if(e.getSource() == btnMulti) {
			try { 
				this.num1 = new	Numerote(this.verificarNumerote(pE.getTfNum1().getText()));
				this.num2 = new Numerote(this.verificarNumerote(pE.getTfNum2().getText()));
				this.pE.getLbSigno().setText("X");
				this.numR = this.num1.multiplica(num2);
				this.pE.getLbResultado().setText(numR.toString());
			} catch(StringIndexOutOfBoundsException sE) {
				generarMensaje("Por favor llene todos los campos");
			} catch (Exception ex) {
				generarMensaje(ex.getMessage());
			}
		}else if(e.getSource() == btnClear) {
			pE.getTfNum1().setText("");
			pE.getTfNum2().setText("");
			pE.getLbSigno().setText("");
			pE.getLbResultado().setText("");
			
		}else if(e.getSource() == btnArchivo) {
			String rutaEntrada,rutaSalida;
			JFileChooser fC = new JFileChooser("../");
			int response = fC.showOpenDialog(this.pE);
			if(response == JFileChooser.APPROVE_OPTION) {
				rutaEntrada = fC.getSelectedFile().getAbsolutePath();
				generarMensaje("Archivo de Origen seleccionado \n"
							 + "Por favor seleccione el archivo Destino");
				response = fC.showSaveDialog(this.pE);
				if(response == JFileChooser.APPROVE_OPTION) {
					rutaSalida = fC.getSelectedFile().getAbsolutePath();
					num1 = new Numerote();
					try {
						num1.ejecutaArchivo(rutaEntrada, rutaSalida);
						generarMensaje("El archivo se ha generado satisfactoriamente");
					} catch (IOException e1) {
						generarMensaje(e1.getMessage());
					} catch(Exception ex) {
						generarMensaje(ex.getMessage());
					}
				}else {
					generarMensaje("Error en apertura de archivo\nInténtelo de Nuevo");
				}
			}else {
				generarMensaje("Error en apertura de archivo\nInténtelo de Nuevo");
			}
		}
		
	}
}
