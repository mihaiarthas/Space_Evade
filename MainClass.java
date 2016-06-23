import java.applet.*;
import java.awt.*;
import java.net.URL;

public class MainClass extends Applet implements Runnable
{

	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600 ;
	
	Thread thread = new Thread(this);
	boolean running = true;
	Player p;
	Enemy e ,e2;
	Image dbImage;
	Graphics dbg;
	private URL url;
	private Image BG;
	
	public void init()
	{
		setSize(WIDTH, HEIGHT);
		p = new Player(this);
		e = new Enemy(this);
		e2 = new Enemy(200, 300, this);
		url = this.getDocumentBase();
		BG = this.getImage(url, "MAP.png");
	}
	
	public void start()
	{
		thread.start();
	}
	
	public void destroy()
	{
		running = false;
	}
	
	public void stop()
	{
		running = false;
	}
	
	public void run()
	{
		while(running)
		{
			repaint();
			p.update(this);
			e.update(this, p);
			e2.update(this, p);
			try
			{
				Thread.sleep(20);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void update(Graphics g)
	{
		dbImage = createImage(this.getWidth(),this.getHeight());
		dbg = dbImage.getGraphics();
		paint(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(BG, 0, 0, this);
		e.paint(g, this);
		e2.paint(g, this);
		p.paint(g, this);
		
	}
}
