import javax.swing.JOptionPane;

public class Division{
	
	public static int divisionEntera(int n, int m){
		return n/m;
	}

	
	public static void main(String[] args){
		boolean hayError = false;
		while(!hayError){
			try{
				int n = Integer.parseInt(JOptionPane.showInputDialog("Escriba un numero"));
				int d = Integer.parseInt(JOptionPane.showInputDialog("Escriba un numero"));

				int res = divisionEntera(n,d);
		
				JOptionPane.showMessageDialog(null, "El resultado de "+ n +"/"+ d +" es "+res);

				//Si llega hasta aquí, no sucedió un error
				hayError = true;

			} catch(ArithmeticException e){
				JOptionPane.showMessageDialog(null, "No se puede dividir entre cero.");
			} catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "No es un número.");
			}
		}
		
	}

}
