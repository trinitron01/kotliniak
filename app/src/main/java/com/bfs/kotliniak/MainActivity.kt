package com.bfs.kotliniak

import android.content.Context
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.RatingBar
import android.widget.Toast
import com.bfs.kotliniak.base.RangesCollections
import com.bfs.kotliniak.base.VariablesBasicTypesArrays2
import kotlinx.android.synthetic.main.activity_main.activity_toolbar
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.content_main.ratingBar2

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

  private fun action() {

    RangesCollections.test()


    val sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE)
    sharedPreferences.edit {
      set("foo" to "bar")
      remove("test")
    }
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


}
