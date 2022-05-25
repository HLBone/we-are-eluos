package view;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Opration;
import model.GameData;

public class MainWin extends JFrame{
    Opration opration;
    GameData gameDate;
    GamePanel gamePanel;
    Container mainpane;

public MainWin(Opration opration, GameData gameDate){
    this.gameDate = gameDate;//从构造体里获取参数
    this.opration = opration;//从构造体里获取参数
    mainpane = getLayeredPane();
    setBounds(50,50,640,1140);//50分别是距离左上角的左侧和左上角的上侧的距离，左到右是600px，上到下是1000px
    setResizable(false);//不允许出现的窗口被拉伸
    setLayout(null);//给图片在窗口中自由布局的权限
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//这是关闭窗口，则窗口直接关闭。
   
    //设置背景,将背景的部分封装
    setBack();
    //绘制区域，添加画布，保证画布在背景之上
    StaticPanel staticPanel = new StaticPanel(opration);
    mainpane.add(staticPanel);//添加画布JPanel，需要重学绘制方法，新建画布类来继承
    setGamePanel();//添加游戏方块
    }
    


    /*
    设置背景 

    */ 
    void setBack(){
        ImageIcon imgic = new ImageIcon("img/bg.png");//本地路径的图片为背景图片
        JLabel j1 = new JLabel(imgic);//建立图片的构造方法
        j1.setBounds(0,0,640,1100);//给图片相对于窗口的大小并设置图片大小
        getContentPane().add(j1);//调用主窗口的添加方法把方法添加进去
        
    }
    //添加游戏方块
    void setGamePanel(){
    gamePanel = new GamePanel(gameDate);
    mainpane.add(gamePanel);
    }
    /**
     * 获取游戏区
     */
    public GamePanel getGamePanel(){
        return gamePanel;
    }


}