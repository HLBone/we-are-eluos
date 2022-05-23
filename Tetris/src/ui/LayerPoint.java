package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {
	/**
	 * 分数的最大位数
	 */
	private static final int  POINT_BIT =5;
	
	/**
	 * 窗口标题(分数）
	 */
	private static final Image IMG_POINT =new ImageIcon("point.png").getImage();
	
	/**
	 * 窗口标题（消行）
	 */
	private static final Image IMG_RMLINE =new ImageIcon("rmline.png").getImage();
	/**
	 * 矩形值槽
	 */
	private static final Image IMG_RECT =new ImageIcon("window/rect.png").getImage();
	/**
	 * 矩形值槽(高度）
	 */
	private static final int RECT_H = IMG_RECT.getHeight(null);
	//TODO
	private static final int LEVER_UP=20;
	
	
	/**
	 * 消行y坐标
	 */
	
	private final int rmLineY;
	/**
	 * 分数y坐标
	 */
	
	private final int pointY;
	/**
	 * 经验值y坐标
	 */
	private final int expY;
	/**
	 * 经验值槽的宽带
	 */
	private final int expW;
	/**
	 * 消行x坐标
	 */
	
	private  final int comX ;

	public LayerPoint(int x,int y,int w,int h) {
		super(x,y,w,h);
		//初始化共通X坐标
		this.comX = this.w-IMG_NUMBER_W*POINT_BIT-PADDING;
		//初始化分数显示的Y坐标
		 this.pointY = PADDING;
			//初始化消行显示的Y坐标
		this.rmLineY = this.pointY+IMG_POINT.getHeight(null)+PADDING;
		//初始化经验值显示的y坐标
		this.expY = this.rmLineY+IMG_RMLINE.getHeight(null)+PADDING;
		//初始化经验值槽的宽度
		this.expW = this.w-(PADDING<<1);
	}
	public void paint(Graphics g) {
		this.createWindow(g);
		//窗口标题(分数）
	g.drawImage(IMG_POINT,this.x+PADDING, this.y+pointY,null );
	
	this.drawNumberLeftPad(comX, pointY,this.dto.getNowPoint(),POINT_BIT, g);
	//窗口标题(消行）
	g.drawImage( IMG_RMLINE ,this.x+PADDING, this.y+rmLineY,null );
	//显示消行
	this.drawNumberLeftPad(comX,rmLineY ,this.dto.getNowRemoveLine(),POINT_BIT,g);
	//绘制值槽(经验值）
	int rmLine = this.dto.getNowRemoveLine();
	this.drawRect((double)(rmLine%LEVER_UP),(double)LEVER_UP,g);
	//TODO临时
	
	}
	private void drawRect(double value,double maxValue,Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(this.x+PADDING,this.y+ expY,this.expW , RECT_H+4 );
		g.setColor(Color.WHITE);
		g.fillRect(this.x+PADDING+1,this.y+ expY+1,this.expW-2 , RECT_H+2);
		g.setColor(Color.BLACK);
		g.fillRect(this.x+PADDING+2,this.y+ expY+2,this.expW-4 , RECT_H);
	    int w = (int)((value/maxValue*(this.expW-4)));
	    g.drawImage(IMG_RECT,
	    		this.x+PADDING+2, this.y+expY+2,
	    		this.x+PADDING+this.expW-2,this.y+expY+2+RECT_H,
	    		0, 0, 1,RECT_H ,
	    		null);

	}
}
