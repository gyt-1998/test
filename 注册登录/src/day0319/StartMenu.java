package day0319;

import java.util.Scanner;

public class StartMenu {

	public static void main(String[] args) {
		Client client=new Client();
		System.out.println("-------��ӭ���뱾ϵͳ-----------");
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("����������ѡ��1.ע��  2.��¼  0.�˳�");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				client.reg();
				//���߳̾�����
				break;
			case 2:
				client.login();
				break;
			default:
				
	            break;
			}
		}while(choice!=0);//�˳�
		System.out.println("��ӭ�´�����");

	}

}
