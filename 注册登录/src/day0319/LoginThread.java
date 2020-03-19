package day0319;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;

public final class LoginThread extends Thread{

	private Socket client;
	private Properties userpros;//配置文件
	public LoginThread(Socket client,Properties userpros) {
		this.client=client;
		this.userpros=userpros;
	}
	
	public void run() {
		
		try {//1.获得输入输出流
			InputStream is=client.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			BufferedReader br= new BufferedReader(isr);
			
			OutputStream os=client.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
			PrintWriter pw= new PrintWriter(osw);
			//2.获得用户提交的数据
			String userinfo=br.readLine();
			String[] users=userinfo.split("#");
			String username=users[0];
			String password=users[1];
			//3.判断用户是否存在
			if(userpros.containsKey(username)) {
				if(userpros.getProperty(username).equals(password)) {
					pw.println("登录成功");
					pw.flush();
				}else {
					pw.println("登录失败，密码输入错误");
					pw.flush();
				}
			}else {//4.如果不存在，应该保存并告知当前客户端注册成功
				pw.println("登录失败，账号不存在");
				pw.flush();
			}
			pw.close();
			br.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
