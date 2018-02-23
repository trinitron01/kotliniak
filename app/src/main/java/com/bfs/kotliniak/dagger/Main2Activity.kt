package com.bfs.kotliniak.dagger

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.bfs.kotliniak.R
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*
import javax.inject.Inject

class Main2Activity : AppCompatActivity() {

@Inject
    lateinit var  info : Info


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        DaggerMagicBox.create().poke(this)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        textView1.text = info.text
    }

}
