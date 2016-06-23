import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class Enemy 
{
	private int x = 100;
	private int y = 100;
	private int speed = 5;
	private URL url;
	private Image enemy;
	public Enemy(MainClass mc)
	{
		url = mc.getDocumentBase();
		enemy = mc.getImage(url, "asteroid_blue.png");
	}
	
	public Enemy (int i, int j, MainClass mc)
	{
		x = i;
		y = j;
		url = mc.getDocumentBase();
		enemy = mc.getImage(url, "asteroid_blue.png");
	}
	
	public void update (MainClass mc, Player p)
	{
		x += speed;
		if(x <= 0) speed = 5;
		else if( x>= mc.getWidth() - 25) speed -= 5;
		
		Collision(p);
	}
	
	private void Collision(Player p) 
	{
		int PX = p.getX();
		int PY = p.getY();
		
		if(PX - 32 <= x && PX + 32 >= x && PY - 32 <= y && PY + 32 >= y)
		{
			System.out.println("COLLISION !!!!");
			p.restart();
		}
	}

	public void paint (Graphics g, MainClass mc)
	{
		g.drawImage(enemy, x, y, mc); 
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
