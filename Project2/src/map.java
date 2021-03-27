import java.awt.Color;
import java.io.FileReader;
import java.util.Scanner;

public class map {
		
	Scanner fileScanner;
	int width;
	int height;
	public int wallcount;
	public int cakescount;
	String inputText;
	EZImage[] mycakes;
	EZImage[] myWallTiles;
	public int i,j,k;
	static final int row =0;
	static final int column =0 ;
	EZImage[] myBanana;
	public int bananacount;
	public int xloc_Nutz, yloc_Nutz;
	
	map() {
		return;
		}
	
	
	
	public void drawMap() throws java.io.IOException{
		// TODO Auto-generated method stub
		
		fileScanner = new Scanner(new FileReader("Level.txt")); // ASSIGN FILESCANNER TO THE MAP TO LOAD IT
		
		 
		
		width = fileScanner.nextInt(); // THE WIDTH OF THE MAP
		height = fileScanner.nextInt(); // THE HEIGHT OF THE MAP
		inputText = fileScanner.nextLine(); // SCAN THE NEXT LINE
		wallcount = 0; // THE NUMBER OF THE WALL
		cakescount = 0; // THE NUMBER OF THE CAKES(DIRTS)
		
		
		
		EZ.initialize(width * 31, height* 31) ; // SET THE WINDOW SIZE 
		EZ.setBackgroundColor(new Color(80,80,80)); //new takes a color object
		
		
		
		mycakes = new EZImage[1000]; // DECLARE EZIMAGE ARRAY MYCAKES 
		myWallTiles = new EZImage[1000]; // DECLARE EZIMAGE ARRAY MYWALLS
		myBanana = new EZImage[1000];
		
		

	
		
		i = 0; // DECLARE INT I AND ASSIGN TO 0
		j = 0; // DECLARE INT I AND ASSIGN TO 0
		
		for (int row = 0 ; row < height ; row++) { // FOR LOOP TO SCAN THE WORDS IN THE TEXTFILE
			
			inputText = fileScanner.nextLine();	// Read a whole line of text
			System.out.println(inputText); // READ A NEXT LINE
		
			
			for (int column = 0  ; column < width ; column ++) { //ANOTHER FOR LOOP TO SCAN THE WORDS IN COLUMN
				
				char ch = inputText.charAt(column); // ASSIGN CHAR CH TO INPUT TEXT
				
				if (ch == 'W') { // IF YOU SCAN 'W'
					myWallTiles[i] = EZ.addImage("barrier.png",column*32,row*32);// INSERT THE IMAGE WALL
					if (myWallTiles[i] != null) { //IF THE SLOT IS NOT EMPTY
						wallcount ++; // ADD 1 TO THE WALLCOUNT 
						i++;
						
						
						
					}
					
					
				}
					else if (ch == 'D') { // IF YOU SCAN D
						myBanana[j] = EZ.addImage("banana.png", column*32 , row *32 ); //INSERT THE IMAGE CAKE
						if (myBanana[j] != null) { // IF THE SLOT IS NOT EMPTY
							bananacount ++; // ADD 1 TO CAKECOUNT
							j++;
						}
							
						}
				
					}
			
				
				
				
				
				}
	
		
		
		System.out.print("Wallcount is:");//PRINT "WALLCOUNT IS"
		System.out.print(wallcount);// PRINT WALLCOUNT
		System.out.println("");// PRINT ""
		System.out.print("cakescount is:"); // PRINT "CAKECOUNT IS"
		System.out.print(cakescount); // PRINT CAKESCOUNT
		System.out.println("");//PRINT ""
		
		
				

	}

		

	public int howManybanana() {
		return bananacount;
	}
	public int howManywalls() {
		return wallcount;
	}
	
	
	
	
	}
	
	

	
