package day0313;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLocks {

	public static void main(String[] args) {
		Test obj=new Test();
		Thread t1=new Thread(new MyTask(obj));
		Thread t2=new Thread(new MyTask2(obj));
		t1.start();
		t2.start();
	}

}
class Test{
	Lock lock=new ReentrantLock();
	//��һ��ʹ��Lock,��Ҫ��ȷд�������ͷ���
	//�ڶ���Ϊ�˱����õ������߳��������ڼ�����쳣�����³�����ֹ��û���ͷ�����Ӧ��try{}finally{}����֤��������ȷִ��������ն����ͷ���
	public void method(){
		System.out.println(Thread.currentThread().getName()+"�����������ķ�����");
		try {
		   lock.lock();//��ʾ��д�� �ڴ˴������
		   try {
		    	Thread.sleep(3000);
		   } catch (InterruptedException e) {
		    	e.printStackTrace();
		   }
		   //ģ��������
		   //int a=10/0;
		   //method();//(����������Ҫ��������ݹ飬�����ڴ������������һֱû���ͷ�
		   System.out.println(Thread.currentThread().getName()+"�˳��������ķ�����");
		}finally {
		   lock.unlock();	//��ʾ��д�� �ڴ˴��ͷ���
        }
	}
}
class MyTask implements Runnable{
   Test obj;
	public MyTask(Test obj) {
	this.obj = obj;
}
	@Override
	public void run() {
		obj.method();
	}
}
class MyTask2 implements Runnable{
	   Test obj;
		public MyTask2(Test obj) {
		this.obj = obj;
	}
		@Override
		public void run() {
			obj.method();
		}
	}