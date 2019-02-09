//Jonathan de Jesus Chavez Tabares A01636160

public class Complejo{
	
	private double real;
	private double imaginario;

	public Complejo(double r, double i){
		real = r;
		imaginario = i;
	}

	public Complejo(){}
	

	public void establecer(double r, double i){
		real = r;
		imaginario = i;
	}

	public void imprimir(){
		System.out.print(real);
		if (imaginario < 0){
			System.out.println(imaginario+"i");
		}
		else{
			System.out.println("+"+imaginario+"i");
		}
	}

	public void agregar(Complejo n){
		real += n.real;
		imaginario += n.imaginario;
	}

	public void agregar(double r, double i){
		real += r;
		imaginario += i;
	}
	
	//Estos metodos retornan otro objeto.
	
	
	public Complejo suma(Complejo b){
		Complejo a = new Complejo(real, imaginario);
		a.agregar(b);
		return a;
	}

	public Complejo resta(Complejo b){
		Complejo a = new Complejo(real, imaginario);
		a.agregar(-b.real, -b.imaginario);
		return a;
	}

	public Complejo multiplicacion(Complejo b){
		Complejo a = new Complejo(real, imaginario);
		a.real = a.real*b.real-a.imaginario*b.imaginario;
		a.imaginario = a.real*b.imaginario + a.imaginario*b.real;
		return a;
	}

	//Multiplicacion por real
	public Complejo multiplicacion(double x){
		Complejo a = new Complejo(real,imaginario);
		a.real *= x;
		a.imaginario *= x;
		return a;
	}

	public Complejo conjugado(){
		Complejo a = new Complejo(real, imaginario);
		a.imaginario *= -1;
		return a;
	}



	

	public static void main(String[] args){
		Complejo a = new Complejo();
		Complejo b = new Complejo(5, -7);
		a.establecer(-8, 7);
		a.imprimir();
		b.imprimir();
		Complejo c=a.suma(b);
		c.imprimir();
		c = a.multiplicacion(b);
		c.imprimir();
	}

}
