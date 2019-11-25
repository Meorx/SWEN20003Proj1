import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import utilities.BoundingBox;

public class Sprite {
	//Variables for the player (the frog).
	private Image player;
	public static int PLAYER_OFFSETX = 512;
	public static int PLAYER_OFFSETY = 720;
	//frogX and frogY keep the current coordinates of the frog.
	private float frogX = PLAYER_OFFSETX;
	private float frogY = PLAYER_OFFSETY;
	
	//The following wall of variables are for the buses.
	//Since each bus has unique coordinates, I decided to create unique variables for each bus, at the price
	//of repetition. I personally found this more intuitive in later parts of the code. The buses are logically
	//numbered and divided, hence recalling a specific bus or row of busses later on is much easier.
	private Image bus;
	//Buses of Row 1. Each bus consists of the offset point [bus(Row number)(bus number)X, e.g. bus11X] and a current positon
	//which has pattern of: bus(Row number)(busNumber)XNOW, e.g. bus11XNOW.
	//All buses of Row 1 also share the y-coordinate (bus(Row + row number), in this case busRow1), because all
	//the following buses will exist only on this row.
	private float busRow1 = 432; // for all busses
	private float bus11X = 48;
	private float bus11XNow = 48;
	private float[] bus1Row1 = {bus11X, bus11XNow};
	private float bus12X = 360; // 48 + 48*6.5
	private float bus12XNow = 360;
	private float[] bus2Row1 = {bus12X, bus12XNow};
	private float bus13X = 672; // 360 + 48*6.5
	private float bus13XNow = 672;
	private float[] bus3Row1 = {bus13X, bus13XNow};
	private float bus14X = 984; // 672 + 48*6.5
	private float bus14XNow = 984;
	private float[] bus4Row1 = {bus14X, bus14XNow};
	private float[][] busesRow1 = {bus1Row1, bus2Row1, bus3Row1, bus4Row1};
	//Buses for Row 2 follow the same pattern as Row1.
	private float busRow2 = 480; // for all busses
	private float bus21X = 0;
	private float bus21XNow = 0;
	private float[] bus1Row2 = {bus21X, bus21XNow};
	private float bus22X = 240; // 0 + 48*5
	private float bus22XNow = 240;
	private float[] bus2Row2 = {bus22X, bus22XNow};
	private float bus23X = 480; // 240 + 48*5
	private float bus23XNow = 480;
	private float[] bus3Row2 = {bus23X, bus23XNow};
	private float bus24X = 720; // 480 + 48*5
	private float bus24XNow = 720;
	private float[] bus4Row2 = {bus24X, bus24XNow};
	private float bus25X = 960; // 720 + 48*5
	private float bus25XNow = 960;
	private float[] bus5Row2 = {bus25X, bus25XNow};
	private float[][] busesRow2 = {bus1Row2, bus2Row2, bus3Row2, bus4Row2, bus5Row2};
	//Buses for Row 3.
	private float busRow3 = 528; 
	private float bus31X = 64;
	private float bus31XNow = 64;
	private float[] bus1Row3 = {bus31X, bus31XNow};
	private float bus32X = 640; 
	private float bus32XNow = 640;
	private float[] bus2Row3 = {bus32X, bus32XNow};
	private float[][] busesRow3 = {bus1Row3, bus2Row3};
	//Buses for Row 4.
	private float busRow4 = 576; 
	private float bus41X = 128;
	private float bus41XNow = 128;
	private float[] bus1Row4 = {bus41X, bus41XNow};
	private float bus42X = 368; 
	private float bus42XNow = 368;
	private float[] bus2Row4 = {bus42X, bus42XNow};
	private float bus43X = 608;
	private float bus43XNow = 608;
	private float[] bus3Row4 = {bus43X, bus43XNow};
	private float bus44X = 848; 
	private float bus44XNow = 848;
	private float[] bus4Row4 = {bus44X, bus44XNow};
	private float bus45X = 1088; 
	private float bus45XNow = 1088;
	private float[] bus5Row4 = {bus45X, bus45XNow};
	private float[][] busesRow4 = {bus1Row4, bus2Row4, bus3Row4, bus4Row4, bus5Row4};
	//Buses for Row 5.
	private float busRow5 = 624; // for all busses
	private float bus51X = 250;
	private float bus51XNow = 250;
	private float[] bus1Row5 = {bus51X, bus51XNow};
	private float bus52X = 562; 
	private float bus52XNow = 562;
	private float[] bus2Row5 = {bus52X, bus52XNow};
	private float bus53X = 874;
	private float bus53XNow = 874;
	private float[] bus3Row5 = {bus53X, bus53XNow};
	private float[][] busesRow5 = {bus1Row5, bus2Row5, bus3Row5};
	
