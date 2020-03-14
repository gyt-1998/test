package day0313;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestCopyOnWriteArrayList {

	public static void main(String[] args) {
		//д����������������
		CopyOnWriteArrayList<String> alist=new CopyOnWriteArrayList<String>();
		//д���� ����
		alist.add("A");//�����ײ���������һ�θ��ƣ�д���������飬��ɸ�ֵ���ٽ��������滻��������
		alist.add("B");//ÿ����һ�Σ��ײ㷽������һ��
		
		//������������
		alist.get(1);//������д�������֮ǰ�ľ����飻д��֮�󣬲��ܶ������������ֵ
		
		CopyOnWriteArraySet<String> aset=new CopyOnWriteArraySet<String>();
        //д���� ����ʹ�õ���add�������ײ�ʵ��ʹ�õ���CopyOnWriteArrayList��addIfAbsent�������жϲ������ֵ�Ƿ����
		aset.add("A");
		aset.add("B");
		aset.add("C");
		for (String string : aset) {
			System.out.println(string);
		}
		
		HashMap<String,String> maps=new HashMap<String,String>();
		//�ֶ������  Segement  JDK1.7������
		//CAS�����㷨��ͬ���� ͬ���������Ǳ�ͷ�����õ����Ķ���Ҫ�����ڵ�������鿴��û����ͬ��key ����ͬ���ǣ���ͬ��������һ���ڵ��next  JDK1.8������
		ConcurrentHashMap<String,String> ch=new ConcurrentHashMap<String,String>();
		
	}

}
