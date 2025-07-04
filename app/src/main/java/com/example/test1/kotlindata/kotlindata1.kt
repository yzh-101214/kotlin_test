package com.example.test1.kotlindata

import kotlin.math.cos
import kotlin.random.Random

val PI1: Double=3.14
fun main() {
    testdata()
    //teststring()
    //testarray()
    //InitOrderDemo("hayden")
    //usertest12()
    //foo(strings = *arrayOf("a", "b", "c"))
    //val a = arrayOf(1, 2, 3)
    //val list = asList(-1, 0, *a, 4)
    //println(list)
    //lambda()

    /*val numbers = listOf(1, 2, 3, 4, 5)
    val doubledNumbers = numbers.map { number -> number * 2 }
    println(doubledNumbers) // 输出: [2, 4, 6, 8, 10]*/
    }

//数据定义方式
fun testdata(){
    var a: Int=1//不可更改定义
    var b: Double=2.0//可更改定义
    val ab :Int=2
    b=cos(25.0)
    a= Random.nextInt(0,100)
    System.out.println("a=$PI1")
    println("a=$a")
    println("b=$b")

}

//字符串定义与循环方式
fun teststring(){
    val str="abdf"
    for(i in str){
        print(i)
    }
}
//数组定义与循环方式
fun testarray(){
    val array1=arrayOf("a","b","c")
    val array2=arrayOf(8,9,10)
    for(it in array1){
        println(it)
    }

    //下标获取
    for(it in array2.indices){
        print(it.toString())
    }
}

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }

    //val thirdProperty = "Third property:${name.uppercase()}".also(::println)
    val thirdProperty = name.uppercase().also(::println)
}

fun usertest1() {
    // 用户输入名称
    println("name：")
    val name = readLine().toString()

    // 创建InitOrderDemo的实例
    val demoInstance = InitOrderDemo(name)

    println("style：")
    println(demoInstance.firstProperty)  // 访问firstProperty
    println(demoInstance.secondProperty) // 访问secondProperty
    println(demoInstance.thirdProperty)  //访问thirdProperty
}

class Person(
    val firstName: String,
    val lastName: String,
    var age: Int, // 尾部逗号
) {
    fun fullName() {
        println("$firstName.$lastName")
        //return "$firstName $lastName"
    }
    fun celebrateBirthday() {
        age++
        println("Happy Birthday, $firstName! You are now $age years old.")
    }
}

fun usertest2() {
    // 从用户输入获取信息
    println("请输入名（First Name）：")
    val firstName = readLine() ?: "Unnamed"  // 默认值为"Unnamed"

    println("请输入姓（Last Name）：")
    val lastName = readLine() ?: "Doe"  // 默认值为"Doe"

    println("请输入年龄（Age）：")
    val ageInput = readLine()
    val age = ageInput?.toIntOrNull() ?: 0  // 如果输入无效，默认为0

    // 创建Person的实例
    val person = Person(firstName, lastName, age)

    // 输出全名并庆祝生日
    person.fullName()
    person.celebrateBirthday()
}

class pet(){
    var name1="a"
    var age=15
    var stlye="dog"
}

fun usertest3(){
    val pets=pet();
    println(pets.name1)
    pets.age=17
    println(pets.age)
}

class Car(val make: String, val model: String) {
    var year: Int = 0
    var color: String = "Unknown"

    // 主构造函数
    /*init {
        println("主构造函数：汽车制造商: $make, 型号: $model")
    }*/

    // 次构造函数1：只接收制造年份
    constructor(make: String, model: String, year: Int) : this(make, model) {
        this.year = year
        //println("次构造函数1：汽车年限: $year")
    }

    // 次构造函数2：接收制造年份和颜色
    constructor(make: String, model: String, year: Int, color: String) : this(make, model, year) {
        this.color = color
        //println("次构造函数2：汽车颜色: $color")
    }

    fun displayInfo() {
        println("汽车信息: $make $model, Year: $year, Color: $color")
    }
}

fun usertest5() {
    // 使用主构造函数
    val car1 = Car("Toyota", "Corolla")
    car1.displayInfo()

    // 使用次构造函数1
    val car2 = Car("Honda", "Civic", 2022)
    car2.displayInfo()

    // 使用次构造函数2
    val car3 = Car("Ford", "Mustang", 2023, "Red")
    car3.displayInfo()
}

