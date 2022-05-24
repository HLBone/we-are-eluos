package ui;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {
	/**
	 * ���������λ��
	 */
	private static final int  POINT_BIT =5;
	
    //TODO�����ļ�
	private static final int LEVER_UP=20;
	
	
	/**
	 * ����y����
	 */
	
	private final int rmLineY;
	/**
	 * ����y����
	 */
	
	private final int pointY;
	/**
	 * ����ֵy����
	 */
	private final int expY;
	/**
	 * ����x����
	 */
	
	private  final int comX ;

	public LayerPoint(int x,int y,int w,int h) {
		super(x,y,w,h);
		//��ʼ����ͨX����
		this.comX = this.w-IMG_NUMBER_W*POINT_BIT-PADDING;
		//��ʼ��������ʾ��Y����
		 this.pointY = PADDING;
			//��ʼ��������ʾ��Y����
		this.rmLineY = this.pointY+Img.POINT.getHeight(null)+PADDING;
		//��ʼ������ֵ��ʾ��y����
		this.expY = this.rmLineY+Img.RMLINE.getHeight(null)+PADDING;
	}
	public void paint(Graphics g) {
		this.createWindow(g);
		//���ڱ���(������
	g.drawImage(Img.POINT,this.x+PADDING, this.y+pointY,null );
	
	this.drawNumberLeftPad(comX, pointY,this.dto.getNowPoint(),POINT_BIT, g);
	//���ڱ���(���У�
	g.drawImage( Img.RMLINE ,this.x+PADDING, this.y+rmLineY,null );
	//��ʾ����
	this.drawNumberLeftPad(comX,rmLineY ,this.dto.getNowRemoveLine(),POINT_BIT,g);
	//����ֵ��(����ֵ��
	int rmLine = this.dto.getNowRemoveLine();
	this.drawRect(expY,"��һ��",null,(double)(rmLine%LEVER_UP),(double)LEVER_UP,g);
	}

}
