package view;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public abstract class  ImgButton extends JButton {
    /**
     * 这里没有序列化
     */
    
     public ImgButton(ImageIcon imgic){

         setContentAreaFilled(false);//背景透明

         setIcon(imgic);//更改图片

         setBorder(null);//去除按钮图片边框

        addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();//点击事件的抽象方法
            }
            
        });//添加按键检测
     }
    public abstract void onClick();

}
