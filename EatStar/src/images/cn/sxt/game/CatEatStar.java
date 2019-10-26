package images.cn.sxt.game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//飞机游戏主窗口

public class CatEatStar extends Frame {
	Image flower = GameUtil1.getImage("images/flower.PNG");
	Image catimg = GameUtil1.getImage("images/cat.png");
	cat cat = new cat(catimg, 20, 350, 40, 40);
	xinxin xinxin1 = new xinxin();
	//xinxin xinxin2 = new xinxin();
	//xinxin[] xinxins = { xinxin1, xinxin2 };
	 xinxin[] xinxins=new xinxin[50];
	 boom[] booms=new boom[10];

	 CatEatStar(){
    		for (int i = 0; i < xinxins.length; i++) {

    			xinxins[i] = new xinxin();

    		}
    		for (int i = 0; i < booms.length; i++) {

    			booms[i] = new boom();

    		}
     }
	public  int count  = 0;
	public void launchFrame() {
		
		this.setTitle("吃星星");
		this.setVisible(true);
		this.setSize(constant.GAME_WIDTH, constant.GAME_HEIGHT);
		this.setLocation(200, 200);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

		new PaintThread().start();// 启动重画
		addKeyListener(new KeyMoniter());
		// 初始化，为什么没用
		for (int i = 0; i < xinxins.length; i++) {

			xinxins[i] = new xinxin();

		}
	}

	public void paint(Graphics g)

	{

		g.drawImage(flower, 0, 0, 1160, 410, null);
		cat.drawSelf(g);// 画猫猫

		for (int i = 0; i < xinxins.length; i++) {

			xinxins[i].drawSelf(g);

			boolean peng1 = xinxins[i].getRect().intersects(cat.getRect());
			// System.out.println("碰撞情况是："+peng);
			// System.out.println(xinxins[i].getRect());
			if (peng1) {
				count++;
				peng1=false;
				System.out.println("分数 是：" + count);
				xinxins[i].live = false;

			}

		}
		for (int i = 0; i < booms.length; i++) {

			booms[i].drawSelf(g);

			boolean peng = booms[i].getRect().intersects(cat.getRect());
			// System.out.println("碰撞情况是："+peng);
			// System.out.println(xinxins[i].getRect());
			if (peng) {
				cat.live = false;
				
				
				
           
			}
            if(!cat.live)
            	g.setColor(Color.WHITE);
			g.drawString("分数是"+count,(int)cat.x,(int)cat.y);
		}

		/*
		 * g.drawImage(cat, x,y,100, 100, null); if(x<=1000) x++; else x=20;
		 */

	}

	// 帮助我们反复地重画窗口
	class PaintThread extends Thread {

		@Override
		public void run() {
			while (true) {
				repaint();// 重画

				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// 键盘
	class KeyMoniter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			cat.addDirection(e);

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			cat.freeDirection(e);
		}

	}

	// 初始化窗口

	// 防闪屏

	public static void main(String[] args) {
		CatEatStar f = new CatEatStar();
		f.launchFrame();
	}

	public void update(Graphics g) {
		Image offScreenImage = null;
		if (offScreenImage == null)
			offScreenImage = this.createImage(constant.GAME_WIDTH, constant.GAME_HEIGHT);// 这是游戏窗口的宽度和高度

		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

}
/*
 * 疑问： 1.为什么星星用循环进行动态初始化会失败，但是用静态初始化却可以成功 2.xinxin类的值为什么写法和参考不同
 * 3.写static和不写static的区别
 * 
 */