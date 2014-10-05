package bingball;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Floor {
	private Image leftFloor;
	private Image RightFloor;
	public static final int WIDTH = 250;
	public static final int HIGHT = 15;
	private float x;
	private float y;

	public Floor(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		leftFloor = new Image("res/floor.png");
		RightFloor = new Image("res/floor.png");

	}

	public void render(){
		leftFloor.draw(x+65,BingBall.GAME_HEIGHT-(y+HIGHT/2));
		RightFloor.draw(x-250,BingBall.GAME_HEIGHT-(y+HIGHT/2));
		
	}
}
