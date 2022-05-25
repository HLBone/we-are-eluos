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
        setBounds(30, 50,400, 800);/*设置游戏的游戏区域的位置，和游戏区的大小一样 
                                    一个方块是25*25的，所以横向能放400/25=16个，纵放32个*/
    }
    @Override
    public void paintComponent(Graphics g){
        for(Point point: gameData.blocks.points){
            g.fillRect((point.x+gameData.x)*25,(point.y+gameData.y)*25, 25, 25);//前两个是方块位置信息，后两个是大小。x,y需要获取GameDate中的变量

        }
    }
}
