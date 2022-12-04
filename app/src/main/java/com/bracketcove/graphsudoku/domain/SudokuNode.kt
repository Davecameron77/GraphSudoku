package com.bracketcove.graphsudoku.domain

import java.io.Serializable

data class SudokuNode(
    var color: Int = 0,
    val x: Int,
    val y: Int,
    var readOnly: Boolean
): Serializable {
    override fun hashCode(): Int {
        return getHash(x, y)
    }
}

internal fun getHash(x: Int, y: Int): Int {
    val newX = x*100
    return "$newX$y".toInt()
}
