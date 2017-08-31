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

  protected constructor(`in`: Parcel) : super(`in`) {
    a = `in`.readString()
    b = `in`.readInt()
  }

  override fun describeContents(): Int {
    return 0
  }

  override fun writeToParcel(dest: Parcel, flags: Int) {
    dest.writeString(a)
    dest.writeInt(b)
  }

  companion object {

    val CREATOR: Parcelable.Creator<TestParceledObject> = object : Parcelable.Creator<TestParceledObject> {
      override fun createFromParcel(`in`: Parcel): TestParceledObject {
        return TestParceledObject(`in`)
      }

      override fun newArray(size: Int): Array<TestParceledObject?> {
        return arrayOfNulls(size)
      }
    }
  }
}
