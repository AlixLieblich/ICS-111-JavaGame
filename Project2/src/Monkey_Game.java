import java.awt.Color;


public class Monkey_Game {
	static EZSound BACKGROUND; // DECLARE EZSOUND BACKGROUND
	static EZSound VICTORY; // DECLARE EZSOUND VICTORY
	static EZSound EAT_Banana; // DECLARE EZSOUND EAT_CAKE
	static EZSound pain_Monkey;
	static int bananas_collected = 0; // DECLARE INT CAKES_COLLECTED
	static final int monkey_Kickin = 0 ;
	static final int monkey_Fallen = 1 ;
	static final int monkey_Eating = 2 ; 
	static final int size_X = 1024;
	static final int size_Y = 768;
	static final int howManyNutz = 5;
	static EZImage banana;
	static final int MOJOMOJO_WINS = 1;
	static final int MOJOMOJO_DIES = 2;

	
	static void backGroundSound(String filename) {
		BACKGROUND = new EZSound (filename);
		BACKGROUND.loop();
	}
	
	static void victorySound() {
		VICTORY = new EZSound ("victorymario.wav");
		VICTORY.play();
	}
	
	static void eatBanana() {
		EAT_Banana = new EZSound ("powerup.wav");
		EAT_Banana.play();
	}
	
	static void monkey_hurt() {
		pain_Monkey = new EZSound("gameover.wav");
		pain_Monkey.play();
		
	}
	
	static boolean bananaHere() {
		return true;
	}
	
	static boolean wallHere() { 
		return true;
	}
	
	
	public static void main(String[] args) throws java.io.IOException {
		
		// TODO Auto-generated method stub

		map map = new map();
		map.drawMap();
		
		int monkeyState = monkey_Kickin;
		
		
		monKey moJomoJo = new monKey("donkeykong.png", 200, 200 ) ;
		
		coconutz cocoNutz[] = new coconutz[howManyNutz];
		
		for (int i = 0 ; i < howManyNutz ; i ++) {
	
			cocoNutz[i] = new coconutz("cocoNUTZ.png", size_X,1 ); 
		}
		
		backGroundSound("background.wav");
		
		
		while (monkeyState == monkey_Kickin) {			
			moJomoJo.controlMonkey();
			
			for (int i = 0 ; i < howManyNutz; i++) {
				cocoNutz[i].youSoNutz();
				
				if ((cocoNutz[i].caughtOnNutz(moJomoJo.get_x() + 10, moJomoJo.get_y()-10))
					|| (cocoNutz[i].caughtOnNutz(moJomoJo.get_x() + 10, moJomoJo.get_y()+10))
					|| (cocoNutz[i].caughtOnNutz(moJomoJo.get_x() - 10, moJomoJo.get_y()-10))
					|| (cocoNutz[i].caughtOnNutz(moJomoJo.get_x() - 10, moJomoJo.get_y()+10))){
					
					BACKGROUND.stop();
					monkeyState = MOJOMOJO_DIES;
					monkey_hurt();
					
				}
				
			}
				
			for (int j = 0 ; j < map.howManybanana(); j++) { //is current banana under monKey
						if (map.myBanana[j].isPointInElement(moJomoJo.get_x(), moJomoJo.get_y())) {
						map.myBanana[j].translateTo(0, 0);
						bananas_collected ++;
						eatBanana();						
	}
}




				if (bananas_collected== map.bananacount) {
					victorySound();
					monkeyState = MOJOMOJO_WINS;

				}
			
				for (int k = 0 ; k < map.howManywalls(); k ++ ) {
					if (map.myWallTiles[k] != null) {
						wallHere();
						
				}
					if (wallHere()) {
						if ((map.myWallTiles[k].isPointInElement(moJomoJo.get_x()+5, moJomoJo.get_y()-5)))
								{moJomoJo.youNutzAllowed1();}
						else if(
						(map.myWallTiles[k].isPointInElement(moJomoJo.get_x()-5, moJomoJo.get_y()+5 ))){
						moJomoJo.youNutzAllowed2();
						}
						else if ( map.myWallTiles[k].isPointInElement(moJomoJo.get_x()-5, moJomoJo.get_y() -5))
						{
							moJomoJo.youNutzAllowed3();	
				}
						if (monkeyState == MOJOMOJO_DIES) {
							
							// Draw coconutz.
							EZ.addImage("cocoNUTZ.png", moJomoJo.get_x(), moJomoJo.get_y());

							// Show the message: You are coconutz
							Color c = new Color(0, 10, 150);
							int fontsize = 40;
							
							EZText text = EZ.addText(390, 200, "You are not satiated", c, fontsize);
							
							text.setFont("8-BIT WONDER.TTF");
							//text.setFont("ethnocentric rg.ttf");
							
						}
						if (monkeyState == MOJOMOJO_WINS) {
							BACKGROUND.stop();
							Color c = new Color(0, 255, 100);
							int fontsize = 40;
							
							EZText text = EZ.addText(390, 150, "Youre not you", c, fontsize);
							EZText texxt = EZ.addText(390, 200, "when youre hungry", c, fontsize);

							text.setFont("8-BIT WONDER.TTF");
							texxt.setFont("8-BIT WONDER.TTF");

							
							monKey damsel = new monKey("damsel.png", 230, 330 ) ;
							monKey heart = new monKey("heart.png", 380, 280);
							monKey happy = new monKey("happykong.png", 550, 350);
				}
			}
		}
			EZ.refreshScreen();
		
		}	
	}	
}


