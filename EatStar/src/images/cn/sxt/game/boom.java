
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
		   // Ϊʲô��public xinxin�����������ֵ������ȥ��Ҫд�������Ϳ��ԣ�����ǰ�滹���ܼ�int
	//public void xinxin(){
	 //    speed=5;
	   // double x=Math.random()*1000;
	   //double y=Math.random()*100;
	  //  double x=100;
	    //double y=60;
	  //  width=10;
	  //   height=40;
	   // Ϊʲô����������ֵ������ȥ
	//}	

		public void drawSelf(Graphics g) {
			if(live){
			g.drawImage(xinxinimg,(int)x,(int)y,width,height,null);
			if(y<=400)
				y++;
			
			//ΪʲôҪд������
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
		//���캯��
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
