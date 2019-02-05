class Clock{

	private int h, m, s;
	
	//Constructors

	Clock(){
		h=0;
		m=0;
		s=0;	
	}

	Clock(int h, int m, int s){
		this.h=h;
		this.m=m;
		this.s=s;
	}

	//Getters and Setters	

	public int getHours(){
		return h;
	}

	public void setHours(int h){
		this.h = h;
	}

	public int getMinutes(){
		return m;
	}

	public void setMinutes(int m){
		this.m = m;
	}

	public int getSeconds(){
		return s;
	}
	
	public void setSeconds(int s){
		this.s = s;
	}
		


	public void printTime(){
		System.out.println(this.h+":"+this.m+":"+this.s);
	}

	public boolean equals(Clock clock){
		if(this.h==clock.h && this.m==clock.m && this.s==clock.s){
			return true;
		}

		return false;
	}

	public Clock getCopy(){
		return Clock(this.h, this.m, this.s);
	}	





}
