package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {

	private int width;
	private int height;
	private String title;
	private int windowUp;
	private int padding;
	private int windowSize;
	private List<LayerConfig> layersConfig;
	public GameConfig() throws Exception {
		//创建XML读取器
		 SAXReader reader = new SAXReader();
		 //读取XML文件
			Document doc=reader.read("config/cfg.xml"); 
			//获得XML文件的根节点
			Element game=doc.getRootElement();
			//配置窗口
			this.setUiConfig(game.element("frame"));
			//配置系统参数
			this.setSystemConfig(game.element("system"));
			//配置系统访问参数
			this.setDataConfig(game.element("data"));
			
	}
	/**
	 * 配置窗口
	 * @param frame配置文件的窗口配置元素
	 */
	
    private	void setUiConfig(Element frame) {
    	//获取窗口宽度
    	this.width=Integer.parseInt(frame.attributeValue("width"));
    	//获取窗口高度
		this.height=Integer.parseInt(frame.attributeValue("height"));
		//获取边框内边距
		this.padding=Integer.parseInt(frame.attributeValue("padding"));
		//获取边框粗细	
		this.windowSize=Integer.parseInt(frame.attributeValue("windowSize"));
		//获取标题
		this.title =frame.attributeValue("title");
		//获取窗体拔高
		this.windowUp=Integer.parseInt(frame.attributeValue("windowUp"));
		//获取窗体属性
        List<Element> layers=frame.elements("layer");
		layersConfig = new ArrayList<LayerConfig>();
		//设置单个窗体属性
		for (Element layer : layers) {
			LayerConfig lc=new LayerConfig(
					layer.attributeValue("className"),
					Integer.parseInt(layer.attributeValue("x")),
					Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")),
					Integer.parseInt(layer.attributeValue("h"))
					
		);
		
		layersConfig.add(lc);
		}
    }
    /**
     * 配置系统参数
     * @param frame
     */
	private void setSystemConfig(Element system) {
		//TODO配置系统参数
	}
	/**
	 * 配置数据访问参数
	 * @param frame
	 */
	private void setDataConfig(Element Data) {
		//TODO配置数据访问参数
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getPadding() {
		return padding;
	}
	public int getWindowSize() {
		return windowSize;
	}
	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}
	public String getTitle() {
		return title;
	}
	public int getWindowUp() {
		return windowUp ;
	}
	
}
