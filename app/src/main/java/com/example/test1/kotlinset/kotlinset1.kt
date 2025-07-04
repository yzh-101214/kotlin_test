package com.example.test1.kotlinset

import kotlin.random.Random


fun main() {
    ktset()
   // ktlist()
   // ktmap()
  /*  ktarray()
    val java=javaset1()
    java.main()
    val java2= javaset2()
    java2.main()
    val java_Alist= java_arraylist()
    java_Alist.main()
    val java_Llist= java_linkedlist()
    java_Llist.main()
    val java_hset= java_HashSet()
    java_hset.main()
    val java_map= java_map()
    java_map.main()*/

}


fun ktarray(){
    val array1=arrayOf("a","b","c")
    val array2=arrayOf(1,2,3,4)
    for(s in array1)
    {
        println("array1 "+s)
    }
    for(s in array2)
    {
        println("array2 "+s)
    }
    //数组排序
    val arrayup=array2.sortedArray()
    println(arrayup.joinToString())
    val arraydowm=array1.sortedArrayDescending()
    println(arraydowm.joinToString())
}

fun ktlist(){
    //不可变集合
    val list1=listOf<Int>(1,2,3,4)
    val s =list1.get(3)
    val i: Boolean=list1.isNotEmpty()
    println(i)
    //可变集合
    val list2=mutableListOf<Any>(1,2,"google",4)
    val b=list2.add(2,5)
    list2.removeAt(2)
    println(list2)
}

fun ktset(){
    //不可变有序集合
    val set1=setOf<String>("google","xunlei","tencent")
    val nullset=setOfNotNull("google",5,"tencent")
   for(i in set1.indices)
   {
       println(i)
   }
    
    println(nullset.toString())
}

fun ktmap(){
    val map1=mapOf(1 to "google",2 to "tencent")
    val map2=mutableMapOf<Any,Any>()
    for(i in 3..7)
    {
        map2[i]="its->$i"
    }
    val map3=mutableMapOf<Any,Any>()
    repeat(5) {Index-> map3[Index]="its->$Index" }
    println(map2.size)
    println(map2)
    println(map3)
    repeat(5) {print("$it") }
}