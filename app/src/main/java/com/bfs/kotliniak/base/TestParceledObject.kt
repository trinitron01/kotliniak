package com.bfs.kotliniak.base

import android.accounts.Account
import android.os.Parcel
import android.os.Parcelable

class TestParceledObject : Account, Parcelable {

  private val a: String
  private val b: Int

  constructor(a: String, b: Int) : super(a, a) {
    this.a = a
    this.b = b
  }



}
