package images.cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

//��Ϸ����ĸ���
public class GameObject {
Image img;
double x;
double y;
int speed; 
int width,height;
public void drawSelf(Graphics g){
	g.drawImage(img, (int)x, (int)y, null);
}

public GameObject(Image img, double x, double y, int width, int height) {
	super();
	this.img = img;
	this.x = x;
	this.y = y;
	//this.speed = speed;
	this.width = width;
	this.height = height;
}
public GameObject(){
}
//�жϾ���
public Rectangle getRect(){
	return new Rectangle((int)x,(int)y,width,height);
}

}
