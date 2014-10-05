package bingball;

import java.util.prefs.BackingStoreException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class BingBall extends BasicGame{

	private Ball ball;
	public static final int GAME_WIDTH = 320;
	public static final int GAME_HEIGHT = 480;
	public static final int BALL_INITIAL_SPEED=7;
	public static final float G = (float)-1.5;
	
	public BingBall(String title)
	{
		super(title);
	}
	
	
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		ball.render();
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		Color background = new Color(0,0,0);
		container.getGraphics().setBackground(background);
		ball=new Ball(GAME_WIDTH/2,GAME_HEIGHT/2,BALL_INITIAL_SPEED);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		
		ball.update(input,delta);
		
	}
	public static void main(String[] args) {
		try {
		      BingBall game = new BingBall("Bing Ball");
		      AppGameContainer appgc = new AppGameContainer(game);
		      appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
		      appgc.start();
		    } catch (SlickException e) {
		      e.printStackTrace();
		    }
	}
}
