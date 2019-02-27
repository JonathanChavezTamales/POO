class Clock implements Comparable{

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

	//Comparable
	public int Comparable(Object clock){
		Clock xc = (Clock)clock;
		int xc_seconds = xc.s;
		int lc_seconds = this.s;
		xc_seconds += xc.m*60;
		lc_seconds += this.m*60;
		xc_seconds += xc.h*60*60;
	       	lc_seconds += this.h*60*60;
		return lc_seconds - xc_seconds;	
	}



}
