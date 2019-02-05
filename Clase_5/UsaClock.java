class UsaClock{

	public static void main(String[] args){
		System.out.println("Hello");
		Clock gda = new Clock(20,31,12);
		gda.printTime();
		Clock ny = new Clock();
		if(gda.equals(ny))
			System.out.println("Iguales");
		else
			System.out.println("Diferentes");
	}


}
