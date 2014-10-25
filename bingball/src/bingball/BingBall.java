package bingball;

import java.util.prefs.BackingStoreException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BingBall extends BasicGame {

	private Ball ball;
	private Floor[] floors;
	public static int score=0;
	public static final int GAME_WIDTH = 320;
	public static final int GAME_HEIGHT = 480;
	public static float BALL_INITIAL_SPEED = 5;
	public static float FLOOR_INITIAL_SPEED = 2f;
	public static final float G = (float) -5;
	public static final int COUNT_FLOOR = 7;
	public BingBall(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		ball.render();
		for (Floor floor : floors)
			floor.render();
		g.drawString("score = "+score, 200, 20);

	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		Color background = new Color(0, 0, 0);
		container.getGraphics().setBackground(background);
		ball = new Ball(GAME_WIDTH / 2, GAME_HEIGHT, BALL_INITIAL_SPEED);
		initFloor();
	}

	private void initFloor() throws SlickException {
		floors = new Floor[COUNT_FLOOR];
		for (int i = 0; i < COUNT_FLOOR; i++)
			floors[i] = new Floor(GAME_WIDTH / 2, GAME_HEIGHT/2 -( 10 + 69 * i),
					FLOOR_INITIAL_SPEED);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		Input input = container.getInput();
		for(Floor floor : floors)
			floor.update();
		for (int i = 0; i < COUNT_FLOOR; i++)
		{
			if(ball.isCollide(floors[i]))
			{
				System.out.println("isCollide"+i);
				break;
			}
		}
		ball.update(input, delta);
		

	}

	public static void main(String[] args) {
		try {
			BingBall game = new BingBall("Bing Ball");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setMinimumLogicUpdateInterval(1000 / 60);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
