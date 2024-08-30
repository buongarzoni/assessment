package common

enum class StringType {
    ALPHANUMERIC,
    ALPHABETIC,
}

private val alphabeticLowerCase = ('a'..'z')
private val alphabeticUpperCase = ('A'..'Z')
private val numeric = ('0'..'9')

fun randomString(
    length: Int = 20,
    type: StringType = StringType.ALPHANUMERIC,
) = (1..length).map {
    val charPool = when(type) {
        StringType.ALPHANUMERIC -> alphabeticLowerCase + alphabeticUpperCase + numeric
        StringType.ALPHABETIC -> alphabeticLowerCase + alphabeticUpperCase
    }
    charPool.random()
}.joinToString("")
