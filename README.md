This repo contains only the logic to calculate the Accuraccy between 2 users, it's made in Kotlin just for speed, but the CalculateScoring class is also written in Java (see CalculateScoringJava).

There is only the algorithm to calculate the accuracy since the behavior was not clear in the example.

A list of users is received and a list of scores is returned but only relative to the first user, if it were wanted between all the users there should be an extra row with the accuracy for user 1002 and 1003

![Captura de pantalla 2024-08-30 a la(s) 7 30 44 p  m](https://github.com/user-attachments/assets/6ece431b-fd05-4065-8c38-3a6a56d3406a)

In any case, it does not add complexity, it is just going through a list, that is why I omit it.

I also chose Kotlin to start with as it was faster to create object mothers and the tests are more readable thanks to the named arguments.
