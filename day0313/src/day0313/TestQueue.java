package day0313;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestQueue {

	public static void main(String[] args) {
		//Queue <String> q=new
		//列表（尾部添加/指定下标）  链表（头尾添加）  队列 FIFO	
		
		//如果要强制LinkedList只遵循队列的规则
	   //Queue<String> link=new LinkedList<String>();//遵循队列规则的列表
		LinkedList<String> link=new LinkedList<String>();
//	   link.add("A");//列表
//	   link.add("B");
       link.offer("A");//队列
       link.offer("B");
       link.offer("C");
       link.add(0,"D");//用列表的方式打乱了FIFO队列的规则
       //强制LinkedList后，不能调用带有下标的add方法
	   System.out.println(link.peek());//队列中的第一个元素
	   
	   //严格遵守了队列的规则，且是线程安全的，采用了CAS算法
	   Queue q=new ConcurrentLinkedQueue<String>();
	   //1.抛出异常的 2.返回结果的
	   q.offer("A");
	   q.offer("B");
	   q.offer("C");
	   q.poll();//删除表头
	   System.out.println(q.peek());//获得表头
	   //手动固定队列上限
	   BlockingQueue<String> bq=new ArrayBlockingQueue<String>(3);
	   //无界队列 最大有Integer.MAX_VALUE
	   BlockingQueue<String> lbq=new LinkedBlockingQueue<String>();
	   
	}

}
