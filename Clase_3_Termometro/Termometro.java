public class Termometro implements Comparable{

	private int temp;
	
	public Termometro(){
		temp = 25;
	}	

	public Termometro(int t){
		temp = t;
	}


	//Getter y setter
	
	public void setTemp(int temp){
		this.temp = temp;
	}

	public int getTemp(){
		return temp;
	}


	//Compareto
	public int compareTo(Object t){
		Termometro term = (Termometro)t;
		return this.temp = term.temp;
	}


	//Main	
	public static void main(String[] args){
		
		Termometro gda = new Termometro();
		Termometro ny = new Termometro(10);
			
		//Si temp fuera public se pudiera hacer esto

		System.out.println("La temperatura en gda es: "+ gda.temp);
		System.out.println("La temperatura en ny es: "+ ny.temp);
		
		//Pero es mejor hacerlo con getters y setters, para encapsular la info y validar

		ny.setTemp(4);
		System.out.println("Temperaura nueva de ny: "+ ny.getTemp());

			
	
	}


}

