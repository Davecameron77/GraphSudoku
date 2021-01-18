package com.bracketcove.graphsudoku.common

import android.app.Activity
import android.widget.Toast
import com.bracketcove.graphsudoku.R
import com.bracketcove.graphsudoku.domain.Difficulty
import com.bracketcove.graphsudoku.domain.Messages

internal fun Activity.makeToast(message: String) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_LONG
    ).show()
}

internal fun Activity.getStringRes(message: Messages): String {
    return when (message) {
        Messages.IO_ERROR_UPDATE -> getString(R.string.error_update)
        Messages.IO_ERROR_READ -> getString(R.string.error_read)
    }
}

internal fun Long.toTime(): String {
    if (this >= 3600) return "+59:59"
    var minutes = ((this % 3600) / 60).toString()
    if (minutes.length == 1) minutes = "0$minutes"
    var seconds = (this % 60).toString()
    if (seconds.length == 1) seconds = "0$seconds"


    return String.format("$minutes:$seconds")
}

internal val Difficulty.toLocalizedResource: Int
    get() {
        return when (this) {
            Difficulty.EASY -> R.string.easy
            Difficulty.MEDIUM -> R.string.medium
            Difficulty.HARD -> R.string.hard
        }
    }