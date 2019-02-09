public class EjemploArreglos{

	public int suma(int[] arreglo){
		int a = 0;
		for(int i=0; i<arreglo.length; i++){
			a+=arreglo[i];
		}
		return a;
	}

	//Para array.length>0
	public int menor(int[] arreglo){
		int min = arreglo[0];
		for(int i=0; i<arreglo.length; i++){
			if(arreglo[i]<min){
				min = arreglo[i];
			}
		}
		return min;
	}

	public int mayor(int[] arreglo){
		int max = arreglo[0];
		for(int i=0; i<arreglo.length; i++){
			if(arreglo[i]>max){
				max = arreglo[i];
			}
		}
		return max;
	}

	public double promedio(int[] arr){
		//Aqui se podria usar el metodo suma y solo dividir, pero como no es estatico no se puede.
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum+=arr[i];
		}	
		return sum/(1.0*arr.length);
	}


	public void imprime(String[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		EjemploArreglos ea = new EjemploArreglos();
		int[] numeros = {5,6,7,5,1,4,6,2};
		System.out.println(ea.suma(numeros));
		String[][] palabras = {{"Hola", "bro", "que"}, {"Rollo", "Adios"}, args};
		System.out.println(ea.promedio(numeros));
		ea.imprime(palabras);
	}

}
