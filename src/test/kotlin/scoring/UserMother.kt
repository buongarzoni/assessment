package scoring

import common.StringType
import common.randomInt
import common.randomString
import org.buongarzoni.scoring.User

fun userRandom(
    id: Int = randomInt(),
    name: String = randomString(10, StringType.ALPHABETIC),
    lastName: String = randomString(10, StringType.ALPHABETIC),
    email: String = randomString(10, StringType.ALPHABETIC) + "@" + randomString(10, StringType.ALPHABETIC) + ".com",
    zipCode: Int = randomInt(),
    address: String = randomString(20, StringType.ALPHANUMERIC),
) = User(
    id = id,
    name = name,
    lastName = lastName,
    email = email,
    zipCode = zipCode,
    address = address,
)