// 基类
open class Animal(var name: String, val age: Int) {
    init {
        println("Animal created: Name = $name, Age = $age")
    }

    open fun namechange(){
        name="hayden"
    }
}

// 派生类
class Dog(name: String, age: Int, val breed: String) : Animal(name, age) {
    init {
        println("Dog created: Breed = $breed")
    }

    override fun namechange() {
        name="yu"
    }
}

fun usertest6() {
    val dog = Dog("Buddy", 3, "Golden Retriever")
    dog.namechange()
    println("new name:${dog.name}")
}

open class Base(val name: String) {

    init { println("Initializing a base class") }

    open val size: Int =
        name.length.also { println("Initializing size in the base class: $it") }
}


class Derived(
    name: String,
    val lastName: String,
) : Base(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {

    init { println("Initializing a derived class") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
}
//sampleEnd

fun usertest7() {
    println("Constructing the derived class(\"hello\", \"world\")")
    Derived("hello", "world")
}

open class Rectangle {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String  = "black"
}

//sampleStart
class FilledRectangle: Rectangle() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() { println("Filling") }
        fun drawAndFill() {
            super@FilledRectangle.draw() // 调用 Rectangle 的 draw() 实现
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}") // 使用 Rectangle 所实现的 borderColor 的 get()
        }
    }
}
//sampleEnd

fun usertest8() {
    val fr = FilledRectangle()
    fr.draw()
}

//sam函数接口
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}
val isEven = IntPredicate { it % 2 == 0 }
val isBig = IntPredicate{ it>5 }

//更简洁实现
typealias Intpredicate1=(i:Int) -> String
typealias Intpredicate2=(s: String) -> String
val istype: Intpredicate1={"a${it}b"}
val istype1: Intpredicate2={"a${it}b"}

fun usertest9() {
    println("Is 7 even? - ${isEven.accept(7)}")
    println("Is 7 big than 5?-${isBig.accept(7)}")
    println(istype(5))
    println(istype1("hayden"))
}

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4  // 默认 public

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() {
    // a 不可见
    // b、c、d 可见
    // Nested 和 e 可见

    override val b = 5   // “b”为 protected
    override val c = 7   // 'c' is internal
}

class Unrelated(o: Outer) {
    // o.a、o.b 不可见
    // o.c 和 o.d 可见（相同模块）
    // Outer.Nested 不可见，Nested::e 也不可见
    val num=o.c
    val num1=o.d
}

fun usertest10(){
    val outer = Outer()
    val unrelated = Unrelated(outer)
    println(unrelated.num)
    println(unrelated.num1)

}

class Outer1 {
    private val bar: Int = 1
    inner class Nested {
        fun foo() = bar
    }
}
fun usertest11(){
    val demo= Outer1().Nested().foo()
    println(demo)
}

@JvmInline
value class Person1(private val fullName: String) {
    init {
        require(fullName.isNotEmpty()) {
            "Full name shouldn't be empty"
        }
    }

    constructor(firstName: String, lastName: String) : this("$firstName $lastName") {
        require(lastName.isNotBlank()) {
            "Last name shouldn't be empty"
        }
    }

    val length: Int
        get() = fullName.length

    fun greet() {
        println("Hello, $fullName")
    }
}
fun foo(vararg strings: String) {
  for(s1 in strings){
      print(s1)
  }
}

fun usertest12() {
    val name1 = Person1("Kotlin", "Mascot")
    val name2 = Person1("Kodee")
    name1.greet() // greet` 函数会作为一个静态方法被调用
    println(name2.length) // 属性的 getter 会作为一个静态方法被调用
}

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts 是一个数组
        result.add(t)
    return result
}

fun lambda(){
    val items = listOf(1, 2, 3, 4, 5)

    // Lambdas 表达式是花括号括起来的代码块。
    items.fold(0, {
        // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // lambda 表达式中的最后一个表达式是返回值：
        result
    })

    // lambda 表达式的参数类型是可选的
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })

    // 函数引用也可以用于高阶函数调用：
    val product = items.fold(1, Int::times)
    //sampleEnd
    println("joinedToString = $joinedToString")
    println("product = $product")
}