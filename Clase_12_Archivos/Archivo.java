import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Archivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String record = "";
		Scanner sc = new Scanner(System.in);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("personas.csv"));
			BufferedReader br = new BufferedReader(new FileReader("personas.csv"));
			StringTokenizer t;
		
		
			while(record!="x") {
				System.out.println("Escriba un registro:");
				record = sc.nextLine();
				if(record.equals("x"))
					break;
				pw.println(record);
					
			}
			
			pw.close();
			
			//Write again
			
			record = "";
			
			pw = new PrintWriter(new FileWriter("procesado.csv"));
	
			String name;
			double h, w;
			while((record = br.readLine())!=null) {
				t = new StringTokenizer(record);
				name = t.nextToken(",");
				h = Double.parseDouble(t.nextToken(","));
				w = Double.parseDouble(t.nextToken(","));
				pw.println(w/((h/100)*(h/100)));
			}
			
			pw.close();
		
		}catch(IOException e){
			
		}

	}

}
