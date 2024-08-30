package org.buongarzoni.scoring

data class Score(
    val contactId: Int,
    val matchId: Int,
    val accuracy: Accuracy,
)
