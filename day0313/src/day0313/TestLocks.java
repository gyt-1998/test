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
	//第一、使用Lock,需要明确写上锁和释放锁
	//第二、为了避免拿到所得线程在运行期间出现异常，导致程序终止，没有释放锁。应用try{}finally{}来保证，无论正确执行与否，最终都会释放锁
	public void method(){
		System.out.println(Thread.currentThread().getName()+"进入了上锁的方法里");
		try {
		   lock.lock();//显示的写上 在此处获得锁
		   try {
		    	Thread.sleep(3000);
		   } catch (InterruptedException e) {
		    	e.printStackTrace();
		   }
		   //模拟程序出错
		   //int a=10/0;
		   //method();//(重入锁）不要出现无穷递归，容易内存溢出，导致锁一直没有释放
		   System.out.println(Thread.currentThread().getName()+"退出了上锁的方法里");
		}finally {
		   lock.unlock();	//显示的写上 在此处释放锁
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