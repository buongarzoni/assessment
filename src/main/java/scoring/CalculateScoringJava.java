package scoring;

import org.buongarzoni.scoring.Accuracy;
import org.buongarzoni.scoring.User;

public class CalculateScoringJava {
  public Accuracy execute(User user, User anotherUser) {
    if (isIdEqualsTo(user, anotherUser)) return Accuracy.HIGH;
    if (isEmailEqualsTo(user, anotherUser)) return Accuracy.HIGH;
    if (isEmailNameEqualsTo(user, anotherUser) && isFullNameSimilarTo(user, anotherUser)) {
      if (isLocationSimilarTo(user, anotherUser)) {
        return Accuracy.HIGH;
      } else {
        return Accuracy.MEDIUM;
      }
    }
    if (isFullNameSimilarTo(user, anotherUser) && isLocationSimilarTo(user, anotherUser)) return Accuracy.MEDIUM;

    return Accuracy.LOW;
  }

  private boolean isIdEqualsTo(User user, User another) {
    return user.getId() == another.getId();
  }

  private boolean isLocationSimilarTo(User user, User another) {
    return haveSameZipCodeAs(user, another) || haveSameAddressAs(user, another);
  }

  private boolean haveSameAddressAs(User user, User another) {
    return user.getAddress().contains(another.getAddress()) || another.getAddress().contains(user.getAddress());
  }

  private boolean haveSameZipCodeAs(User user, User another) {
    return user.getZipCode() == another.getZipCode();
  }

  private boolean isEmailEqualsTo(User user, User another) {
    return user.getEmail().equals(another.getEmail());
  }

  private boolean isFullNameSimilarTo(User user, User another) {
    return haveSimilarLastNameAs(user, another) && haveSimilarNameAs(user, another);
  }

  private boolean haveSimilarNameAs(User user, User another) {
    return user.getName().contains(another.getName()) || another.getName().contains(user.getName());
  }

  private boolean haveSimilarLastNameAs(User user, User another) {
    return user.getLastName().contains(another.getLastName()) || another.getLastName().contains(user.getLastName());
  }

  private boolean isEmailNameEqualsTo(User user, User another) {
    String userEmailName = getEmailName(user.getEmail());
    String anotherUserEmailName = getEmailName(another.getEmail());
    return userEmailName.equals(anotherUserEmailName);
  }

  private String getEmailName(String string) {
    int index = string.indexOf("@");
    if (index == -1) return string;
    return string.substring(0, index);
  }
}
