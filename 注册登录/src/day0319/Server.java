package day0319;

import java.io.File;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
	private Properties userpros;
	public Server() {
		userpros=new Properties();//集合 key-value
		File f=new File("Files\\user.properties");
		if(f.exists()) {
			try {
				userpros.load(new FileReader(f));//把文件中的内容加载到集合中去
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void regist() {
		
		try {
			//1.创建服务端
			ServerSocket server=new ServerSocket(6666);
			System.out.println("注册线程已启动");
			//2.接收客户端
			while(true) {
				//2.接收客户端
			    Socket client= server.accept();
			    //3.将客户端对象和配置文件注册线程
			    new RegThread(client,userpros).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void login() {
		try {
			ServerSocket server=new ServerSocket(7777);
			System.out.println("登录线程启动");
			while(true) {
				Socket client=server.accept();
				LoginThread lt=new LoginThread(client,userpros);
				lt.start();
				}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