	//Following similar logic with buses, since each bus has a unique coordinates, a unique BoundingBox is given
	//to each of the bus.
	//Declaring Bounding Boxes Frog
    public BoundingBox frogBoundingBox;
    //Declaring Bounding Boxes for buses from Row 1
    public BoundingBox bus11BoundingBox;
    public BoundingBox bus12BoundingBox;
    public BoundingBox bus13BoundingBox;
    public BoundingBox bus14BoundingBox;
    public BoundingBox bus15BoundingBox;
    //Declaring Bounding Boxes for buses from Row 2
    public BoundingBox bus21BoundingBox;
    public BoundingBox bus22BoundingBox;
    public BoundingBox bus23BoundingBox;
    public BoundingBox bus24BoundingBox;
    public BoundingBox bus25BoundingBox;
    //Declaring Bounding Boxes for buses from Row 3
    public BoundingBox bus31BoundingBox;
    public BoundingBox bus32BoundingBox;
    //Declaring Bounding Boxes for buses from Row 4
    public BoundingBox bus41BoundingBox;
    public BoundingBox bus42BoundingBox;
    public BoundingBox bus43BoundingBox;
    public BoundingBox bus44BoundingBox;
    public BoundingBox bus45BoundingBox;
    //Declaring Bounding Boxes for buses from Row 5
    public BoundingBox bus51BoundingBox;
    public BoundingBox bus52BoundingBox;
    public BoundingBox bus53BoundingBox;
    public BoundingBox bus54BoundingBox;
    public BoundingBox bus55BoundingBox;
	
