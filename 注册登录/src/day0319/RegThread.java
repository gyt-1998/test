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

public class RegThread extends Thread {

		// �ͻ���
		private Socket client;
		private Properties userpros;//�����ļ�
		public RegThread(Socket client,Properties userpros) {
			this.client=client;
			this.userpros=userpros;
		}
		
		public void run() {
			
			try {//1.������������
				InputStream is=client.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"UTF-8");
				BufferedReader br= new BufferedReader(isr);
				
				OutputStream os=client.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
				PrintWriter pw= new PrintWriter(osw);
				//2.����û��ύ������
				String userinfo=br.readLine();
				String[] users=userinfo.split("#");
				String username=users[0];
				String password=users[1];
				//3.�ж��û��Ƿ����
				if(userpros.containsKey(username)) {
					pw.println("�û��Ѵ��ڣ�����������");
					pw.flush();
				}else {//4.��������ڣ�Ӧ�ñ��沢��֪��ǰ�ͻ���ע��ɹ�
					//�浽���϶�����
					userpros.setProperty(username, password);
					//�浽Ӳ���ļ���
					userpros.store(new FileWriter("Files\\userpros.properties"), "�û���Ϣ");
					pw.println("ע��ɹ�");
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
