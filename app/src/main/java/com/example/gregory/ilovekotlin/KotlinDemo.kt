package com.example.gregory.ilovekotlin

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.click_btn
import kotlinx.android.synthetic.main.activity_main.title_tv

/**
 * @author Gregory
 * @since 2017/8/21
 */
class KotlinDemo : AppCompatActivity() {

  // Data class
  private data class User(val name: String, val age: Int)
  // Init as null
  private var customHandler: CustomHandler? = null
  // Lazy init
  private val lazyTv: TextView by lazy(LazyThreadSafetyMode.NONE) {
    findViewById(R.id.lazy_tv) as TextView
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    customHandler = CustomHandler()
  }

  override fun onResume() {
    super.onResume()
    title_tv.text = "This is good" // instead of .setText()
    val messageTv = findViewById(R.id.message_tv) as TextView
    messageTv.text = "Without extension"
    lazyTv.text = "So lazy"

    click_btn.text = "Click me!"
    click_btn.setOnClickListener({
      clicked()
    })

    val practice = KotlinPractice()
    practice.printMessage("Test")
    practice.variablesOne()
    practice.variablesTwo()
    practice.nullOne()
    try {
      practice.nullTwo(null)
    } catch (e: Exception) {
      println(e.message)
    }

    practice.stringOne()
    practice.stringTwo()
    practice.ternaryOperator(6)
    practice.ternaryOperator(4)
    practice.basicOperations()
    practice.isAsIn(1, "2", 3)
    practice.smartCast(5)
    for (i in 0..15) {
      practice.switchAsWhen(i)
    }

    val strings: MutableList<String> = ArrayList()
    strings.addAll(arrayOf("Java", "Kotlin", "Android"))
    val entries: MutableMap<String, String> = HashMap()
    entries.putAll(
        arrayOf(Pair("Sun", "Java"), Pair("JetBrains", "Kotlin"), Pair("Google", "Android")))
    practice.asFor(10, strings, entries)
    practice.asForEach(practice.getIntegerList(), 3)
  }

  private fun clicked() {
    val greg = User("Greg", 27)
    println(greg.name + ", " + greg.age)
    val olderGreg = greg.copy(age = 30)
    println(olderGreg.name + ", " + olderGreg.age)
    loop@ for (i in 0..20) {
      whenTest(i)
    }
  }

  private fun whenTest(numbers: Int = 0) {
    when (numbers) {
      0 -> println("Default value")
      in 1..5 -> println("From 1 to 5")
      !in 6..10 -> println("Not from 6 to 10")
      else -> {
        println("Anything else")
      }
    }
  }

  private class CustomHandler internal constructor() : Handler()
}