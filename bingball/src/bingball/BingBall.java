package bingball;

import java.util.prefs.BackingStoreException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class BingBall extends BasicGame{

	public BingBall(String title)
	{
		super(title);
	}
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		Color background = new Color(0,0,0);
		container.getGraphics().setBackground(background);
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		try {
		      BingBall game = new BingBall("Bing Ball");
		      AppGameContainer appgc = new AppGameContainer(game);
		      appgc.setDisplayMode(320, 480, false);
		      appgc.start();
		    } catch (SlickException e) {
		      e.printStackTrace();
		    }

	}
}
