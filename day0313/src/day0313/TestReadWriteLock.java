package day0313;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TestReadWriteLock {

	public static void main(String[] args) {
		Student stu=new Student();//������Դ����
		ExecutorService es=Executors.newFixedThreadPool(20);
		WriteTask1 write=new WriteTask1(stu);//�߳�����
		ReadTask1 read=new ReadTask1(stu);
		//ִ�е�������ֵ���߳�����
		long start=System.currentTimeMillis();//��ʼʱ�� ����ֵ
		es.submit(write);
		es.submit(write);
		
		for (int i =1 ; i <=18; i++) {
			es.submit(read);
			
		}
		//ֹͣ�̳߳� ���ǲ�ֹͣ���ύ���񣡵����ύ����ִ�����
		es.shutdown();
		//ѯ���̳߳������������
		while(true) {
		        System.out.println("��������");
				if(es.isTerminated()==true){
					break;
				}
		}
		long end=System.currentTimeMillis();//����ʱ��
		System.out.println(end-start);

	}

}
//д��������
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
//����������
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
	//Lock lock=new ReentrantLock();//д�Ͷ������� ����̫��
	ReentrantReadWriteLock rrwl=new ReentrantReadWriteLock();//��������
	ReadLock read=rrwl.readLock();//����
	WriteLock write=rrwl.writeLock();//д��
	//��ֵ-->д����
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
	//ȡֵ--������
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
