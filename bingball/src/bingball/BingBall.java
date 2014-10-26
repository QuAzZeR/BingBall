package bingball;

import java.util.prefs.BackingStoreException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BingBall extends BasicGame {

	private Ball ball;
	private Floor[] floors;
	private boolean startedGame=false;
	private boolean isGameOver;
	private Image started;
	private Image gameOver;
	public static int score;
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

		if (startedGame == true&&!isGameOver) {
			ball.render();
			for (Floor floor : floors)
				floor.render();
			g.drawString("score = " + score, 200, 20);

		}
		else if(isGameOver){
			g.drawImage(gameOver, 0,0);
		}
		if (startedGame == false) {
			g.drawImage(started, 0, 0);
		}

	}

	@Override
	public void init(GameContainer container) throws SlickException {

		started = new Image("res/start.png");
		gameOver = new Image("res/gameover.png");
		Color background = new Color(0, 0, 0);
		score=0;
		isGameOver = false;
		container.getGraphics().setBackground(background);
		ball = new Ball(GAME_WIDTH / 2, GAME_HEIGHT - 40, BALL_INITIAL_SPEED);
		initFloor();
	}

	private void initFloor() throws SlickException {

		floors = new Floor[COUNT_FLOOR];
		for (int i = 0; i < COUNT_FLOOR; i++)
			floors[i] = new Floor(GAME_WIDTH / 2, GAME_HEIGHT / 2
					- (10 + 69 * i), FLOOR_INITIAL_SPEED);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		System.out.println(isGameOver+ " / "+ startedGame);
		if (!isGameOver) {
			checkNewGame(container.getInput());
			if (startedGame == true) {
				if(score==-999999)
					isGameOver=true;
				ball.update(container.getInput(), delta);
				for (Floor floor : floors)
					floor.update();
				for (int i = 0; i < COUNT_FLOOR; i++) {
					if (ball.isCollide(floors[i])) {
						System.out.println("isCollide" + i);
						break;
					}
				}
			}
		}
		if(isGameOver){
			restart(container.getInput());
			if(isGameOver==false){
				System.out.println("fucker");
				
				
				init(container);
			}
		}

	}
	public void checkNewGame(Input input)
	{
		if (input.isKeyDown(Input.KEY_ENTER)&&!startedGame)
		{
			score=0;
			startedGame=true;
		}
	}
	public void restart(Input input)
	{
		if (input.isKeyDown(Input.KEY_ENTER))
		{
			isGameOver=false;
		}
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
