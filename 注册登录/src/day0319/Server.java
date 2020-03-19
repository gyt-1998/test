package day0319;

import java.io.File;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Server {
	private Properties userpros;
	public Server() {
		userpros=new Properties();//���� key-value
		File f=new File("Files\\user.properties");
		if(f.exists()) {
			try {
				userpros.load(new FileReader(f));//���ļ��е����ݼ��ص�������ȥ
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void regist() {
		
		try {
			//1.���������
			ServerSocket server=new ServerSocket(6666);
			System.out.println("ע���߳�������");
			//2.���տͻ���
			while(true) {
				//2.���տͻ���
			    Socket client= server.accept();
			    //3.���ͻ��˶���������ļ�ע���߳�
			    new RegThread(client,userpros).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void login() {
		try {
			ServerSocket server=new ServerSocket(7777);
			System.out.println("��¼�߳�����");
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
