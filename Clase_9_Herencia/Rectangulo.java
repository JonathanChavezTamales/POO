public class Rectangulo extends Figura{
	private double largo, ancho;
	
	public Rectangulo(double largo, double ancho){
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public Rectangulo(){
		this.Rectangulo(0.0, 0.0);
	}

	public double perimetro(){
		return 2*(largo+ancho);
	}

}
