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
    	 try { //1.获取输入输出流
    		    InputStream is=client.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"UTF-8");
				BufferedReader br= new BufferedReader(isr);
				
				OutputStream os=client.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
				PrintWriter pw= new PrintWriter(osw);
				//2.用户输入数据，并拼接处理
				Scanner sc=new Scanner(System.in);
				System.out.println("开始登录");
				System.out.println("请输入用户名");
				String username=sc.next();
				System.out.println("请输入密码");
				String password=sc.next();
				String userinfo=username+"#"+password;
				pw.println(userinfo);//3.提交给服务端
				pw.flush();
				String msg=br.readLine();//4.接收
				System.out.println(msg);
			    pw.close();//5.释放
				br.close();
				client.close();
				
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 } 
     }
}
