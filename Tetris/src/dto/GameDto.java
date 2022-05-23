package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	
private List<Player> dbRecode;

private List<Player> diskRecode;

private boolean[][] gameMap;

private GameAct gameAct;

private int next;

private int nowlevel;

private int nowPoint;

private int nowRemoveLine;
//构造函数
public GameDto() {
	dtoInit();
}
/**
 * dto初始化
 */
public void dtoInit() {
	//TODO硬编码
	this.gameMap=new boolean[10][18];
	//TODO初始化所有游戏对象
}

public List<Player> getDbRecode() {
	return dbRecode;
}

public void setDbRecode(List<Player> dbRecode) {
	this.dbRecode = dbRecode;
}

public List<Player> getDiskRecode() {
	return diskRecode;
}

public void setDiskRecode(List<Player> diskRecode) {
	this.diskRecode = diskRecode;
}

public boolean[][] getGameMap() {
	return gameMap;
}

public void setGameMap(boolean[][] gameMap) {
	this.gameMap = gameMap;
}

public GameAct getGameAct() {
	return gameAct;
}

public void setGameAct(GameAct gameAct) {
	this.gameAct = gameAct;
}

public int getNext() {
	return next;
}

public void setNext(int next) {
	this.next = next;
}

public int getLevel() {
	return nowlevel;
}

public void setLevel(int level) {
	this.nowlevel = level;
}

public int getNowPoint() {
	return nowPoint;
}

public void setNowPoint(int nowPoint) {
	this.nowPoint = nowPoint;
}

public int getNowRemoveLine() {
	return nowRemoveLine;
}

public void setNowRemoveLine(int nowRemoveLine) {
	this.nowRemoveLine = nowRemoveLine;
}


}
