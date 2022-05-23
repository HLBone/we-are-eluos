package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackGround extends Layer {
	//TODO¡Ÿ ±±≥æ∞
	private static Image IMG_BG_TEMP=new ImageIcon("background/bg06.jpg").getImage();

  public LayerBackGround(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(IMG_BG_TEMP, 0, 0,1162,654, null);

	}

}
