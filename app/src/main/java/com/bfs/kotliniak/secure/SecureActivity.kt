package com.bfs.kotliniak.secure

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.bfs.kotliniak.R.layout
import kotlinx.android.synthetic.main.activity_secure.*

class SecureActivity : AppCompatActivity() {

  val systemServices by lazy(LazyThreadSafetyMode.NONE) { SystemServices(this) }

  private var showDeviceSecurityAlert : AlertDialog? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_secure)
    setSupportActionBar(toolbar)
    fab.setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          .setAction("Action", null).show()
    }
  }

  override fun onStart() {
    super.onStart()
    if (!systemServices.isDeviceSecure()) {
      showDeviceSecurityAlert = systemServices.showDeviceSecurityAlert()
    }
  }

  override fun onStop() {
    super.onStop()
    showDeviceSecurityAlert?.dismiss()
  }
}
