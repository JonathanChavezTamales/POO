import javax.swing.*;
public class IntroJava{
	public static void estatusCalificacion(){
		String strCalif = JOptionPane.showInputDialog("Dame un numero");
		int calif = Integer.parseInt(strCalif);
		if (calif >= 70){
			System.out.println("Aprobado mijo");
		}
		else{
			System.out.println("Reprobado");
		}
	}

	public static void cienNumeros(){
		for (int i=0; i<=100; i++){
			System.out.println(i);
		}
	}

	public static void serie(int n){
		for (int i=0; i<50; i++){
			System.out.println(i*n);
		}
	}

	public static int calorias(){
		int comidas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de comidas"));
		int calorias = 0;
		for (int i=1; i<=comidas; i++){
			calorias += Integer.parseInt(JOptionPane.showInputDialog("Ingrese calorias de comida "+i));
		}
		return calorias;
	}
	
	public static void main(String[] args){
		System.out.println(calorias());
	}
}
