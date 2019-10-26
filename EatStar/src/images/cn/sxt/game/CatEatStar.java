package images.cn.sxt.game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//�ɻ���Ϸ������

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
		
		this.setTitle("������");
		this.setVisible(true);
		this.setSize(constant.GAME_WIDTH, constant.GAME_HEIGHT);
		this.setLocation(200, 200);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

		new PaintThread().start();// �����ػ�
		addKeyListener(new KeyMoniter());
		// ��ʼ����Ϊʲôû��
		for (int i = 0; i < xinxins.length; i++) {

			xinxins[i] = new xinxin();

		}
	}

	public void paint(Graphics g)

	{

		g.drawImage(flower, 0, 0, 1160, 410, null);
		cat.drawSelf(g);// ��èè

		for (int i = 0; i < xinxins.length; i++) {

			xinxins[i].drawSelf(g);

			boolean peng1 = xinxins[i].getRect().intersects(cat.getRect());
			// System.out.println("��ײ����ǣ�"+peng);
			// System.out.println(xinxins[i].getRect());
			if (peng1) {
				count++;
				peng1=false;
				System.out.println("���� �ǣ�" + count);
				xinxins[i].live = false;

			}

		}
		for (int i = 0; i < booms.length; i++) {

			booms[i].drawSelf(g);

			boolean peng = booms[i].getRect().intersects(cat.getRect());
			// System.out.println("��ײ����ǣ�"+peng);
			// System.out.println(xinxins[i].getRect());
			if (peng) {
				cat.live = false;
				
				
				
           
			}
            if(!cat.live)
            	g.setColor(Color.WHITE);
			g.drawString("������"+count,(int)cat.x,(int)cat.y);
		}

		/*
		 * g.drawImage(cat, x,y,100, 100, null); if(x<=1000) x++; else x=20;
		 */

	}

	// �������Ƿ������ػ�����
	class PaintThread extends Thread {

		@Override
		public void run() {
			while (true) {
				repaint();// �ػ�

				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// ����
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

	// ��ʼ������

	// ������

	public static void main(String[] args) {
		CatEatStar f = new CatEatStar();
		f.launchFrame();
	}

	public void update(Graphics g) {
		Image offScreenImage = null;
		if (offScreenImage == null)
			offScreenImage = this.createImage(constant.GAME_WIDTH, constant.GAME_HEIGHT);// ������Ϸ���ڵĿ�Ⱥ͸߶�

		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

}
/*
 * ���ʣ� 1.Ϊʲô������ѭ�����ж�̬��ʼ����ʧ�ܣ������þ�̬��ʼ��ȴ���Գɹ� 2.xinxin���ֵΪʲôд���Ͳο���ͬ
 * 3.дstatic�Ͳ�дstatic������
 * 
 */