package com.bfs.kotliniak.github

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.bfs.kotliniak.R
import com.bfs.kotliniak.databinding.ActivityGithubListBinding

class GithubListActivity : AppCompatActivity() {

  lateinit var binding : ActivityGithubListBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_github_list)
    binding.apply {
      repositoryName.text = "New Name"
      repositoryHasIssues.text = "yes"


    }

    var repo = Repository("repo name", "owner", 1000, true)
    binding.repository = repo

    Handler().postDelayed({repo.repoName="New Name delayed"
      binding.repository = repo
    }, 2000)

    binding.repositoryHasIssues.setOnClickListener {
      repo.repoName = "Clicked"

    }
  }
}
