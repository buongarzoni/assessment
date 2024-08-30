package org.buongarzoni.scoring

class CalculateScoring {
    fun execute(user: User, anotherUser: User): Accuracy {
        if (user haveSameIdAs anotherUser) return Accuracy.HIGH
        if (user haveSameEmail anotherUser) return Accuracy.HIGH
        if (user haveSameEmailName anotherUser && user haveSimilarFullName anotherUser) {
            return if (user haveSimilarLocation anotherUser) {
                Accuracy.HIGH
            } else {
                Accuracy.MEDIUM
            }
        }
        if (user haveSimilarFullName anotherUser && user haveSimilarLocation anotherUser) return Accuracy.MEDIUM

        return Accuracy.LOW
    }

    private infix fun User.haveSameIdAs(another: User) = id == another.id
    private infix fun User.haveSameEmail(another: User) = email == another.email
    private infix fun User.haveSameEmailName(another: User) = email.substringBefore('@') == another.email.substringBefore('@')
    private infix fun User.haveSimilarLocation(another: User) = haveSameZipCodeAs(another) || haveSameAddressAs(another)
    private infix fun User.haveSameAddressAs(another: User) = address.contains(another.address) || another.address.contains(address)
    private infix fun User.haveSameZipCodeAs(another: User) = zipCode == another.zipCode
    private infix fun User.haveSimilarFullName(another: User) = similarLastNameTo(another) && similarNameTo(another)
    private infix fun User.similarNameTo(another: User) = name.contains(another.name) || another.name.contains(name)
    private infix fun User.similarLastNameTo(another: User) = lastName.contains(another.lastName) || another.name.contains(lastName)
}
