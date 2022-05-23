package ui;

import javax.swing.*;
import java.awt.*;

public class PanelGame extends JPanel {
    public PanelGame() {

    }

    @Override//这个关键词出现的方法是覆盖父类的方法
    public void paintComponent(Graphics g) {
        Image img = new ImageIcon("Graphics/window/window.png").getImage();
//      g.drawImage(img, 32, 32, null);
        int size = 7;
        g.drawImage(img, 64, 64, 64 + size, 64 + size, 0, 0, size, size, null);
    }
}
