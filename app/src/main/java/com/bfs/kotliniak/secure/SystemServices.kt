package com.bfs.kotliniak.secure

import android.app.KeyguardManager
import android.content.Context
import android.os.Build
import android.support.v7.app.AlertDialog
import com.bfs.kotliniak.BuildConfig
import com.bfs.kotliniak.openLockScreenSettings

class SystemServices(private val context:Context) {

private val keyguardManager: KeyguardManager

init {
  keyguardManager = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
}

  companion object {
    fun hasMarshmallow() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M


  }



fun isDeviceSecure(): Boolean = if (hasMarshmallow()) keyguardManager.isDeviceSecure else keyguardManager.isKeyguardSecure

// Used to block application if no lock screen is setup.
fun showDeviceSecurityAlert(): AlertDialog {
  return AlertDialog.Builder(context)
      .setTitle("lock title")
      .setMessage("no lock screen")
      .setPositiveButton("go to lock", { _, _ -> context.openLockScreenSettings() })
      .setNegativeButton("exit", { _, _ -> System.exit(0) })
      .setCancelable(BuildConfig.DEBUG)
      .show()
}

}