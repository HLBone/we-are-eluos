package ui;

import javax.swing.JFrame;
import java.awt.*;

public class FrameGame extends JFrame {
    public FrameGame() {
        //设置标题
        this.setTitle("Java俄罗斯方块");
        //设计默认关闭属性（程序结束）
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小
        this.setSize(1200, 700);
        //禁止改变窗口大小
        this.setResizable(false);
        //窗口居中
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();//获得显示器的大小
        int x = (screen.width - this.getWidth()) / 2;
        int y = (screen.height - this.getHeight()) / 2 - 32;
        this.setLocation(x, y);
        //设置默认Panel
        this.setContentPane(new PanelGame());

    }
}
