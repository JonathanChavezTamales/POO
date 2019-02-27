public class EjemploException{

	public void metodoD(){
		//Este metodo solo lo arroja, no lo maneja, se lo arroja a la funcion que la llamó.
		throw new RuntimeException("Error Runtime en Metodo D");
	}

	public void metodoC(){
		this.metodoD();
	}

	public void metodoB(){
		this.metodoC();
	}

	public void metodoA(){
		this.metodoB();
	}

	public static void main(String[] args){
		EjemploException ee = new EjemploException();
		
		//Irá en cascada el error de Metodo D porque nadie lo maneja, ni main
		ee.metodoA();
	}

}
