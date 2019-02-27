import javax.swing.JOptionPane;

public class Division{
	
	public static int divisionEntera(int n, int m){
		return n/m;
	}

	
	public static void main(String[] args){
	int n = Integer.parseInt(JOptionPane.showInputDialog("Escriba un numero"));
	int d = Integer.parseInt(JOptionPane.showInputDialog("Escriba un numero"));

	int res = divisionEntera(n,d);

	JOptionPane.showMessageDialog(null, "El resultado de "+ n +"/"+ d +" es "+res);

	}

}
