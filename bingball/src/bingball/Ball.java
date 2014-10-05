package bingball;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ball {
	private float x;
	private float y;
	private Image image;
	private float speed;
	public static final int WIDTH=40;
	public static final int HEIGHT=40; 
	
	public Ball(float x, float y,int speed) throws SlickException {
		this.x = x;
		this.y = y;
		this.speed=speed;
		image = new Image("res/ball.png");
		
	}
	public void render()
	{
		image.draw(x - WIDTH/2, BingBall.GAME_HEIGHT - (y + HEIGHT/2));
	}
	public void moveLeft()
	{
		x-=speed;
	
	}
	public void moveRight()
	{
		x+=speed;
	}
	public void update(Input input,int delta)
	{
		if(input.isKeyDown(Input.KEY_LEFT))
			moveLeft();
		if(input.isKeyDown(Input.KEY_RIGHT))
			moveRight();
		this.y+=BingBall.G;
	}
	
}
