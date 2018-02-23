package com.bfs.kotliniak.github

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.bfs.kotliniak.BR

class Repository : BaseObservable {


  var repoOwner: String?
  var noOfStars: Int?
  var hasIssues: Boolean
  @get:Bindable
  var repoName : String? =""
    set(value) {
      field = value
      notifyPropertyChanged(BR.repoName)
    }

  constructor(repoName: String?, repoOwner: String?, noOfStars: Int?,
      hasIssues: Boolean = false) : super() {
    this.repoOwner = repoOwner
    this.noOfStars = noOfStars
    this.hasIssues = hasIssues
    this.repoName = repoName
  }



}