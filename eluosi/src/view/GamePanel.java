package view;

import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;

import model.GameData;

//我是俄罗斯方块的画布
public class GamePanel extends JPanel{

    GameData gameData;    //创建私有成员变量
    /**
     * 这里没有序列化
     * @param gameDate
     */
    GamePanel(GameData gameDate){
        this.gameData = gameDate;
        setOpaque(false);//设置背景透明
        setBounds(15, 30,200, 360);/*设置游戏的游戏区域的位置，和游戏区的大小一样 
                                    一个方块是25*25的，所以横向能放400/20=10个，纵放18个*/
    }
    @Override
    public void paintComponent(Graphics g){
        for(Point point: gameData.blocks.points){
            g.setColor(gameData.colors[gameData.current]);
            g.fill3DRect((point.x+gameData.x)*20,(point.y+gameData.y)*20, 20, 20,false);//前两个是方块位置信息，后两个是大小。x,y需要获取GameDate中的变量

        }
        for(int i = 19;i >=2;i--){ 
            for(int j = 0;j<10;j++){
                if(gameData.existBlocks[j][i] != 0){
                    g.setColor(gameData.colors[gameData.existBlocks[j][i] - 1]);
                    g.fill3DRect((j)*20,(i - 2)*20, 20, 20,false);//前两个是方块位置信息，后两个是大小。x,y需要获取GameDate中的变量

                }
            }
        }
    }
}