	public Sprite() throws SlickException {
		bus = new Image("assets/bus.png");
		player = new Image("assets/frog.png");
	}
	
	
	public void update(Input input, int delta, float SPEED, int SCREEN_HEIGHT, int SCREEN_WIDTH)  {
        //The first thing is to check for any collisions. The following nest if statements check if there is any collision.
		//Bounding boxes are created in each update, because sprites are dynamic and so are their coordinates.
		//If sprite moves, the bounding box has to be created anew to adjust to the new position.
		frogBoundingBox = new BoundingBox(player, frogX, frogY);
		//To save on efficiency, the bounding boxes are considered once the frog enters that specific row with buses.
		//That is why there is an if statement for each row.
		//The if detects collision for Row 1 buses.
		if (frogY == 432) {
			//Creating a new BoundingBox per bus.
			bus11BoundingBox = new BoundingBox(bus, busesRow1[0][1], busRow1);
			bus12BoundingBox = new BoundingBox(bus, busesRow1[1][1], busRow1);
			bus13BoundingBox = new BoundingBox(bus, busesRow1[2][1], busRow1);
			bus14BoundingBox = new BoundingBox(bus, busesRow1[3][1], busRow1);
			//Checking if the player's BoundigBox intersect with either of the buses' BoundingBoxes.
			if ((frogBoundingBox.intersects(bus11BoundingBox) == true) || (frogBoundingBox.intersects(bus12BoundingBox) == true) ||
					(frogBoundingBox.intersects(bus13BoundingBox) == true) || (frogBoundingBox.intersects(bus14BoundingBox) == true)){
				//Player loses if frogs intersects any of the buses.
				System.exit(0);
			}
			
		}
		//Detects collision for Row 2 buses.
		if (frogY == 480) {
			bus21BoundingBox = new BoundingBox(bus, busesRow2[0][1], busRow2);
			bus22BoundingBox = new BoundingBox(bus, busesRow2[1][1], busRow2);
			bus23BoundingBox = new BoundingBox(bus, busesRow2[2][1], busRow2);
			bus24BoundingBox = new BoundingBox(bus, busesRow2[3][1], busRow2);
			bus25BoundingBox = new BoundingBox(bus, busesRow2[4][1], busRow2);
			
			if ((frogBoundingBox.intersects(bus21BoundingBox) == true) || (frogBoundingBox.intersects(bus22BoundingBox) == true) ||
					(frogBoundingBox.intersects(bus23BoundingBox) == true) || (frogBoundingBox.intersects(bus24BoundingBox) == true) || 
					(frogBoundingBox.intersects(bus25BoundingBox) == true)){
				System.exit(0);
			}

		}
		//Detect collision for Row 3 buses
		if (frogY == 528) {
			bus31BoundingBox = new BoundingBox(bus, busesRow3[0][1], busRow3);
			bus32BoundingBox = new BoundingBox(bus, busesRow3[1][1], busRow3);
			
			if ((frogBoundingBox.intersects(bus31BoundingBox) == true) || (frogBoundingBox.intersects(bus32BoundingBox) == true)){
				System.exit(0);
			}
		}
		
		//Detect collision for Row 4 buses
		if (frogY == 576) {
			bus41BoundingBox = new BoundingBox(bus, busesRow4[0][1], busRow4);
			bus42BoundingBox = new BoundingBox(bus, busesRow4[1][1], busRow4);
			bus43BoundingBox = new BoundingBox(bus, busesRow4[2][1], busRow4);
			bus44BoundingBox = new BoundingBox(bus, busesRow4[3][1], busRow4);
			bus45BoundingBox = new BoundingBox(bus, busesRow4[4][1], busRow4);
				
			if ((frogBoundingBox.intersects(bus41BoundingBox) == true) || (frogBoundingBox.intersects(bus42BoundingBox) == true) ||
					(frogBoundingBox.intersects(bus43BoundingBox) == true) || (frogBoundingBox.intersects(bus44BoundingBox) == true) || 
					(frogBoundingBox.intersects(bus45BoundingBox) == true)){
				System.exit(0);
			}
		}
		//Detect Collision for Row 5
		if (frogY == 624) {
			bus51BoundingBox = new BoundingBox(bus, busesRow5[0][1], busRow5);
			bus52BoundingBox = new BoundingBox(bus, busesRow5[1][1], busRow5);
			bus53BoundingBox = new BoundingBox(bus, busesRow5[2][1], busRow5);
			if ((frogBoundingBox.intersects(bus51BoundingBox) == true) || (frogBoundingBox.intersects(bus52BoundingBox) == true) ||
				(frogBoundingBox.intersects(bus53BoundingBox) == true) ){
						System.exit(0);
			}					
		}
		
		//Here the input is read and basing on that, the game responds. 
		//The frog moves as long as it does not step into the water. The first nested-ifs ensure
		//that the game ends once the frog enters the water.
		if (input.isKeyPressed(Input.KEY_UP)) {
			if (frogY - 48 < 384) {
				System.exit(0);
			}
			frogY = frogY - 48;
		}
		
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			if (frogY == 48) {
				frogY = 48;
			}
			frogY = frogY + 48;
		}
		
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			frogX = frogX - 48;
		}
		
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			frogX = frogX + 48;
		}
		
		//The following three if's ensure that the frog does not go off the screen.
		//There is no need for upper bound, because the water is already the barrier.
		if (frogX < 48) {
			frogX = 48;
		}
		if (frogY > 720) {
			frogY = 720;
		}
		if (frogX > 976) {
			frogX = 976;
		}
		
		//The following 5 for loops with nested if statements, update the presence of buses in the game.
		//This for loop updates the buses from Row 1.
		for (int i = 0; i< busesRow1.length; i++) {
			if (busesRow1[i][0] == busesRow1[i][1]) {
				if (busesRow1[i][0] + delta*SPEED >= App.SCREEN_WIDTH) {
					busesRow1[i][1] = 0;
					busesRow1[i][0] = busesRow1[i][1];
				}
				busesRow1[i][1] = busesRow1[i][1] + delta*SPEED;
				busesRow1[i][0] = busesRow1[i][1];
			}
			
		}
		
		//This for loop updates the buses from Row 2.
		for (int i = 0; i< busesRow2.length; i++) {
			if (busesRow2[i][0] == busesRow2[i][1]) {
				if (busesRow2[i][0] + delta*SPEED <= 0) {
					busesRow2[i][1] = App.SCREEN_WIDTH;
					busesRow2[i][0] = busesRow2[i][1];
				}
				busesRow2[i][1] = busesRow2[i][1] - delta*SPEED;
				busesRow2[i][0] = busesRow2[i][1];
			}
			
		}
		//This for loop updates the buses from Row 3.
		for (int i = 0; i< busesRow3.length; i++) {
			if (busesRow3[i][0] == busesRow3[i][1]) {
				if (busesRow3[i][0] + delta*SPEED >= App.SCREEN_WIDTH) {
					busesRow3[i][1] = 0;
					busesRow3[i][0] = busesRow3[i][1];
				}
				busesRow3[i][1] = busesRow3[i][1] + delta*SPEED;
				busesRow3[i][0] = busesRow3[i][1];
			}
			
		}
		//This for loop updates the buses from Row 4.
		for (int i = 0; i< busesRow4.length; i++) {
			if (busesRow4[i][0] == busesRow4[i][1]) {
				if (busesRow4[i][0] + delta*SPEED <= 0) {
					busesRow4[i][1] = App.SCREEN_WIDTH;
					busesRow4[i][0] = busesRow4[i][1];
				}
				busesRow4[i][1] = busesRow4[i][1] - delta*SPEED;
				busesRow4[i][0] = busesRow4[i][1];
			}
			
		} 
		//This for loop updates the buses from Row 5.
		for (int i = 0; i< busesRow5.length; i++) {
			if (busesRow5[i][0] == busesRow5[i][1]) {
				if (busesRow5[i][0] + delta*SPEED >= App.SCREEN_WIDTH) {
					busesRow5[i][1] = 0;
					busesRow5[i][0] = busesRow5[i][1];
				}
				busesRow5[i][1] = busesRow5[i][1] + delta*SPEED;
				busesRow5[i][0] = busesRow5[i][1];
			}
			
		}
	}
	
	public void render(Graphics g, int SCREEN_WIDTH) {
        //The following for loops draw the busses.
		//Draw busses for Row 1.
		for (int i = 0; i < busesRow1.length; i++) {
			bus.drawCentered(busesRow1[i][1], busRow1);
		}
		//Draw busses for Row 2
		for (int i = 0; i < busesRow2.length; i++) {
			bus.drawCentered(busesRow2[i][1], busRow2);
		}
		//Draw busses for Row 3
		for (int i = 0; i < busesRow3.length; i++) {
			bus.drawCentered(busesRow3[i][1], busRow3);
		}
		//Draw busses for Row 4
		for (int i = 0; i < busesRow4.length; i++) {
			bus.drawCentered(busesRow4[i][1], busRow4);
			
		}
		//Draw busses for Row 5
		for (int i = 0; i < busesRow5.length; i++) {
			bus.drawCentered(busesRow5[i][1], busRow5);
		}
		
		//Finally, the player is drawn.
        player.drawCentered(frogX, frogY);

	}
	
}
