package pers.chbrobin.study.thread.communicate;
/**
 * 
 * 
 * 项目名称：ThreadApp
 * 类名称：Producer
 * 类描述：生产者－消费者模型之生产者
 * 创建人：Defonds
 * 创建时间：2010-1-26 上午10:45:30
 * 修改人：Defonds
 * 修改时间：2010-1-26 上午10:45:30
 * 修改备注：
 * @version 
 *
 */
public class Producer extends Thread{
	
	private int needNum;//每次要生产产品的数量
	private Godown godown;//仓库
	
	/**
	 * 
	 * 创建一个新的实例 Producer.
	 *
	 * @param needNum
	 * @param godown
	 */
	public Producer(int needNum,Godown godown){
		this.needNum = needNum;
		this.godown = godown;
	}
	
	/**
	 * 重写 java.lang.Thread 的 run 方法
	 */
	public void run(){
		this.godown.produce(this.needNum);
	}
}
