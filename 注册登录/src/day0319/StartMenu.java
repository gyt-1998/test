package day0319;

import java.util.Scanner;

public class StartMenu {

	public static void main(String[] args) {
		Client client=new Client();
		System.out.println("-------欢迎进入本系统-----------");
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("请输入您的选择：1.注册  2.登录  0.退出");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				client.reg();
				//多线程竞争了
				break;
			case 2:
				client.login();
				break;
			default:
				
	            break;
			}
		}while(choice!=0);//退出
		System.out.println("欢迎下次再来");

	}

}
