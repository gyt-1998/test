package day0313;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollectionsForSyn {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();//0x123456
		List<String> safeList=Collections.synchronizedList(list);//0x456789 new Collections$SnychronizedList(��̬�ڲ���ʵ��List�ӿ�)
		safeList.add("A");//synchronized���add�������÷�������˸���
		safeList.add("B");
		safeList.add("C");
		

	}

}
