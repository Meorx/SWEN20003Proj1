//Student ID: 1012976
//Name: Hong Ngoc Do

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import utilities.BoundingBox;


public class World extends App{
    public Sprite sprite;
    private int screen_Width = 0;
    private int screen_Height = 0;
	private static float SPEED = 0.15f;
	private Image backgroundGrass;
	private Image backgroundWater;
	
	public World(int screen_Width, int screen_Height) throws SlickException {
		//The background is initialized.
		backgroundGrass = new Image("assets/grass.png");
		backgroundWater = new Image("assets/water.png");
		this.screen_Width = screen_Width;
		this.screen_Height = screen_Height; 
		//Sprites have their own class because, unlike the background, they are dynamic.
		sprite = new Sprite();
		
	}
	
	public void update(Input input, int delta) throws SlickException{
		//Update the screen to get the newest position of the sprites.
		sprite.update(input, delta, SPEED, screen_Height, screen_Width);
		
	}	

	public void render(Graphics g) throws SlickException {
		// This for loops draws the water.
		for (int i = 48; i <= 336; i = i + 48) {
			for (int j = 0; j < SCREEN_WIDTH; j = j + 48)
			backgroundWater.drawCentered(j, i);
		}
		//Since the grass appears in two distinct places, there are unfortunately
		//two separate loops to create that grass.
		for (int i = 0; i < SCREEN_WIDTH; i = i + 48) {
			backgroundGrass.drawCentered(i, 384);
		
		}
		for (int i = 0; i < SCREEN_WIDTH; i = i + 48) {
			backgroundGrass.drawCentered(i, 672);
		
		}
		//Finally, render the spirtes on top of the background.
		sprite.render(g, SCREEN_WIDTH);

	}
}
