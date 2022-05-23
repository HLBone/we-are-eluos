package ui;

import java.awt.Graphics;

import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/**
 * ���ƴ���
 * @author ����
 */
public abstract class Layer {
	protected static final int PADDING;
	private static final int SIZE;
	static {
		//�����Ϸ����
		GameConfig cfg =ConfigFactory.getGameConfig();
		PADDING=cfg.getPadding();
		 SIZE=cfg.getWindowSize();
	}
	private static Image WINDOW_IMG =new ImageIcon("window/window.png").getImage();
	private static int WINDOW_W =WINDOW_IMG.getWidth(null);
	 
	private static  int WINDOW_H=WINDOW_IMG.getHeight(null);
	/**
	 * ����ͼƬ 260 36
	 */
	private static final Image IMG_NUMBER = new ImageIcon("window/num.png").getImage();
	/**
	 * ������Ƭ�Ŀ��
	 */
	protected static final int IMG_NUMBER_W =IMG_NUMBER.getWidth(null)/10 ;
	/**
	 * ������Ƭ�ĸ߶�
	 */
	private static final int IMG_NUMBER_H = IMG_NUMBER.getHeight(null);
	/**
	 * �������Ͻ�x����
	 */
	protected final int x;
	
	/**
	 * �������Ͻ�y����
	 */
	protected final int y;
	
	/**
	 * ���ڿ��
	 */
	protected  final int w;
	
	/**
	 *���ڸ߶�
	 */
	protected  final int h;
	/**
	 * ��Ϸ����
	 */
	
	protected  GameDto dto=null;
	
	protected Layer(int x,int y,int w,int h) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
}
	/**
	 * ���ƴ���
	 */
	protected  void createWindow(Graphics g) {
		
		//����
	    g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
	    //����
	    g.drawImage(WINDOW_IMG, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);
	    //����
	    g.drawImage(WINDOW_IMG, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
	    //����
	    g.drawImage(WINDOW_IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);
	    //��
	    g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE,x+ w-SIZE, y+h-SIZE, SIZE, SIZE,WINDOW_W- SIZE,WINDOW_H- SIZE, null);
	    //����
	    g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W,WINDOW_H- SIZE, null);
	    //����
	    g.drawImage(WINDOW_IMG, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
	    //����
	    g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE,WINDOW_W- SIZE, WINDOW_H, null);
	    //����
	    g.drawImage(WINDOW_IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);
	}
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	/**
	 * ��ʾ����
	 * @param x���Ͻ�x����
	 * @param y���Ͻ�y����
	 * @param numҪ��ʾ������
	 * @param bitCount ����λ��
	 * @param g���ʶ���
	 */
		protected void drawNumberLeftPad( int x,int y,int num,int maxBit,Graphics g) {
			//��Ҫ��ӡ������ת�����ַ���
			String strNum = Integer.toString(num);
			//ѭ�����������Ҷ���
			for (int i = 0; i <maxBit; i++) {
				//�ж��Ƿ������������
				if(maxBit-i<=strNum.length()) {
					//����������ַ����е��±�
					int idx=i-maxBit+strNum.length();
					//������number�е�ÿһλȡ��
					int bit = strNum.charAt(idx)-'0';
					//��������
					g.drawImage(IMG_NUMBER,
							this.x+x+ IMG_NUMBER_W *i, this.y+y,
							this.x+x+IMG_NUMBER_W*(i+1 ),this.y+y+IMG_NUMBER_H,
							bit* IMG_NUMBER_W, 0,
							(bit+1)* IMG_NUMBER_W,IMG_NUMBER_H , null);
				}	  
			}   
		}
	
	
	/**
	 * ˢ����Ϸ��������
	 * @author ����
	 * @param g ����
	 */
	 abstract public void paint(Graphics g) ;
		
	

}
