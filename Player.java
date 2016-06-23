import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class Player implements KeyListener
{
	private int x = 200;
	private int y = 200;
	private int radius = 20;
	private int velX = 0;
	private int velY = 0;
	private URL url;
	private Image player;
	
	public Player(MainClass mc)
	{
		url = mc.getDocumentBase();
		player = mc.getImage(url, "fighter.png");
	}
	
	public void update(MainClass mc)
	{
		mc.addKeyListener(this);
		x += velX;
		y += velY;
	}
	
	public void paint(Graphics g, MainClass mc)
	{
		g.drawImage(player, x, y, mc);
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_D:
			{
				velX = 5;
				break;
			}
			case KeyEvent.VK_A:
			{
				velX = -5;
				break;
			}			
			case KeyEvent.VK_W:
			{
				velY = -5;
				break;
			}
			case KeyEvent.VK_S:
			{
				velY = 5;
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_D:
			{
				velX = 0;
				break;
			}
			case KeyEvent.VK_A:
			{
				velX = 0;
			}			
			case KeyEvent.VK_W:
			{
				velY = 0;
				break;
			}
			case KeyEvent.VK_S:
			{
				velY = 0;
				break;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getRadius()
	{
		return radius;
	}

	public void restart() 
	{
		x = 200;
		y = 200;
	}
}
