package ui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Img {

	private Img() {}
	/**
	 * ����ǩ��
	 */
		public static Image SIGN=new ImageIcon("window/sign.png").getImage();
		/**
		 * ����ͼƬ
		 */
		public static Image WINDOW =new ImageIcon("window/window.png").getImage();
		/**
		 * ����ͼƬ 260 36
		 */
		public static  Image NUMBER = new ImageIcon("window/num.png").getImage();
		/**
		 * ����ֵ��
		 */
		public static  Image RECT=new ImageIcon("window/rect.png").getImage();
		/**
		 * ���ݿⴰ�ڱ���
		 */
	    public static Image DB =new ImageIcon("db.png").getImage();
	    /**
	     * ���ؼ�¼���ڱ���
	     */
	   public static Image DISK =new ImageIcon("disk.png").getImage();
	   /**
	    * ����ͼƬ
	    */
       public static  Image ACT =new ImageIcon("game/rect.jpg").getImage();
   	/**
   	 * �ȼ�����ͼƬ
   	 */
       public  static  Image LVEVL =new ImageIcon("level.png").getImage();
       /**
   	 * ���ڱ���(������
   	 */
      public static  Image POINT =new ImageIcon("point.png").getImage();
   	
   	/**
   	 * ���ڱ��⣨���У�
   	 */
   	   public static  Image RMLINE =new ImageIcon("rmline.png").getImage();
   	   /**
   	    * ��һ��ͼƬ����
   	    */
   	public static Image[] NEXT_ACT ;
	static {
		NEXT_ACT = new Image[7];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("game/"+i+".jpg").getImage();
		}
	}
	    
	    
	
}
