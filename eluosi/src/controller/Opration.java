package controller;
//操作


import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.GameData;
import view.ImgButton;
import view.MainWin;

public class Opration {
    MainWin mainWin;//
    GameData gameData;

    public ImgButton left;//左
    public ImgButton rigt;//右
    public ImgButton down;//下
    public ImgButton rota;//旋转
    public JButton stst;//开始、结束
    public ImgButton sett;//登录
    public ImgButton logi;//设置

    Opration(){
         left = new ImgButton(new ImageIcon("img/left.png")){

            @Override
            public void onClick() {
                gameData.move(true, -1);
                mainWin.getGamePanel().repaint();
            }

        };
        
         rigt = new ImgButton(new ImageIcon("img/rigt.png")){

            @Override
            public void onClick() {
                gameData.move(true, 1);
                mainWin.getGamePanel().repaint();
                
            }

        };
         down = new ImgButton(new ImageIcon("img/dowm.png")){

            @Override
            public void onClick() {
                if(gameData.move(false, 1)){
                    mainWin.getScoreNext().repaint();
                };
                mainWin.getGamePanel().repaint();
                
            }

        };
         rota = new ImgButton(new ImageIcon("img/rota.png")){

            @Override
            public void onClick() {
                gameData.rote();
                mainWin.getGamePanel().repaint();
                
            }

        };
         stst =  new JButton("开始");

         sett = new ImgButton(new ImageIcon("img/logi.png")){

            @Override
            public void onClick() {
                // TODO Auto-generated method stub
                
            }

        };
         logi = new ImgButton(new ImageIcon("img/sett.png")){

            @Override
            public void onClick() {
                // TODO Auto-generated method stub
                
            }

        };
    }
    /**
     * 关联视图
     * @param mainwen
     */
    public void setWin(MainWin mainwen) {
        this.mainWin = mainwen;
    }
    /**
     * 关联model
     * @param gameData
     */
    public void steData(GameData gameData) {
        this.gameData = gameData;
    }
    
}
