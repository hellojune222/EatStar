package images.cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class cat extends GameObject{

	private Image img;
    boolean left,right;
    int speed=7;
	public boolean live=true;
	public void drawSelf(Graphics g) {
		// TODO Auto-generated constructor stub
		if(live){g.drawImage(img,(int)x, (int)y, (int)width,(int)height, null);
		if(left&&(x>0)){
			x-=speed;
			
		}
		if(right&&(x<=1060)){
			x+=speed;
		}}
		else{
			
		}
	}
    
	public cat(Image img,double x,double y,int width,int height)
	{
		this.img=img;
		this.width=width;
		this.height=height;
		this.x=x;
		this.y=y;
		this.width=60;
		this.height=60;
		
	}
	//摁下的情况
	public void addDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			 left=true;
			 break;
		case KeyEvent.VK_RIGHT:
			 right=true;
			 break;
		}
	}
	//取消的情况
	public void freeDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			 left=false;
			 break;
		case KeyEvent.VK_RIGHT:
			 right=false;
			 break;
		}
	}
	
}
