public class Caja {
	protected double alto;

	public Caja(double largo, double ancho, double alto){
		super(largo, ancho);
		this.alto = alto;
	}

	public Caja(){
		this(0.0,0.0,0.0);
	}

	public double perimetro(){
		return 4*this.largo+2*ancho+8*alto;
	}



	public double volumen(){
		return super.area()*this.altura;
	}

}
