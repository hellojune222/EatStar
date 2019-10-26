
package images.cn.sxt.game;

	import java.awt.Graphics;
	import java.awt.Image;

	public class boom extends GameObject{
		public  boolean live=true;
		Image xinxinimg=GameUtil1.getImage("images/boom.png");
		{


		   speed=5;
		   x=Math.random()*1000;
		   y=Math.random()*300;
		  //  double x=100;
		    //double y=60;
		    width=40;
		     height=40;
	     
		
		
		}
		   // 为什么用public xinxin（）方法里的值传不出去，要写成这样就可以，而且前面还不能加int
	//public void xinxin(){
	 //    speed=5;
	   // double x=Math.random()*1000;
	   //double y=Math.random()*100;
	  //  double x=100;
	    //double y=60;
	  //  width=10;
	  //   height=40;
	   // 为什么这个方法里的值传不出去
	//}	

		public void drawSelf(Graphics g) {
			if(live){
			g.drawImage(xinxinimg,(int)x,(int)y,width,height,null);
			if(y<=400)
				y++;
			
			//为什么要写成这样
		}
			else{

			y--;
			
			}
			
			
			
			
			}
		
		/*
		@Override
		public String toString() {
			return "xinxin [speed=" + speed + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height
					+ ", xinxinimg=" + xinxinimg + "]";
		}
		*/
		//构造函数
		/*public xinxin(xinxinimg,x,y,width,height,null)
		{
			this.img=img;
			this.width=width;
			this.height=height;
			this.x=x;
			this.y=y;

			
		}
	*/



}
