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
		//�б�β�����/ָ���±꣩  ����ͷβ��ӣ�  ���� FIFO	
		
		//���Ҫǿ��LinkedListֻ��ѭ���еĹ���
	   //Queue<String> link=new LinkedList<String>();//��ѭ���й�����б�
		LinkedList<String> link=new LinkedList<String>();
//	   link.add("A");//�б�
//	   link.add("B");
       link.offer("A");//����
       link.offer("B");
       link.offer("C");
       link.add(0,"D");//���б�ķ�ʽ������FIFO���еĹ���
       //ǿ��LinkedList�󣬲��ܵ��ô����±��add����
	   System.out.println(link.peek());//�����еĵ�һ��Ԫ��
	   
	   //�ϸ������˶��еĹ��������̰߳�ȫ�ģ�������CAS�㷨
	   Queue q=new ConcurrentLinkedQueue<String>();
	   //1.�׳��쳣�� 2.���ؽ����
	   q.offer("A");
	   q.offer("B");
	   q.offer("C");
	   q.poll();//ɾ����ͷ
	   System.out.println(q.peek());//��ñ�ͷ
	   //�ֶ��̶���������
	   BlockingQueue<String> bq=new ArrayBlockingQueue<String>(3);
	   //�޽���� �����Integer.MAX_VALUE
	   BlockingQueue<String> lbq=new LinkedBlockingQueue<String>();
	   
	}

}
