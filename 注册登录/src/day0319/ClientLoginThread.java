package day0319;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientLoginThread extends Thread {
	 private Socket client;
     public ClientLoginThread(Socket client) {
    	 this.client=client;
     }
     public void run() {
    	 try { //1.��ȡ���������
    		    InputStream is=client.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"UTF-8");
				BufferedReader br= new BufferedReader(isr);
				
				OutputStream os=client.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
				PrintWriter pw= new PrintWriter(osw);
				//2.�û��������ݣ���ƴ�Ӵ���
				Scanner sc=new Scanner(System.in);
				System.out.println("��ʼ��¼");
				System.out.println("�������û���");
				String username=sc.next();
				System.out.println("����������");
				String password=sc.next();
				String userinfo=username+"#"+password;
				pw.println(userinfo);//3.�ύ�������
				pw.flush();
				String msg=br.readLine();//4.����
				System.out.println(msg);
			    pw.close();//5.�ͷ�
				br.close();
				client.close();
				
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 } 
     }
}
