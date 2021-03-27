import java.util.*;




public class coconutz {
	
	private int x,y;
	private EZImage Coconutz;
	private int screenX, screenY;
	Random ranDom ;
	private int graVity;
	
	
	public void coconutz () {
		return;
		
	}
	public coconutz (String filename, int myXcreen, int myYcreen) {
		Coconutz = EZ.addImage(filename , myXcreen, myYcreen);
		screenX = myXcreen;
		screenY = myYcreen;
		algorithSm();
		
	}
	
	
	public void algorithSm() {
		
		ranDom = new Random();
		
		int check_Size = screenX / Coconutz.getWidth();
		int ranDomX = ranDom.nextInt(check_Size) * Coconutz.getWidth();
		whereGoNutz(ranDomX, screenY * 2);
		int falLing = ranDom.nextInt(4) + 1;
		graVity = falLing; 
		 
	}
	
	public int set_X () {
		
		return x;
		
	}
	
	public int set_Y () {
		return y;
		
	}
	
	public void whereAtNutz() {
		Coconutz.translateTo(x, y); }
	
	public void whereGoNutz(int Xcent, int Ycent ) {
		x = Xcent;
		y = Ycent;
		whereAtNutz();
		
		}
	public void youSoNutz() {
		y = y + graVity;
		whereGoNutz(x,y);
		if ( y >= 1000) {
			algorithSm();
		}
	}
	
	
	
	
	public boolean caughtOnNutz(int Xcent, int Ycent) {
		return Coconutz.isPointInElement(Xcent, Ycent);
		
	}
	
	
	
	
	
	
	
	}
	
	
	


