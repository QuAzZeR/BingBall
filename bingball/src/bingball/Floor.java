package bingball;

import java.util.Random;

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
		Random random = new Random();
		this.x = random.nextInt(BingBall.GAME_WIDTH-50)+20;
		this.y = y;
		this.speed=speed;
		leftFloor = new Image("res/floor.png");
		rightFloor = new Image("res/floor.png");
	

	}
	public float getX()
	{
		return x;
	}
	public float getY()
	{
		return y;
	}
	public void render(){
		leftFloor.draw(x-100,BingBall.GAME_HEIGHT-(y+HIGHT/2));
		//rightFloor.draw(x-(200),BingBall.GAME_HEIGHT-(y+HIGHT/2));
		
	}
	public void update()
	{
		y+=speed;
		if(y>480){
			y=BingBall.GAME_HEIGHT-(480+HIGHT-15);
			this.randomX();
		}
		if(BingBall.score%200==0&&BingBall.score!=0)
			this.speed+=0.2f;
		
	}
	public void randomX()
	{
		Random random = new Random();
		this.x = random.nextInt(BingBall.GAME_WIDTH-50)+20;
	}
}
