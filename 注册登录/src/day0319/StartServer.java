package day0319;

public class StartServer {

	public static void main(String[] args){
		Server server=new Server();
		//�������� �����߳�
		//�����ڲ���
		new Thread() {
			
			public void run() {
			  server.regist();
			}
		}.start();
		
		new Thread() {
			public void run() {
					server.login();
			}
		}.start();
		

	}

}
