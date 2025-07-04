package com.example.test1.kotlinset;

import androidx.core.content.res.TypedArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

//java 类建立与kotlin->java 联合调用
public class javaset1 {
    public  void main() {
        Integer[] array = new Integer[5];
        for (int i = 0; i < 5; i++) {
            array[i] = i+1;
        }
        //System.out.println(array);
        for(int i = 0; i < 5; i++) {
            System.out.print(array[i]);
        }
        System.out.print("\n");
        for(int s:array){
            System.out.print(s);
        }
        System.out.println(Arrays.binarySearch(array,3));
        //多维数组实现
        int[][]array1=new int[2][3];

        //数组正向排序
        Arrays.sort(array);
        //数组逆向排序
        Arrays.sort(array,Collections.reverseOrder());

        Integer[] array3 = new  Integer[5];
        //快速复制数组
        //System.arraycopy(array,0,array3,0,5);
    }
}
class javaset2{
    public void main(){
        System.out.println("javaset2");
    }
}

class java_arraylist{
    public void main(){
        ArrayList<String>sites=new ArrayList<>();
        sites.add("google");
        sites.add("weibo");
        sites.add("taobao");
        sites.add(3,"mon");
        System.out.println(sites);
        //修改元素
        sites.set(2,"ziki");
        //获取元素
        System.out.println(sites.get(2));
        //删除元素
        sites.remove("taobao");
        System.out.println(sites);
        System.out.println(sites.size());
        //倒叙排序
        sites.sort(Comparator.reverseOrder());
        //正向排序
        sites.sort(Comparator.naturalOrder());
        //输出的两种循环遍历方法
        for(String s:sites){
            System.out.println(s);
        }
        //list排序
        Collections.sort(sites);
        for(int i=0;i<sites.size();i++){
            System.out.println(sites.get(i));
        }
        Boolean in=sites.contains("mon");
        System.out.println(in);

        //迭代器的使用
        Iterator<String>it=sites.iterator();
        System.out.println("迭代器使用");
        System.out.println(it.next());
        //循环输出
        while(it.hasNext()){
            System.out.println(it.next());

        }
    }
}

class java_linkedlist{
    /**
     * 继承AbstractSequentiaList类
     *实现Queue接口，可作为队列使用
     * 实现List接口，可进行列表的函数调用
     * 实现Deque接口，可作为队列使用
     * 实现Cloneable接口，可实现克隆
     * 实现了java.io.Serializable接口，即可支持序列化，能通过序列化去传输
     */
    public void main(){
        LinkedList<String> sites=new LinkedList<>();
        sites.add("google");
        sites.add("weibo");
        sites.add("taobao");
        //头尾添加元素
        sites.addFirst("souhu");
        sites.addLast("tecent");
        System.out.println(sites);
        //头尾删除元素
        sites.removeFirst();
        sites.removeLast();
        System.out.println(sites);

        LinkedList<String> emptyList = new LinkedList<>();
        // 对空列表使用 poll()
        String result = emptyList.poll();
        System.out.println("结果是: " + result);  // 输出: null
    }
}

class java_HashSet{
    public void main(){
        HashSet<String>sites=new HashSet<String>();
        sites.add("google");
        sites.add("weibo");
        sites.add("zhihu");
        sites.add("tencent");
        sites.add("tencent");
        //sites.clear();
        System.out.println(sites);
        System.out.println(sites.size());
        for (String i: sites) {
            System.out.print(i+"\t");
        }
    }
}

class java_map{
    public void main(){
        HashMap<Integer,String>sites=new HashMap<>();
        sites.put(1,"google");
        sites.put(2,"runoob");
        sites.put(3,"taobao");
        sites.put(4,"zhihu");
        System.out.println(sites);
        //计算大小
        System.out.println(sites.size());
        //迭代
        for(Integer i:sites.keySet()){
            System.out.println("key "+i+" value "+sites.get(i));
        }
        //只获取value值
        for(String value:sites.values()){
            System.out.println(value);
        }
        //无法保证插入顺序
        HashMap<String,String>sites1=new HashMap<>();
        sites1.put("one","google");
        sites1.put("two","runoob");
        sites1.put("three","taobao");
        sites1.put("four","zhihu");
        System.out.println(sites1);
        //获取元素
        System.out.println(sites1.get("three"));

        //保证插入顺序
        //LinkedHashMap<String,String>sites2=new LinkedHashMap<>();


    }
}

