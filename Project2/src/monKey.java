
public class monKey {
	
	
	private int x,y;
	
	private EZImage Monkey ;
	static final int Monkey_walk = 1;
	double goBack = 180;
	
	
	public monKey(String filename, int Xcent, int Ycent) {
		Monkey = EZ.addImage (filename, Xcent , Ycent); 
		x = Xcent;
		y = Ycent;
	}
	
	public int get_x() {
		return x;
	}
	
	public int get_y() {
		return y;
	}
	
	public void set_postion(int Xcent , int Ycent) {
		x = Xcent;
		y = Ycent;
		whereYouGone();
	}
	
	public void whereYouGone() {
		Monkey.translateTo(x, y);
	}
	
	public void moveLeftMonkey(int S) { 
		x = x - S;
		whereYouGone();
	}
	
	public void moveRightMonkey(int S) {
		x = x + S ;
		whereYouGone();
	}
	
	public void moveUpMonkey(int S) {
		y = y - S;
		whereYouGone();}
	
	public void moveDownMonkey(int S) {
		y = y + S; 
		whereYouGone();
	}
	
	public void controlMonkey () {
		if (EZInteraction.isKeyDown("a")) {
			moveLeftMonkey(Monkey_walk);
		}
		
		if (EZInteraction.isKeyDown("d")) {
			moveRightMonkey(Monkey_walk);
		}
		
		if (EZInteraction.isKeyDown("w")) {
			
			moveUpMonkey(Monkey_walk);
		}
		
		if (EZInteraction.isKeyDown("s")) {
			moveDownMonkey(Monkey_walk);
			
	}
}
	public void youNutzAllowed1() {
		
		x = x - 5;
		y = y + 5;
		whereYouGone();	
	}
	
	public void youNutzAllowed2() {
		
		x = x + 5;
		y = y - 5; 
		whereYouGone();	
	}
	
	public void youNutzAllowed3() {
		x = x + 5;
		y = y + 5; 
		whereYouGone();
	
	}
	
}
