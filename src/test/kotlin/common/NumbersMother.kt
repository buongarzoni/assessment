package common

import kotlin.random.Random

fun randomInt(
    from: Int = 0,
    until: Int = 99_999,
) = Random.nextInt(from, until)
