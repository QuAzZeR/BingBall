package bingball;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ball {
	private float x;
	private float y;
	private Image image;
	private float speed;
	private boolean collide;
	public static final int WIDTH = 40;
	public static final int HEIGHT = 35;

	public Ball(float x, float y, float speed) throws SlickException {
		this.x = x;
		this.y = y;
		this.speed = speed;
		image = new Image("res/ball.png");
	}

	public void render() {
		image.draw(x - WIDTH / 2, BingBall.GAME_HEIGHT - (y + HEIGHT / 2));
	}

	public void moveLeft() {
		if (x > 20)
			x -= speed;
	}

	public void moveRight() {
		if (x < BingBall.GAME_WIDTH - 20)
			x += speed;
	}

	public void update(Input input, int delta) {
		if (input.isKeyDown(Input.KEY_LEFT))
			moveLeft();
		if (input.isKeyDown(Input.KEY_RIGHT))
			moveRight();

		if (!collide)
			if (y > 30) {
				BingBall.score++;
				this.y += BingBall.G;
			}
		if(BingBall.score%200==0&&BingBall.score!=0)
			this.speed+=0.3;
			

	}

	public boolean isCollide(Floor f) {

		if (Math.abs((this.y - HEIGHT / 2) - (f.getY() + Floor.HIGHT / 2)) < Floor.HIGHT / 2) {
			if (this.x + WIDTH / 2 - 30 > f.getX() - Floor.WIDTH / 2
					&& this.x - WIDTH + 10 < f.getX() + Floor.WIDTH / 2) {
				// if (Math.abs((this.x + WIDTH / 2) - (f.getX()
				// +65))<Floor.WIDTH &&
				// Math.abs((this.x+WIDTH/2)-(f.getX()-250))<Floor.WIDTH){
				System.out
						.println(this.y + " / " + f.getY() + " \\ " + collide);

				this.y = f.getY() + Floor.HIGHT / 2 + HEIGHT / 2;
				collide = true;
			}
			return true;
		} else {
			collide = false;
			return false;
		}
	}
}
