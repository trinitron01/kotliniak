package com.bfs.kotliniak.dagger

import dagger.Component

@Component
interface MagicBox {
    fun poke(app: Main2Activity)
}