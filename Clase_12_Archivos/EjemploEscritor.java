import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class EjemploEscritor{
	public static void main(String[] args){
		/*try{
			FileWriter fw = new FileWriter("hola.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Hola");
			pw.close();

		}catch(IOException e){
			System.out.println("No se puede escribir en el archivo");
		}
		*/
		try{
			BufferedReader br = new BufferedReader(new FileReader("hola.txt"));
			String a;
			do{
				a = br.readLine();
				if(a != null)
					System.out.println(a);
			}while(a!=null);

			br.close();
		}catch(FileNotFoundException e){
			System.out.println("FILE NOT FOUND");
		}catch(IOException e){
			System.out.println("Error en I/O");
		}

	}
}
