public class Libro{
	
	//FIELDS

	private String title,
			author,
			editorial,
			isbn;

	//CONSTRUCTORS
	
	public Libro(){		

	}


	public Libro(String title, String author, String editorial, String isbn){
		
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.isbn = isbn;

	}
	

	//GETTERS AND SETTERS

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	 }
	
	public void setAuthor(String author){ 
		this.author = author;
	 }

	public String getAuthor(){ 
		return author; 
	}
	
	public void setEditorial(String editorial){ 
		this.editorial = editorial; 
	}

	public String getEditorial(){
		return editorial;
	}

	public void setIsbn(String isbn){
		this.isbn = isbn;
	}

	public String getIsbn(){
		return isbn;
	}

	
		
	//MAIN FOR TESTING

	public static void main(String[] args){
		
		Libro libroActual = new Libro("Estructuras de datos", "Osvaldo Cairo", "Planeta", "AS235AAFS52B1");

		System.out.println("El libro que leo actualmente es: "+ libroActual.getTitle());

		libroActual.setEditorial("Pearson");
		
		//Can even access the private field because main its called inside the class.
		System.out.println("De la editorial "+libroActual.editorial);


	}


}
