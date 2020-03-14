package day0313;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class TestCopyOnWriteArrayList {

	public static void main(String[] args) {
		//写有锁，读无锁集合
		CopyOnWriteArrayList<String> alist=new CopyOnWriteArrayList<String>();
		//写操作 有锁
		alist.add("A");//都将底层数组做了一次复制，写的是新数组，完成赋值后，再将新数组替换掉旧数组
		alist.add("B");//每调用一次，底层方法扩容一次
		
		//读造作，无锁
		alist.get(1);//读的是写操作完成之前的旧数组；写完之后，才能读到新数组的新值
		
		CopyOnWriteArraySet<String> aset=new CopyOnWriteArraySet<String>();
        //写操作 表面使用的是add方法，底层实际使用的是CopyOnWriteArrayList的addIfAbsent方法来判断插入的新值是否存在
		aset.add("A");
		aset.add("B");
		aset.add("C");
		for (String string : aset) {
			System.out.println(string);
		}
		
		HashMap<String,String> maps=new HashMap<String,String>();
		//分段锁设计  Segement  JDK1.7的做法
		//CAS交换算法和同步锁 同步锁锁的是表头对象，拿到锁的对象要先做节点遍历，查看有没有相同的key ，相同覆盖，不同则挂在最后一个节点的next  JDK1.8的做法
		ConcurrentHashMap<String,String> ch=new ConcurrentHashMap<String,String>();
		
	}

}
