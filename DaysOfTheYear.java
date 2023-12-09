import java.util.*;

public class DaysOfTheYear {

  static Scanner sc = new Scanner(System.in);
  static int currentDay = 1;
  static int currentMonth = 1;
  static int player = 0;
  static String userEntryDay;
  static String userEntryMonth;

  static String[] allMonth = {
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  };

  static String lastMonth = "December";

  static void player() {
    if (player % 2 == 0) {
      player = 2;
    } else {
      player = 1;
    }
  }

  static void checkingDay() {
    userEntryDay = sc.next();

    while (!checkInput(userEntryDay)) {
      System.out.println("Input invalid, please try again!");
      userEntryDay = sc.next();
    }
    int day = Integer.parseInt(userEntryDay);
    if (0 < day && day < 32) {
      if (currentDay <= day) {
        currentDay = day;
      } else {
        System.out.println("Input invalid, please try again!");
      }
    } else {
      System.out.println("Input invalid, please try again!");
      checkingDay();
    }
  }

  static void checkingMonth() {
    userEntryMonth = sc.next();
    while (!checkInputMonth(userEntryMonth)) {
      System.out.println("Input invalid, please try again!");
      userEntryMonth = sc.next();
    }
    int monthValidate = Integer.parseInt(userEntryMonth);
    if ((0 < monthValidate) && (monthValidate <= 12)) {
      if (currentMonth < monthValidate) {
        currentMonth = monthValidate;
      } else {
        System.out.println("Input invalid, please try again!");
      }
    } else {
      System.out.println("Input invalid, please try again!");
      checkingMonth();
    }
  }

  static boolean checkInput(String userEntryDay) {
    boolean hasString = false;
    int index = 0;
    while (index < userEntryDay.length()) {
      if (
        (userEntryDay.charAt(index) >= '0') &&
        (userEntryDay.charAt(index) <= '9')
      ) {
        hasString = true;
      }
      index++;
    }
    return hasString;
  }

  static boolean checkInputMonth(String userEntryMonth) {
    boolean hasString = false;
    int index = 0;
    while (index < userEntryMonth.length()) {
      if (
        (userEntryMonth.charAt(index) >= '0') &&
        (userEntryMonth.charAt(index) <= '9')
      ) {
        hasString = true;
      }
      index++;
    }
    return hasString;
  }

  static void caseMonth() {
    System.out.print("Which month do you want to pick: ");
    userEntryMonth = sc.next();
    while (!checkInputMonth(userEntryMonth)) {
      System.out.println("Input invalid, please try again!");
      userEntryMonth = sc.next();
    }
    int monthValidate = Integer.parseInt(userEntryMonth);
    if ((0 < monthValidate) && (monthValidate <= 12)) {
      if (currentMonth < monthValidate) {
        currentMonth = monthValidate;
      } else {
        System.out.println("Input invalid, please try again!");
        checkingMonth();
      }
    } else {
      System.out.println("Input invalid, please try again!");
      checkingMonth();
    }
  }

  static void caseDay() {
    System.out.print("Which day do you want to pick: ");
    userEntryDay = sc.next();

    while (!checkInput(userEntryDay)) {
      System.out.println("Input invalid, please try again!");
      userEntryDay = sc.next();
    }
    int day = Integer.parseInt(userEntryDay);
    if (0 < day && day < 32) {
      if (currentDay < day) {
        currentDay = day;
      } else {
        System.out.println("Input invalid, please try again!");
        checkingDay();
      }
    } else {
      System.out.println("Input invalid, please try again!");
      checkingDay();
    }
  }

  static void selectedMonthDay() {
    String selectDayOrMonth = sc.next();
    switch (selectDayOrMonth.toLowerCase()) {
      case "day":
        caseDay();
        break;
      case "month":
        caseMonth();
        break;
      default:
        System.out.println("Input invalid, please try again!");
        selectedMonthDay();
    }
  }

  public static void main(String[] args) {
    while (true) {
      player = player + 1;
      if (currentDay == 31 && currentMonth == 12) {
        if (currentMonth == 12) {
          System.out.println(
            "The current date is: " +
            currentDay +
            " of " +
            allMonth[currentMonth - 1]
          );
        }
        System.out.println(
          "Player " + (player - 1) + " is the winner of the game!"
        );
        player();
        break;
      } else {
        player();
        System.out.println(
          "The current date is: " +
          currentDay +
          " of " +
          allMonth[currentMonth - 1]
        );
        System.out.println("It is Player " + player + "'s Turn!");
        System.out.print(
          "Do you want to increase the day or the month? (day or month): "
        );
        selectedMonthDay();
      }
    }
    sc.close();
  }
}
