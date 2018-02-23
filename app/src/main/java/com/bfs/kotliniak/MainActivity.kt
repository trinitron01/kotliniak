package com.bfs.kotliniak

import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.RatingBar
import android.widget.Toast
import com.bfs.kotliniak.base.VariablesBasicTypesArrays2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.io.File
import java.util.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(activity_toolbar)
    ratingBar2.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
      val text = "test $rating "
      toast(text)
    }
    fab.setOnClickListener { view ->
      action()
    }
    VariablesBasicTypesArrays2().test2();
    action()
  }



  private fun toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    return when (item.itemId) {
      R.id.action_settings -> {
        toast("settings")
        true
      }
      else -> super.onOptionsItemSelected(item)
    }


  }

  inline fun SQLiteDatabase.inTransaction(func: SQLiteDatabase.() -> Unit) {
    beginTransaction()
    try {
      func()
      setTransactionSuccessful()
    } finally {
      endTransaction()
    }

  }

  inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit();
    editor.func()
    editor.apply()
  }

  fun SharedPreferences.Editor.set(pair: Pair<String, String>) {
    putString(pair.first, pair.second)


  }


  fun compress(files: List<File>, applyStrategy: (List<File>) -> CompressedFiles){
    applyStrategy(files)
  }

  class CompressedFiles {

  }

  val dog = { action: Action ->
    var weight: Int = 10

    when (action) {
      Action.feed -> { food: Int -> weight += food; println(weight) }
      Action.workout -> { intensity: Int -> weight -= intensity; println(weight) }
    }
  }
  enum class Action {
    feed, workout
  }


  class Student(
          val name: String,
          val surname: String,
          val passing: Boolean,
          val averageGrade: Double
  )

  private fun action() {

    /*   RangesCollections.test()


       val sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE)
       sharedPreferences.edit {
         set("foo" to "bar")
         remove("test")
       }*/
    dog(Action.feed)(5)
    val random = Random()
    var students : MutableList<Student> = mutableListOf()
    for (i: Int in 1..20) {

      students.add(Student("name"+i,"surname"+i,true, i.toDouble()))
    }
    val predicate: (Student) -> Boolean = { it.passing && it.averageGrade > 4.0 }
    val selector: (IndexedValue<Student>) -> Double = { (i, s) -> s.averageGrade }
    val selector1: (IndexedValue<Student>) -> Int = { (i, s) -> i }
    val transform: (IndexedValue<Student>) -> Student = { (i, s) -> s }
    val filtered =
           students.filter(predicate)
                   .withIndex() // 1
                   .sortedBy(selector) // 2
                   .take(10)
                   .sortedBy(selector1) // 3
                   .map(transform) // 4

/*

    We add current index to every element.
            We need to destructure value and index before use.
            We sort by index.
    We remove index and keep only students.

*/

    val size = filtered.size
  }
}
