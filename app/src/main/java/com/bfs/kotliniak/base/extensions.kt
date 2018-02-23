package com.bfs.kotliniak.base

import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.util.Patterns
import android.widget.EditText
import android.widget.TextView
import com.bfs.kotliniak.R


inline internal fun EditText.validateWith(passIcon: Drawable = ContextCompat.getDrawable(context, R.drawable.abc_ab_share_pack_mtrl_alpha),
    failIcon: Drawable = ContextCompat.getDrawable(context, R.drawable.abc_ab_share_pack_mtrl_alpha),
    validator: TextView.() -> Boolean): Boolean {
  setCompoundDrawablesWithIntrinsicBounds(null, null,
      if (validator(this)) passIcon else failIcon, null)
  return validator(this)
}


val notEmpty: TextView.() -> Boolean = { text.isNotEmpty() }
val isEmail: TextView.() -> Boolean = { Patterns.EMAIL_ADDRESS.matcher(text).matches() }
/*
*
* mFirstNameEdit.validateWith(validator =notEmpty)
* */