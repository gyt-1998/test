package day0319;

public class StartServer {

	public static void main(String[] args){
		Server server=new Server();
		//启动服务 两个线程
		//匿名内部类
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
