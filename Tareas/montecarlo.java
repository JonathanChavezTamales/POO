/* Programa que calcula PI a través del método montecarlo */

import java.util.Random;

class Montecarlo{
	
	public static void main(String[] args){
		
		double radio = 1.0f;
		int puntos;
			
		if (args.length == 0){
			puntos = 1000;
		}

		else{
			puntos = Integer.parseInt(args[0]);
		}

		int puntosDentro = 0;
		int puntosFuera = 0;
		Random random = new Random();
		
		double puntoX, puntoY, distanciaAlCentro;

		for (int i=0; i<puntos; i++){
			puntoX =  random.nextFloat() * radio*2;
			puntoY =  random.nextFloat() * radio*2;
			distanciaAlCentro = Math.sqrt(Math.pow(puntoX-radio,2.0) + Math.pow(puntoY-radio,2.0));
			
			if (distanciaAlCentro < radio){
				puntosDentro++;
			}
			
		}

		System.out.println("Simulación con "+ puntos +" puntos de lanzamiento:\n"+
				"Puntos dentro del circulo/Puntos totales: "+ puntosDentro +"/"+puntos+"\n"+
				"Proporción: "+ 4*puntosDentro/(double)puntos);
	
	}


}
