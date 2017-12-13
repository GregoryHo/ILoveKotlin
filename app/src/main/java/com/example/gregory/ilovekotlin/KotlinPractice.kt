package com.example.gregory.ilovekotlin

/**
 * @author Gregory
 * @since 2017/8/23
 *
 * The practice which reference to https://github.com/fabiomsr/from-java-to-kotlin
 */

class KotlinPractice {

  fun printMessage(message: String) {
    // System.out.print(message);
    print(message)
    // System.out.print("\n");
    print("change line\n")
    // System.out.println(message);
    println(message)
  }

  fun variablesOne() {
    println("variablesOne")
    // final int x;
    val x: Int
    // final int y = 1;
    val y = 1
  }

  fun variablesTwo() {
    println("variablesTwo")
    // int x;
    var x: Int
    // int y = 1;
    var y = 1
    // x = 2;
    x = 2
    // y = 3;
    y = 3
    // int sum = x + y;
    val sum = x + y
    // println(Integer.toString(sum);
    println(sum.toString())
  }

  fun nullOne() {
    println("nullOne")
    // final String name = null;
    val name: String? = null
    // String lastName;
    var lastName: String
    // lastName = null;
    // Kotlin occurs compile error when set lastName to null
  }

  fun nullTwo(name: String?) {
    println("nullTwo")
    /*if (name != null) {
      int length = name.length();
    }*/
    val length1 = name?.length
    println(length1.toString())
    val length2 = name!!.length // Throw NPE if name is null
    println(length2.toString())
  }

  fun stringOne() {
    println("stringOne")
    // final String name = "Java";
    val name = "Java"
    // final String lastName = "Kotlin";
    val lastName = "Kotlin"
    // final String combine = "My name is: " + name + " " + lastName;
    val combine = "My name is: $name $lastName"
    // final String others = "My name length is: " + name.length();
    val others = "My name length is: ${name.length}"

    println(name)
    println(lastName)
    println(combine)
    println(others)
  }

  fun stringTwo() {
    println("stringTwo")
    // String message = "Java\n" + "Kotlin\n" + "Android\n";
    val message = """
      |Java
      |Kotlin
      |Android
    """.trimMargin()
    println(message)
  }

  fun ternaryOperator(value: Int) {
    println("ternaryOperator")
    // String str = value > 5 ? "value > 5" : "value <= 5";
    val str = if (value > 5) "value > 5" else "value <= 5"
    println(str)
  }

  fun basicOperations() {
    println("basicOperations")
    // int x = 0;
    val x = 1
    // int y = 1;
    val y = 1
    // final int andResult = x & y;
    val andResult = x and y
    // final int orResult = x | y;
    val orResult = x or y
    // final int xorResult = x ^ y;
    val xorResult = x xor y
    // final int rightShiftX = x >> 1;
    val rightShiftX = x shr 1
    // final int leftShiftY = y << 1;
    val leftShiftY = y shl 1

    println(andResult.toString())
    println(orResult.toString())
    println(xorResult.toString())
    println(rightShiftX.toString())
    println(leftShiftY.toString())
  }

  fun isAsIn(value: Any, message: Any, index: Int) {
    println("isAsIn")
    /*if (value instanceof Integer) {
       println("I am integer");
    }*/
    if (value is Int) {
      println("I am integer")
    }
    // final string str = (String) message;
    val str = message as String
    println(str)
    /*if (index >= 0 && index <= 10) {
      println("Index in 0 to 1o")
    }*/
    if (index in 0..10) {
      println("Index in 0 to 10")
    }
  }

  fun smartCast(value: Any) {
    println("smartCast")
    /*if (value instanceof Integer) {
      if ((int) value >= 0 && (int) value <= 10) {
        println("value in 0 to 10")
      }
    }*/
    if (value is Int) {
      if (value in 0..10) {
        println("Value in 0 to 10")
      }
    }
  }

  fun switchAsWhen(value: Int) {
    println("switchAsWhen")
    /*final String message;
    switch(value) {
      case 0:
      case 11:
        message = "Value is 0 or 11";
      break;

      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
        message = "Value form 1 to 10";
      break;

      default:
        message = "Value grater than 10";
      break;
    }*/
    val message = when (value) {
      0, 11 -> "Value is 0 or 11"
      in 1..10 -> "Value from 1 to 10"
      else -> "Value grater than 10"
    }

    println(message)
  }

  fun asFor(
      endIndex: Int, items: Collection<String>, entries: Map<String, String>) {
    /*for (int i = 0; i < 10; i++) {
      println(Integer.toString(i));
    }*/
    for (i in 0..endIndex) {
      println(i.toString())
    }
    /*for (int i = 0; i < 10; i+=2) {
      println(Integer.toString(i));
    }*/
    for (i in 0..endIndex step 2) {
      println(i.toString())
    }
    /*for (String item : items) {
      println(item);
    }*/
    for (item in items) {
      println(item)
    }
    /*for (Map.Entry<String, String> entry : entries.entrySet()) {
      println(entry);
    }*/
    for ((key, value) in entries) {
      println("Key: $key , value: $value")
    }
  }

  fun asForEach(items: Collection<Int>, threshold: Int) {
    /*for (String item : items) {
      println(item);
    }*/
    items.forEach {
      println(it)
    }
    /*for (Integer number : numbers) {
      if (number < 3) {
        println(number);
      }
    }*/
    items.filter { it < threshold }.forEach { println(it) }
  }



  fun getStringList(): List<String> {
    // final List<String> things = Arrays.asList("1", "2", "3", "4");
    val things = listOf("Java", "Kotlin", "Android")
    return things
  }

  fun getIntegerList(): List<Int> {
    // final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    val numbers = listOf(1, 2, 3, 4, 5)
    return numbers
  }

  fun getHashMap(): Map<String, String> {
    // final Map<String, String> maps = new HashMap<>();
    // maps.put("Sun", "Java");
    // maps.put("JetBrains", "Kotlin");
    // maps.put("Google", "Android");
    val maps = mapOf("Sun" to "Java", "JetBrains" to "Kotlin", "Google" to "Android")
    return maps
  }
}