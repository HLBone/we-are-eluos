
package service;

import java.awt.Point;
import java.util.Random;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	/**
	 * 
	 */
	private GameDto dto;
	/**
	 * 随机数生成器
	 */
	private Random random=new Random();
	/**
	 *方块种类个数
	 */
	private static final int MAX_TYPE=6;
  public GameService(GameDto dto) {
	this.dto =dto;
	GameAct  act = new GameAct(random.nextInt(MAX_TYPE)) ;
	dto.setGameAct(act);
}

/**
 * 方块操作（上）
 */
public void keyUp() {
	this.dto.getGameAct().round(this.dto.getGameMap());
}
/**
 * 方块操作（下）
 */
public void keyDown() {
	//方块向下移动，并判断是否移动成功
	if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())) {
		return;
	}
	//获得游戏地图对象
			boolean[][] map=this.dto.getGameMap();
			//获得方块对象
			Point[] act=this.dto.getGameAct().getActPoints();
			//将方块堆积到地图数组
			for(int i=0;i<act.length;i++) {
				map[act[i].x][act[i].y]=true;
			}
			//TODO判断是否可以消行
			//TODO消行操作
			//TODO算分操作
			//TODO判断是否升级
			//TODO升级
			//创建下一个方块
			this.dto.getGameAct().init(this.dto.getNext());
			//随机生成再下一个方块
			this.dto.setNext(random.nextInt(MAX_TYPE));
			
}
	
	
/**
 * 方块操作（左）
 */
public void keyLeft() {
	this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
}

/**
 * 方块操作（右）
 */
public void keyRight() {
this.dto.getGameAct().move(1, 0,this.dto.getGameMap());

}
//TODO=============测试专用方法============================
public void testLeverS() {
	int point = this.dto.getNowPoint();
	int rmLine = this.dto.getNowRemoveLine();
	int Lv = this.dto.getLevel();
	point+=10;
	rmLine+=1;
	if(rmLine%20==0) {
		Lv+=1;
	}
	this.dto.setNowPoint(point);
	this.dto.setLevel(Lv);
	this.dto.setNowRemoveLine(rmLine);
	
}



}
