package view;
//分数提示
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;

import model.GameData;

//我是俄罗斯方块的画布
public class ScoreNext extends JPanel{

    GameData gameData;    //创建私有成员变量
    int[] offset = new int[]{0,-10,0,0,-10,0,0};
    /**
     * 这里没有序列化
     * @param gameDate
     */
    ScoreNext(GameData gameDate){
        this.gameData = gameDate;
        setOpaque(false);//设置背景透明
        setBounds(233,30,90,215);
                                    
    }
    @Override
    public void paintComponent(Graphics g){
        g.setFont(new Font("黑体",Font.PLAIN,23));
        g.drawString(GameData.getScore(), 10, 60);
        for(Point point: gameData.BLOCKS[gameData.next].points){
            g.setColor(gameData.colors[gameData.next]);
            g.fill3DRect((point.x)*20+ 35 + offset[gameData.next],(point.y)*20 + 150, 20, 20,false);//前两个是方块位置信息，后两个是大小。x,y需要获取GameDate中的变量

        }
    }
}
