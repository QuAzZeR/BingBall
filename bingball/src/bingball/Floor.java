package bingball;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Floor {
	private Image leftFloor;
	private Image rightFloor;
	public static final int WIDTH = 250;
	public static final int HIGHT = 15;
	private float x;
	private float y;
	private float speed;
	public Floor(float x, float y,float speed) throws SlickException {
		this.x = x;
		this.y = y;
		this.speed=speed;
		leftFloor = new Image("res/floor.png");
		rightFloor = new Image("res/floor.png");
	

	}

	public void render(){
		leftFloor.draw(x+65,BingBall.GAME_HEIGHT-(y+HIGHT/2));
		rightFloor.draw(x-250,BingBall.GAME_HEIGHT-(y+HIGHT/2));
		
	}
	public void update()
	{
		y+=speed;
		System.out.println(y);
		if(y>480){
			System.out.println("ludna");
			y=BingBall.GAME_HEIGHT-(480+HIGHT);
		}
	}
}
