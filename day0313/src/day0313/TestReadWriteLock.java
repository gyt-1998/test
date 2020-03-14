package day0313;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TestReadWriteLock {

	public static void main(String[] args) {
		Student stu=new Student();//共享资源对象
		ExecutorService es=Executors.newFixedThreadPool(20);
		WriteTask1 write=new WriteTask1(stu);//线程任务
		ReadTask1 read=new ReadTask1(stu);
		//执行的两个赋值的线程任务
		long start=System.currentTimeMillis();//开始时间 毫秒值
		es.submit(write);
		es.submit(write);
		
		for (int i =1 ; i <=18; i++) {
			es.submit(read);
			
		}
		//停止线程池 但是不停止已提交任务！等已提交任务都执行完毕
		es.shutdown();
		//询问线程池任务结束了吗
		while(true) {
		        System.out.println("结束了吗");
				if(es.isTerminated()==true){
					break;
				}
		}
		long end=System.currentTimeMillis();//结束时间
		System.out.println(end-start);

	}

}
//写操作任务
class WriteTask1 implements Callable{
    Student stu;
	public WriteTask1(Student stu) {
		this.stu = stu;
	}

	@Override
	public Object call() throws Exception {
		stu.setAge(100);
		return null;
	}
	
}
//读操作任务
class ReadTask1 implements Callable{
    Student stu;
	public ReadTask1(Student stu) {
		this.stu = stu;
	}

	@Override
	public Object call() throws Exception {
		stu.getAge();
		return null;
	}
	
}

class Student{
	private int age;
	//Lock lock=new ReentrantLock();//写和读都加锁 性能太低
	ReentrantReadWriteLock rrwl=new ReentrantReadWriteLock();//有两把锁
	ReadLock read=rrwl.readLock();//读锁
	WriteLock write=rrwl.writeLock();//写锁
	//赋值-->写操作
	public void setAge(int age) {
		write.lock();
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.age=age;
		}finally {
			write.unlock();
		}
	}
	//取值--读操作
	public int getAge() {
		read.lock();
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return this.age=age;
		}finally {
			read.unlock();
		}
		
	}
}
