package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;//画笔
import java.awt.Graphics2D;//边框粗细的类
import java.awt.BasicStroke;


import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Opration;

public class StaticPanel extends JPanel{
    /**
     * 这里没有序列化
     */
    JButton left ;//设置左按钮
    JButton rigt ;//设置右按钮
    JButton down ;//设置下按钮
    JButton rota ;//设置旋转按钮
    JButton stst ;//开始、结束按钮
    JButton sett ;//设置登录按钮
    JButton logi ;//设置按钮

     StaticPanel(Opration opration){
        /*setLayout(null);
        setOpaque(false);
         setBounds(0,0,640,1100);//设置画布大小和窗口一样大
         setLayout(null);          //给自由布局    */
         left = opration.left;
         rigt = opration.rigt;
         down = opration.down;
         rota = opration.rota;
         stst = opration.stst;
         sett = opration.sett;
         logi = opration.logi;
         setBounds(0,0,640,1100);//设置画布大小和窗口一样大
         setLayout(null);          //给自由布局 
         setOpaque(false);
         left.setBounds(470, 670, 60, 60);//设置左按钮的位置
         rigt.setBounds(535, 670, 60, 60);//设置右按钮的位置
         down.setBounds(470, 740, 60, 60);//设置下按钮的位置
         rota.setBounds(535, 740, 60, 60);//设置旋转按钮的位置
         stst.setBounds(470, 600, 125, 60);//设置开始、结束按钮的位置
         sett.setBounds(470, 900, 125, 60);//设置登录按钮的位置
         logi.setBounds(470, 970, 125, 60);//设置设置按钮的位置
         add(left);
         add(rigt);
         add(down);
         add(rota);
         add(stst);
         add(sett);
         add(logi);
     }
     //绘制游戏区，得分区等
     @Override
     public void paintComponent(Graphics g){

         super.paintComponent(g);//继承按钮父类的绘制方法，这时背景没有了，然后去按钮区域设置setLayout(null);setOpaque(false);
         g.setColor(new Color(0,0,0,30));//将画布变透明，0，0，0是黑色，最后一个是透明度（0-255）
         g.fillRect(30, 50,400, 800);//  左上设置 "游戏区" 的大小
         g.fillRect(30,880 ,400, 170);// 左下角 排名区
         g.fillRect(450, 50, 160, 800);//右侧大区域
         g.setColor(new Color(2,2,2,30));
         g.fillRect(460, 70, 140, 160);//右上第一个 得分区
         g.fillRect(460, 270, 140, 320);//右上第二个 提示区
         g.fillRect(460, 600, 140, 240);//右上第三个 操作区
         g.setColor(Color.orange); //加边框颜色
         ((Graphics2D)g).setStroke(new BasicStroke(3L)); //设置边框的宽度
         g.drawRect(30, 50, 402, 798);//给 游戏区 边框定位置和大小
         g.drawRect(28, 882, 402, 168);//给 排名区 边框定位置和大小
         /**
          * 给区域写名字
          */
        g.setColor(Color.DARK_GRAY);//设置字体颜色深灰色
        g.setFont(new Font("黑体",Font.PLAIN,30));//设置字体和大小
        g.drawString("得分：", 490,125);//设置字的位置
        g.drawString("下一个", 480,310);//设置字的位置
        g.drawString("排行榜", 50,940);//设置字的位置

     }
}
    

