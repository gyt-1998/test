package day0319;

import java.net.Socket;

/*
 * 注册 
 * 登录
 * */
public class Client {
	
	public void reg(){
		try {
			//1.连接服务端
			Socket client=new Socket("192.168.43.189",6666);
			//2.把客户端传给线程
			ClientRegThread crt=new ClientRegThread(client);
			//3.启动线程
			crt.start();
			//4.等主线程先执行
			crt.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	public void login(){
		try {//ALT+Shift+z
			//1.连接服务端
			Socket client=new Socket("192.168.43.189",7777);
			//2.把客户端传给线程
			ClientLoginThread clt=new ClientLoginThread(client);
			//3.启动线程
			clt.start();
			//4.等主线程先执行
			clt.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
