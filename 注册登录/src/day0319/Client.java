package day0319;

import java.net.Socket;

/*
 * ע�� 
 * ��¼
 * */
public class Client {
	
	public void reg(){
		try {
			//1.���ӷ����
			Socket client=new Socket("192.168.43.189",6666);
			//2.�ѿͻ��˴����߳�
			ClientRegThread crt=new ClientRegThread(client);
			//3.�����߳�
			crt.start();
			//4.�����߳���ִ��
			crt.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	public void login(){
		try {//ALT+Shift+z
			//1.���ӷ����
			Socket client=new Socket("192.168.43.189",7777);
			//2.�ѿͻ��˴����߳�
			ClientLoginThread clt=new ClientLoginThread(client);
			//3.�����߳�
			clt.start();
			//4.�����߳���ִ��
			clt.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
