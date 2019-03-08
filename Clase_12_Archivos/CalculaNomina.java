import java.io.*;
import java.util.StringTokenizer;

public class CalculaNomina{

		public static void main(String[] args){
			try{
				BufferedReader br = new BufferedReader(new FileReader("horasTrabajadas.txt"));
				PrintWriter pw = new PrintWriter(new FileWriter("Nomina.csv"));
				String linea;
				StringTokenizer st;
				String nombre, apellido;
				int hrs;
				double tab;

				//TODO: Leer cada linea y obtener su nomina, luego escribirla a un csv

				//Lee una vez para ignorar los headers
				br.readLine();
				pw.println("Nombre completo, nomina");
				while((linea = br.readLine()) != null){
					st = new StringTokenizer(linea);
					nombre = st.nextToken();
					apellido = st.nextToken();
					hrs = Integer.parseInt(st.nextToken());
					tab = Double.parseDouble(st.nextToken());
					pw.println(nombre+" "+apellido+","+hrs*tab);
				}
				pw.close();
				br.close();

			}catch(FileNotFoundException e){
				System.out.println("Archivo no encontrado");
			}catch(IOException e){
				System.out.println("IOException");
			}
		}

}	
