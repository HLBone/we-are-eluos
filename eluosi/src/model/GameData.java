package model;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;


//俄罗斯方块的随机出现的方块
public class GameData {
    public Blocks blocks;
    public Blocks[] BLOCKS = new Blocks[]{
        new Blocks(new int[]{-1,0,1,1},new int[]{0,0,0,1}),//0:
        new Blocks(new int[]{-1,0,1,2},new int[]{0,0,0,0}),//1:长的
        new Blocks(new int[]{-1,-1,0,1},new int[]{0,1,0,0}),
        new Blocks(new int[]{-1,0,0,1},new int[]{0,0,1,1}),
        new Blocks(new int[]{0,1,0,1},new int[]{0,0,1,1}),//4:正方形
        new Blocks(new int[]{-1,0,0,1},new int[]{1,0,1,0}),
        new Blocks(new int[]{-1,0,0,1},new int[]{0,0,1,0}),//6:下
        new Blocks(new int[]{1,0,0,-1},new int[]{0,0,-1,0}),//7:上
    };
    public Color[] colors = new Color[]{
        new Color(255,0,0),//红
        new Color(0,255,0),//绿
        new Color(0,0,255),//蓝
        new Color(255,255,0),
        new Color(255,0,255),
        new Color(0,255,255),
        new Color(150,150,150),//灰色
    };


    /**
     * 偏移量
     */
    public int x ;
    public int y ;
    /**
     * 存放格子的数组
     */
    public int[][] existBlocks;
    /**
     * 存放删除格子的数组
     */
    int[] deletnum;
    /**
     * 随机因子
     */
    Random random;
    /**
     * 下一个
     */
    public int next;
    /**
     * 得分
     */
    public static int score;
    /**
     * 现在的格子编号
     */
    public int current;
    public GameData(){
        existBlocks = new int[10][20];
        random = new Random();
        next = random.nextInt(7);
        initBlocks();
    }
    /**
     * 移动方法
     */

    public boolean move(boolean isH,int step){
        boolean isdelet = false;
        //左右移动限制
        if(isH){
            for(Point point: blocks.points){
                if (point.x + x + step < 0 || point.x + x + step > 9
                        || existBlocks[point.x + x + step][point.y + y + 2] != 0) {
                    return false;
                }
            }

                x += step;
            
        }else{
            for(Point point: blocks.points){
            if(point.y + y + step > 17 || existBlocks[point.x + x][point.y + y + 2 + step] != 0){
                saveBlocks();
                isdelet = deletTest();
                if(isdelet){
                    deletLine();
                }
                if (isdead()){
                    //TODO 死亡方法
                }
                initBlocks();
                return true;
            }
        }    
             y += step;
        }
        return isdelet;
    }
    /**
     * 重置下落的方块
     */
    private void initBlocks() {
        x = 4;
        y = 0;
        deletnum = new int[20];
        blocks =new Blocks(BLOCKS [next]);
        current = next;
        next = random.nextInt(7);
    }
    /**
     * 旋转方法
     */
    public void rote(){
         for(Point point: blocks.points){
             int _x = -point.y + x;
             int _y = point.x + y;
             if (_x < 0 || _x > 9) {
                 return;
             }
             if(_y > 17){
                 return;
             }
         }
        
        for(Point point: blocks.points){
            int temp = point.x;
            point.x = -point.y;
            point.y = temp;
        }
    }
    /**
     * 保存方块组
     */
    void saveBlocks(){
       for(Point point:blocks.points) {
           existBlocks[point.x + x][point.y + y + 2] = current + 1;
       }
    }
    /**
     * 检测消行
     */
    boolean deletTest(){
        boolean isdelet = false;
        boolean isEmpt;
        for(int i = 19;i >= 2;i--){
            isEmpt = false;
            for(int j = 0; j < 10;j++){
                if(existBlocks[j][i] == 0){
                    isEmpt = true;
                    break;
                }
            }
            if(!isEmpt){
                isdelet = true;
                deletnum[i-1] = deletnum[i]+1;
            }else{
                deletnum[i-1] = deletnum[i];
            }
        }
        return isdelet;
    }
    /**
     * 消除行
     */
    void deletLine(){
        for(int i = 19;i >= 2;i--){
            for(int j = 0; j < 10;j++){
                existBlocks[j][i + deletnum[i]] = existBlocks[j][i];
            }
        }
        score += deletnum[2]*10;
    }
        /**
         * 死亡判断
         */
        boolean isdead(){
            for(int j = 0; j < 10;j++){
                if (existBlocks[j][2] != 0)
                return true;
        }
        return false;
    }
        public static String getScore() {
            return "" + score;
        }
}
