package day0313;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollectionsForSyn {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();//0x123456
		List<String> safeList=Collections.synchronizedList(list);//0x456789 new Collections$SnychronizedList(静态内部类实现List接口)
		safeList.add("A");//synchronized里的add方法，该方法里加了个锁
		safeList.add("B");
		safeList.add("C");
		

	}

}
