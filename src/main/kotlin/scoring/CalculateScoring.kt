package org.buongarzoni.scoring

class CalculateScoring {
    fun execute(user: User, anotherUser: User): Accuracy {
        if (user isIdEqualsTo anotherUser) return Accuracy.HIGH
        if (user isEmailEqualsTo anotherUser) return Accuracy.HIGH
        if (user isEmailNameEqualsTo anotherUser && user isFullNameSimilarTo anotherUser) {
            return if (user isLocationSimilarTo anotherUser) {
                Accuracy.HIGH
            } else {
                Accuracy.MEDIUM
            }
        }
        if (user isFullNameSimilarTo anotherUser && user isLocationSimilarTo anotherUser) return Accuracy.MEDIUM

        return Accuracy.LOW
    }

    private infix fun User.isIdEqualsTo(another: User) = id == another.id
    private infix fun User.isEmailEqualsTo(another: User) = email == another.email
    private infix fun User.isEmailNameEqualsTo(another: User) = email.substringBefore('@') == another.email.substringBefore('@')

    private infix fun User.isLocationSimilarTo(another: User) = haveSameZipCodeAs(another) || haveSameAddressAs(another)
    private infix fun User.haveSameAddressAs(another: User) = address.contains(another.address) || another.address.contains(address)
    private infix fun User.haveSameZipCodeAs(another: User) = zipCode == another.zipCode

    private infix fun User.isFullNameSimilarTo(another: User) = haveSimilarLastNameAs(another) && haveSimilarNameAs(another)
    private infix fun User.haveSimilarNameAs(another: User) = name.contains(another.name) || another.name.contains(name)
    private infix fun User.haveSimilarLastNameAs(another: User) = lastName.contains(another.lastName) || another.name.contains(lastName)
}
