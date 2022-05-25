package model;

import java.awt.Point;



//俄罗斯方块的随机出现的方块
public class GameData {
    public Blocks blocks;
    static Blocks[] BLOCKS = new Blocks[]{
        new Blocks(new int[]{-1,0,1,1},new int[]{0,0,0,1}),
        new Blocks(new int[]{-1,0,1,2},new int[]{0,0,0,0}),
        new Blocks(new int[]{-1,-1,0,1},new int[]{0,1,0,0}),
    };
    /**
     * 偏移量
     */
    public int x ;
    public int y ;
    public GameData(){
        x = 4;
        y = 0;
        blocks =new Blocks(BLOCKS[0]);
    }
    /**
     * 移动方法
     */

    public void move(boolean isH,int step){
        boolean isAllow =true;
        //左右移动限制
        if(isH){
            for(Point point: blocks.points){
            if(point.x + x + step < 0 || point.x + x + step>15){
                isAllow = false;
            }
        }
            if(isAllow){
                x += step;
            }
        }else{
            for(Point point: blocks.points){
            if(point.y + y + step > 31){
                isAllow = false;
            }
        }    
            if(isAllow){
                y += step;
            }
        }
    }
    /**
     * 旋转方法
     */
    public void rote(){
        for(Point point: blocks.points){
            int _x = -point.y + x;
            int _y = point.x + y;
            if()
        }
        
        for(Point point: blocks.points){
            int temp = point.x;
            point.x = -point.y;
            point.y = temp;
        }
    }
}
