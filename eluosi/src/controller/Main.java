package controller;
import model.GameData;
/**
 * 负责层与层之间的关系
 */
import view.MainWin;//窗口

public class Main {
    public static void main(String[] args) {
        Opration opration = new Opration();//实列化操作
        GameData gameData = new GameData();//加载数据
        //将数据和窗口关联
        MainWin mainwin = new MainWin(opration,gameData);//主窗口
        //将窗口和操作区进行关联
        opration.setWin(mainwin);
        //将数据和操作区关联
        opration.steData(gameData);
        mainwin.setVisible(true);
    }
}
